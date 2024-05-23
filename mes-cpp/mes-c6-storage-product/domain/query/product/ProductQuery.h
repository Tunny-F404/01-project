#pragma once
#ifndef _PRODUCTQUERY_H_
#define _PRODUCTQUERY_H_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 生产领料列表查询
 */
class ProductQuery : public PageQuery
{
	// 定义初始化
	DTO_INIT(ProductQuery, PageQuery);
	//领料单编号
	API_DTO_FIELD_DEFAULT(String, pnum, ZH_WORDS_GETTER("product.fields.pnum"));
	//领料单名称
	API_DTO_FIELD_DEFAULT(String, pname, ZH_WORDS_GETTER("product.fields.pname"));
	//仓库名称
	API_DTO_FIELD_DEFAULT(String, prname, ZH_WORDS_GETTER("product.fields.prname"));
	//领料日期
	API_DTO_FIELD_DEFAULT(String, pdate, ZH_WORDS_GETTER("product.fields.pdate"));
	//单据状态
	API_DTO_FIELD_DEFAULT(String, pstatus, ZH_WORDS_GETTER("product.fields.pstatus"));

};
//详情查询
class ProductDetailQuery : public oatpp::DTO
{
	// 定义初始化
	DTO_INIT(ProductQuery, DTO);
	//领料单编号
	API_DTO_FIELD_DEFAULT(String, pnum, ZH_WORDS_GETTER("product.fields.pnum"));

};
#include OATPP_CODEGEN_END(DTO)
#endif // !_DEPTQUERY_H_