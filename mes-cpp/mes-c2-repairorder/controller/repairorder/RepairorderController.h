#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: Heng_Xin
 @Date: 2024/5/18 15:45:52

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
#ifndef _HX_CONTROLLER_
#define _HX_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "domain/query/repairorder/RepairorderQuery.h"
#include "domain/dto/repairorder/RepairorderDTO.h"
#include "domain/vo/repairorder/RepairorderVO.h"

#include OATPP_CODEGEN_BEGIN(ApiController)

/**
 * 维修单控制器
 */
class RepairorderController : public oatpp::web::server::api::ApiController
{
    API_ACCESS_DECLARE(RepairorderController);
public:
    // 维修单分页查询接口描述
    ENDPOINT_INFO(queryRepairorder) {
        // 定义接口标题
        API_DEF_ADD_TITLE(ZH_WORDS_GETTER("repairorder.summary"));
        // 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
        API_DEF_ADD_AUTH();
        // 定义响应参数格式
        API_DEF_ADD_RSP_JSON_WRAPPER(RepairorderPageJsonVO);
        // 定义分页查询参数描述
        API_DEF_ADD_PAGE_PARAMS();
        // 定义其他查询参数描述
        // 维修单编号
        API_DEF_ADD_QUERY_PARAMS(String, "repairCode", ZH_WORDS_GETTER("repairorder.query.fields.repair_code"), "0x3f", false);

        // 维修单名称
        API_DEF_ADD_QUERY_PARAMS(String, "repairName", ZH_WORDS_GETTER("repairorder.query.fields.repair_name"), "bugRepair", false);

        // 设备编码
        API_DEF_ADD_QUERY_PARAMS(String, "machineryCode", ZH_WORDS_GETTER("repairorder.query.fields.machinery_code"), "M0721", false);

        // 设备名称
        API_DEF_ADD_QUERY_PARAMS(String, "machineryName", ZH_WORDS_GETTER("repairorder.query.fields.machinery_name"), "mk-2", false);

        // 维修结果
        API_DEF_ADD_QUERY_PARAMS(String, "repairResult", ZH_WORDS_GETTER("repairorder.query.fields.repair_result"), "OK", false);

        // 单据状态
        API_DEF_ADD_QUERY_PARAMS(String, "status", ZH_WORDS_GETTER("repairorder.query.fields.status"), "cao", false);
    }
    // 定义维修单分页查询接口处理
    ENDPOINT(API_M_GET, "/repairorder/page-query-repairorder-table", queryRepairorder, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
        // 解析查询参数为Query领域模型
        API_HANDLER_QUERY_PARAM(pageQuery, RepairorderQuery, queryParams);
        // 呼叫执行函数响应结果
        API_HANDLER_RESP_VO(execQueryRepairorder(pageQuery));
    }
private:
    // 维修单分页查询数据
    RepairorderPageJsonVO::Wrapper execQueryRepairorder(const RepairorderQuery::Wrapper& query);
};

#include OATPP_CODEGEN_END(ApiController)
#endif // _HX_CONTROLLER_