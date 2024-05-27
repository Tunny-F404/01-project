#include "stdafx.h"
#include "MatDAO.h"
#include "MatMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->rtcode) { \
	sql << " AND `rtcode`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->rtcode.getValue("")); \
} \
if (query->rtname) { \
	sql << " AND rtname=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->rtname.getValue("")); \
} \
if (query->pocode) { \
	sql << " AND pocode=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->pocode.getValue("")); \
} \
if (query->vendorname) { \
	sql << " AND vendorname=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->vendorname.getValue("")); \
}
uint64_t MatDAO::count1(const GetReturnListQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM wm_rt_vendor";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

list<MatlistDO> MatDAO::selectWithPage1(const GetReturnListQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT rtcode,rtname,pocode,vendorcode,vendorname,rtdate,statuss FROM wm_rt_vendor";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	MatlistMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<MatlistDO, MatlistMapper>(sqlStr, mapper, params);
}

list<MatlistDO> MatDAO::selectByName1(const string& name)
{
	return list<MatlistDO>();
}

uint64_t MatDAO::insert1(const MatlistDO& iObj)
{
	string sql = "INSERT INTO `wm_rt_vendor` (`rtcode`, `rtname`, `pocode`,`vendorname`, `batchcode`, `rtdate`, `statuss`, `remark`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	return sqlSession->executeInsert(sql, "%s%s%s%s%s%s%s%s", iObj.getRtcode(), iObj.getRtname(), iObj.getPocode(),
		iObj.getVendorname(), iObj.getBatchcode(), iObj.getRtdate(),
		iObj.getStatuss(), iObj.getRemark());
}

int MatDAO::update1(const MatlistDO& uObj)
{
	string sql = "UPDATE INTO `wm_rt_vendor` (`rtcode`, `rtname`, `pocode`,`vendorname`, `batchcode`, `rtdate`, `statuss`, `remark`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	return sqlSession->executeUpdate(sql, "%s%s%s%s%s%s%s%s", uObj.getRtcode(), uObj.getRtname(), uObj.getPocode(),
		uObj.getVendorname(), uObj.getBatchcode(), uObj.getRtdate(),
		uObj.getStatuss(), uObj.getRemark());
}

int MatDAO::deleteById1(uint64_t id)
{
	string sql = "DELETE FROM `wm_rt_vendor` WHERE `rt_id`=?";
	return sqlSession->executeUpdate(sql, "%ull", id);
}
