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
#include "DeviceMangeDAO.h"
#include "DeviceManageMapper.h"
#include <sstream>

int DeviceManageDAO::update(const DeviceManageDO& uObj)
{
	string sql = "UPDATE `dv_subject` SET `subject_code`=?, `subject_name`=?, `subject_type`=?, `subject_content`=?, `subject_standard`=?, `enable_flag`=? WHERE `subject_id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%s%s%s%s%ull", uObj.getSubjectCode(), uObj.getSubjectName(), uObj.getSubjectType(), uObj.getSubjectContent(), uObj.getSubjectStandard(), 
		uObj.getEnableFlag(), uObj.getSubjectId());

}

list<DeviceManageDO> DeviceManageDAO::queryById(const DeviceManageDelDO& uObj)
{
	string sql = "SELECT subject_id,subject_code,subject_name,subject_type,subject_content,subject_standard,enable_flag FROM dv_subject WHERE subject_id in(" + uObj.getSubjectDelId() + ")";
	DeviceManageMapper mapper;
	return sqlSession->executeQuery<DeviceManageDO, DeviceManageMapper>(sql, mapper);

}

int DeviceManageDelDAO::deleteById(const DeviceManageDelDO& uObj)
{
	string sql = "DELETE from `dv_subject` WHERE `subject_id` in(" + uObj.getSubjectDelId() + ")";

	 
	return sqlSession->executeUpdate(sql);

}

