#pragma once


#ifndef _SETPROADD_DTO_
#define _SETPROADD_DTO_
#include "../../GlobalInclude.h"
/**
* 添加工序以及修改工序共用DTO
*/
#include OATPP_CODEGEN_BEGIN(DTO)
class SetProAddTableDTO : public oatpp::DTO
{
	DTO_INIT(SetProAddTableDTO, DTO);
	//唯一标识
	API_DTO_FIELD_DEFAULT(String, processId, ZH_WORDS_GETTER("set.fields.processid"));
	//工序编码
	API_DTO_FIELD_DEFAULT(String, processCode, ZH_WORDS_GETTER("set.fields.processcode"));
	//工序名称
	API_DTO_FIELD_DEFAULT(String, processName, ZH_WORDS_GETTER("set.fields.processname"));
	//是否启用
	API_DTO_FIELD(String, enableFlag, ZH_WORDS_GETTER("set.fields.enableflag"),true,"Y");
	//工序说明
	API_DTO_FIELD_DEFAULT(String, attention, ZH_WORDS_GETTER("set.fields.attention"));
	//备注
	API_DTO_FIELD(String, remark, ZH_WORDS_GETTER("set.fields.remark"),true,"");
};
//class SetProAddTablePageDTO : public PageDTO<SetProAddTableDTO::Wrapper>
//{
//	DTO_INIT(SetProAddTablePageDTO, PageDTO<SetProAddTableDTO::Wrapper>);
//};
#include OATPP_CODEGEN_END(DTO)
#endif // _USERDTO_H_