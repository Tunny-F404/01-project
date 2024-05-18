#pragma once
/*
* 
*/
#ifndef _PLANSUBJECTVO_H_
#define _PLANSUBJECTVO_H_

#include "../../GlobalInclude.h"
#include "../../dto/planSubject/PlanSubjectDTO.h"
#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * ABF:定义一个部门显示VO
 */

 //class DeptTableJsonVO : public JsonVO<List<DeptTableDTO::Wrapper>> {
 //	DTO_INIT(DeptTableJsonVO, JsonVO<List<DeptTableDTO::Wrapper>>);
class PlanSubjectTableJsonVO : public JsonVO<PlanSubjectTableDTO::Wrapper> {
	DTO_INIT(PlanSubjectTableJsonVO, JsonVO<PlanSubjectTableDTO::Wrapper>);

public:
	PlanSubjectTableJsonVO() {
		this->data = {};
	}
};

class PlanSubjectDetailPageJsonVO : public JsonVO<PlanSubjectDetailPageDTO::Wrapper> {
	DTO_INIT(PlanSubjectDetailPageJsonVO, JsonVO<PlanSubjectDetailPageDTO::Wrapper>);

public:
	PlanSubjectDetailPageJsonVO() {
		this->data = {};
	}
};



#include OATPP_CODEGEN_END(DTO)

#endif // !_DEPTVO_H_
