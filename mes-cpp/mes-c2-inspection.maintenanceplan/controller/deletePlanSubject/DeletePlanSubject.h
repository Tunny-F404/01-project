#ifndef _REMOVEDEVICECONTROLLER_H_
#define _REMOVEDEVICECONTROLLER_H_

#include "domain/vo/BaseJsonVO.h"
#include "ApiHelper.h"
#include "Macros.h"
#include "../../domain/dto/deletePlanSubject/DeletePlanSubjectDTO.h"


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
	API_HANDLER_ENDPOINT(API_M_DEL, "/device-manage/delete-plan", deletePlan, BODY_DTO(DeletePlanTDO::Wrapper, dto), execDeletePlan(dto))

	/*
	std::shared_ptr<oatpp::web::server::api::Endpoint::Info> Z__ENDPOINT_CREATE_ADDITIONAL_INFO_deletePlan() 
	{
		auto info = Z__EDNPOINT_INFO_GET_INSTANCE_deletePlan();
		Z__ENDPOINT_ADD_INFO_deletePlan(info); 
		return info;
	} 
	const std::shared_ptr<oatpp::web::server::api::Endpoint::Info> Z__ENDPOINT_ADDITIONAL_INFO_deletePlan = Z__ENDPOINT_CREATE_ADDITIONAL_INFO_deletePlan();
	void Z__ENDPOINT_ADD_INFO_deletePlan(const std::shared_ptr<oatpp::web::server::api::Endpoint::Info>& info)
	{
		info->summary = YamlHelper().getString(&(ServerInfo::getInstance().getZhDictNode()), "deleteOP.summary.plan");
		info->addResponse<BooleanJsonVO::Wrapper>(Status::CODE_200, "application/json");
	}

	//---
	template<class T> static typename std::shared_ptr<Handler<T>> Z__ENDPOINT_HANDLER_GET_INSTANCE_deletePlan(T* controller) 
	{
		auto handler = std::static_pointer_cast<Handler<T>>(controller->getEndpointHandler("deletePlan"));
		if (!handler) {
			handler = Handler<T>::createShared(controller, &T::Z__PROXY_METHOD_deletePlan, nullptr);
			controller->setEndpointHandler("deletePlan", handler);
		} return handler;
	} 

	std::shared_ptr<oatpp::web::server::api::Endpoint::Info> Z__EDNPOINT_INFO_GET_INSTANCE_deletePlan()
	{
		std::shared_ptr<oatpp::web::server::api::Endpoint::Info> info = getEndpointInfo("deletePlan");
		if (!info) 
		{
			info = oatpp::web::server::api::Endpoint::Info::createShared(); setEndpointInfo("deletePlan", info);
		}
		return info;

	} 

	EndpointInfoBuilder Z__CREATE_ENDPOINT_INFO_deletePlan = [this]() 
		{
			auto info = Z__EDNPOINT_INFO_GET_INSTANCE_deletePlan(); info->name = "deletePlan";
			info->path = ((m_routerPrefix != nullptr) ? m_routerPrefix + "/device-manage/delete-plan" : "/device-manage/delete-plan");
			info->method = "DELETE";
			info->body.name = "dto";
			info->body.required = true;
			info->body.type = DeletePlanTDO::Wrapper::Class::getType(); if (getDefaultObjectMapper()) 
			{
				info->bodyContentType = getDefaultObjectMapper()->getInfo().http_content_type;
			} 
			return info; 
		}; 

	const std::shared_ptr<oatpp::web::server::api::Endpoint> Z__ENDPOINT_deletePlan = createEndpoint(m_endpoints, Z__ENDPOINT_HANDLER_GET_INSTANCE_deletePlan(this), Z__CREATE_ENDPOINT_INFO_deletePlan);
	
	std::shared_ptr<oatpp::web::protocol::http::outgoing::Response> Z__PROXY_METHOD_deletePlan(const std::shared_ptr<oatpp::web::protocol::http::incoming::Request>& __request) {
		if (!getDefaultObjectMapper()) 
		{
			return ApiController::handleError(Status::CODE_500, "ObjectMapper was NOT set. Can't deserialize the request body.");
		} 
		const auto& dto = __request->readBodyToDto<DeletePlanTDO::Wrapper>(getDefaultObjectMapper().get());
		if (!dto) 
		{
			return ApiController::handleError(Status::CODE_400, "Missing valid body parameter '" "dto" "'");
		} 
		return deletePlan(dto);
	} 
	std::shared_ptr<oatpp::web::protocol::http::outgoing::Response> deletePlan(const DeletePlanTDO::Wrapper& dto) 
	{
		return createDtoResponse(Status::CODE_200, execDeletePlan(dto));
	};
	*/

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
	BooleanJsonVO::Wrapper execDeletePlan(const DeletePlanTDO::Wrapper& dto);
};

#include OATPP_CODEGEN_END(ApiController)

#endif // !_REMOVEDEVICECONTROLLER_H_
