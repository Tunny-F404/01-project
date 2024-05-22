#pragma once
#ifndef _RETURN_SERVICE_
#define _RETURN_SERVICE_
#include <list>
#include "domain/vo/return/ReturnVO.h"
#include "domain/query/return/ReturnQuery.h"
#include "domain/dto/return/ReturnDTO.h"

/**
 * 退货单据相关服务
 */
class ReturnService
{
public:
	// 分页查询所有数据
	ReturnPageDTO::Wrapper listAll(const ReturnQuery::Wrapper& query);
	// 查询单一数据详情
	ReturnDetailDTO::Wrapper getDetail(const ReturnDetailQuery::Wrapper& returnDetailQuery);
	// 添加新数据
	uint64_t saveData(const ReturnAdd::Wrapper& dto);
};

#endif // !_SAMPLE_SERVICE_
