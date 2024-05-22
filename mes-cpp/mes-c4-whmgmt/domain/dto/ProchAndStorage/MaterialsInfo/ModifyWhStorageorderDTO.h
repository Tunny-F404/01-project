#pragma once
#ifndef _MODIFYWHSTORAGEORDERDTO_H_
#define _MODIFYWHSTORAGEORDERDTO_H_

#include "../../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/*
定义一个修改入库单行的数据传输类型
*/
class ModifyWhStorageorderDTO : public oatpp::DTO
{
	DTO_INIT(ModifyWhStorageorderDTO, DTO);
	//入库单名称 
	API_DTO_FIELD_DEFAULT(String, recpt_name, ZH_WORDS_GETTER("whstorageorder.field.recpt_name"));
	//入库单编号 recpt_code varchar
	API_DTO_FIELD_DEFAULT(String, recpt_code, ZH_WORDS_GETTER("whstorageorder.field.recpt_code"));
	//供应商名称 vendor_name varchar
	API_DTO_FIELD_DEFAULT(String, vendor_name, ZH_WORDS_GETTER("whstorageorder.field.vendor_name"));
	//采购订单号 po_code varchar
	API_DTO_FIELD_DEFAULT(String, po_code, ZH_WORDS_GETTER("whstorageorder.field.po_code"));
	//单据状态 status varchar
	API_DTO_FIELD_DEFAULT(String, status, ZH_WORDS_GETTER("whstorageorder.field.status"));
	//入库日期 recpt_date String
	API_DTO_FIELD_DEFAULT(String, recpt_date, ZH_WORDS_GETTER("whstorageorder.field.recpt_date"));
	//入库仓库 warehouse_name varchar
	API_DTO_FIELD_DEFAULT(String, warehouse_name, ZH_WORDS_GETTER("whstorageorder.field.warehouse_name"));
	//备注 remark varchar
	API_DTO_FIELD_DEFAULT(String, remark, ZH_WORDS_GETTER("whstorageorder.field.remark"));

};

/*
定义一个修改后入库信息的分页传输对象
*/
class ModifyWhPageStorageorderDTO : public PageDTO<ModifyWhStorageorderDTO::Wrapper>
{
	DTO_INIT(ModifyWhPageStorageorderDTO, PageDTO<ModifyWhStorageorderDTO::Wrapper>);
	//.....
};



#include OATPP_CODEGEN_END(DTO)
#endif // _MODIFYWHSTORAGEORDERDTO_H_
