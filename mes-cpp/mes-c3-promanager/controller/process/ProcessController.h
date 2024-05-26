#pragma once
#ifndef _PROCESS_CONTROLLER_
#define _PROCESS_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/vo/process/ProcessListVO.h"
#include "domain/query/process/ProcessListQuery.h"
#include "domain/dto/process/ProcessListDTO.h"

#include "domain/query/process/ProcessProductsQuery.h"
#include "domain/dto/process/ProcessProductsDTO.h"
#include "domain/vo/process/ProcessProductsVO.h"
#include "domain/query/process/ProcessQuery.h"

#include "domain/vo/process/ComProVo.h"
#include "domain/dto/process/ComProDTO.h"
#include "domain/query/process/ComProQuery.h"

#include "domain/vo/process/RelateProVO.h"
#include "domain/dto/process/RelateProDTO.h"
#include "domain/dto/process/ProMaterialDTO.h"
#include "domain/vo/process/ProMaterialVO.h"
#include "domain/query/process/ProMaterialQuery.h"

#include "domain/query/process/outputRouteProductQuery.h"

#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 生产管理-工艺流程控制器
 */
class ProcessController : public oatpp::web::server::api::ApiController
{

	API_ACCESS_DECLARE(ProcessController);

public:
	// 1 获取工艺列表
	ENDPOINT_INFO(queryProcessList) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.get.summary1"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProcessListJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "routeCode", ZH_WORDS_GETTER("process.field.routecode"), "R1126", false);
		API_DEF_ADD_QUERY_PARAMS(String, "routeName", ZH_WORDS_GETTER("process.field.name"), "111", false);
		API_DEF_ADD_QUERY_PARAMS(String, "enableFlag", ZH_WORDS_GETTER("process.field.flag"), "Y", false);
	}
	ENDPOINT(API_M_GET, "/pro/get-list", queryProcessList, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(Query, ProcessListQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProcessList(Query));//, authObject->getPayload()
	}

	// 2 获取工艺详情
	ENDPOINT_INFO(queryProcessDetail) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.get.summary2"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProcessDetailJsonVO);
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(UInt32, "routeId", ZH_WORDS_GETTER("process.field.id"), 239, true);
	}
	ENDPOINT(API_M_GET, "/pro/get-detail", queryProcessDetail, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(Query, ProcessDetailQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProcessDetail(Query));
	}

	// 3 添加工艺流程
	ENDPOINT_INFO(addProcess) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.post.summary1"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	ENDPOINT(API_M_POST, "/pro/add-process", addProcess, BODY_DTO(ProcessAddDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddProcess(dto));
	}

	// 4 修改工艺
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("process.put.summary1"), modifyProcess, Uint64JsonVO::Wrapper);
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/pro/modify-process", modifyProcess, BODY_DTO(ProcessAddDTO::Wrapper, dto), execModifyBasicProcess(dto));

	// 5 获取工艺关联产品列表
	ENDPOINT_INFO(queryCorrProduct) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.get.summary3"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProductsPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "id", ZH_WORDS_GETTER("product.field.id"), "249", false);

	}
	ENDPOINT(API_M_GET, "/pro/get-corrprocess", queryCorrProduct, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, ProcessProductsQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProducts(userQuery));
	}

	// 6 删除组成工序
	ENDPOINT_INFO(removeProcess) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("process.delete.summary1"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
	}
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/pro/delete-process/{id}", removeProcess, BODY_DTO(List<UInt64>, id), execRemoveProcess(id));

	// 7 工艺导出
	ENDPOINT_INFO(queryProcess) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.get_field.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(StringJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "code", ZH_WORDS_GETTER("process.field.route_code"), "R1121", false);
		API_DEF_ADD_QUERY_PARAMS(String, "name", ZH_WORDS_GETTER("process.field.route_name"), ZH_WORDS_GETTER("process.field.example"), false);
		API_DEF_ADD_QUERY_PARAMS(String, "flag", ZH_WORDS_GETTER("process.field.enable_flag"), "Y", false);
	}
	ENDPOINT(API_M_POST, "/set/export-process", queryProcess, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, ProcessQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProcess(userQuery));
	}

	// 8 获取组成工序列表
	ENDPOINT_INFO(QueryProTable) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.get.summary4"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(String, "process_name", ZH_WORDS_GETTER("pro.fields.proName"), "01 star", false);
		API_DEF_ADD_QUERY_PARAMS(String, "process_code", ZH_WORDS_GETTER("pro.fields.proCode"), "0", false);
		API_DEF_ADD_QUERY_PARAMS(String, "key_flag", ZH_WORDS_GETTER("pro.fields.key_flag"), "No", false);
	}
	ENDPOINT(API_M_GET, "/pro/query-pro-table", QueryProTable, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(Query, ProQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execProTable(Query));
	}

	// 9 添加组成工序
	ENDPOINT_INFO(addComProcess) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.add.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	ENDPOINT(API_M_POST, "/pro/add-comprocess", addComProcess, BODY_DTO(NewProcessDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execaddComProcess(dto));
	}

	// 10 修改组成工序
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("process.modify.summary"), ModifyProcess, Uint64JsonVO::Wrapper);
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/pro/modify-comprocess", ModifyProcess, BODY_DTO(ModifyProDTO::Wrapper, dto), execModifyProcess(dto));

	//11 添加工艺关联产品
	ENDPOINT_INFO(addRelatePro) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("RelatePro.summary.AddRelatePro"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	ENDPOINT(API_M_POST, "/pro/add-relatepro", addRelatePro, BODY_DTO(AddRelateProDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddRelatePro(dto));
	}

	// 12 修改工艺关联产品
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("RelatePro.summary.ModRelatePro"), modifyRelatePro, Uint64JsonVO::Wrapper);
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/pro/modify-relatepro", modifyRelatePro, BODY_DTO(ModRelateProDTO::Wrapper, dto), execModifyRelatePro(dto));

	// 13 获取产品制程物料BOM列表
	ENDPOINT_INFO(queryProMaterial) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("RelatePro.summary.ProMaterial"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(ProMaterialPageJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();
		// 定义其他查询参数描述
		API_DEF_ADD_QUERY_PARAMS(UInt64, "item_code", ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.item_code"), 1, false);
		API_DEF_ADD_QUERY_PARAMS(String, "item_name", ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.item_name"), "N", false);
	}
	ENDPOINT(API_M_GET, "/pro/query-promaterial-table", queryProMaterial, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, ProMaterialQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execQueryProMaterial(query, authObject->getPayload()));
	}

	// 14 定义删除工艺流程接口
	ENDPOINT_INFO(removeProRoute) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("process.route.delete1"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "id", ZH_WORDS_GETTER("process.route.id"), 1, true);
	}
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/pro/route/{id}", removeProRoute, PATH(UInt64, id), execRemoveProRoute(id));


	// 15 定义删除工艺关联产品接口
	ENDPOINT_INFO(removeRouteProduct) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("process.route.delete2"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "id", ZH_WORDS_GETTER("process.route.corproductid"), 1, true);
	}
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/pro/route/product/{id}", removeRouteProduct, PATH(UInt64, id), execRemoveRouteProduct(id));

	// 16 定义工艺关联产品导出接口
	ENDPOINT_INFO(outputRouteProduct) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.route.output"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(StringJsonVO);
		// 定义分页查询参数描述
		API_DEF_ADD_PAGE_PARAMS();

	}
	ENDPOINT(API_M_POST, "/pro/export-corproducts", outputRouteProduct, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(userQuery, outputRouteProductQuery, queryParams);
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execOutputRouteProduct(userQuery, authObject->getPayload()));
	}

	// 17 删除产品制程物料BOM
	ENDPOINT_INFO(removeProcessBOM) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("process.delete.summary2"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "id", ZH_WORDS_GETTER("process.field.BOMid"), 1, true);
	}
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/pro/delete/{id}", removeProcessBOM, PATH(UInt64, id), execRemoveProcessBOM(id));

	// 18 添加产品制程物料BOM
	ENDPOINT_INFO(addProductMaterial) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("process.post.summary2"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO);
	}
	ENDPOINT(API_M_POST, "/pro/add-productmaterial", addProductMaterial, BODY_DTO(ProductMaterialDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execAddProductMaterial(dto));
	}

	// 19 修改产品制程BOM
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("process.put.summary2"), modifyProductMaterial, Uint64JsonVO::Wrapper);
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/pro/modify-productmaterial", modifyProductMaterial, BODY_DTO(ProductMaterialDTO::Wrapper, dto), execModifyProductMaterial(dto));

private:
	// 1 获取工艺列表数据
	ProcessListJsonVO::Wrapper execQueryProcessList(const ProcessListQuery::Wrapper& query);
	// 2 查询工艺详情
	ProcessDetailJsonVO::Wrapper execQueryProcessDetail(const ProcessDetailQuery::Wrapper& query);
	// 3 添加工艺流程
	Uint64JsonVO::Wrapper execAddProcess(const ProcessAddDTO::Wrapper& dto);
	// 4 修改工艺基础数据
	Uint64JsonVO::Wrapper execModifyBasicProcess(const ProcessAddDTO::Wrapper& dto);
	// 5 获取工艺关联产品列表
	ProductsPageJsonVO::Wrapper execQueryProducts(const ProcessProductsQuery::Wrapper& query);
	// 6 删除组成工序（支持批量删除）
	Uint64JsonVO::Wrapper execRemoveProcess(const List<UInt64>& id);
	// 7 工艺导出
	StringJsonVO::Wrapper execQueryProcess(const ProcessQuery::Wrapper& query);
	// 8 获取组成工序列表
	ProJsonVO::Wrapper execProTable(const ProQuery::Wrapper& query);
	// 9 添加组成工序
	Uint64JsonVO::Wrapper execaddComProcess(const NewProcessDTO::Wrapper& dto);
	// 10 修改组成工序
	Uint64JsonVO::Wrapper execModifyProcess(const ModifyProDTO::Wrapper& dto);
	// 11 添加工艺关联产品
	Uint64JsonVO::Wrapper execAddRelatePro(const AddRelateProDTO::Wrapper& dto);
	// 12 修改工艺关联产品
	Uint64JsonVO::Wrapper execModifyRelatePro(const ModRelateProDTO::Wrapper& dto);
	// 13 获取产品制程物料BOM列表
	ProMaterialPageJsonVO::Wrapper execQueryProMaterial(const ProMaterialQuery::Wrapper& query, const PayloadDTO& payload);
	// 14 删除工艺流程
	Uint64JsonVO::Wrapper execRemoveProRoute(const UInt64& id);
	// 15 删除工艺关联产品
	Uint64JsonVO::Wrapper execRemoveRouteProduct(const UInt64& id);
	// 16 导出工艺关联产品
	StringJsonVO::Wrapper execOutputRouteProduct(const outputRouteProductQuery::Wrapper& query, const PayloadDTO& payload);
	// 17 删除产品制程物料BOM
	Uint64JsonVO::Wrapper execRemoveProcessBOM(const UInt64& id);
	// 18 添加产品制程物料BOM
	Uint64JsonVO::Wrapper execAddProductMaterial(const ProductMaterialDTO::Wrapper& dto);
	// 19 修改产品制程物料BOM
	Uint64JsonVO::Wrapper execModifyProductMaterial(const ProductMaterialDTO::Wrapper& dto);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_


