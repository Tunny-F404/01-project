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
#include "EquipmentDAO.h"
#include "EquipmentMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define EQUIPMENT_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->equipmentCode) { \
	sql << " AND `equimentCode`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->equipmentCode.getValue("")); \
} \
if (query->equipmentName) { \
	sql << " AND sex=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->equipmentName.getValue("")); \
} 

uint64_t EquipmentDAO::count(const EquipmentQuery::Wrapper& query)
{
	return 0;
}

std::list<EquipmentDO> EquipmentDAO::selectWithPage(const EquipmentQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT id,name,sex,age FROM sample";
	//EQUIPMENT_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	EquipmentMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<EquipmentDO, EquipmentMapper>(sqlStr, mapper);
}