#pragma once
#ifndef _RawMaterialOp_QUERY_
#define _RawMaterialOp_QUERY_

#include "../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 示例分页查询对象
 */
class RawMaterialOpQuery : public PageQuery
{
	DTO_INIT(RawMaterialOpQuery, PageQuery);
	// 退料单编号
	DTO_FIELD(String, id);
	DTO_FIELD_INFO(id) {
		info->description = ZH_WORDS_GETTER("RawMaterialOp.field.id");
	}
	// 生产工单
	DTO_FIELD(String, order);
	DTO_FIELD_INFO(order) {
		info->description = ZH_WORDS_GETTER("RawMaterialOp.field.order");
	}
	// 仓库名称
	DTO_FIELD(UInt32, warehouse);
	DTO_FIELD_INFO(warehouse) {
		info->description = ZH_WORDS_GETTER("RawMaterialOp.field.warehouse");
	}
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_MATERIALINFORMATION_QUERY_