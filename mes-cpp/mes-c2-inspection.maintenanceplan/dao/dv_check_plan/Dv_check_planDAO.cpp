/*
* 
*/
#include "stdafx.h"
#include "Dv_check_planDAO.h"
#include "Dv_check_planMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
//abf：这个应该是在组合sql语句的宏，对于查询条件，有输入就放AND一并去查询
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->plan_code) { \
	sql << " AND `plan_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->plan_code.getValue("")); \
} \
if (query->plan_name) { \
	sql << " AND plan_name=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->plan_name.getValue("")); \
} \
if (query->plan_type) { \
	sql << " AND plan_type=?"; \
	SQLPARAMS_PUSH(params, "i", std::string, query->plan_type.getValue("")); \
} \
if (query->status) { \
	sql << " AND status=?"; \
	SQLPARAMS_PUSH(params, "i", std::string, query->status.getValue("")); \
}


uint64_t Dv_check_planDAO::count(const MachineryPlanQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM dv_check_plan";
	SAMPLE_TERAM_PARSE(query, sql);

	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

std::list<Dv_check_planDO> Dv_check_planDAO::selectWithPage(const MachineryPlanQuery::Wrapper& query)
{
	stringstream sql;
	//sql << "SELECT plan_id,plan_code,plan_name,plan_type,status FROM dv_check_plan";
	sql << "SELECT * FROM dv_check_plan";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	Dv_check_planMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<Dv_check_planDO, Dv_check_planMapper>(sqlStr, mapper, params);
}
/*
std::list<SampleDO> Dv_check_planDO::selectByName(const string& name)
{
	string sql = "SELECT id,name,sex,age FROM sample WHERE `name` LIKE CONCAT('%',?,'%')";
	SampleMapper mapper;
	return sqlSession->executeQuery<SampleDO, SampleMapper>(sql, mapper, "%s", name);
}
*/

//暂时先注释不看【插入，修改，删除】
/*
uint64_t Dv_check_planDAO::insert(const Dv_check_planDO& iObj)
{
	string sql = "INSERT INTO `sample` (`name`, `sex`, `age`) VALUES (?, ?, ?)";
	return sqlSession->executeInsert(sql, "%s%s%i", iObj.getName(), iObj.getSex(), iObj.getAge());
}

int Dv_check_planDAO::update(const Dv_check_planDO& uObj)
{
	string sql = "UPDATE `sample` SET `name`=?, `sex`=?, `age`=? WHERE `id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%i%ull", uObj.getName(), uObj.getSex(), uObj.getAge(), uObj.getId());
}

int Dv_check_planDAO::deleteById(uint64_t id)
{
	string sql = "DELETE FROM `sample` WHERE `id`=?";
	return sqlSession->executeUpdate(sql, "%ull", id);
}
*/