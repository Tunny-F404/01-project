#include "stdafx.h"
#include "EquipmentDAO.h"
#include"../../dao/equipment/EquipmentMapper.h"
//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->eCode) { \
	sql << " AND `machinery_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->eCode.getValue("")); \
} \
if (query->eName) { \
	sql << " AND machinery_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->eName.getValue("")); \
} 

#define SAMPLE_TERAM_PARSEX(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->eId) { \
	sql << " AND `machinery_id`=?"; \
	SQLPARAMS_PUSH(params, "i", int, query->eId.getValue(0)); \
} 


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
	sql << "SELECT machinery_id,machinery_code,machinery_name,machinery_brand,machinery_spec,workshop_id,workshop_code,workshop_name,status,create_time FROM dv_machinery";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	EquipmentMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<dvMachineryDO, EquipmentMapper>(sqlStr, mapper, params);
}

list<dvMachineryDO> EquipmentDAO::selectWithId(const EquipmentDetailQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT machinery_id,machinery_code,machinery_name,machinery_brand,machinery_type_id,machinery_type_code,machinery_type_name,machinery_spec,workshop_id,workshop_code,workshop_name,remark FROM dv_machinery ";
	SAMPLE_TERAM_PARSEX(query, sql);
	EquipmentDetailMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<dvMachineryDO, EquipmentDetailMapper>(sqlStr, mapper, params);
}
