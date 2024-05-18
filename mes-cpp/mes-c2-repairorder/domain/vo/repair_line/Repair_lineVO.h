#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: hejianwei
 @Date: 2024/5/18 15:24:36

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
#ifndef _REPAIRLINE_VO_
#define _REPAIRLINE_VO_

#include "../../GlobalInclude.h"
#include "../../dto/repair_line/Repair_lineDTO.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 维修内容显示JsonVO，用于响应给客户端的Json对象
 */
class Repair_lineJsonVO : public JsonVO<Repair_lineDTO::Wrapper> {
    DTO_INIT(Repair_lineJsonVO, JsonVO<Repair_lineDTO::Wrapper>);
};

/**
 * 维修内容分页显示JsonVO，用于响应给客户端的Json对象
 */
class Repair_linePageJsonVO : public JsonVO<Repair_linePageDTO::Wrapper> {
    DTO_INIT(Repair_linePageJsonVO, JsonVO<Repair_linePageDTO::Wrapper>);
};

#include OATPP_CODEGEN_END(DTO)

#endif // !_REPAIRLINE_VO_