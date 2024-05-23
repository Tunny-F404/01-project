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

#ifndef _WAREHOUSE_EXPORT_VO_
#define _WAREHOUSE_EXPORT_VO_

#include "../../GlobalInclude.h"
#include "domain/dto/WarehouseExport/WarehouseExportDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 物料入库单显示JsonVO，用于响应给客户端的Json对象
 */
class WarehouseExportXLSXVO : public JsonVO<WarehouseExportDTO::Wrapper> {
    DTO_INIT(WarehouseExportXLSXVO, JsonVO<WarehouseExportDTO::Wrapper>);
};

class WarehouseExportPageXLSXVO : public JsonVO<WarehouseExportPageDTO::Wrapper> {
    DTO_INIT(WarehouseExportPageXLSXVO, JsonVO<WarehouseExportPageDTO::Wrapper>);
};


#include OATPP_CODEGEN_END(DTO)

#endif // !_WAREHOUSE_EXPORT_VO_
