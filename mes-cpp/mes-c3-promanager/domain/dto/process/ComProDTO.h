#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/26 23:47:08

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

	  https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
#ifndef _COMPRODTO_H_
#define _COMPRODTO_H_

#include "../../GlobalInclude.h"
#include "domain/dto/process/ProcessListDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 组成工序列表对象
 */
class ComProListDTO : public oatpp::DTO
{
	//初始化
	DTO_INIT(ComProListDTO, DTO);
	//字段	
	//唯一标识
	API_DTO_FIELD_DEFAULT(UInt64, process_id, ZH_WORDS_GETTER("pro.fields.proId"));
	//工序编码
	API_DTO_FIELD_DEFAULT(String, process_code, ZH_WORDS_GETTER("pro.fields.proCode"));
	//工序名称
	API_DTO_FIELD_DEFAULT(String, process_name, ZH_WORDS_GETTER("pro.fields.proName"));
	//是否为关键工序
	API_DTO_FIELD_DEFAULT(String, key_flag, ZH_WORDS_GETTER("pro.fields.key_flag"), true, "No");
	//下一道工序
	API_DTO_FIELD_DEFAULT(String, next_process_name, ZH_WORDS_GETTER("pro.fields.proName"), false, "01star");
	//下一道的工序关系
	API_DTO_FIELD_DEFAULT(String, link_type, ZH_WORDS_GETTER("pro.fields.type"), false, "01star");
	//是否质检
	API_DTO_FIELD_DEFAULT(String, is_check, ZH_WORDS_GETTER("Pro.fields.Check"), true, "No");
	//准备时间
	API_DTO_FIELD(Int32, default_pre_time, ZH_WORDS_GETTER("Pro.fields.PreTime"), false, 0);
	//等待时间
	API_DTO_FIELD(Int32, default_suf_time, ZH_WORDS_GETTER("Pro.fields.SufTime"), false, 0);
	//甘特图颜色
	API_DTO_FIELD(String, color_code, ZH_WORDS_GETTER("Pro.fields.Color"), false, "red");

};

/**
 * 工艺列表分页传输对象
 */
class ComProPageDTO : public PageDTO<ComProListDTO::Wrapper>
{
	DTO_INIT(ComProPageDTO, PageDTO<ComProListDTO::Wrapper>);
};

/*
修改组成工序
*/
class ModifyProDTO : public ComProListDTO
{
	//初始化
	DTO_INIT(ModifyProDTO, ComProListDTO);
	//备注
	API_DTO_FIELD(String, Remark, ZH_WORDS_GETTER("Pro.fields.Remark"), false, "");
};
/*
新增组成工序
*/
class NewProcessDTO : public ModifyProDTO
{
	//初始化
	DTO_INIT(NewProcessDTO, ModifyProDTO);
	//字段
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_ROLISTDTO_H_