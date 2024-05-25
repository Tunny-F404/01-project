#include "stdafx.h"
#include "ProductDAO.h"
#include "ProductMapper.h"
#include <sstream>


//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->pnum) { \
	sql << " AND `pnum`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->pnum.getValue("")); \
} \
if (query->pname) { \
	sql << " AND pname=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->pname.getValue("")); \
} \
if (query->prname) { \
	sql << " AND prname=?"; \
	SQLPARAMS_PUSH(params, "s", int, query->prname.getValue("")); \
}\
if (query->pdate) {\
		sql << " AND pdate=?"; \
		SQLPARAMS_PUSH(params, "s", int, query->pdate.getValue("")); \
}\
if (query->pstatus) {\
		sql << " AND pstatus=?"; \
		SQLPARAMS_PUSH(params, "s", int, query->pstatus.getValue("")); \
}\

uint64_t ProductTableDAO::count(const ProductQuery::Wrapper & query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM wm_issue_header ";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<ProductTableDO> ProductTableDAO::selectWithPage(const ProductQuery::Wrapper & query)
{
	stringstream sql;
	sql << "SELECT issue_id,issue_code,issue_name,workorder_code,client_code,client_name,issue_date,status FROM  wm_issue_header";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	ProductTableMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ProductTableDO, ProductTableMapper>(sqlStr, mapper, params);
}
