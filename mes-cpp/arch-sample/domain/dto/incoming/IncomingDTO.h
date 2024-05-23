#pragma once

#ifndef _INCOMING_DTO_
#define _INCOMING_DTO_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 来料检验单列表
 */
class IncomingTableDTO : public oatpp::DTO
{
	DTO_INIT(IncomingTableDTO, DTO);
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
	// 接收数量
	API_DTO_FIELD_DEFAULT(Float64, recvNum, ZH_WORDS_GETTER("incoming.fields.rcvnum"));
	// 检测数量
	API_DTO_FIELD_DEFAULT(Int32, inspectNum, ZH_WORDS_GETTER("incoming.fields.ispnum"));
	// 不合格数量
	API_DTO_FIELD_DEFAULT(Int32, unqualifiedNum, ZH_WORDS_GETTER("incoming.fields.unqnum"));
	// 检测结果
	API_DTO_FIELD_DEFAULT(String, checkResult, ZH_WORDS_GETTER("incoming.fields.spresult"));
	// 来料日期
	API_DTO_FIELD_DEFAULT(String, reciveDate, ZH_WORDS_GETTER("incoming.fields.indate"));

};

/**
*来料检验单详情
*/
class IncomingDetailDTO : public IncomingTableDTO
{
	DTO_INIT(IncomingDetailDTO, DTO);

};

/**
 * 分页传输对象
 */
class IncomingPageDTO : public PageDTO<IncomingDTO::Wrapper>
{
	DTO_INIT(IncomingPageDTO, PageDTO<IncomingDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_INCOMING_DTO_