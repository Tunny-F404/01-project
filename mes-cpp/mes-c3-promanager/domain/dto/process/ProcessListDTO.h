#pragma once
#ifndef _PROCESSLIST_DTO_
#define _PROCESSLIST_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 工艺列表传输对象,与获取工艺详情、添加工艺共用
 */
class ProcessDTO : public oatpp::DTO
{
	DTO_INIT(ProcessDTO, DTO);

	// 唯一标识
	DTO_FIELD(UInt32, routeid);
	DTO_FIELD_INFO(routeid) {
		info->description = ZH_WORDS_GETTER("process.field.id");
	}
	// 路线编号
	DTO_FIELD(String, routeCode);
	DTO_FIELD_INFO(routeCode) {
		info->description = ZH_WORDS_GETTER("process.field.code");
	}
	// 路线名称
	DTO_FIELD(String, routeName);
	DTO_FIELD_INFO(routeName) {
		info->description = ZH_WORDS_GETTER("process.field.name");
	}
	// 路线说明
	DTO_FIELD(String, routedesc);
	DTO_FIELD_INFO(routedesc) {
		info->description = ZH_WORDS_GETTER("process.field.desc");
	}
	// 是否启用
	DTO_FIELD(String, enableFlag);
	DTO_FIELD_INFO(enableFlag) {
		info->description = ZH_WORDS_GETTER("process.field.flag");
	}
	// 备注
	DTO_FIELD(String, remark);
	DTO_FIELD_INFO(remark) {
		info->description = ZH_WORDS_GETTER("process.field.remark");
	}
	// 创建时间
	DTO_FIELD(String, createtime);
	DTO_FIELD_INFO(createtime) {
		info->description = ZH_WORDS_GETTER("process.field.createtime");
	}
	// 更新时间
	DTO_FIELD(String, updatetime);
	DTO_FIELD_INFO(updatetime) {
		info->description = ZH_WORDS_GETTER("process.field.updatetime");
	}
};

/**
 * 工艺列表分页传输对象
 */
class ProcessListDTO : public PageDTO<ProcessDTO::Wrapper>
{
	DTO_INIT(ProcessListDTO, PageDTO<ProcessDTO::Wrapper>);
};


#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_DTO_
