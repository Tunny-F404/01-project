/*
 * Copyright Zero One Star. All rights reserved.
 *
 * @Author: Heng_Xin
 * @Date: 2024/5/18 16:01:19
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
#include "stdafx.h"
#include "RepairorderController.h"
#include "../../service/repairorder/RepairorderService.h"
#include "../ApiDeclarativeServicesHelper.h"

// 维修单分页查询数据
RepairorderPageJsonVO::Wrapper RepairorderController::execQueryRepairorder(const RepairorderQuery::Wrapper& query)
{
    // 定义一个Service
    RepairorderService service;
    // 查询数据
    auto result = service.listAll(query);
    // 响应结果
    auto jvo = RepairorderPageJsonVO::createShared();
    jvo->success(result);
    return jvo;
}

// 维修单详情查询
RepairorderDetailsJsonVO::Wrapper RepairorderController::execQueryDetailsRepairorder(const RepairorderDetailsQuery::Wrapper& id)
{
    // 定义返回数据对象
    auto jvo = RepairorderDetailsJsonVO::createShared();
    // 参数校验
    if (id->repairId <= 0) {
        jvo->fail(RepairorderDetailsDTO::Wrapper());
        return jvo;
    }
    // 定义一个Service
    RepairorderService service;
    // 执行数据查询
    auto dto = service.getData(id);
    jvo->success(dto);
    // 响应结果
    return jvo;
}

Uint64JsonVO::Wrapper RepairorderController::execAddRepairorder(const RepairorderDetailsDTO::Wrapper& dto)
{
    return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RepairorderController::execModifyRepairorder(const RepairorderDetailsDTO::Wrapper& dto)
{
    return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RepairorderController::execRemoveRepairorder(const DeleteMultipleRepairersDTO::Wrapper& id)
{
    return Uint64JsonVO::Wrapper();
}
