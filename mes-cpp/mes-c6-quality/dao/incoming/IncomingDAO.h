#pragma once
=
#ifndef _INCOMING_DAO_
#define _INCOMING_DAO_
#include "BaseDAO.h"
#include "../../domain/do/incoming/IncomingDO.h"
#include "../../domain/query/incoming/IncomingQuery.h"

/**
 * 示例表数据库操作实现
 */
class IncomingDAO : public BaseDAO
{
public:
	// 统计数据条数
	uint64_t count(const IncomingQuery::Wrapper& query);
	// 分页查询数据
	list<IncomingDO> selectWithPage(const IncomingQuery::Wrapper& query);
	// 通过姓名查询数据
	//list<IncomingDO> selectByName(const string& name);
	// 插入数据
	//uint64_t insert(const IncomingDO& iObj);
	// 修改数据
	//int update(const IncomingDO& uObj);
	// 通过ID删除数据
	//int deleteById(uint64_t id);
};
#endif // !_INCOMING_DAO_
