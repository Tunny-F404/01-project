#pragma once

#ifndef _PRODWORKORDER_SERVICE_
#define _PRODWORKORDER_SERVICE_
#include <list>
#include "../../domain/vo/ProdWorkorder/ConfirmProWorkorderVO.h"
#include "../../domain/dto/ProdWorkorder/ConfirmProWorkorderDTO.h"

/**
 * 示例服务实现，演示基础的示例服务实现
 */
class ProdWorkorderService
{
public:
	//// 分页查询所有数据
	//SamplePageDTO::Wrapper listAll(const SampleQuery::Wrapper& query);
	//// 保存数据
	//uint64_t saveData(const SampleDTO::Wrapper& dto);
	//// 修改数据
	//bool updateData(const SampleDTO::Wrapper& dto);
	// 通过ID完成生产工单
	bool completeData(uint64_t id);
	// 通过ID删除生产工单
	bool removeData(uint64_t id);

	// 通过ID删除生产工单
	bool confirmData(uint64_t id);
};

#endif // !_PROWORKORDER_SERVICE_

