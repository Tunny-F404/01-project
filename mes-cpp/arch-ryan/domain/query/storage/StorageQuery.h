#pragma once

#ifndef _STORAGEQUERY_H_
#define _STORAGEQUERY_H_

#include "../../GlobalInclude.h"
// #include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 仓库管理查询对象
 */
class StorageQuery : public oatpp::DTO
{
	// 定义初始化
	DTO_INIT(StorageQuery, DTO);
	// 退货单名称
	API_DTO_FIELD_DEFAULT(String, returnName, ZH_WORDS_GETTER("storage.fields.rtname"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_USERQUERY_H_