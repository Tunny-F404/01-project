#include "stdafx.h"
#include "Single_Defect_DAO.h"
#include "Single_Defect_Mapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE1(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->iqc_id) { \
	sql << " AND `iqc_id`=?"; \
	SQLPARAMS_PUSH(params, "ull", std::uint64_t, query->iqc_id.getValue(0)); \
} 

#define SAMPLE_TERAM_PARSE2(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->qc_id) { \
	sql << " AND `qc_id`=?"; \
	SQLPARAMS_PUSH(params, "ull", std::uint64_t, query->qc_id.getValue(0)); \
} 

// 统计检测项表数据条数

uint64_t Single_Defect_DAO::count_Index(const SingleQuery::Wrapper & query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM qc_iqc_line ";
	SAMPLE_TERAM_PARSE1(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

uint64_t Single_Defect_DAO::count_Defect(const DefectQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM qc_defect_record ";
	SAMPLE_TERAM_PARSE2(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

list<IndexDO> Single_Defect_DAO::selectIndexPage(const SingleQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT index_name,index_type,qc_tool,check_method,stander_val,unit_of_measure,threshold_max,threshold_min,cr_quantity,maj_quantity,min_quantity, remark FROM  qc_iqc_line";
	SAMPLE_TERAM_PARSE1(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	IndexMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<IndexDO, IndexMapper>(sqlStr, mapper, params);
}

list<DefectDO> Single_Defect_DAO::selectDefectPage(const DefectQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT record_id,qc_type,qc_id,line_id,defect_name,defect_level,defect_quantity,remark FROM  qc_defect_record";
	SAMPLE_TERAM_PARSE2(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	DefectMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<DefectDO, DefectMapper>(sqlStr, mapper, params);
}

uint64_t Single_Defect_DAO::insert(const DefectDO& iObj)
{
	//string sql = "INSERT INTO `qc_iqc` ( `iqc_id`,`iqc_code`,) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)";//
	//return sqlSession->executeInsert(sql, "%ull%s%s%ull%ull%s%s%s%s%ull%s%s%d%i%i%s%s%s%s%s%s",  //
	//	iObj.getIqc_id(),
	//	
	//);

	return{};
}

int Single_Defect_DAO::update(const DefectDO& uObj)
{
	return{};
}

int Single_Defect_DAO::deleteById(uint64_t iqc_id)
{
	return{};
}
