#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: xinye
 @Date: 2024/5/22 23:00:00

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

#ifndef _WAREHOUSE_DELETE_CONTROLLER_
#define _WAREHOUSE_DELETE_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "ApiHelper.h"
#include "ServerInfo.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 删除单据（支持批量删除）
 */
class WarehouseDeleteController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
    // 2 定义控制器访问入口
    API_ACCESS_DECLARE(WarehouseDeleteController);
    // 3 定义接口
public:

    // 3.1 定义删除接口描述
    ENDPOINT_INFO(removeWmItemRecpt) {
        // 定义标题和返回类型以及授权支持
        API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("wm_item_recpt.delete.summary"), Uint64JsonVO::Wrapper);
        // 定义其他路径参数说明
        API_DEF_ADD_PATH_PARAMS(UInt64, "id", ZH_WORDS_GETTER("wm_item_recpt.field.id"), 1, true);
    }
    // 3.2 定义删除接口处理
    API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/wm-item-recpt/{id}", removeWmItemRecpt, PATH(UInt64, id), execWarehouseRemove(id));


private:

    // 3.3 演示删除数据
    Uint64JsonVO::Wrapper execWarehouseRemove(const UInt64& id);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _WAREHOUSE_DELETE_CONTROLLER_
