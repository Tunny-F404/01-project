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
#include "ReturnDAO.h"
#include "ReturnMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
//#define RETURN_TERAM_PARSE(query, sql) \
//SqlParams params; \
//sql<<" WHERE 1=1"; \
//if (query->name) { \
//	sql << " AND `name`=?"; \
//	SQLPARAMS_PUSH(params, "s", std::string, query->name.getValue("")); \
//} \
//if (query->sex) { \
//	sql << " AND sex=?"; \
//	SQLPARAMS_PUSH(params, "s", std::string, query->sex.getValue("")); \
//} \
//if (query->age) { \
//	sql << " AND age=?"; \
//	SQLPARAMS_PUSH(params, "i", int, query->age.getValue(0)); \
//}

//uint64_t ReturnDAO::count(const ReturnQuery::Wrapper& query)
//{
//	return 1;
//}
//
//std::list<ReturnDO> ReturnDAO::selectWithPage(const ReturnQuery::Wrapper& query)
//{
//	return {};
//}
//
//std::list<ReturnDO> ReturnDAO::selectByName(const string& name)
//{
//	return {};
//}
//
//uint64_t ReturnDAO::insert(const ReturnDO& iObj)
//{
//	return 1;
//}

int ReturnDAO::update(const ReturnDO& uObj)
{
	//rt_code rt_name po_code vendor_name batch_code rt_date status remark
	string sql = "UPDATE `wm_rt_vendor` SET `rt_code`=?, `rt_name`=?, `po_code`=? , `vendor_name`=?, `batch_code`=?, `rt_date`=?, `status`=? , `remark`=? WHERE `rt_id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%s%s%s%s%s%s%ull", uObj.getRt_code(), uObj.getRt_name(), uObj.getPo_code(), uObj.getVendor_name(),
		uObj.getBatch_code(), uObj.getRt_date(), uObj.getStatus_(), uObj.getRemark(), uObj.getRt_id());
}

int ReturnDAO::deleteById(uint64_t id)
{
	string sql = "DELETE FROM `wm_rt_vendor` WHERE `rt_id`=?";
	return sqlSession->executeUpdate(sql, "%ull", id);
}

int ReturnDAO::updateStatusById(uint64_t id)
{
	string executeStatus = "Finished";
	string sql = "UPDATE `wm_rt_vendor` SET `status`=? WHERE `rt_id`=?";
	return sqlSession->executeUpdate(sql, "s%%ull", executeStatus,id);
}
