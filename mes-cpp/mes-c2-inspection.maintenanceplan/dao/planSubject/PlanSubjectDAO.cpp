//#include "stdafx.h"
//#include "PlanSubjectDAO.h"
//#include "PlanSubjectMapper.h"
//#include <sstream>
//
////定义条件解析宏，减少重复代码
//#define PLANSUBJECT_TERAM_PARSE(query, sql) \
//SqlParams params; \
//sql<<" WHERE 1=1"; \
//if (query->name) { \
//	sql << " AND `name`=?"; \
//	SQLPARAMS_PUSH(params, "s", std::string, query->name.getValue("")); \
//} \
//if (query->sex) { \
//	sql << " AND sex=?"; \
//	SQLPARAMS_PUSH(params, "s", std::string, query->sex.getValue("")); \
//} \
//if (query->age) { \
//	sql << " AND age=?"; \
//	SQLPARAMS_PUSH(params, "i", int, query->age.getValue(0)); \
//}
//
//uint64_t PlanSubjectDAO::count(const PlanSubjectQuery::Wrapper & query)
//{
//	stringstream sql;
//	sql << "SELECT COUNT(*) FROM sample";
//	PLANSUBJECT_TERAM_PARSE(query, sql);
//	string sqlStr = sql.str();
//	return sqlSession->executeQueryNumerical(sqlStr, params);
//}
//
//std::list<PlanSubjectDO> PlanSubjectDAO::selectWithPage(const PlanSubjectQuery::Wrapper & query)
//{
//	stringstream sql;
//	sql << "SELECT id,name,sex,age FROM sample";
//	PLANSUBJECT_TERAM_PARSE(query, sql);
//	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
//	PlanSubjectMapper mapper;
//	string sqlStr = sql.str();
//	return sqlSession->executeQuery<PlanSubjectDO, PlanSubjectMapper>(sqlStr, mapper, params);
//}
//
//std::list<PlanSubjectDO> PlanSubjectDAO::selectByName(const string & name)
//{
//	string sql = "SELECT id,name,sex,age FROM sample WHERE `name` LIKE CONCAT('%',?,'%')";
//	PlanSubjectMapper mapper;
//	return sqlSession->executeQuery<PlanSubjectDO, PlanSubjectMapper>(sql, mapper, "%s", name);
//}
//
//uint64_t PlanSubjectDAO::insert(const PlanSubjectDO & iObj)
//{
//	string sql = "INSERT INTO `sample` (`name`, `sex`, `age`) VALUES (?, ?, ?)";
//	return sqlSession->executeInsert(sql, "%s%s%i", iObj.getName(), iObj.getSex(), iObj.getAge());
//}
//
//int PlanSubjectDAO::update(const PlanSubjectDO & uObj)
//{
//	string sql = "UPDATE `sample` SET `name`=?, `sex`=?, `age`=? WHERE `id`=?";
//	return sqlSession->executeUpdate(sql, "%s%s%i%ull", uObj.getName(), uObj.getSex(), uObj.getAge(), uObj.getId());
//}
//
//int PlanSubjectDAO::deleteById(uint64_t id)
//{
//	string sql = "DELETE FROM `sample` WHERE `id`=?";
//	return sqlSession->executeUpdate(sql, "%ull", id);
//}