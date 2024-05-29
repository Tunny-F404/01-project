#pragma once
#ifndef _INSPECTDTO_H
#define _INSPECTDTO_H

#include "../../GlobalInclude.h"
#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 来料检验单列表数据传输对象
 */
class InspectDTO:public oatpp::DTO
{
	DTO_INIT(InspectDTO, DTO);
	// 数据库表行id
	API_DTO_FIELD_DEFAULT(UInt64, line_id, ZH_WORDS_GETTER("inspect.line_id"));
	// 来料检验单编号
	API_DTO_FIELD_DEFAULT(String, code, ZH_WORDS_GETTER("inspect.code"));
	// 来料检验单名称
	API_DTO_FIELD_DEFAULT(String, name, ZH_WORDS_GETTER("inspect.name"));
	//检验模板ID
	API_DTO_FIELD_DEFAULT(UInt64, template_id, ZH_WORDS_GETTER("inspect.template_id"));
	//供应商ID
	API_DTO_FIELD_DEFAULT(UInt64, vendor_id, ZH_WORDS_GETTER("inspect.vendor_id"));
	// 供应商编码
	API_DTO_FIELD_DEFAULT(String, vendor_code, ZH_WORDS_GETTER("inspect.vendor_code"));
	// 供应商名称
	API_DTO_FIELD_DEFAULT(String, vendor_name, ZH_WORDS_GETTER("inspect.vendor_name"));
	// 供应商简称
	API_DTO_FIELD_DEFAULT(String, vendor_nick, ZH_WORDS_GETTER("inspect.vendor_nick"));
	//供应商批次号
	API_DTO_FIELD_DEFAULT(String, vendor_batch, ZH_WORDS_GETTER("inspect.vendor_batch"));
	//产品物料编码
	API_DTO_FIELD_DEFAULT(String, item_code, ZH_WORDS_GETTER("inspect.item_code"));
	//产品物料名称
	API_DTO_FIELD_DEFAULT(String, item_name, ZH_WORDS_GETTER("inspect.item_name"));
	//接收数量
	API_DTO_FIELD_DEFAULT(Int64, quantity_recived, ZH_WORDS_GETTER("inspect.quantity_recived"));
	//检测数量
	API_DTO_FIELD_DEFAULT(Int64, quantity_check, ZH_WORDS_GETTER("inspect.quantity_check"));
	//不合格数
	API_DTO_FIELD_DEFAULT(Int64, quantity_unqualified, ZH_WORDS_GETTER("inspect.quantity_unqualified"));
	//检测结果
	API_DTO_FIELD_DEFAULT(String, check_result, ZH_WORDS_GETTER("inspect.check_result"));
	//来料日期
	API_DTO_FIELD_DEFAULT(String, recive_date, ZH_WORDS_GETTER("inspect.recive_date"));
	//检测日期
	API_DTO_FIELD_DEFAULT(String, inspect_date, ZH_WORDS_GETTER("inspect.inspect_date"));
	//检测人员
	API_DTO_FIELD_DEFAULT(String, inspector, ZH_WORDS_GETTER("inspect.inspector"));
	//单据状态
	API_DTO_FIELD_DEFAULT(String, list_status, ZH_WORDS_GETTER("inspect.list_status"));
	
};

//来料检验列表分页传输对象
class InspectPageDTO : public PageDTO<InspectDTO::Wrapper>
{
	DTO_INIT(InspectPageDTO, PageDTO<InspectDTO::Wrapper>);
};

class Inspect_detailDTO :public InspectDTO
{
	DTO_INIT(Inspect_detailDTO, InspectDTO);

	//单位
	API_DTO_FIELD_DEFAULT(String, unit_of_measure, ZH_WORDS_GETTER("inspect.unit_of_measure"));
	//致命缺陷率
	API_DTO_FIELD_DEFAULT(Float64, maj_rate, ZH_WORDS_GETTER("inspect.maj_rate"));
	//严重缺陷率
	API_DTO_FIELD_DEFAULT(Float64, cr_rate, ZH_WORDS_GETTER("inspect.cr_rate")); 
	//轻微缺陷率
	API_DTO_FIELD_DEFAULT(Float64, min_rate, ZH_WORDS_GETTER("inspect.min_rate"));
	//致命缺陷数量
	API_DTO_FIELD_DEFAULT(Int64, cr_quantity, ZH_WORDS_GETTER("inspect.cr_quantity"));
	//严重缺陷数量
	API_DTO_FIELD_DEFAULT(Int64, maj_quantity, ZH_WORDS_GETTER("inspect.maj_quantity"));
	//轻微缺陷数量
	API_DTO_FIELD_DEFAULT(Int64, min_quantity, ZH_WORDS_GETTER("inspect.min_quantity"));
	//备注
	API_DTO_FIELD_DEFAULT(String, remark, ZH_WORDS_GETTER("inspect.remark"));
};

class Inspect_detailPageDTO : public PageDTO<Inspect_detailDTO::Wrapper>
{
	DTO_INIT(Inspect_detailPageDTO, PageDTO<Inspect_detailDTO::Wrapper>);
};

class Inspect_tableDTO : public Inspect_detailDTO
{
	DTO_INIT(Inspect_tableDTO, Inspect_detailDTO);
};

class Item_idDTO :public oatpp::DTO
{
	DTO_INIT(Item_idDTO, DTO);
	// 数据库表行id
	API_DTO_FIELD_DEFAULT(UInt64, line_id, ZH_WORDS_GETTER("inspect.line_id"));
};


#include OATPP_CODEGEN_END(DTO)

#endif // !_INSPECTDTO_H_