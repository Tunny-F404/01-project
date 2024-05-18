#pragma once
#include "../../GlobalInclude.h"
#include "../../dto/WorkFixtureDTO/WorkFixtureDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 工装夹具列表的Json显示对象，可分页，用于相应给客户端的Json对象
 */
class WorkFixtureJsonVO : public JsonVO<List<WorkFixturePageDTO::Wrapper>> {
	DTO_INIT(WorkFixtureJsonVO, JsonVO<List<WorkFixturePageDTO::Wrapper>>);
};

/**
 * 工装夹具详情的显示对象（无分页）
 */
class WorkFixtureDetailJsonVO : public JsonVO<List<WorkFixtureDetailDTO::Wrapper>> {
	DTO_INIT(WorkFixtureDetailJsonVO, WorkFixtureDetailDTO);
};

#include OATPP_CODEGEN_END(DTO)