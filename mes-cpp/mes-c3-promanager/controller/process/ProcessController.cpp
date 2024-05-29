#include "stdafx.h"
#include "ProcessController.h"
#include "../../service/process/ProcessListService.h"
#include "../../service/process/ProcessProductsService.h"
#include "../../service/process/ComProService.h"
#include "../../service/process/RelateProService.h"
#include "../../service/process/ProMaterialService.h"


//#include "declarative/ProMaterialApiClient.h"
#include "../ApiDeclarativeServicesHelper.h"
#include "Macros.h"
#include "ExcelComponent.h"

// 注意：用到FastDfs的地方都要在最后在导入DFS的头文件
#include "ServerInfo.h"
#include "NacosClient.h"
#include "FastDfsClient.h"

// 1 查询工艺列表
ProcessListJsonVO::Wrapper ProcessController::execQueryProcessList(const ProcessListQuery::Wrapper& query)
{
	// 定义一个Service
	ProcessListService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = ProcessListJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

// 2 查询工艺详情
ProcessDetailJsonVO::Wrapper ProcessController::execQueryProcessDetail(const ProcessDetailQuery::Wrapper& query)
{
	// 定义一个Service
	ProcessListService service;
	// 查询数据
	auto result = service.getById(query);
	// 响应结果
	auto jvo = ProcessDetailJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

// 3 添加工艺
Uint64JsonVO::Wrapper ProcessController::execAddProcess(const ProcessAddDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	//非空校验
	if (!dto->routeCode || !dto->routeName || !dto->enableFlag)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 有效值校验
	if (dto->routeCode->empty() || dto->routeName->empty())
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}

	//定义一个Service
	ProcessListService service;
	//执行数据新增
	uint64_t id = service.saveProcessAdd(dto);
	if (id > 0) {
		jvo->success(UInt64(id));
	}
	else
	{
		jvo->fail(UInt64(id));
	}
	//响应结果
	return jvo;
}

// 4 修改工艺
Uint64JsonVO::Wrapper ProcessController::execModifyBasicProcess(const ProcessDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	if (!dto->routeId || dto->routeId <= 0)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 定义一个Service
	ProcessListService service;
	// 执行数据修改
	if (service.updateData(dto)) {
		jvo->success(dto->routeId);
	}
	else
	{
		jvo->fail(dto->routeId);
	}
	// 响应结果
	return jvo;
}

// 5 获取工艺关联产品列表（条件+分页）
ProductsPageJsonVO::Wrapper ProcessController::execQueryProducts(const ProcessProductsQuery::Wrapper& query)
{
	// 定义一个Service
	ProcessProductsService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = ProductsPageJsonVO::createShared();
	jvo->success(result);
	return jvo;
}

// 6 删除组成工序
Uint64JsonVO::Wrapper ProcessController::execRemoveProcess(const List<UInt64>& id)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();

	list<uint64_t> data;
	for (auto p = id->begin(); p != id->end(); ++p) {
		//数据校验
		if (!*p || *p <= 0)
		{
			jvo->init(UInt64(-1), RS_PARAMS_INVALID);
			return jvo;
		}
		data.emplace_back(*p);
	}
	// 定义一个Service
	ComProService service;
	// 执行数据删除
	int res = service.removeData(data);
	if (res) {
		jvo->success(res);
	}
	else
	{
		jvo->fail(res);
	}
	// 响应结果
	return jvo;
}

//7 工艺导出
StringJsonVO::Wrapper ProcessController::execQueryProcess(const ProcessListQuery::Wrapper& query)
{
	// 定义一个Service
	ProcessListService service;
	// 查询数据
	list<ProcessAddDTO::Wrapper> result = service.listAllForProcess(query);
	std::vector<std::vector<std::string>> data;

	// DTO数据转换为vector
	for (auto sub : result) {
		std::vector<std::string> tmp;
		tmp.emplace_back(sub->routeCode);
		tmp.emplace_back(sub->routeName);
		tmp.emplace_back(sub->routeDesc);
		tmp.emplace_back(sub->enableFlag);
		data.emplace_back(tmp);
	}

	// 插入表头
	data.insert(data.begin(), {
		ZH_WORDS_GETTER("excel.header.h5"),
		ZH_WORDS_GETTER("excel.header.h6"),
		ZH_WORDS_GETTER("excel.header.h7"),
		ZH_WORDS_GETTER("excel.header.h8"),
		});

	// 保存到文件
	std::string fileName = "./public/excel/process.xlsx";
	std::string sheetName = ZH_WORDS_GETTER("excel.sheet.s2");
	ExcelComponent excel;
	excel.writeVectorToFile(fileName, sheetName, data);
	std::string filename = "";
	filename = "./public/excel/process.xlsx";
	// 创建一个fastdfs对象及前缀
	ZO_CREATE_DFS_CLIENT_URL(dfs, urlPrefix);
	// 获取文件后缀名
	string suffix = "";
	size_t pos = filename.rfind(".");
	if (pos != string::npos)
	{
		suffix = filename.substr(pos + 1);
	}
	// 上传文件
	string downloadUrl = dfs.uploadFile(filename);
	downloadUrl = urlPrefix + downloadUrl;
	OATPP_LOGD("Multipart", "download url='%s'", downloadUrl.c_str());

	// 响应结果
	auto jvo = StringJsonVO::createShared();
	if (downloadUrl != "") {
		jvo->success(downloadUrl);
	}
	else {
		jvo->fail(downloadUrl);
	}

	return jvo;
}
//8 获取组成工序列表
ProJsonVO::Wrapper ProcessController::execProTable(const ProQuery::Wrapper& query)
{
	return ProJsonVO::Wrapper();
}
//9 添加组成工序
Uint64JsonVO::Wrapper ProcessController::execaddComProcess(const NewProcessDTO::Wrapper& dto)
{
	return {};
}
//10 修改组成工序
Uint64JsonVO::Wrapper ProcessController::execModifyProcess(const ModifyProDTO::Wrapper& dto)
{
	return {};
}
// 11 添加工艺关联产品
Uint64JsonVO::Wrapper ProcessController::execAddRelatePro(const AddRelateProDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	// 非空校验
	if (!dto->item_code || !dto->item_name || !dto->unit_of_measure || !dto->specification)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 有效值校验
	if (dto->item_code->empty() || dto->item_name->empty() || dto->unit_of_measure->empty() || dto->specification->empty())
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}

	// 定义一个Service
	RelateProService service;
	// 执行数据新增
	uint64_t id = service.saveData(dto);
	if (id > 0) {
		jvo->success(UInt64(id));
	}
	else
	{
		jvo->fail(UInt64(id));
	}
	//响应结果
	return jvo;
}
// 12 修改工艺关联产品
Uint64JsonVO::Wrapper ProcessController::execModifyRelatePro(const ModRelateProDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	if (!dto->record_id || dto->record_id <= 0 || !dto->item_code || !dto->item_name || !dto->unit_of_measure ||
		!dto->specification)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 定义一个Service
	RelateProService service;
	// 执行数据修改
	if (service.updateData(dto)) {
		jvo->success(dto->record_id);
	}
	else
	{
		jvo->fail(dto->record_id);
	}
	// 响应结果
	return jvo;
}
// 13 获取产品制程物料BOM列表
ProMaterialPageJsonVO::Wrapper ProcessController::execQueryProMaterial(const ProMaterialQuery::Wrapper& query, const PayloadDTO& payload)
{
	// 定义一个Service
	ProMaterialService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = ProMaterialPageJsonVO::createShared();
	jvo->success(result);
	return jvo;
}
// 14 删除工艺流程
Uint64JsonVO::Wrapper ProcessController::execRemoveProRoute(const UInt64& id)
{
	return {};
}
// 15 删除工艺关联产品
Uint64JsonVO::Wrapper ProcessController::execRemoveRouteProduct(const UInt64& id)
{
	return {};
}
// 16 导出工艺关联产品
StringJsonVO::Wrapper ProcessController::execOutputRouteProduct(const outputRouteProductQuery::Wrapper& query, const PayloadDTO& payload)
{
	return {};
}
// 17 删除产品制程物料BOM
Uint64JsonVO::Wrapper ProcessController::execRemoveProcessBOM(const UInt64& id)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}
// 18 添加产品制程物料BOM
Uint64JsonVO::Wrapper ProcessController::execAddProductMaterial(const ProductMaterialDTO::Wrapper& dto)
{
	return {};
}
// 19 修改产品制程物料BOM
Uint64JsonVO::Wrapper ProcessController::execModifyProductMaterial(const ProductMaterialDTO::Wrapper& dto)
{
	return {};
}

