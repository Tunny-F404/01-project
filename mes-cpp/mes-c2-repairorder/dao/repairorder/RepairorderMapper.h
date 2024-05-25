#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: Heng_Xin
 @Date: 2024/5/25 14:13:29

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
#ifndef _REPAIRORDER_MAPPER_
#define _REPAIRORDER_MAPPER_

#include "Mapper.h"
#include "../../domain/do/dv_repair/DvRepairDO.h"

/**
 * dv_repair表(维修单查询表) 分页查询 字段匹配映射
 */
class RepairorderMapper : public Mapper<DvRepairDO>
{
public:
    DvRepairDO mapper(ResultSet* resultSet) const override
    {
        // 注: 等待测试, 看看日期是什么
        // repair_id,repair_code,repair_name,machinery_id,machinery_code,machinery_name,machinery_brand,machinery_spec,machinery_type_id,require_date,finish_date,confirm_date,repair_result,accepted_by,confirm_by,status,remark,attr1,attr2,attr3,attr4,create_by,create_time,update_by,update_time
        DvRepairDO data;
        data.setRepair_code(resultSet->getString(1));
        data.setRepair_name(resultSet->getString(2));
        data.setMachinery_id(resultSet->getUInt64(3));
        data.setMachinery_code(resultSet->getString(4));
        data.setMachinery_name(resultSet->getString(5));
        data.setMachinery_brand(resultSet->getString(6));
        data.setMachinery_spec(resultSet->getString(7));
        data.setMachinery_type_id(resultSet->getUInt64(8));
        data.setRequire_date(resultSet->getString(9));
        data.setFinish_date(resultSet->getString(10));
        data.setConfirm_date(resultSet->getString(11));
        data.setRepair_result(resultSet->getString(12));
        data.setAccepted_by(resultSet->getString(13));
        data.setConfirm_by(resultSet->getString(14));
        data.setStatus(resultSet->getString(15));
        data.setRemark(resultSet->getString(16));
        data.setAttr1(resultSet->getString(17));
        data.setAttr2(resultSet->getString(18));
        data.setAttr3(resultSet->getInt(19));
        data.setAttr4(resultSet->getInt(20));
        data.setCreate_by(resultSet->getString(21));
        data.setCreate_time(resultSet->getString(22));
        data.setUpdate_by(resultSet->getString(23));
        data.setUpdate_time(resultSet->getString(24));
        return data;
    }
};

#endif // !_REPAIRORDER_MAPPER_