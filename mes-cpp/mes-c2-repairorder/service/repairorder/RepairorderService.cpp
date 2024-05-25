/*
 * Copyright Zero One Star. All rights reserved.
 *
 * @Author: Heng_Xin
 * @Date: ${time}$
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
#include "RepairorderService.h"
#include "../../dao/repairorder/RepairorderDAO.h"

RepairorderPageDTO::Wrapper RepairorderService::listAll(const RepairorderQuery::Wrapper& query)
{
    // 构建返回对象
    auto pages = RepairorderPageDTO::createShared();
    pages->pageIndex = query->pageIndex;
    pages->pageSize = query->pageSize;

    // 查询数据总条数
    RepairorderDAO dao;
    uint64_t count = dao.count(query);
    if (count <= 0) {
        return pages;
    }

    // 分页查询数据
    pages->total = count;
    pages->calcPages();
    list<DvRepairDO> result = dao.selectWithPage(query);
    // 将DO转换成DTO
    for (const DvRepairDO& sub : result) {
        auto dto = RepairorderDTO::createShared();
        ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub,
            repairId, Repair_id,
            repairCode, Repair_code,
            repairName, Repair_name,
            machineryId, Machinery_id,
            machineryCode, Machinery_code,
            machineryName, Machinery_name,
            requireDate, Require_date,
            finishDate, Finish_date,
            confirmDate, Confirm_date,
            repairResult, Repair_result,
            acceptedBy, Accepted_by,
            confirmBy, Confirm_by,
            status, Status)
        pages->addData(dto);
    }
    return pages;
}

RepairorderDetailsDTO::Wrapper RepairorderService::getData(const RepairorderDetailsQuery::Wrapper& id)
{
    // 构建返回对象
    auto pages = RepairorderDetailsDTO::createShared();

    // 查询数据总条数
    RepairorderDAO dao;
    uint64_t count = dao.count(id);
    if (count <= 0) {
        return pages;
    }

    list<DvRepairDO> result = dao.selectById(id->repairId);

    for (const DvRepairDO& sub : result) {
        ZO_STAR_DOMAIN_DO_TO_DTO(pages, sub,
            repairId, Repair_id,
            repairCode, Repair_code,
            repairName, Repair_name,
            machineryCode, Machinery_code,
            machineryName, Machinery_name,
            machineryBrand, Machinery_brand,
            requireDate, Require_date,
            remark, Remark)
    }

    return pages;
}
