#pragma once
/*

 @Author: Croissant
 @Date: 2024/5/18

*/
#ifndef _WORKFIXTURETYPENAMELISTVO_H_
#define _WORKFIXTURETYPENAMELISTVO_H_

#include "../../GlobalInclude.h"
#include "../../dto/WorkFixture/WorkFixtureTypeNameListDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 示例显示JsonVO，用于响应给客户端的Json对象
 */
class WorkFixtureTypeNameListJsonVO : public JsonVO<WorkFixtureTypeNameListDTO::Wrapper> {
	DTO_INIT(WorkFixtureTypeNameListJsonVO, JsonVO<WorkFixtureTypeNameListDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)

#endif // !_WORKFIXTURETYPENAMELISTVO_H_