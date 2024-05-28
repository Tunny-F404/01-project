#include "stdafx.h"
#include "ProMaterialDAO.h"
#include "ProMaterialMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->item_code) { \
	sql << " AND `item_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->item_code.getValue("")); \
} \
if (query->item_name) { \
	sql << " AND item_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->item_name.getValue("")); \
} 

uint64_t ProMaterialDAO::count(const ProMaterialQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM pro_route_product_bom";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<ProRouteProductBomDO> ProMaterialDAO::selectWithPage(const ProMaterialQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT item_code,item_name,specification,unit_of_measure,quantity,remark FROM pro_route_product_bom";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	ProMaterialMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ProRouteProductBomDO, ProMaterialMapper>(sqlStr, mapper, params);
}

std::list<ProRouteProductBomDO> ProMaterialDAO::selectByItemCode(const string& item_code)
{
	string sql = "SELECT item_code,item_name,specification,unit_of_measure,quantity,remark FROM pro_route_product_bom WHERE `item_code` LIKE CONCAT('%',?,'%')";
	ProMaterialMapper mapper;
	return sqlSession->executeQuery<ProRouteProductBomDO, ProMaterialMapper>(sql, mapper, "%s", item_code);
}

std::list<ProRouteProductBomDO> ProMaterialDAO::selectByItem_Name(const string& item_name)
{
	string sql = "SELECT item_code,item_name,specification,unit_of_measure,quantity,remark FROM pro_route_product_bom WHERE `item_name` LIKE CONCAT('%',?,'%')";
	ProMaterialMapper mapper;
	return sqlSession->executeQuery<ProRouteProductBomDO, ProMaterialMapper>(sql, mapper, "%s", item_name);
}