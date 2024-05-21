#pragma once

#ifndef _INCOMING_SERVICE_
#define _INCOMING_SERVICE_
#include <list>
#include"domain/dto/incoming/IncomingDTO.h"
#include"domain/query/incoming/IncomingQuery.h"
#include"domain/vo/incoming/IncomingVO.h"

/**
 * 示例服务实现，演示基础的示例服务实现
 */
class IncomingService
{
public:
	// 分页查询所有数据
	IncomingPageDTO::Wrapper listAll(const IncomingQuery::Wrapper& query);
	// 保存数据
	uint64_t saveData(const IncomingDTO::Wrapper& dto);
	// 修改数据
	bool updateData(const IncomingDTO::Wrapper& dto);
	// 通过ID删除数据
	bool removeData(uint64_t id);
};

#endif // !_INCOMING_SERVICE_

