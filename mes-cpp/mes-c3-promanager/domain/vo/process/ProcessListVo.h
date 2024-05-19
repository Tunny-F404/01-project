#pragma once
#ifndef _PROCESSLIST_VO_
#define _PROCESSLIST_VO_

#include "../../GlobalInclude.h"
#include "../../dto/process/ProcessListDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 示例分页显示JsonVO，用于响应给客户端的Json对象
 */
class ProcessListJsonVO : public JsonVO<ProcessListDTO::Wrapper> {
	DTO_INIT(ProcessListJsonVO, JsonVO<ProcessListDTO::Wrapper>);
};


#include OATPP_CODEGEN_END(DTO)

#endif // !_SAMPLE_VO_