#pragma once
#ifndef _ADD_QUERY_
#define _ADD_QUERY_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 *  项目计划添加对象
 */
class AddQuery : public oatpp::DTO
{
	DTO_INIT(AddQuery, DTO);
	API_DTO_FIELD_DEFAULT(String, subjectCode, ZH_WORDS_GETTER("add-mj.fields.scode"));
	//项目名称
	API_DTO_FIELD_DEFAULT(String, subjectName, ZH_WORDS_GETTER("add-mj.fields.sname"));
	//项目类型
	API_DTO_FIELD_DEFAULT(String, subjectType, ZH_WORDS_GETTER("add-mj.fields.stype"));
	//是否启用
	API_DTO_FIELD_DEFAULT(String, attr3, ZH_WORDS_GETTER("add-mj.fields.attr3"));
	//项目内容
	API_DTO_FIELD_DEFAULT(String, subjectContent, ZH_WORDS_GETTER("add-mj.fields.scontent"));
	//标准
	API_DTO_FIELD_DEFAULT(String, subjectStandard, ZH_WORDS_GETTER("add-mj.fields.sstandard"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_QUERY_