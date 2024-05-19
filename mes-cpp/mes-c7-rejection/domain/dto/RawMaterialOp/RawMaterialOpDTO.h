#pragma once
#ifndef _RawMaterialOp_DTO_
#define _RawMaterialOp_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 生产退料物料信息传输对象
 */
class RawMaterialOpDTO : public oatpp::DTO
{
	DTO_INIT(RawMaterialOpDTO, DTO);
	// 退料单编号
	DTO_FIELD(String, id);
	DTO_FIELD_INFO(id) {
		info->description = ZH_WORDS_GETTER("RawMaterialOp.field.id");
	}
	// 退料单名称
	DTO_FIELD(String, name);
	DTO_FIELD_INFO(name) {
		info->description = ZH_WORDS_GETTER("RawMaterialOp.field.name");
	}
	// 生产工单
	DTO_FIELD(String, order);
	DTO_FIELD_INFO(order) {
		info->description = ZH_WORDS_GETTER("RawMaterialOp.field.order");
	}
	// 接收仓库
	DTO_FIELD(String, warehouse);
	DTO_FIELD_INFO(warehouse) {
		info->description = ZH_WORDS_GETTER("RawMaterialOp.field.warehouse");
	}
	//退料日期
	DTO_FIELD(String, date);
	DTO_FIELD_INFO(date) {
		info->description = ZH_WORDS_GETTER("RawMaterialOp.field.date");
	}
	//备注
	DTO_FIELD(String, common);
	DTO_FIELD_INFO(common) {
		info->description = ZH_WORDS_GETTER("RawMaterialOp.field.common");
	}

};

/**
 * 示例分页传输对象
 */
class RawMaterialOpPageDTO : public PageDTO<RawMaterialOpDTO::Wrapper>
{
	DTO_INIT(RawMaterialOpPageDTO, PageDTO<RawMaterialOpDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_MaterialInformation_DTO_