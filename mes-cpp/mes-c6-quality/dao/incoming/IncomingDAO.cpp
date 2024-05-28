//#include "stdafx.h"
//#include "IncomingDAO.h"
//#include "IncomingMapper.h"
//#include <sstream>
//
////定义条件解析宏，减少重复代码
//#define INCOMING_TERAM_PARSE(query, sql) \
//SqlParams params; \
//sql<<" WHERE 1=1"; \
//if (query->incomingCode) { \
//	sql << " AND `iqc_code`=?"; \
//	SQLPARAMS_PUSH(params, "s", std::string, query->incomingCode.getValue("")); \
//} \
//if (query->vendorCode) { \
//	sql << " AND vendor_code=?"; \
//	SQLPARAMS_PUSH(params, "s", std::string, query->vendorCode.getValue("")); \
//} \
//if (query->vendorName) { \
//	sql << " AND vendor_name=?"; \
//	SQLPARAMS_PUSH(params, "s", std::string, query->vendorName.getValue("")); \
//} \
//if (query->vendorBatch) { \
//	sql << " AND vendor_batch=?"; \
//	SQLPARAMS_PUSH(params, "s", std::string, query->vendorBatch.getValue("")); \
//} \
//
//
//uint64_t IncomingDAO::count(const IncomingQuery::Wrapper& query)
//{
//	stringstream sql;
//	sql << "SELECT COUNT(*) FROM qc_iqc";
//	INCOMING_TERAM_PARSE(query, sql);
//	string sqlStr = sql.str();
//	return sqlSession->executeQueryNumerical(sqlStr, params);
//}
//
//std::list<IncomingDO> IncomingDAO::selectWithPage(const IncomingQuery::Wrapper& query)
//{
//	stringstream sql;
//	sql << "SELECT iqc_code,vendor_code,vendor_name,vendor_batch FROM qc_iqc";
//	INCOMING_TERAM_PARSE(query, sql);
//	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
//	IncomingMapper mapper;
//	string sqlStr = sql.str();
//	return sqlSession->executeQuery<IncomingDO, IncomingMapper>(sqlStr, mapper, params);
//}
//
//uint64_t IncomingDAO::insert(const IncomingDO& iObj)
//{
//	string sql = "INSERT INTO `qc_iqc` (`iqc_code`, `vendor_code`, `vendor_name`,`vendor_batch`) VALUES (?, ?, ?, ?)";
//	return sqlSession->executeInsert(sql, "%s%s%s%s", iObj.getIncomingCode(), iObj.getVendorCode(), iObj.getVendorName(),iObj.getVendorBatch());
//}
//
//int IncomingDAO::update(const IncomingDO& uObj)
//{
//	string sql = "UPDATE `qc_iqc` SET `vendor_code`=?, `vendor_name`,`vendor_batch`=? WHERE `iqc_code`=?";
//	return sqlSession->executeUpdate(sql, "%s%s%s%s",  uObj.getVendorCode(), uObj.getVendorName(), uObj.getVendorBatch(), uObj.getIncomingCode());
//}
//
//int IncomingDAO::deleteByIcCode(string incomingCode)
//{
//	string sql = "DELETE FROM `qc_iqc` WHERE `iqc_code`=?";
//	return sqlSession->executeUpdate(sql, "%s", incomingCode);
//}