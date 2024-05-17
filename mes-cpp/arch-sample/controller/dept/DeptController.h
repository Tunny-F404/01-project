#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2024/05/17 19:43:10

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
#ifndef _DEPTCONTROLLER_H_
#define _DEPTCONTROLLER_H_

#include "domain/vo/dept/DeptVO.h"
#include "domain/query/dept/DeptQuery.h"

#include OATPP_CODEGEN_BEGIN(ApiController)

/**
 * ���Ź������
 */
class DeptController : public oatpp::web::server::api::ApiController
{
	// ����������������
	API_ACCESS_DECLARE(DeptController);
public: // ����ӿ�
	// 3.1 �����ѯ�ӿ�����
	ENDPOINT_INFO(queryDeptTable) {
		// ����ӿڱ���
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("dept.query.summary"));
		// ����Ĭ����Ȩ��������ѡ���壬��������ˣ�����ENDPOINT������Ҫ����API_HANDLER_AUTH_PARAME��
		API_DEF_ADD_AUTH();
		// ������Ӧ������ʽ
		API_DEF_ADD_RSP_JSON_WRAPPER(DeptTableJsonVO);
		// ����������ѯ��������
		API_DEF_ADD_QUERY_PARAMS(String, "deptName", ZH_WORDS_GETTER("dept.fields.dname"), "li ming", false);
		API_DEF_ADD_QUERY_PARAMS(Int32, "status", ZH_WORDS_GETTER("dept.fields.status"), 0, false);
	}
	// 3.2 �����ѯ�ӿڴ���
	ENDPOINT(API_M_GET, "/dept/query-dept-table", queryDeptTable, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// ������ѯ����ΪQuery����ģ��
		API_HANDLER_QUERY_PARAM(query, DeptQuery, queryParams);
		// ����ִ�к�����Ӧ���
		API_HANDLER_RESP_VO(execDeptTable(query));
	}

private: // ����ӿ�ִ�к���
	// 3.3 ��ʾ��ҳ��ѯ����
	DeptTableJsonVO::Wrapper execDeptTable(const DeptQuery::Wrapper& query);
};

#include OATPP_CODEGEN_END(ApiController)

#endif // !_DEPTCONTROLLER_H_