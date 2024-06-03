#include "stdafx.h"
#include "../../mes-c4-prodmgmt/dao/ProdWorkorder/ProdWorkorderDAO.h"
#include "../../mes-c4-prodmgmt/dao/ProdWorkorder/ProdWorkorderMapper.h"
#include <sstream>
#include "ProdWorkorderDAO.h"

//�������������꣬�����ظ�����
#define PRODWORKORDER_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->workorder_code) { \
	sql << " AND `workorder_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->workorder_code.getValue("")); \
} \
if (query->workorder_name) { \
	sql << " AND `workorder_name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->workorder_name.getValue("")); \
} \
if (query->workorder_type) { \
	sql << " AND `workorder_type`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->workorder_type.getValue("")); \
} \
if (query->source_code) { \
	sql << " AND `source_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->source_code.getValue("")); \
} \
if (query->product_code) { \
	sql << " AND `product_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->product_code.getValue("")); \
} \
if (query->product_name) { \
	sql << " AND `product_name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->product_name.getValue("")); \
} \
if (query->client_code) { \
	sql << " AND `client_code`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->client_code.getValue("")); \
} \
if (query->client_name) { \
	sql << " AND `client_name`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->client_name.getValue("")); \
} \
if (query->request_date) { \
	sql << " AND `request_date`=?"; \
	SQLPARAMS_PUSH(params, "s", std::string, query->request_date.getValue("")); \
}

//�����ȡBOM�б��ĺ�
#define PRODWORKORDER_BOM_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->line_id) { \
	sql << " AND `line_id`=?"; \
	SQLPARAMS_PUSH(params, "ull", std::uint64_t, query->line_id.getValue(0)); \
}


uint64_t ProdWorkorderDAO::count(const GetProdWorkorderListQuery::Wrapper & query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM pro_workorder";
	PRODWORKORDER_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

uint64_t ProdWorkorderDAO::countBom(const ProdWorkorderBomListQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM pro_workorder_bom";
	PRODWORKORDER_BOM_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
}

//��ȡ������������
std::list<ProdWorkorderInfoDO> ProdWorkorderDAO::selectByWorkorderId(const uint64_t& workorder_id)
{
	string sql = "SELECT workorder_code,workorder_name,order_source,source_code,status,workorder_type,product_code,product_name,product_spc,unit_of_measure,quantity,request_date,batch_code,client_code,client_name,vendor_code,vendor_name,remark FROM pro_workorder WHERE `workorder_id`=?";
	ProdWorkorderInfoMapper mapper;
	return sqlSession->executeQuery<ProdWorkorderInfoDO, ProdWorkorderInfoMapper>(sql, mapper, "%ull", workorder_id);
}

//��ȡ���������б�
std::list<GetProdWorkorderListDO> ProdWorkorderDAO::selectWithPage(const GetProdWorkorderListQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT workorder_code,workorder_name,workorder_type,source_code,product_code,product_name,client_code,client_name,request_date FROM pro_workorder";
	PRODWORKORDER_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	GetProdWorkorderListMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<GetProdWorkorderListDO, GetProdWorkorderListMapper>(sqlStr, mapper, params);
}

//��ȡ��������BOM�б�
std::list<ProdWorkorderBomListDO> ProdWorkorderDAO::selectByBomId(const ProdWorkorderBomListQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT line_id,item_code,item_name,item_spc,unit_of_measure,item_or_product,quantity FROM pro_workorder_bom";
	PRODWORKORDER_BOM_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	ProdWorkorderBomListMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ProdWorkorderBomListDO, ProdWorkorderBomListMapper>(sqlStr, mapper, params);
}

//������������
uint64_t ProdWorkorderDAO::insert(const AddProdWorkorderDO& iObj)
{
	string sql = "INSERT INTO `pro_workorder` (`workorder_id`, `workorder_code`, `workorder_name`, `order_source`, `status`, `workorder_type`, `product_code`, `product_name`, `product_spc`, `unit_of_measure`, `quantity`, `request_date`, `batch_code`, `remark`, `product_id`, `ancestors`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	return sqlSession->executeInsert(sql, "%ull%s%s%s%s%s%s%s%s%s%d%s%s%s%ull%s", iObj.getWorkorder_id(), iObj.getWorkorder_code(), iObj.getWorkorder_name(), iObj.getOrder_source(), iObj.getStatus(), iObj.getWorkorder_type(), iObj.getProduct_code(), iObj.getProduct_name(), iObj.getProduct_spc(), iObj.getUnit_of_measure(), iObj.getQuantity(), iObj.getRequest_date(), iObj.getBatch_code(), iObj.getRemark(), iObj.getProduct_id(), iObj.getAncestors());
}





//�������������꣬�����ظ�����
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


uint64_t ProdWorkorderDAO::selectByID(uint64_t workorder_id)
{
	string sql = "SELECT product_id FROM pro_workorder WHERE workorder_id=?";
	return sqlSession->executeQueryNumerical(sql, "%ull", workorder_id);
		
}

int ProdWorkorderDAO::update(const ProdWorkorderDO & uObj)
{
	string sql = "UPDATE `pro_workorder` SET `workorder_code`=?, `workorder_name`=?, `order_source`=?, `source_code`=?, `workorder_type`=?, `product_id`=?, `product_code`=?, `product_name`=?, `product_spc`=?, `unit_of_measure`=?, `quantity`=?, `request_date`=?, `batch_code`=?, `client_id`=?, `client_code`=?, `client_name`=?, `remark`=?,`update_time`=? WHERE `workorder_id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%s%s%s%ull%s%s%s%s%d%s%s%ull%s%s%s%s%ull", uObj.getWorkOrderCode(), uObj.getWorkOrderName(), uObj.getOrderSource(), uObj.getSourceCode(), uObj.getWorkOrderType(), uObj.getProductId(), uObj.getProductCode(), uObj.getProductName(), uObj.getProductSpc(), uObj.getUnitOfMeasure(), uObj.getQuantity(), uObj.getRequestDate(), uObj.getBatchCode(), uObj.getClientId(), uObj.getClientCode(), uObj.getClientName(), uObj.getRemark(), uObj.getUpdateTime(), uObj.getWorkOrderID());
}	


uint64_t ProdWorkorderDAO::countById(ProdWorkorderDO iObj)
{
	SqlParams params;
	stringstream sql;
	sql << "SELECT COUNT(*) FROM pro_workorder";
	sql << " WHERE 1=1";
	if (iObj.getWorkOrderID() > 0) {
		sql << " AND `workorder_id`=? "; 
		SQLPARAMS_PUSH(params, "ull", uint64_t, iObj.getWorkOrderID());
	}
	if (iObj.getParentId() > 0) {
		sql << " AND `parent_id`=? ";
		SQLPARAMS_PUSH(params, "ull", uint64_t, iObj.getParentId());
		sql << " AND `status`!=? ";
		SQLPARAMS_PUSH(params, "s", std::string, iObj.getStatus());
	}
	else if (iObj.getStatus() != "") {
		sql << " AND `status`=? ";
		SQLPARAMS_PUSH(params, "s", std::string, iObj.getStatus());
	}
	
	string sqlStr = sql.str();
	
	return sqlSession->executeQueryNumerical(sqlStr, params);

}

int ProdWorkorderDAO::completeById(uint64_t id)
{
	
	string sql = "UPDATE `pro_workorder` SET `status`='FINISHED' WHERE `workorder_id`= ?";
	return sqlSession->executeUpdate(sql, "%ull", id);
}

int ProdWorkorderDAO::deleteById(uint64_t id)
{
	string sql = "DELETE FROM `pro_workorder` WHERE `workorder_id`=?";
	return sqlSession->executeUpdate(sql, "%ull", id);
}

int ProdWorkorderDAO::comfirmById(uint64_t id)
{
	string sql = "UPDATE `pro_workorder` SET `status`='CONFIRMED' WHERE `workorder_id`= ? ";
	return sqlSession->executeUpdate(sql, "%ull", id);
	
}
