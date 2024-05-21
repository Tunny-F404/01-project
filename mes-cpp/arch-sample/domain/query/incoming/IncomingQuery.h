#pragma once

#ifndef _INCOMING_QUERY_
#define _INCOMING_QUERY_

#include "../../GlobalInclude.h"


#include OATPP_CODEGEN_BEGIN(DTO)

/**
* 来料检验查询条件对象
*/
class IncomingQuery : public oatpp::DTO
{
	DTO_INIT(IncomingQuery, DTO);
	// 来料检验单编号
	API_DTO_FIELD_DEFAULT(String, incomingCode, ZH_WORDS_GETTER("incoming.fields.incode"));
	// 来料检验单名称
	API_DTO_FIELD_DEFAULT(String, vendorCode, ZH_WORDS_GETTER("incoming.fields.vcode"));
	// 供应商简称
	API_DTO_FIELD_DEFAULT(String, vendorName, ZH_WORDS_GETTER("incoming.fields.vname"));
	// 供应商批次号
	API_DTO_FIELD_DEFAULT(String, vendorBatch, ZH_WORDS_GETTER("incoming.fields.vbatch"));
	// 产品物料编码
	API_DTO_FIELD_DEFAULT(String, itemCode, ZH_WORDS_GETTER("incoming.fields.itcode"));
	// 产品物料名称
	API_DTO_FIELD_DEFAULT(String, itemName, ZH_WORDS_GETTER("incoming.fields.itname"));
	// 检测结果
	API_DTO_FIELD_DEFAULT(String, checkResult, ZH_WORDS_GETTER("incoming.fields.spresult"));
	// 来料日期
	API_DTO_FIELD_DEFAULT(String, reciveDate, ZH_WORDS_GETTER("incoming.fields.indate"));
	// 检测日期
	API_DTO_FIELD_DEFAULT(String, inspectDate, ZH_WORDS_GETTER("incoming.fields.spdate"));
	// 检测人员
	API_DTO_FIELD_DEFAULT(String, inspector, ZH_WORDS_GETTER("incoming.fields.spector"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_INCOMING_QUERY_