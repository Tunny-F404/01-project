#pragma once
#ifndef _PROMATERIAL_DTO_H_
#define _PROMATERIAL_DTO_H_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 修改添加产品制程物料BOM传输对象
 */
class ProductMaterialDTO : public oatpp::DTO
{
	DTO_INIT(ProductMaterialDTO, DTO);

	// 物料编码
	API_DTO_FIELD(UInt64, item_code, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.item_code"), true, 1);
	// 物料名称
	API_DTO_FIELD(String, item_name, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.item_name"), true, "01star");
	// 物料单位
	API_DTO_FIELD(String, unit_of_measure, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.unit_of_measure"), true, "g");
	// 规格型号
	API_DTO_FIELD(String, specification, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.specification"), true, "null");
	// 备注
	API_DTO_FIELD(String, RPmodels, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.RPmodels"), false, "null");
};
/**
 * 获取产品制程物料BOM列表传输对象
 */
class ProMaterialDTO : public oatpp::DTO
{
	DTO_INIT(ProMaterialDTO, DTO);

	// 物料ID
	API_DTO_FIELD(UInt64, item_id, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.item_id"), true, 1);
	// 物料编码
	API_DTO_FIELD(UInt64, item_code, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.item_code"), true, 1);
	// 物料名称
	API_DTO_FIELD(String, item_name, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.item_name"), true, "01star");
	// 物料单位
	API_DTO_FIELD(String, unit_of_measure, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.unit_of_measure"), true, "g");
	// 规格型号
	API_DTO_FIELD(String, specification, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.specification"), true, "null");
	// 备注
	API_DTO_FIELD(String, RPmodels, ZH_WORDS_GETTER("RelatePro.ProMaterialDTO.RPmodels"), false,"null");
};


/**
 * 获取产品制程物料BOM列表的分页传输对象
 */
class ProMaterialPageDTO : public PageDTO<ProMaterialDTO::Wrapper>
{
	DTO_INIT(ProMaterialPageDTO, PageDTO<ProMaterialDTO::Wrapper>);
};
#endif // !_PROMATERIAL_DTO_