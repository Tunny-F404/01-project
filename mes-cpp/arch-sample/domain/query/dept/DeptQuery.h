#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2024/05/17 19:11:03

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
#ifndef _DEPTQUERY_H_
#define _DEPTQUERY_H_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * ���Ź����ѯ��������
 */
class DeptQuery : public oatpp::DTO
{
	DTO_INIT(DeptQuery, DTO);

	// ��������
	API_DTO_FIELD_DEFAULT(String, deptName, ZH_WORDS_GETTER("dept.fields.dname"));
	// ����״̬��0���� 1ͣ�ã�
	API_DTO_FIELD_DEFAULT(Int32, status, ZH_WORDS_GETTER("dept.fields.status"));
};

#include OATPP_CODEGEN_END(DTO)

#endif // !_DEPTQUERY_H_