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

#ifndef _WAREHOUSE_EXPORT_CONTROLLER_
#define _WAREHOUSE_EXPORT_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "ApiHelper.h"
#include "ServerInfo.h"
#include "domain/query/WarehouseExport/WarehouseExportQuery.h"
#include "domain/vo/WarehouseExport/WarehouseExportVO.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 物料入库单控制器，演示基础接口的使用
 */
class WarehouseExportController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
    // 2 定义控制器访问入口
    API_ACCESS_DECLARE(WarehouseExportController);
    // 3 定义接口
public:

    // 3.1 定义查询接口描述
    ENDPOINT_INFO(exportWarehouse) {
        // 定义接口标题
        API_DEF_ADD_TITLE(ZH_WORDS_GETTER("wm_item_recpt.export.summary"));
        // 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
        API_DEF_ADD_AUTH();
        // 定义响应参数格式
        API_DEF_ADD_RSP_JSON_WRAPPER(WarehouseExportJsonVO);
        // 定义导出文件名参数描述
        API_DEF_ADD_QUERY_PARAMS(String, "filename", ZH_WORDS_GETTER("wm_item_recpt.field.filename"), "test", true);
        // 定义导出格式查询参数
        API_DEF_ADD_QUERY_PARAMS(String, "format", ZH_WORDS_GETTER("wm_item_recpt.field.format"), "xlsx", true);
    }

    // 3.2 定义查询接口处理
    ENDPOINT(API_M_GET, "/wm-item-recpt/export", exportWarehouse, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
        // 解析查询参数为Query领域模型
        API_HANDLER_QUERY_PARAM(userQuery, WarehouseExportQuery, queryParams);
        // 呼叫执行函数响应结果
        API_HANDLER_RESP_VO(execWarehouseExport(userQuery, authObject->getPayload()));
    }

private:
    // 3.3 演示分页查询数据
    WarehouseExportJsonVO::Wrapper execWarehouseExport(const WarehouseExportQuery::Wrapper& query, const PayloadDTO& payload);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _WAREHOUSE_EXPORT_CONTROLLER_
