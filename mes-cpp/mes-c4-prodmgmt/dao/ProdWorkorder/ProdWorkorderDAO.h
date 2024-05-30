#pragma once

#ifndef _PRODWORKORDER_DAO_
#define _PRODWORKORDER_DAO_
#include "BaseDAO.h"
#include "../../domain/do/ProdWorkorder/ProdWorkorderDO.h"

/**
 * 生产工单表数据库操作实现
 */
class ProdWorkorderDAO : public BaseDAO
{
public:
	// 通过ID完成生产工单
	int completeById(uint64_t id);
	// 通过ID删除生产工单
	int deleteById(uint64_t id);
	//通过id确认生产工单
	int comfirmById(uint64_t id);
};
#endif // !_PRODWORKORDER_DAO_
