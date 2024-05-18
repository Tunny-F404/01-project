#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: hejianwei
 @Date: 2024/5/18 17:12:31

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
#ifndef _REPAIRLINEQUERY_
#define _REPAIRLINEQUERY_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/repair_line/Repair_lineQuery.h"
#include "domain/dto/repair_line/Repair_lineDTO.h"
#include "domain/vo/repair_line/Repair_lineVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

// 维修内容控制器，用于处理维修内容相关的请求
class Repair_lineController : public oatpp::web::server::api::ApiController
{
    API_ACCESS_DECLARE(RepairController);

public:
    // 新增维修内容的接口描述
    ENDPOINT_INFO(addRepair) {
        API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repair.post.summary")); // 接口标题
        API_DEF_ADD_AUTH(); // 授权参数
        API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO); // 响应参数格式
    }

    // 新增维修内容的处理函数
    ENDPOINT(API_M_POST, "/repair", addRepair, BODY_DTO(RepairDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
        API_HANDLER_RESP_VO(execAddRepair(dto)); // 执行新增维修内容的操作
    }

    // 修改维修内容的接口描述
    ENDPOINT_INFO(modifyRepair) {
        API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repair.put.summary")); // 接口标题
        API_DEF_ADD_AUTH(); // 授权参数
        API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO); // 响应参数格式
    }

    // 修改维修内容的处理函数
    ENDPOINT(API_M_PUT, "/repair", modifyRepair, BODY_DTO(RepairDTO::Wrapper, dto), API_HANDLER_AUTH_PARAME) {
        API_HANDLER_RESP_VO(execModifyRepair(dto)); // 执行修改维修内容的操作
    }

    // 删除维修内容的接口描述
    ENDPOINT_INFO(removeRepair) {
        API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repair.delete.summary")); // 接口标题
        API_DEF_ADD_AUTH(); // 授权参数
        API_DEF_ADD_RSP_JSON_WRAPPER(Uint64JsonVO); // 响应参数格式
        API_DEF_ADD_PATH_PARAMS(UInt64, "id", ZH_WORDS_GETTER("repair.field.id"), 1, true); // 路径参数
    }

    // 删除维修内容的处理函数
    API_HANDLER_AUTH(API_M_DEL, "/repair/{id}", removeRepair, PATH(UInt64, id), execRemoveRepair(id));

private:
    // 执行新增维修内容的操作
    Uint64JsonVO::Wrapper execAddRepair(const RepairDTO::Wrapper& dto);

    // 执行修改维修内容的操作
    Uint64JsonVO::Wrapper execModifyRepair(const RepairDTO::Wrapper& dto);

    // 执行删除维修内容的操作
    Uint64JsonVO::Wrapper execRemoveRepair(const UInt64& id);
};

#include OATPP_CODEGEN_END(ApiController)
#endif // _REPAIRLINEQUERY_