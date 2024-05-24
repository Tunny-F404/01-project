#pragma once
#ifndef _ADDWHSTORAGEORDERDTO_H_
#define _ADDWHSTORAGEORDERDTO_H_

#include "../../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)
/*
定义一个添加入库单行信息的数据传输类型
*/
class AddWhStorageorderDTO : public oatpp::DTO
{
	DTO_INIT(AddWhStorageorderDTO, DTO);
	//物料编码 item_code varchar
	API_DTO_FIELD_DEFAULT(String, item_code, ZH_WORDS_GETTER("whstorageorder.field.item_code"));
	//物料名称 item_name varchar
	API_DTO_FIELD_DEFAULT(String, item_name, ZH_WORDS_GETTER("whstorageorder.field.item_name"));
	//单位 unit_of_measure varchar
	API_DTO_FIELD_DEFAULT(String, unit_of_measure, ZH_WORDS_GETTER("whstorageorder.field.unit_of_measure"));
	//入库数量 quantity_recived double
	API_DTO_FIELD_DEFAULT(Float64, quantity_recived, ZH_WORDS_GETTER("whstorageorder.field.quantity_recived"));
	//入库批次号 batch_code varchar
	API_DTO_FIELD_DEFAULT(String, batch_code, ZH_WORDS_GETTER("whstorageorder.field.batch_code"));
	//有效期 expire_date String
	API_DTO_FIELD_DEFAULT(String, expire_date, ZH_WORDS_GETTER("whstorageorder.field.expire_date"));
	//入库仓库 warehouse_name varchar
	API_DTO_FIELD_DEFAULT(String, warehouse_name, ZH_WORDS_GETTER("whstorageorder.field.warehouse_name"));
	//是否检验 iqc_check char
	API_DTO_FIELD_DEFAULT(String, iqc_check, ZH_WORDS_GETTER("whstorageorder.field.iqc_check"));
	//来料检验单编码 iqc_code varchar
	API_DTO_FIELD_DEFAULT(String, iqc_code, ZH_WORDS_GETTER("whstorageorder.field.iqc_code"));
	//来料检验单ID iqc_id bigint
	API_DTO_FIELD_DEFAULT(UInt64, iqc_id, ZH_WORDS_GETTER("whstorageorder.field.iqc_id"));
	//备注 remark varchar
	API_DTO_FIELD_DEFAULT(String, remark, ZH_WORDS_GETTER("whstorageorder.field.remark"));

};



#include OATPP_CODEGEN_END(DTO)
#endif // _ADDWHSTORAGEORDERDTO_H_
