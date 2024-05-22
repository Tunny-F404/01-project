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
	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("planSubject.op.deleteT"), deletePlanSubject, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/inspection-maintennace/delete-opration", deletePlanSubject, BODY_DTO(DeletePlanSubjectDTO::Wrapper, dto), execDeletePlanSubject(dto))

	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("planSubject.op.deleteOneToMany"), deletePlanSubjectOneToMany, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/inspection-maintennace/del-one-to-many", deletePlanSubjectOneToMany, BODY_DTO(DeletePlanSubjectOneToManyDTO::Wrapper, dto), execDeletePlanSubjectOneToMany(dto))
	
	//-------------↓abf，扩充;
	//单一主键
	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("deleteTemplate.summary.deleteUnique"), deleteUnique, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/delete-template/keyUnique", deleteUnique, BODY_DTO(DeleteTableUniqueDTO::Wrapper, dto), execDeleteUnique(dto))
	//主从主键
	API_DEF_ENDPOINT_INFO(ZH_WORDS_GETTER("deleteTemplate.summary.deleteShared"), deleteShared, BooleanJsonVO::Wrapper)
	API_HANDLER_ENDPOINT(API_M_DEL, "/delete-template/keyShared", deleteShared, BODY_DTO(DeleteTableSharedDTO::Wrapper, dto), execDeleteShared(dto))
private: // 定义接口执行函数

	// 前端发过来的dto由这个函数执行
	BooleanJsonVO::Wrapper execDeletePlanSubject(const DeletePlanSubjectDTO::Wrapper& dto);
	BooleanJsonVO::Wrapper execDeletePlanSubjectOneToMany(const DeletePlanSubjectOneToManyDTO::Wrapper& dto);
	//----------------↓abf，扩充
	BooleanJsonVO::Wrapper execDeleteUnique(const DeleteTableUniqueDTO::Wrapper& dto);
	BooleanJsonVO::Wrapper execDeleteShared(const DeleteTableSharedDTO::Wrapper& dto);
};

#include OATPP_CODEGEN_END(ApiController)

#endif // !_REMOVEDEVICECONTROLLER_H_
