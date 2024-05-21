#pragma once
#ifndef _PROCESSADD_DTO_
#define _PROCESSADD_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 添加工艺流程传输对象
 */
class ProcessAddDTO : public oatpp::DTO
{
	DTO_INIT(ProcessAddDTO, DTO);

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
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_DTO_