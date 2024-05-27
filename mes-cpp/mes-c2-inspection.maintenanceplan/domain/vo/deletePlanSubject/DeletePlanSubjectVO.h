#ifndef _DELETEPLANSUBJECT_VO_
#define _DELETEPLANSUBJECT_VO_

#include "../../GlobalInclude.h"
#include "../../dto/deletePlanSubject/DeletePlanSubjectDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
* 点检/保养 显示JsonVO，用于响应给客户端的Json对象
*/
class DeletePlanQueryJsonVO : public JsonVO<DeletePlanQueryDTO::Wrapper> {
	DTO_INIT(DeletePlanQueryJsonVO, JsonVO<DeletePlanQueryDTO::Wrapper>);
};
#include OATPP_CODEGEN_END(DTO)

#endif // !_MACHINERY_PLAN_VO_
