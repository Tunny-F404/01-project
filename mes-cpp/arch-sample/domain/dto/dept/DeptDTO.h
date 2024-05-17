#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2024/05/17 19:24:00

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
#ifndef _DEPTDTO_H_
#define _DEPTDTO_H_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)
/**
 * 部门列表数据模型
 */
class DeptTableDTO : public oatpp::DTO
{
	DTO_INIT(DeptTableDTO, DTO);
	// 唯一标识
	API_DTO_FIELD(UInt64, deptId, ZH_WORDS_GETTER("dept.fields.id"), true, 1);
	// 部门名称
	API_DTO_FIELD(String, deptName, ZH_WORDS_GETTER("dept.fields.dname"), true, "01star");
	// 部门排序
	API_DTO_FIELD(Int32, orderNum, ZH_WORDS_GETTER("dept.fields.order"), true, 0);
	// 部门状态（0正常 1停用）
	API_DTO_FIELD(Int32, status, ZH_WORDS_GETTER("dept.fields.status"), true, 0);
	// 创建时间
	API_DTO_FIELD(String, createTime, ZH_WORDS_GETTER("dept.fields.ctime"), true, "2024-05-17 00:29:30");
};

/**
 * 部门详情数据模型
 */
class DeptDetailDTO : public DeptTableDTO
{
	DTO_INIT(DeptDetailDTO, DeptTableDTO);
	// 负责人
	API_DTO_FIELD(String, leader, ZH_WORDS_GETTER("dept.fields.leader"), true, "zhang san");
	// .......
};

#include OATPP_CODEGEN_END(DTO)

#endif // !_DEPTDTO_H_