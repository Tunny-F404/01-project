#pragma once
#ifndef _DEPTQUERY_H_
#define _DEPTQUERY_H_

#include "../../GlobalInclude.h"


#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 部门管理查询条件对象
 */
class DeptQuery : public oatpp::DTO
{
	// 定义初始化
	DTO_INIT(DeptQuery, DTO);
	//部门名称
	API_DTO_FIELD_DEFAULT(String, deptName, ZH_WORDS_GETTER("dept.fields.dname"));
	//状态
	API_DTO_FIELD_DEFAULT(Int32, status, ZH_WORDS_GETTER("dept.fields.dstatus"));
	
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_DEPTQUERY_H_