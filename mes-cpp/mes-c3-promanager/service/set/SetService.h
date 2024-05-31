#pragma once

#ifndef _SET_SERVICE_
#define _SET_SERVICE_
#include <list>
#include "domain/vo/set/SetProListVO.h"
#include "domain/query/set/SetProListQuery.h"
#include "domain/dto/set/SetProAddDTO.h"
#include "domain/dto/set/SetProListDTO.h"

#include "domain/vo/set/ProDetailVO.h"
#include "domain/vo/set/ProNameListVO.h"
#include "domain/query/set/ProListQuery.h"
#include "domain/query/set/ProDetailQuery.h"

/**
 * 示例服务实现，演示基础的示例服务实现
 */
class SetService
{
public:
	// 分页查询所有数据
	SetProListPageDTO::Wrapper listAll(const SetProListQuery::Wrapper& query);
	// 保存数据
	uint64_t saveData(const SetProAddTableDTO::Wrapper& dto);
	uint64_t saveStepData(const SetProListDTO::Wrapper& dto);
	// 修改数据
	bool updateData(const SetProAddTableDTO::Wrapper& dto);

	// 分页查询所有工序
	ProListPageDTO::Wrapper listAllForProcess(const ProListQuery::Wrapper& query);
	// 查询工序详情
	ProDetailDTO::Wrapper getProcessDetail(const ProDetailQuery::Wrapper& query);
	// 查询工序名称列表
	ProNameListJsonVO::Wrapper getProcessNameList();

#endif // !_SET_SERVICE_

};