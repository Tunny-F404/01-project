#include "stdafx.h"
#include "InspectDAO.h"
#include "InspectMapper.h"
#include <sstream>


//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->code) { \
	sql << " AND `code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->code.getValue("")); \
} ;\
if (query->vendor_code) { \
	sql << " AND `vendor_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->vendor_code.getValue("")); \
} ;\
if (query->vendor_name) { \
	sql << " AND `vendor_name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->vendor_name.getValue("")); \
} ;\
if (query->vd_batch) { \
	sql << " AND `vd_batch`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->vd_batch.getValue("")); \
} ;\
if (query->item_code) { \
	sql << " AND `item_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->item_code.getValue("")); \
} ;\
if (query->item_name) { \
	sql << " AND `item_name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->item_name.getValue("")); \
} ;\
if (query->check_result) { \
	sql << " AND `check_result`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->check_result.getValue("")); \
} ;\
if (query->recive_date) { \
	sql << " AND `recive_date`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->recive_date.getValue("")); \
} ;\
if (query->inspect_date) { \
	sql << " AND `inspect_date`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->inspect_date.getValue("")); \
} ;\
if (query->inspector) { \
	sql << " AND `inspector`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->inspector.getValue("")); \
} ;\

uint64_t InspectDAO::count(const InspectQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM qc_iqc ";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

//分页查询列表
std::list<InspectDO> InspectDAO::selectWithPage(const InspectQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT line_id,code,name,template_id,vendor_name,vendor_nick,vendor_batch,item_code,item_name,quantity_recived,quantity_check,quantity_unqualified,check_result,recive_date,inspect_date,inspector,list_status FROM  qc_iqc";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	InspectMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<InspectDO, InspectMapper>(sqlStr, mapper, params);
}

//查询详情
Inspect_detailDO InspectDAO::selectWithID(const int & line_id)
{
	stringstream sql;
	sql << "SELECT line_id, code, name,vendor_code, vendor_nick, vendor_batch, item_code, item_name, unit_of_measure,quantity_recived, quantity_check, quantity_unqualified, check_result, recive_date, inspect_date, maj_rate,cr_rate, min_rate,list_status FROM  qc_iqc";
	sql << "where `line_id`=?";
	Inspect_detailMapper mapper;
	string sqlStr = sql.str();
	std::list<Inspect_detailDO> A = sqlSession->executeQuery<Inspect_detailDO, Inspect_detailMapper>(sqlStr, mapper, "%i", line_id);
	if (A.size() == 0) return {};
	return A.front();
}

//新增检验表
uint64_t InspectDAO::insert(const InspectDO& iObj)
{                                  //`line_id`,
	string sql = "INSERT INTO `qc_iqc` ( `code`,`name`,`template_id`, `vendor_id`, `vendor_code`,`vendor_name`,`vendor_nick`,`vendor_batch`,`item_code`,`item_name` ,`quantity_recived`,`quantity_check`,`quantity_unqualified`,`check_result`,`recive_date`,`inspect_date`,`inspector`,`list_status`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?,)";
	return sqlSession->executeInsert(sql, "%ull%s%s%ull%ull%s%s%s%s%s%s%i%i%i%s%s%s%s%s",
		//iObj.getLine_id(),
		iObj.getCode(),
		iObj.getName(),
		iObj.getTemplate_id(),
		iObj.getVendor_id(),
		iObj.getVendor_code(),
		iObj.getVendor_name(),
		iObj.getVendor_nick(),
		iObj.getVendor_batch(),
		iObj.getItem_code(),
		iObj.getItem_name(),
		iObj.getQuantity_recived(),
		iObj.getQuantity_check(),
		iObj.getQuantity_unqualified(),
		iObj.getCheck_result(),
		iObj.getRecive_date(),
		iObj.getInspect_date(),
		iObj.getInspector(),
		iObj.getList_status()
	);
}

////修改检验表
//int InspectDAO::update(const InspectDO& uObj)
//{
//	string sql = "UPDATE `qc_iqc` SET `code` = ?, `name`= ?, `template_id`= ?, `vendor_id`= ? , `vendor_code`= ?, `vendor_name`= ?, `vendor_nick`= ?, `vendor_batch`= ?, `item_code`= ?, `item_name`= ?, `quantity_recived`= ? ,`quantity_check`=?,`quantity_unqualified`=?,`check_result`=?,`recive_date`=?,`inspect_date`=?,`inspector`=?,`list_status`=? WHERE `line_id` = ?;";
//	return sqlSession->executeUpdate(sql, "%ull%ull%s%s%s%s%d%s%s%s%s%s%ull",
//		uObj.getCode(),
//		uObj.getName(),
//		uObj.getTemplate_id(),
//		uObj.getVendor_id(),
//		uObj.getVendor_code(),
//		uObj.getVendor_name(),
//		uObj.getVendor_nick(),
//		uObj.getVendor_batch(),
//		uObj.getItem_code(),
//		uObj.getItem_name(),
//		uObj.getQuantity_recived(),
//		uObj.getQuantity_check(),
//		uObj.getQuantity_unqualified(),
//		uObj.getCheck_result(),
//		uObj.getRecive_date(),
//		uObj.getInspect_date(),
//		uObj.getInspector(),
//		uObj.getList_status(),
//		uObj.getLine_id());
//}
//
//int InspectDAO::deleteById(uint64_t id)
//{
//	string sql = "DELETE FROM `qc_iqc` WHERE `line_id`=?";
//	return sqlSession->executeUpdate(sql, "%ull", id);
//}
