#pragma once

#ifndef _GETWORKSTATIONLIST_DTO_H_
#define _GETWORKSTATIONLIST_DTO_H_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 工作站列表数据模型
 */
class GetWorkStationListDTO : public oatpp::DTO
{
	DTO_INIT(GetWorkStationListDTO, DTO);
	// 唯一标识（工作站ID）
	API_DTO_FIELD_DEFAULT(UInt64, workstationId, ZH_WORDS_GETTER("getlist.fields.workstationId"));
	// 工作站编号
	API_DTO_FIELD_DEFAULT(String, workstationCode, ZH_WORDS_GETTER("getlist.fields.workstationCode"));
	//工作站名称
	API_DTO_FIELD_DEFAULT(String, workstationName, ZH_WORDS_GETTER("getlist.fields.workstationCode"));
	// 工作站地点
	API_DTO_FIELD_DEFAULT(String, workstationAddress, ZH_WORDS_GETTER("getlist.fields.workstationAddress"));
	//所在车间的名称
	API_DTO_FIELD_DEFAULT(String, workshopName, ZH_WORDS_GETTER("getlist.fields.workshopName"));
	//所属工序（工序名称）
	API_DTO_FIELD_DEFAULT(String, processName, ZH_WORDS_GETTER("getlist.fields.processName"));
	//是否启用—带默认值'Y'
	API_DTO_FIELD(String, enableFlag, ZH_WORDS_GETTER("getlist.fields.enableFlag"), true, "Y");
	//备注
	API_DTO_FIELD(String, remark, ZH_WORDS_GETTER("getlist.fields.remark"),true,"");
};


/**
 * 定义一个工作站列表分页传输对象
 */
class GetWorkStationListPageDTO : public PageDTO<GetWorkStationListDTO::Wrapper>
{
	DTO_INIT(GetWorkStationListPageDTO, PageDTO<GetWorkStationListDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)
#endif // _USERDTO_H_