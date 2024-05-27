#pragma once
#ifndef _PROCESSPRO_SERVICE_
#define _PROCESSPRO_SERVICE_
#include <list>
#include "domain/vo/process/ComProVO.h"
#include "domain/query/process/ComProQuery.h"
#include "domain/dto/process/ComProDTO.h"

/**
 * 删除组成工序的service
 */
class ComProService
{
public:

	// 通过ID删除数据
	bool removeData(list<uint64_t> id);
};

#endif // !_SAMPLE_SERVICE_