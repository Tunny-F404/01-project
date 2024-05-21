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
	//入库单id(标识数据唯一)
	API_DTO_FIELD_DEFAULT(UInt64, recpt_id, ZH_WORDS_GETTER("whstorageorder.field.recpt_id"), true, 0);
	//入库单名称
	API_DTO_FIELD_DEFAULT(String, recpt_name, ZH_WORDS_GETTER("whstorageorder.field.recpt_name"), true, ZH_WORDS_GETTER("whstorageorder.defult.recpt_name"));
	//入库单编号
	API_DTO_FIELD_DEFAULT(String, recpt_code, ZH_WORDS_GETTER("whstorageorder.field.recpt_code"), true, "R20230905001");
	//供应商名称
	API_DTO_FIELD_DEFAULT(String, vendor_name, ZH_WORDS_GETTER("whstorageorder.field.vendor_name"), true, "DUOMU");
	//采购订单号
	API_DTO_FIELD_DEFAULT(String, po_code, ZH_WORDS_GETTER("whstorageorder.field.po_code"), true);
	//单据状态
	API_DTO_FIELD_DEFAULT(String, status, ZH_WORDS_GETTER("whstorageorder.field.status"), false );
	//入库日期
	API_DTO_FIELD_DEFAULT(String, recpt_date, ZH_WORDS_GETTER("whstorageorder.field.recpt_date"), true, "2023-09-05");
	//入库仓库
	API_DTO_FIELD_DEFAULT(String, warehouse_name, ZH_WORDS_GETTER("whstorageorder.field.warehouse_name"));
	//备注
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
