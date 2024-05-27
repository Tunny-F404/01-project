#ifndef _REMOVEDEVICECONTROLLER_H_
#define _REMOVEDEVICECONTROLLER_H_

#include "domain/vo/BaseJsonVO.h"
#include "ApiHelper.h"
#include "Macros.h"
#include "../../domain/dto/deletePlanSubject/DeletePlanSubjectDTO.h"
//---
#include "../../domain/vo/deletePlanSubject/DeletePlanSubjectVO.h"
#include "../../domain/dto/deletePlanSubject/DeletePlanSubjectDTO.h"
#include "../../domain/query/deletePlanSubject/DeletePlanSubjectQuery.h"


#include OATPP_CODEGEN_BEGIN(ApiController)

// 删除数据不需要自定义JsonVO，只要返回true或false即可，直接使用学长在BaseJsonVO.h中定义的BooleanJsonVO即可
// 删除数据不需要Query参数，没有分页查询或者其它额外的参数，它的删除是通过前端由用户在基础表单数据项中勾选得到的

class DeletePlanSubjectController : public oatpp::web::server::api::ApiController
{
	// 定义控制器访问入口
	API_ACCESS_DECLARE(DeletePlanSubjectController)
public: // 定义接口
	/*
	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("planSubject.op.deleteT"), deletePlanSubject, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/inspection-maintennace/delete-opration", deletePlanSubject, BODY_DTO(DeletePlanSubjectDTO::Wrapper, dto), execDeletePlanSubject(dto))

	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("planSubject.op.deleteOneToMany"), deletePlanSubjectOneToMany, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/inspection-maintennace/del-one-to-many", deletePlanSubjectOneToMany, BODY_DTO(DeletePlanSubjectOneToManyDTO::Wrapper, dto), execDeletePlanSubjectOneToMany(dto))
	*/
	/*
	//-------------↓abf，扩充（示例）
	//单一主键
	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("deleteTemplate.summary.deleteUnique"), deleteUnique, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/delete-template/keyUnique", deleteUnique, BODY_DTO(DeleteTableUniqueDTO::Wrapper, dto), execDeleteUnique(dto))
	//主从主键
	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("deleteTemplate.summary.deleteShared"), deleteShared, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/delete-template/keyShared", deleteShared, BODY_DTO(DeleteTableSharedDTO::Wrapper, dto), execDeleteShared(dto))
	*/
	//----↓abf，删除【计划，计划涉及的项目，计划涉及的设备】

	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("deleteOP.summary.machiner"), deletePlanMachiner, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/device-manage/delete-plan-machiner", deletePlanMachiner, BODY_DTO(DeleteMachinerDTO::Wrapper, dto), execDeletePlanMachiner(dto))

	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("deleteOP.summary.subject"), deletePlanSubject, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/device-manage/delete-plan-subject", deletePlanSubject, BODY_DTO(DeleteSubjectDTO::Wrapper, dto), execDeletePlanSubject(dto))

	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("deleteOP.summary.plan"), deletePlan, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/device-manage/delete-plan", deletePlan, BODY_DTO(DeletePlanDTO::Wrapper, dto), execDeletePlan(dto))
		
	//API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("machinery-plan.query-details.summary"), deletePlanQuery, DeletePlanQueryJsonVO::Wrapper)
	//API_HANDLER_ENDPOINT(API_M_GET, "/device-manage/delete-plan", deletePlanQuery, BODY_DTO(DeletePlanQuery::Wrapper, dto), execDeletePlanQuery(dto))

	//--------另一种描述
	// 定义点检/保养设备计划列表接口描述
	ENDPOINT_INFO(deletePlanQuery) {
	// 定义接口标题
	API_DEF_ADD_TITLE(ZH_WORDS_GETTER("machinery-plan.query-details.summary"));
	// 定义默认授权参数
	API_DEF_ADD_AUTH();
	// 定义响应参数格式
	API_DEF_ADD_RSP_JSON_WRAPPER(DeletePlanQueryJsonVO);
	// 定义其他参数描述
	API_DEF_ADD_QUERY_PARAMS(Int64, "plan_id", ZH_WORDS_GETTER("machinery-plan.field.plan-id"), 69, true);
	}
	// 定义查询设备清单列表接口处理
	ENDPOINT(API_M_GET, "/device-manage/delete-plan-query", deletePlanQuery, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
	// 解析领域模型
	API_HANDLER_QUERY_PARAM(query_delete_plan, DeletePlanQuery, queryParams);
	// 呼叫执行函数响应结果
	API_HANDLER_RESP_VO(execDeletePlanQuery(query_delete_plan));
	}

	//// 定义点检/保养设备计划列表接口描述
	//ENDPOINT_INFO(deletePlanQuery)
	//{
	//	// 定义接口标题
	//	API_DEF_ADD_TITLE(ZH_WORDS_GETTER("machinery-plan.query-details.summary"));
	//    // 定义默认授权参数
	//    API_DEF_ADD_AUTH();
	//    // 定义响应参数格式
	//    API_DEF_ADD_RSP_JSON_WRAPPER(DeletePlanQueryJsonVO);
	//    // 定义其他参数描述
	//    API_DEF_ADD_QUERY_PARAMS(String, "plan_id", ZH_WORDS_GETTER("machinery-plan.field.plan-id"), "65", true);
	//}
	//// 定义查询设备清单列表接口处理
	//ENDPOINT(API_M_GET, "/device-manage/delete-plan-query", deletePlanQuery, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) 
	//{
	//// 解析领域模型
	//API_HANDLER_QUERY_PARAM(queryPlan, DeletePlanQueryJsonVO, queryParams);
	//// 呼叫执行函数响应结果
	//API_HANDLER_RESP_VO(execDeletePlanQuery(queryPlan));
	//}


private: // 定义接口执行函数

	// 前端发过来的dto由这个函数执行
	/*
	BooleanJsonVO::Wrapper execDeletePlanSubject(const DeletePlanSubjectDTO::Wrapper& dto);
	BooleanJsonVO::Wrapper execDeletePlanSubjectOneToMany(const DeletePlanSubjectOneToManyDTO::Wrapper& dto);
	*/

	/*
	//----------------↓abf，扩充（示例）
	BooleanJsonVO::Wrapper execDeleteUnique(const DeleteTableUniqueDTO::Wrapper& dto);
	BooleanJsonVO::Wrapper execDeleteShared(const DeleteTableSharedDTO::Wrapper& dto);
	//----↓abf，删除【计划，计划涉及的项目，计划涉及的设备】
	*/
	BooleanJsonVO::Wrapper execDeletePlanMachiner(const DeleteMachinerDTO::Wrapper& dto);
	BooleanJsonVO::Wrapper execDeletePlanSubject(const DeleteSubjectDTO::Wrapper& dto);
	BooleanJsonVO::Wrapper execDeletePlan(const DeletePlanDTO::Wrapper& dto);

	DeletePlanQueryJsonVO::Wrapper execDeletePlanQuery(const DeletePlanQuery::Wrapper& query);


	//MachineryPlanDetailsJsonVO::Wrapper execQueryMachineryPlanDetails(const MachineryPlanDetailsQuery::Wrapper& query);
};

#include OATPP_CODEGEN_END(ApiController)

#endif // !_REMOVEDEVICECONTROLLER_H_
