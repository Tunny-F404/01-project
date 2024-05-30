
#include "stdafx.h"
#include "ProdWorkorderDAO.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->name) { \
	sql << " AND `name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->name.getValue("")); \
} \
if (query->sex) { \
	sql << " AND sex=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->sex.getValue("")); \
} \
if (query->age) { \
	sql << " AND age=?"; \
	SQLPARAMS_PUSH(params, "i", int, query->age.getValue(0)); \
}


int ProdWorkorderDAO::completeById(uint64_t id)
{
	//待完成----子工单必须都完成
	string sql = "UPDATE `pro_workorder` SET `status`='FINISHED' WHERE `workorder_id`= ? ";
	return sqlSession->executeUpdate(sql, "%ull", id);
}

int ProdWorkorderDAO::deleteById(uint64_t id)
{
	string sql = "DELETE FROM `pro_workorder` WHERE `workorder_id`=? and `status`='PREPARE'";
	return sqlSession->executeUpdate(sql, "%ull", id);
}

int ProdWorkorderDAO::comfirmById(uint64_t id)
{
	string sql = "UPDATE `pro_workorder` SET `status`='CONFIRMED' WHERE `workorder_id`= ? ";
	return sqlSession->executeUpdate(sql, "%ull", id);
	
}
