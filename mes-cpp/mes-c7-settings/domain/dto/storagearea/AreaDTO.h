#pragma once
#ifndef __AREADTO_H__
#define __AREADTO_H__

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/*
* 传输对象
*/
class AreaDTO: public oatpp::DTO
{
	DTO_INIT(AreaDTO, DTO)
	//唯一标识
	API_DTO_FIELD(UInt64, id, ZH_WORDS_GETTER("storagearea.fields.areaId"), true, 1);
	//仓库库位编码
	API_DTO_FIELD(String, area_code, ZH_WORDS_GETTER("storagearea.fields.areacode"), true, "00000")
	//仓库库位名称
	API_DTO_FIELD(String, area_name, ZH_WORDS_GETTER("storagearea.fields.areaname"), true, "")
	//库区ID
	API_DTO_FIELD(UInt64, location_id, ZH_WORDS_GETTER("storagearea.fields.locationId"),true,1)
	//仓库库位位置x
	API_DTO_FIELD(Int32, position_x, ZH_WORDS_GETTER("storagearea.fields.positionx"), true, 0)
	//仓库库位位置y
	API_DTO_FIELD(Int32, position_y, ZH_WORDS_GETTER("storagearea.fields.positiony"), true, 0)
	//仓库库位位置z
	API_DTO_FIELD(Int32, position_z, ZH_WORDS_GETTER("storagearea.fields.positionz"), true, 0)
	//是否启用库位
	API_DTO_FIELD(String, enable_flag, ZH_WORDS_GETTER("storagearea.fields.enableFlag"), true, "Y")
	//库位面积
	API_DTO_FIELD(Float64, areasize, ZH_WORDS_GETTER("storagearea.fields.area"), true, 0.00)
	//最大载重量
	API_DTO_FIELD(Float64, max_loa, ZH_WORDS_GETTER("storagearea.fields.maxLoa"), true, 0.00)
	//备注
	API_DTO_FIELD(String, remarktext, ZH_WORDS_GETTER("storagearea.fields.remark"), true, "")
	//预留字段1
	API_DTO_FIELD(String, attr1, ZH_WORDS_GETTER("storagearea.fields.attr_one"), true, "")
	//预留字段2
	API_DTO_FIELD(String, attr2, ZH_WORDS_GETTER("storagearea.fields.attr_two"), true, "")
	//预留字段3
	API_DTO_FIELD(Int32, attr3, ZH_WORDS_GETTER("storagearea.fields.attr_three"), true, 0)
	//预留字段4
	API_DTO_FIELD(Int32, attr4, ZH_WORDS_GETTER("storagearea.fields.attr_four"), true, 0)
	//库位创建者
	API_DTO_FIELD(String, create_by, ZH_WORDS_GETTER("storagearea.fields.createBy"), true, "")
	//库位创建时间
	API_DTO_FIELD(String, create_time, ZH_WORDS_GETTER("storagearea.fields.createTime"), true, "")
	//库位更新者
	API_DTO_FIELD(String, update_by, ZH_WORDS_GETTER("storagearea.fields.updateBy"), true, "")
    //库位更新时间
	API_DTO_FIELD(String, update_time, ZH_WORDS_GETTER("storagearea.fields.updateTime"), true, "")
};
/*
* 分页传输对象（分页）
*/
class AreaPageDTO : public PageDTO<AreaDTO::Wrapper>
{
	DTO_INIT(AreaPageDTO, PageDTO<AreaDTO::Wrapper>)
};


#include OATPP_CODEGEN_END(DTO)

#endif //__AREADTO_H__
