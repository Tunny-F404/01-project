#include "stdafx.h"
#include "ReceiptDAO.h"
#include "ReceiptMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->recptCode) { \
	sql << " AND recpt_code=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->recptCode.getValue("")); \
} \
if (query->recptName) { \
	sql << " AND recpt_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->recptName.getValue("")); \
} \
if (query->vendorName) { \
	sql << " AND vendor_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->vendorName.getValue("")); \
} \
if (query->poCode) { \
	sql << " AND po_code=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->poCode.getValue("")); \
}\
if (query->recptDate) { \
	sql << " AND recpt_date=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->recptDate.getValue("")); \
}


uint64_t ReceiptPageTableDAO::count(const ReceiptTableQuery::Wrapper & query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM wm_item_recpt";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<ReceiptPageTableDO> ReceiptPageTableDAO::selectWithPage(const ReceiptTableQuery::Wrapper & query)
{
	stringstream sql;
	sql << "select recptId, recptCode, recptName, vendorName, poCode, recptDate, status from wm_item_recpt";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	ReceiptMapper mapper;
	std::string sqlStr = sql.str();

	return sqlSession->executeQuery<ReceiptPageTableDO, ReceiptMapper>(sqlStr, mapper, params);
}
