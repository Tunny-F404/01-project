#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: xinye
 @Date: 2024/5/22 22:00:00

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

#ifndef _WAREHOUSING_INBOUND_DTO_
#define _WAREHOUSING_INBOUND_DTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 执行入库
 */
class WarehouseInboundDTO : public oatpp::DTO
{
    DTO_INIT(WarehouseInboundDTO, DTO);
    // 入库单编号
    DTO_FIELD(Int32, recpt_id);
    DTO_FIELD_INFO(recpt_id) {
        info->description = ZH_WORDS_GETTER("wm_item_recpt.field.recpt_id");
    }
    // 单据状态
    DTO_FIELD(String, status);
    DTO_FIELD_INFO(status) {
        info->description = ZH_WORDS_GETTER("wm_item_recpt.field.status");
    }
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_WAREHOUSING_INBOUND_DTO_
