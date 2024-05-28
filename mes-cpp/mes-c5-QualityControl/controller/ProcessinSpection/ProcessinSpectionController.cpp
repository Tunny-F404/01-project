#include "stdafx.h"
#include "ProcessinSpectionController.h"
#include "../ApiDeclarativeServicesHelper.h"
#include "../../service/processinspection/ProcessInspectionService.h"
#include "../../dao/processinspection/ProcessInspectionDAO.h"
#include "Macros.h"
#include "ExcelComponent.h"
#include "gtest/gtest.h"
#include "FastDfsClient.h"
#include "../include/NacosClient.h"

ProcessinSpectionQueryPageJsonVO::Wrapper ProcessinSpectionController::execQueryProcessinSpection(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload)
{
	ProcessInspectionService service;
	//执行查询
	auto result = service.listAll(query);
	auto vo = ProcessinSpectionQueryPageJsonVO::createShared();
	//把QueryPageDTO装到vo中
	vo->success(result);
	return vo;
}

Uint64JsonVO::Wrapper ProcessinSpectionController::execRemoveProcessinSpection(const List<UInt64>& ids)
{
	ProcessInspectionService service;
	//查询是否每一个id都符合,符合的查询,
	int flag = 0;
	auto result = Uint64JsonVO::createShared();
	for (auto i = ids->begin(); i != ids->end(); ++i) {
		auto x = (*i).getValue(0);
		//参数错误
		if (x < 0 || !x) {
			if(!flag)
				result->init(UInt64(-1), RS_PARAMS_INVALID);
			flag = 1;
		}
		else {
			//删除失败
			if (!service.remove(x)) {
				if (!flag)
					result->init(UInt64(-1), RS_FAIL);
				flag = 1;
			}
		}
	}
	if(!flag)
		result->init(UInt64(1), RS_SUCCESS);
	return result;
}

StringJsonVO::Wrapper ProcessinSpectionController::execExportProcessinSpection(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload)
{
	ExcelComponent excel;
	ProcessInspectionService service;
	//获取数据
	auto result = service.listAllExort(query);
	vector<vector<std::string>> data;
	stringstream ss;
	//读取数据
	for (auto i = result.begin(); i != result.end();++i) {
		auto x = *i;
		vector<std::string> row;
		ss.clear();
		ss << x.getId();
		row.push_back(ss.str());

		ss.str("");
		ss << x.getIpqc_Code();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getIpqc_Type();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getWorkorder_Code();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getItem_Code();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getItem_Name();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getSpecification();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getUnit_Of_Measure();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getQuantity_Check();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getCheck_Result();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getInspect_Date();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getInspector();
		row.push_back(ss.str());
		ss.str("");

		ss.str("");
		ss << x.getStatus_Order();
		row.push_back(ss.str());
		ss.str("");

		data.push_back(row);
	}
	std::string fileName = ZH_WORDS_GETTER("excel.ProcessInspection.path");
	// 中文词典 
	std::string sheetName = ZH_WORDS_GETTER("excel.sheet.s1");
	// 插入表头
	data.insert(data.begin(), {
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h1"),
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h2"),
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h3") ,
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h4") ,
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h5") ,
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h6"),
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h7"),
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h8"),
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h9"),
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h10"),
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h11"),
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h12"),
		ZH_WORDS_GETTER("excel.ProcessInspection.header.h13")
		});
	//创建excel
	excel.writeVectorToFile(fileName, sheetName,data);
	//创建文件服务器对象,并拼接url前缀
	ZO_CREATE_DFS_CLIENT_URL(dfs, urlPrefix);
	//后缀名长度
	auto pos = fileName.rfind(".");
	string suffix = "";
	//有后缀名
	if (pos != string::npos) {
		suffix = fileName.substr(pos + 1);
	}
	//上传文件
	auto downloadUrl=dfs.uploadFile(fileName);
	downloadUrl = urlPrefix + downloadUrl;
	auto ans = StringJsonVO::createShared();
	//只有前缀,上传失败
	if (downloadUrl== urlPrefix) {
		ans->init("error", RS_FAIL);
	}
	else {
		ans->init(downloadUrl, RS_SUCCESS);
	}
	//删除本地文件
	std::remove(fileName.c_str());
	return ans;
}

ProcessinSpectionJsonVO::Wrapper ProcessinSpectionController::execQueryInspectionDetails(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload)
{
	//ProcessinSpectionService service;
	//auto result = service.getInspectionDetails(query);
	auto jvo = ProcessinSpectionJsonVO::createShared();
	//jvo->success(result);
	//jvo->success(String("test 1"));
	//jvo->success(1);
	return jvo;
}

Uint64JsonVO::Wrapper ProcessinSpectionController::execModifyTheProcessInspection(const ProcessinSpectionDTO::Wrapper& dto)
{
	//// 定义返回数据对象
	//auto jvo = Uint64JsonVO::createShared();
	//// 参数校验
	//if (!dto->id || dto->id <= 0)
	//{
	//	jvo->init(UInt64(-1), RS_PARAMS_INVALID);
	//	return jvo;
	//}
	//// 定义一个Service
	//ProcessInspectionService service;
	//// 执行数据修改
	//if (service.updateData(dto)) {
	//	jvo->success(dto->id);
	//}
	//else
	//{
	//	jvo->fail(dto->id);
	//}
	//// 响应结果
	//return jvo;
	return {};
}

ProcessinSpectionPageJsonVO::Wrapper ProcessinSpectionController::execAddProcessInspection(const ProcessinSpectionQuery::Wrapper& query, const PayloadDTO& payload)
{
	return {};
}
