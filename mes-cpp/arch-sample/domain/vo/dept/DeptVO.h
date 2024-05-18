#pragma once
#ifndef _DEPTVO_H_
#define _DEPTVO_H_
#include "../../GlobalInclude.h"
#include "../../dto/dept/DeptDTO.h"
#include OATPP_CODEGEN_BEGIN(DTO)
//定义一个部门列表显示VO
class DeptTableJsonVO : public JsonVO<DeptTableDTO::Wrapper>
{
	// 定义初始化
	DTO_INIT(DeptTableJsonVO, JsonVO<DeptTableDTO::Wrapper>);
	
public:
	DeptTableJsonVO() {
		this->data = {};
	}
};

#include OATPP_CODEGEN_END(DTO)
#endif 
