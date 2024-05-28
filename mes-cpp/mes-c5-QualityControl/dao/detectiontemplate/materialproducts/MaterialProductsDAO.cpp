#include "stdafx.h"
#include <sstream>
#include "MaterialProductsDAO.h"
#include "MaterialProductsMapper.h"
#include "domain/dto/detectiontemplate/materialproductsDTO.h"

//定义条件解析宏，减少重复代码
#define MaterialProducts_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->record_id) { \
		sql << " AND record_id=?"; \
		SQLPARAMS_PUSH(params, "i", int, query->record_id.getValue(0)); \
} \
if (query->item_code) { \
		sql << " AND item_code=?"; \
		SQLPARAMS_PUSH(params, "s", std::int, query->item_code.getValue(0)); \
} \
if (query->item_name) { \
		sql << " AND item_name=?"; \
		SQLPARAMS_PUSH(params, "s", std::string, query->item_name.getValue("")); \
} \
if (query->specification) { \
		sql << " AND specification=?"; \
		SQLPARAMS_PUSH(params, "s", std::string, query->specification.getValue("")); \
}


int MaterialProductsDAO::updateMaterialProducts(const MaterialProductsDO& uObj)
{
	string sql = "UPDATE `qc_template_product` SET item_name=? WHERE template_id=?";
	return sqlSession->executeUpdate(sql, "%s%ull", uObj.getitem_name(), uObj.getrecord_id());
}

uint64_t MaterialProductsDAO::insertMaterialProducts(const MaterialProductsDO& iObj)
{
	string sql = "INSERT INTO `qc_template_product` (`template_id`, `item_code`, `item_name`, `specification`,`unit_of_measure`, `quantity_check`,`cr_rate`,`maj_rate`,`min_rate`,`remark`,`create_time`)VALUES (?,?,?,?,?,?,?,?,?,?,?)";
	return sqlSession->executeInsert(sql, "%ull%ull%s%s%s%s%s%s%s%s%s", iObj.getrecord_id(), iObj.getitem_code(),
		iObj.getitem_name(), iObj.getspecification(), iObj.getunit_of_measure(), iObj.getquantity_check(), iObj.getcr_rate(), iObj.getmaj_rate(), iObj.getmin_rate(), \
		iObj.getremark());
}

int MaterialProductsDAO::deleteByRecordId(uint64_t record_id)
{
	string sql = "DELETE FROM `qc_template_product` WHERE `record_id`=?";
	return sqlSession->executeUpdate(sql, "%ull", record_id);
}
