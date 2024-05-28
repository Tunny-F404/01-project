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
#include "SampleDAO.h"
#include "SampleMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->record_id) { \
	sql << " AND `record_id`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->record_id.getValue("")); \
} \
if (query->feedback_type) { \
	sql << " AND feedback_type=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->feedback_type.getValue("")); \
} \
if (query->workstation_name) { \
	sql << " AND workstation_name=?"; \
	SQLPARAMS_PUSH(params, "i", int, query->workstation_name.getValue(0)); \
}\
if (query->workorder_code) { \
	sql << " AND workorder_code=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->workorder_code.getValue("")); \
}\
if (query->item_code) { \
	sql << " AND item_code=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->item_code.getValue("")); \
} \
if (query->item_name) { \
	sql << " AND item_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->item_name.getValue("")); \
} \
if (query->specification) { \
	sql << " AND specification=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->specification.getValue("")); \
} \
if (query->quantity_feedback) { \
	sql << " AND squantity_feedbackex=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->quantity_feedback.getValue("")); \
} \
if (query->user_name) { \
	sql << " AND user_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->user_name.getValue("")); \
} \
if (query->feedback_time) { \
	sql << " AND feedback_time=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->feedback_time.getValue("")); \
} \
if (query->record_nick) {\
	sql << " AND record_nick=?"; \
		SQLPARAMS_PUSH(params, "s", std::string, query->record_nick.getValue("")); \
} \
if (query->status) {\
    sql << " AND status=?"; \
		SQLPARAMS_PUSH(params, "s", std::string, query->status.getValue("")); \
} \

uint64_t ProduceWorkDAO::count(const PworkQery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM ktgmes";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<PworkDo> ProduceWorkDAO::selectWithPage(const PworkQery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT record_id,feedback_type,workstation_name,\
	workorder_code,item_code,item_name,specification,quantity_feedback,\
	user_name,feedback_time,record_nick,status FROM ktgmes";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	ProduceWorkMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<PworkDo, ProduceWorkMapper>(sqlStr, mapper, params);
}


std::list<PworkDo> ProduceWorkDAO::selectByName(const string& name)
{
	string sql = "SELECT record_id,feedback_type,workstation_name,\
	workorder_code,item_code,item_name,specification,quantity_feedback,\
	user_name,feedback_time,record_nick,status FROM ktgmes WHERE `record_id` LIKE CONCAT('%',?,'%')";
	ProduceWorkMapper mapper;
	return sqlSession->executeQuery<PworkDo, ProduceWorkMapper>(sql, mapper, "%s", name);
}


//
uint64_t SampleDAO::insert(const addProduceWorkDo& iObj)
{
	string sql = "INSERT INTO `ktgmes` (`name`, `sex`, `age`) VALUES (?, ?, ?)";
	return sqlSession->executeInsert(sql, "%s%s%i", iObj.getName(), iObj.getSex(), iObj.getAge());
}

int SampleDAO::update(const PworkDo& uObj)
{
	string sql = "UPDATE `ktgmes` SET `name`=?, `sex`=?, `age`=? WHERE `id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%i%ull", uObj.getName(), uObj.getSex(), uObj.getAge(), uObj.getId());
}

