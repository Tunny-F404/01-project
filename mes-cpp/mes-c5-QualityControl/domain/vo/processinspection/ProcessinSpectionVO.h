#pragma once
#ifndef _PROCESSINSPECTION_VO_
#define _PROCESSINSPECTION_VO_

#include "../../GlobalInclude.h"
#include "../../dto/ProcessinSpection/ProcessinSpectionDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 示例显示JsonVO，用于响应给客户端的Json对象
 */
class ProcessinSpectionJsonVO : public JsonVO<ProcessinSpectionDTO::Wrapper> {
	DTO_INIT(ProcessinSpectionJsonVO, JsonVO<ProcessinSpectionDTO::Wrapper>);
};

class ProcessinSpectionQueryJsonVO : public JsonVO<ProcessinSpectionQueryDTO::Wrapper> {
	DTO_INIT(ProcessinSpectionQueryJsonVO, JsonVO<ProcessinSpectionQueryDTO::Wrapper>);
};

/**
 * 示例分页显示JsonVO，用于响应给客户端的Json对象
 */
class ProcessinSpectionPageJsonVO : public JsonVO<ProcessinSpectionPageDTO::Wrapper> {
	DTO_INIT(ProcessinSpectionPageJsonVO, JsonVO<ProcessinSpectionPageDTO::Wrapper>);
};

class ProcessinSpectionQueryPageJsonVO : public JsonVO<ProcessinSpectionQueryPageDTO::Wrapper> {
	DTO_INIT(ProcessinSpectionQueryPageJsonVO, JsonVO<ProcessinSpectionQueryPageDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)

#endif // !_PROCESSINSPECTION_VO_