#pragma once
#ifndef _PROCESSLIST_SERVICE_
#define _PROCESSLIST_SERVICE_
#include <list>
#include "domain/vo/process/ProcessListVO.h"
#include "domain/query/process/ProcessListQuery.h"
#include "domain/dto/process/ProcessListDTO.h"

/**
 * 示例服务实现，演示基础的示例服务实现
 */
class ProcessListService
{
public:
	// 分页查询工艺列表数据
	ProcessListDTO::Wrapper listAll(const ProcessListQuery::Wrapper& query);
	// 通过id查询工艺详情
	ProcessDTO::Wrapper getById(const ProcessDetailQuery::Wrapper& query);
	// 添加工艺 保存数据
	uint64_t saveProcessAdd(const ProcessAddDTO::Wrapper& dto);
};

#endif // !_SAMPLE_SERVICE_
