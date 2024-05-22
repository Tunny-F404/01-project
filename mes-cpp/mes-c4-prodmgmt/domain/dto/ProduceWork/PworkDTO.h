#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 10:59:38

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
#ifndef _SAMPLE_DTO_
#define _SAMPLE_DTO_
#include "../../GlobalInclude.h"
#include "ApiHelper.h"
#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 生产报工
 */
class PworkTableDTO : public oatpp::DTO
{
	DTO_INIT(PworkTableDTO, DTO);
	
	//记录IDrecord_id
	API_DTO_FIELD_DEFAULT(UInt64, record_id, ZH_WORDS_GETTER("ProduceWork.fields.record_id"));
	//API_DTO_FIELD(UInt64, record_id, ZH_WORDS_GETTER("ProduceWork.fields.record_id"), true, 0);

	// 报工类型
	API_DTO_FIELD(String, feedback_type, ZH_WORDS_GETTER("ProduceWork.fields.feedback_type"),true,"自行报工");

	// 工作站名称
	API_DTO_FIELD_DEFAULT(String, workstation_name, ZH_WORDS_GETTER("ProduceWork.fields.workstation_name"));

	// 生产工单编号
	API_DTO_FIELD_DEFAULT(String, workorder_code, ZH_WORDS_GETTER("ProduceWork.fields.workorder_code"));

	//产品物料编码
	API_DTO_FIELD_DEFAULT(String, item_code, ZH_WORDS_GETTER("ProduceWork.fields.item_code"));

	//产品物料名称
	API_DTO_FIELD_DEFAULT(String, item_name, ZH_WORDS_GETTER("ProduceWork.fields.item_name"));


	//规格型号
	API_DTO_FIELD(String, specification, ZH_WORDS_GETTER("ProduceWork.fields.specification"), true, "无色");

	//报工数量
	API_DTO_FIELD(String, quantity_feedback, ZH_WORDS_GETTER("ProduceWork.fields.quantity_feedback"), true, "0");

	//报工人
	API_DTO_FIELD_DEFAULT(String, user_name, ZH_WORDS_GETTER("ProduceWork.fields.user_name"));

	//报工时间
	API_DTO_FIELD(String, feedback_time, ZH_WORDS_GETTER("ProduceWork.fields.feedback_time"), true, "无");

	//审核人
	//API_DTO_FIELD_DEFAULT(String, , ZH_WORDS_GETTER("ProduceWork.fields."));

	//状态(0正常 1停用)
	API_DTO_FIELD_DEFAULT(String, status, ZH_WORDS_GETTER("ProduceWork.fields.status"));
	
};
class PworkDetailDTO : public PworkTableDTO {
	DTO_INIT(PworkDetailDTO, PworkTableDTO);

	//待检测质量
	API_DTO_FIELD(String, quantity_uncheck, ZH_WORDS_GETTER("ProduceWork.fields.quantity_uncheck"), true, "没了"); 
	//。。。。。
};
/**
 * 示例分页传输对象
 */
class SamplePageDTO : public PageDTO<PworkTableDTO::Wrapper>
{
	DTO_INIT(SamplePageDTO, PageDTO<PworkTableDTO::Wrapper>);

};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_DTO_