#pragma once
#ifndef _INSPECT_DAO
#define _INSPECT_DAO
#include "BaseDAO.h"
#include "../../domain/do/LaiLiaoInspect/InspectDO.h"
#include "../../domain/query/LaiLiaoInspect/InspectQuery.h"

/**
 * 来料检验信息信息的数据库操作
 */
class InspectDAO : public BaseDAO
{
public:
	// 统计数据条数
	uint64_t count(const InspectQuery::Wrapper& query);
	// 分页查询数据
	list<InspectDO> selectWithPage(const InspectQuery::Wrapper& query);
	//查询详情
	InspectDO selectWith(const Inspect_detailQuery::Wrapper& query);
	// 插入数据
	uint64_t insert(const InspectDO& iObj);
	//// 修改数据
	//int update(const InspectDO& uObj);
	//// 通过ID删除数据
	//int deleteById(uint64_t id);
};




#endif // !_INSPECT_DAO

