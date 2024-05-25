/*
 * Copyright Zero One Star. All rights reserved.
 *
 * @Author: Heng_Xin
 * @Date: 2024/5/25 13:52:06
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
#include "RepairorderDAO.h"
#include "RepairorderMapper.h"
#include <sstream>

// 定义条件解析宏，减少重复代码
#define REPAIRORDER_QUERY_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->repairCode) { \
	sql << " AND repair_code=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->repairCode.getValue("")); \
} \
if (query->repairName) { \
	sql << " AND repair_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->repairName.getValue("")); \
} \
if (query->machineryCode) { \
	sql << " AND machinery_code=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->machineryCode.getValue("")); \
} \
if (query->machineryName) { \
	sql << " AND machinery_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->machineryName.getValue("")); \
} \
if (query->repairResult) { \
	sql << " AND repair_result=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->repairResult.getValue("")); \
} \
if (query->status) { \
	sql << " AND status=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->status.getValue("")); \
}

uint64_t RepairorderDAO::count(const RepairorderQuery::Wrapper& query)
{
    stringstream sql;
    sql << "SELECT COUNT(*) FROM dv_repair";
    REPAIRORDER_QUERY_PARSE(query, sql);
    string sqlStr = sql.str();
    return sqlSession->executeQueryNumerical(sqlStr, params);
}

list<DvRepairDO> RepairorderDAO::selectWithPage(const RepairorderQuery::Wrapper& query)
{
    stringstream sql;
    sql << "SELECT repair_id,repair_code,repair_name,machinery_id,machinery_code,machinery_name,machinery_brand,machinery_spec,machinery_type_id,require_date,finish_date,confirm_date,repair_result,accepted_by,confirm_by,status,remark,attr1,attr2,attr3,attr4,create_by,create_time,update_by,update_time FROM dv_repair";
    REPAIRORDER_QUERY_PARSE(query, sql);
    sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
    RepairorderMapper mapper;
    string sqlStr = sql.str();
    return sqlSession->executeQuery<DvRepairDO, RepairorderMapper>(sqlStr, mapper, params);
}

list<DvRepairDO> RepairorderDAO::selectByName(const string& name)
{
    return list<DvRepairDO>();
}

uint64_t RepairorderDAO::insert(const DvRepairDO& iObj)
{
    return 0;
}

int RepairorderDAO::update(const DvRepairDO& uObj)
{
    return 0;
}

int RepairorderDAO::deleteById(uint64_t id)
{
    return 0;
}
