#include "stdafx.h"
#include "EquipmentDAO.h"

uint64_t EquipmentDAO::count(const EquipmentQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM dv_machinery";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

list<dvMachineryDO> EquipmentDAO::selectWithPage(const EquipmentQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT id,name,sex,age FROM sample";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	SampleMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<SampleDO, SampleMapper>(sqlStr, mapper, params);
}
