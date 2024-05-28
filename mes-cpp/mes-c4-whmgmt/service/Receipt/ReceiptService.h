#pragma once

#ifndef __RECEIPT_SERVICE_
#define __RECEIPT_SERVICE_
#include <list>
#include "../../domain/dto/Receipt/ReceiptDTO.h"
#include "../../domain/query/Receipt/ReceiptQuery.h"
#include "../../domain/do/Receipt/ReceiptDO.h"

/**
 * 获取单据列表 
 */
class ReceiptService
{
public:
	// 分页查询列表数据
	ReceiptPageTableDTO::Wrapper listAll(const ReceiptTableQuery::Wrapper& query);
};

#endif // !__RECEIPT_SERVICE_

