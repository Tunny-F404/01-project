/*
 Copyright Zero One Star. All rights reserved.

 @Author: hejianwei
 @Date: 2024/05/24 10:36:52

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
#include "RepaircontentDAO.h"
#include "RepaircontentMapper.h"
#include <sstream>

#include "../../domain\query\repaircontent\RepaircontentQuery.h"

using namespace std;

//定义条件解析宏，减少重复代码
#define REPAIRCONTENT_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->subject_name) { \
	sql << " AND `subject_name`=?"; \
	SQLPARAMS_PUSH(params, "s", string, query->subject_name.getValue("")); \
} \
if (query->repair_id) { \
	sql << " AND repair_id=?"; \
	SQLPARAMS_PUSH(params, "ull", uint64_t, query->repair_id.getValue(1)); \
}


uint64_t RepaircontentDAO::count(const RepaircontentQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM dv_repair_line";
	REPAIRCONTENT_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<dv_repair_lineDO> RepaircontentDAO::selectWithPage(const RepaircontentQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT subject_name,malfunction,malfunction_url,repair_des,subject_code,subject_type,subject_content,create_by,create_time,update_by,update_time FROM dv_repair_line";
	REPAIRCONTENT_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	RepaircontentMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<dv_repair_lineDO, RepaircontentMapper>(sqlStr, mapper, params);
}

std::list<dv_repair_lineDO> RepaircontentDAO::selectByName(const string& name)
{
	stringstream sql;
	SqlParams params;
	sql << "SELECT subject_name,malfunction,malfunction_url,repair_des,subject_code,subject_type,subject_content FROM dv_repair_line WHERE `name` LIKE CONCAT('%',?,'%')";
	SQLPARAMS_PUSH(params, "s", string, name);
	RepaircontentMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<dv_repair_lineDO, RepaircontentMapper>(sqlStr, mapper, params);
}

uint64_t RepaircontentDAO::insert(const dv_repair_lineDO& iObj)
{
	string sql = "INSERT INTO `dv_repair_line` (`subject_name`, `malfunction`, `malfunction_url`,`repair_des`) VALUES (?, ?, ?,?)";
	return sqlSession->executeInsert(sql, "%s%s%s%s", iObj.getsubject_Name(), iObj.getMalfunction(),
		iObj.getMalfunction_url(), iObj.getrepair_Des());
}


int RepaircontentDAO::update(const dv_repair_lineDO& uObj)
{
	string sql = "UPDATE `dv_repair_line` SET `getsubject_Name`=?, `getMalfunction`=?, `getMalfunction_url`=?,`getrepair_Des`=? WHERE `subject_id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%s%s%ull", uObj.getsubject_Name(), uObj.getMalfunction(),
 uObj.getMalfunction_url(), uObj.getrepair_Des(), uObj.getsubject_Id());
}

int RepaircontentDAO::deleteById(uint64_t id)
{
	string sql = "DELETE FROM `dv_repair_line` WHERE `subject_id`=?";
	return sqlSession->executeUpdate(sql, "%ull", id);
}