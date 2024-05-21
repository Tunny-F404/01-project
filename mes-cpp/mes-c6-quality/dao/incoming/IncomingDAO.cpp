#include "stdafx.h"
#include "IncomingDAO.h"
#include "IncomingMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define INCOMING_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->iqcCode) { \
	sql << " AND `iqcCode`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->iqcCode.getValue("")); \
} \
if (query->vendorCode) { \
	sql << " AND vendorCode=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->vendorCode.getValue("")); \
} \
if (query->vendorName) { \
	sql << " AND vendorName=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->vendorName.getValue("")); \
} \
if (query->vendorBatch) { \
	sql << " AND vendorBatch=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->vendorBatch.getValue("")); \
} \


uint64_t IncomingDAO::count(const IncomingQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM incoming";
	INCOMING_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<IncomingDO> IncomingDAO::selectWithPage(const IncomingQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT iqcCode,vendorCode,vendorName,vendorBatch FROM incoming";
	INCOMING_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	IncomingMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<IncomingDO, IncomingMapper>(sqlStr, mapper, params);
}
