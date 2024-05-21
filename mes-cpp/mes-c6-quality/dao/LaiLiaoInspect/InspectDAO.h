#pragma once
#ifndef _INSPECT_DAO
#define _INSPECT_DAO
#include "BaseDAO.h"
#include "../../domain/do/LaiLiaoInspect/InspectDO.h"
#include "../../domain/query/LaiLiaoInspect/InspectQuery.h"

/**
 * 来料检验信息信息的数据库操作
 */
class MaterialDAO : public BaseDAO
{
public:
	// 统计数据条数
	uint64_t count(const MaterialQuery::Wrapper& query);
	// 分页查询数据
	list<MaterialDO> selectWithPage(const MaterialQuery::Wrapper& query);
	// 插入数据
	uint64_t insert(const MaterialDO& iObj);
	// 修改数据
	int update(const MaterialDO& uObj);
	// 通过ID删除数据
	int deleteById(uint64_t id);
};
#endif // !_INSPECT_DAO

