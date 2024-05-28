#pragma once
#ifndef _RELATEPRO_DAO_
#define  _RELATEPRO_DAO_
#include "BaseDAO.h"
#include "../../domain/do/pro/ProRouteProductDO.h"

/**
 * 关联产品数据库操作实现
 */
class RelateProDAO : public BaseDAO
{
public:
	// 插入关联产品
	uint64_t insert(const ProRouteProductDO& iObj);
	// 修改关联产品
	int update(const ProRouteProductDO& uObj);
};
#endif // ! _RELATEPRO_DAO_
