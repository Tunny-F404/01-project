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


int ProcessInspectionDAO::update(const ProcessinSpectionDO & uObj)
{
	//string sql = "UPDATE `sample` SET `name`=?, `sex`=?, `age`=? WHERE `id`=?";
	//return sqlSession->executeUpdate(sql, "%s%s%i%ull", uObj.getName(), uObj.getSex(), uObj.getAge(), uObj.getId());
	string sql = "UPDATE qc_ipqc \
		SET \
		ipqc_code=?,\
		ipqc_name=?,\
		ipqc_type=?,\
		workorder_code=?,\
		workorder_name=?,\
		workstation_code=?,\
		workstation_name=?,\
		item_code=?, \
		item_name=?, \
		specification=?, \
		process_code=?,\
		process_name=?,\
		task_code=?,\
		task_name=?,\
		unit_of_measure=?,\
		quantity_check=?, \
		quantity_unqualified=?,\
		quantity_qualified=?,\
		cr_quantity=?,\
		maj_quantity=?,\
		min_quantity=?,\
		inspect_date=?,\
		check_result=?, \
		inspector=?,\
		remark=? WHERE ipqc_id=?";
	return sqlSession->executeUpdate(sql,
		"%ull%s%s%s%s%s%s%s%s%s%s%s%s%s%s%d%d%d%d%d%d%s%s%s%s%ull",
		uObj.getIpqc_Code(), uObj.getIpqc_Name(),
		uObj.getIpqc_Type(), uObj.getWorkorder_Code(),
		uObj.getWorkorder_Name(), uObj.getWorkstation_Code(),
		uObj.getWorkstation_Name(), uObj.getItem_Code(),
		uObj.getItem_Name(), uObj.getSpecification(),
		uObj.getProcess_Code(), uObj.getProcess_Name(),
		uObj.getTask_Code(), uObj.getTask_Name(),
		uObj.getUnit_Of_Measure(), uObj.getQuantity_Check(),
		uObj.getQuantity_Unqualified(), uObj.getQuantity_Qualified(),
		uObj.getCr_Quantity(), uObj.getMaj_Quantity(),
		uObj.getMin_Quantity(), uObj.getInspect_Date(),
		uObj.getCheck_Result(), uObj.getInspector(),
		uObj.getRemark(), uObj.getId());
	//return {};
}

list<ProcessinSpectionDO> ProcessInspectionDAO::select(const ProcessinSpectionQuery::Wrapper& query,int flag)
{
	stringstream sql;
	sql << "SELECT ipqc_id,ipqc_code,ipqc_type,workorder_code,item_code, item_name, specification, unit_of_measure,quantity_check, check_result, inspect_date, inspector,`status` from qc_ipqc";
	PROCESSINSPECTION_TERAM_PARSE(query, sql);
	if(!flag)
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

