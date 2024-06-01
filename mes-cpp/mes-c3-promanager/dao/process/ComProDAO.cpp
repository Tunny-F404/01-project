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
#include "ComProDAO.h"
#include "ComProMapper.h"
#include "domain/dto/process/ComProDTO.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->process_name) { \
	sql << " AND `process_name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->process_name.getValue("")); \
} \
if (query->process_code) { \
	sql << " AND process_code=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->process_code.getValue("")); \
} 
//统计组成工序列表数据条数
uint64_t ComProDAO::count(const ProQuery::Wrapper & query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM pro_route_process";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}
//分页查询
list<ProRouteProcessDO> ComProDAO::selectWithPage(const ProQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT process_id,process_code,process_name,key_flag,next_process_name,link_type,is_check,default_pre_time,default_suf_time,color_code FROM pro_route_process";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	ComProMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ProRouteProcessDO, ComProMapper>(sqlStr, mapper, params);
}

//通过id查询
//list<ProRouteProcessDO> ComProDAO::selectByProcessID(const ComProListDTO::Wrapper& query)
//{
//	stringstream sql;
//	sql << "SELECT process_id,process_name,process_code,order_num,key_flag FROM pro_route_process";
//	SqlParams params;
//	sql << " WHERE 1=1";
//	if (query->process_id) {
//		sql << " AND `process_id`=?";
//		params.emplace_back(SqlParam("i", std::make_shared<int>(query->process_id.getValue(0))));
//	};
//	ComProMapper mapper;
//	string sqlStr = sql.str();
//	return sqlSession->executeQuery<ProRouteProcessDO, ComProMapper>(sqlStr, mapper, params);
//
//}

//添加
uint64_t ComProDAO::insert(const ProRouteProcessDO& iObj)
{
	string sql = "INSERT INTO `pro_route_process`						\
		(`route_id`,`process_id`,`next_process_id`,`process_code`,		\
		`process_name`, `next_process_name`,`key_flag`,`link_type`,		\
		`is_check`,`default_pre_time`,`default_suf_time`,`color_code`,`remark`)				\
		VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	return sqlSession->executeInsert(sql, "%ull%ull%ull%s%s%s%s%s%s%i%i%s%s", 
		iObj.getRouteId(), iObj.getProcessId(), iObj.getNextProcessId(), iObj.getProcessCode(), 
		iObj.getProcessName(), iObj.getKeyFlag(), iObj.getNextProcessName(), iObj.getLinkType(),
		iObj.getIsCheck(), iObj.getDefaultPreTime(), iObj.getDefaultSufTime(), iObj.getColorCode(), iObj.getRemark());
}
//修改
int ComProDAO::update(const ProRouteProcessDO& uObj)
{
	string sql = "UPDATE `pro_route_process` SET			\
		`process_code`=?, `process_name`=?, `key_flag`=?,	\
		`next_process_name`=?, `link_type`=?, `is_check`=?,	\
		`default_pre_time`=?, `default_suf_time`=?, `color_code`=?,\
		`remark`=? WHERE `record_id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%s%s%s%s%i%i%s%s%ull", 
		uObj.getProcessCode(), uObj.getProcessName(), uObj.getKeyFlag(),
		uObj.getNextProcessName(), uObj.getLinkType(), uObj.getIsCheck(), 
		uObj.getDefaultPreTime(), uObj.getDefaultSufTime(), uObj.getColorCode(),
		uObj.getRemark(),uObj.getRecordId());

}
