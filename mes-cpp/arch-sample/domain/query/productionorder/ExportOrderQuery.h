#pragma once
#ifndef _Order_QUERY_
#define _Order_QUERY_
#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"//有分页就导入并继承
#include OATPP_CODEGEN_BEGIN(DTO)

class OrderQuery : public oatpp::DTO
{
	DTO_INIT(OrderQuery, DTO);
	API_DTO_FIELD_DEFAULT(String, workOrderCode,ZH_WORDS_GETTER("productionorder.query.fields.workorder_code"));
	API_DTO_FIELD_DEFAULT(String, workOrderName, ZH_WORDS_GETTER("productionorder.query.fields.workorder_name"));
	API_DTO_FIELD_DEFAULT(String, sourceCode, ZH_WORDS_GETTER("productionorder.query.fields.source_code"));
	API_DTO_FIELD_DEFAULT(String, productCode, ZH_WORDS_GETTER("productionorder.query.fields.product_code"));
	API_DTO_FIELD_DEFAULT(String, productName, ZH_WORDS_GETTER("productionorder.query.fields.product_name"));
	API_DTO_FIELD_DEFAULT(String, clientCode, ZH_WORDS_GETTER("productionorder.query.fields.client_code"));
	API_DTO_FIELD_DEFAULT(String, clientName, ZH_WORDS_GETTER("productionorder.query.fields.client_name"));
	API_DTO_FIELD_DEFAULT(String, requestDate, ZH_WORDS_GETTER("productionorder.query.fields.request_date"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_Order_QUERY_