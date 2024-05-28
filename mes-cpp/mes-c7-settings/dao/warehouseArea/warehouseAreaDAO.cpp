/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 14:26:52

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
#include "stdafx.h"
#include "warehouseAreaDAO.h"
#include "warehouseAreaMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define WAREHOUSE_AREA_TERAM_PARSE(query,sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->warehouseAreaName) { \
	sql << " AND `location_name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->warehouseAreaName.getValue("")); \
}

uint64_t warehouseAreaDAO::count(const WarehouseAreaQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM wm_storage_location";
	WAREHOUSE_AREA_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<warehouseAreaDO> warehouseAreaDAO::selectWithPage(const WarehouseAreaQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT location_id,location_code,location_name,area,remark FROM wm_storage_location";
	WAREHOUSE_AREA_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	warehouseAreaMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<warehouseAreaDO, warehouseAreaMapper>(sqlStr, mapper, params);
}