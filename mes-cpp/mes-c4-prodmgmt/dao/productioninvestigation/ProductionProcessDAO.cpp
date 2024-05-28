/*
 Copyright Zero One Star. All rights reserved.
 @Author: amie
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
#include "ProductionProcessDAO.h"
#include "ProductionProcessMapper.h"
#include <sstream> 
uint64_t ProductionProcessDAO::count(const ProductionProcessQuery::Wrapper& query)
{
	string sql;
	if (query->workOrderCode)
	{
		sql = "SELECT COUNT(*) FROM from pro_process as p join pro_task as t on p.process_id = t.process_id where t.workorder_code = ?";
		return sqlSession->executeQueryNumerical(sql, "%s", query->workOrderCode.getValue(""));
	}
	else
	{
		sql = "SELECT COUNT(*) FROM pro_process";
	}
	return sqlSession->executeQueryNumerical(sql);
}
list<ProProcessDO> ProductionProcessDAO::query_by_workordercode(const ProductionProcessQuery::Wrapper& query)
{
	stringstream sql;
	if (query->workOrderCode)
	{
		sql << "select p.process_name from pro_process as p join pro_task as t on p.process_id = t.process_id where t.workorder_code = ? order by p.process_id";
		ProProcessDOMapper mapper;
		string sqlStr = sql.str();
		return sqlSession->executeQuery<ProProcessDO, ProProcessDOMapper>(sqlStr, mapper, "%s", query->workOrderCode.getValue(""));
	}
	else
	{
		sql << "SELECT process_name FROM pro_process by process_id";
	}
	ProProcessDOMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ProProcessDO, ProProcessDOMapper>(sqlStr, mapper);
}