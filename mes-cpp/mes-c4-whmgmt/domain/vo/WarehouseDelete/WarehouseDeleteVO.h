#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: xinye
 @Date: 2024/5/22 22:30:00

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

#ifndef _WAREHOUSE_DELETE_VO_
#define _WAREHOUSE_DELETE_VO_

#include "../../GlobalInclude.h"
#include "domain/dto/WarehouseDelete/WarehouseDeleteDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 物料入库单显示JsonVO，用于响应给客户端的Json对象
 */
class WarehouseDeleteJsonVO : public JsonVO<WarehouseDeleteDTO::Wrapper> {
    DTO_INIT(WarehouseDeleteJsonVO, JsonVO<WarehouseDeleteDTO::Wrapper>);
};

/**
 * 物料入库单分页显示JsonVO，用于响应给客户端的Json对象
 */
class WarehouseDeletePageJsonVO : public JsonVO<WarehouseDeletePageDTO::Wrapper> {
    DTO_INIT(WarehouseDeletePageJsonVO, JsonVO<WarehouseDeletePageDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_WAREHOUSE_DELETE_VO_
