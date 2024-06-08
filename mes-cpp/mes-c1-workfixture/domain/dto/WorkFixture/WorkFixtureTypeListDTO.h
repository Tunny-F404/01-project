#pragma once
/*

 @Author: Croissant
 @Date: 2024/5/17

*/
#ifndef _WORKFIXTURETYPELISTDTO_H_
#define _WORKFIXTURETYPELISTDTO_H_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 工装夹具/类型设置/工装夹具类型列表DTO 分页 条件 type
 */
class WorkFixtureTypeListDTO : public PageQuery
{
	DTO_INIT(WorkFixtureTypeListDTO, DTO);
	//工装夹具类型ID
	API_DTO_FIELD_DEFAULT(UInt64, toolTypeId, ZH_WORDS_GETTER("workfixture.type.fields.id"));
	//工装夹具类型编码
	API_DTO_FIELD_DEFAULT(String, toolTypeCode, ZH_WORDS_GETTER("workfixture.type.fields.code"));
	//工装夹具类型名称
	API_DTO_FIELD_DEFAULT(String, toolTypeName, ZH_WORDS_GETTER("workfixture.type.fields.name"));
	//工装夹具类型是否编码管理N/Y 
	//API_DTO_FIELD_DEFAULT(String, codeFlag, ZH_WORDS_GETTER("workfixture.type.fields.codeflag"));
	//工装夹具类型保养维护类型 REGULAR定期维护 USAGE按使用次数维护
	API_DTO_FIELD(String, maintenType, ZH_WORDS_GETTER("workfixture.type.fields.mtype"), true, "");
	//工装夹具类型保养周期
	//API_DTO_FIELD(Int32, maintenPriod, ZH_WORDS_GETTER("workfixture.type.fields.mpriod"), true, 0);
	//工装夹具类型备注
	//API_DTO_FIELD(String, remark, ZH_WORDS_GETTER("workfixture.type.fields.remark"), true, "");

};
class WorkFixtureTypeListPageDTO : public PageDTO<WorkFixtureTypeListDTO::Wrapper>
{
	DTO_INIT(WorkFixtureTypeListPageDTO, PageDTO<WorkFixtureTypeListDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_WORKFIXTURETYPELISTDTO_H_