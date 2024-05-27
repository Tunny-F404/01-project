#include "stdafx.h"
#include "ProcessDAO.h"
#include "ProcessMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->routeCode) { \
	sql << " AND `route_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->routeCode.getValue("")); \
} \
if (query->routeName) { \
	sql << " AND route_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->routeName.getValue("")); \
} \
if (query->enableFlag) { \
	sql << " AND enable_flag=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->enableFlag.getValue("")); \
}
// 统计工艺列表数据条数
uint64_t ProcessDAO::count(const ProcessListQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM pro_route";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}
// 分页查询工艺列表
std::list<ProRouteDO> ProcessDAO::selectWithPage(const ProcessListQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT route_id,route_code,route_name,route_desc,enable_flag,remark FROM pro_route";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	ProcessMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ProRouteDO, ProcessMapper>(sqlStr, mapper, params);
}
// 通过id查询工艺详情
std::list<ProRouteDO>  ProcessDAO::selectById(const ProcessDetailQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT route_id,route_code,route_name,route_desc,enable_flag,remark FROM pro_route";
	SqlParams params;
	sql << " WHERE 1=1";
	if (query->routeId) {
		sql << " AND `route_id`=?";
		params.emplace_back(SqlParam("i", std::make_shared<int>(query->routeId.getValue(0))));
	};
	ProcessMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ProRouteDO, ProcessMapper>(sqlStr, mapper, params);
	
}
// 添加工艺
uint64_t ProcessDAO::insert(const ProRouteDO& iObj)
{
	string sql = "INSERT INTO `pro_route` (`route_code`, `route_name`, `route_desc`, `enable_flag`, `remark`) VALUES (?, ?, ?, ?, ?)";
	return sqlSession->executeInsert(sql, "%s%s%s%s%s", iObj.getRouteCode(), iObj.getRouteName(), iObj.getRouteDesc(), iObj.getEnableFlag(), iObj.getRemark());
}
