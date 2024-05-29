#pragma once

#ifndef _SET_DAO_
#define _SET_DAO_
#include "BaseDAO.h"
#include "../../domain/do/pro/ProProcessDO.h"
#include "../../domain/do/pro/ProProcessContentDO.h"
#include "../../domain/query/set/SetProListQuery.h"

/**
 * 示例表数据库操作实现
 */
class SetDAO : public BaseDAO
{
public:
	// 统计数据条数
	uint64_t count(const SetProListQuery::Wrapper& query);
	// 分页查询数据
	list<ProProcessContentDO> selectWithPage(const SetProListQuery::Wrapper& query);
	//// 通过id查询数据
	list<ProProcessContentDO> selectById(const uint64_t& id);
	// 插入数据
	uint64_t insertSet(const ProProcessDO& iObj);
	// 插入步骤数据
	uint64_t insertstepSet(const ProProcessContentDO& iObj);
	// 修改数据
	int updateSet(const ProProcessDO& uObj);
};
#endif // !_SET_DAO_
