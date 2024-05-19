#pragma once
#ifndef _PROCESSDETAIL_VO_
#define _PROCESSDETAIL_VO_

#include "../../GlobalInclude.h"
#include "../../dto/process/ProcessListDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 示例分页显示JsonVO，用于响应给客户端的Json对象
 */
class ProcessDetailJsonVO : public JsonVO<ProcessDTO::Wrapper> {
	DTO_INIT(ProcessDetailJsonVO, JsonVO<ProcessDTO::Wrapper>);
};


#include OATPP_CODEGEN_END(DTO)

#endif // !_SAMPLE_VO_
