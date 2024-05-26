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
#include "ProcessInspectionDAO.h"
#include "ProcessinSpectionMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define PROCESSINSPECTION_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->ipqc_code) { \
	sql << " AND `ipqc_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->ipqc_code.getValue("")); \
} \
if (query->ipqc_type) { \
	sql << " AND ipqc_type=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->ipqc_type.getValue("")); \
} \
if (query->workorder_code) { \
	sql << " AND workorder_code=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->workorder_code.getValue("")); \
}\
if (query->item_code) { \
	sql << " AND item_code=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->item_code.getValue("")); \
}\
if (query->item_name) { \
	sql << " AND item_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->item_name.getValue("")); \
}\
if (query->check_result) { \
	sql << " AND check_result=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->check_result.getValue("")); \
}


int ProcessInspectionDAO::update(const ProcessinSpectionDO& uObj)
{
	//string sql = "UPDATE `sample` SET `name`=?, `sex`=?, `age`=? WHERE `id`=?";
	//return sqlSession->executeUpdate(sql, "%s%s%i%ull", uObj.getName(), uObj.getSex(), uObj.getAge(), uObj.getId());
	return {};
}

list<ProcessinSpectionDO> ProcessInspectionDAO::select(const ProcessinSpectionQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT ipqc_id,ipqc_code,ipqc_type,workorder_code,item_code, item_name, specification, unit_of_measure,quantity_check, check_result, inspect_date, inspector,`status` from qc_ipqc";
	PROCESSINSPECTION_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex-1) * query->pageSize) << "," << query->pageSize;
	ProcessinSpectionQueryMapper mapper;
	string str = sql.str();
	return sqlSession->executeQuery<ProcessinSpectionDO, ProcessinSpectionQueryMapper>(str, mapper,params);
}

uint64_t ProcessInspectionDAO::count(const ProcessinSpectionQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM qc_ipqc";
	PROCESSINSPECTION_TERAM_PARSE(query, sql);
	string str = sql.str();
	return sqlSession->executeQueryNumerical(str, params);
}

bool ProcessInspectionDAO::deleteById(uint64_t id)
{
	string sql = "delete from `qc_ipqc` where `ipqc_id`=?";
	return sqlSession->executeUpdate(sql, "%ull", id);
}

