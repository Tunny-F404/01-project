#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: ronaldo
 @Date: 2024/05/21 17:08

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
#ifndef _ADDRETURNDTO_H_
#define _ADDRETURNDTO_H_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)
/**
 * 定义一个修改信息的数据传输DTO
 */
class AddReturnDTO : public oatpp::DTO
{
	DTO_INIT(AddReturnDTO, DTO);
	// 行ID
	API_DTO_FIELD_DEFAULT(String, lineid, ZH_WORDS_GETTER("material.lineid"));
	// 退货单ID
	API_DTO_FIELD_DEFAULT(String, rtid, ZH_WORDS_GETTER("material.rtid"));
	// 退货单编号
	API_DTO_FIELD_DEFAULT(String, rtcode, ZH_WORDS_GETTER("material.rtcode"));
	// 退货单名称
	API_DTO_FIELD_DEFAULT(String, rtname, ZH_WORDS_GETTER("material.rtname"));
	// 采购订单编号
	API_DTO_FIELD_DEFAULT(String, pocode, ZH_WORDS_GETTER("material.pocode"));
	// 供应商编码
	//API_DTO_FIELD_DEFAULT(String, vendorcode, ZH_WORDS_GETTER("material.vendorcode"));
	// 供应商名称
	API_DTO_FIELD_DEFAULT(String, vendorname, ZH_WORDS_GETTER("material.vendorname"));
	// 批次号
	API_DTO_FIELD_DEFAULT(String, batchcode, ZH_WORDS_GETTER("material.batchcode"));
	// 退货日期
	API_DTO_FIELD_DEFAULT(String, rtdate, ZH_WORDS_GETTER("material.rtdate"));
	// 单据状态
	API_DTO_FIELD_DEFAULT(String, status, ZH_WORDS_GETTER("material.status"));
	// 备注
	API_DTO_FIELD_DEFAULT(String, remark, ZH_WORDS_GETTER("material.remark"));

};


#include OATPP_CODEGEN_END(DTO)
#endif // _ADDRETURNDTO_H_
