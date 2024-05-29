#include "stdafx.h"
#include <sstream>
#include "MaterialProductsDAO.h"
#include "MaterialProductsMapper.h"
#include "domain/dto/detectiontemplate/materialproductsDTO.h"

//定义条件解析宏，减少重复代码
#define MaterialProducts_TERAM_PARSE(query, sql) \
//SqlParams params; \

//sql<<" WHERE 1=1"; \
//if (query->record_id) { \
		sql << " AND record_id=?"; \
		SQLPARAMS_PUSH(params, "i", int, query->record_id.getValue(0)); \
} \
//if (query->item_code) { \
//		sql << " AND item_code=?"; \
//		SQLPARAMS_PUSH(params, "s", std::int, query->item_code.getValue(0)); \
//} \
//if (query->item_name) { \
//		sql << " AND item_name=?"; \
//		SQLPARAMS_PUSH(params, "s", std::string, query->item_name.getValue("")); \
//} \
if (query->specification) { \
		sql << " AND specification=?"; \
		SQLPARAMS_PUSH(params, "s", std::string, query->specification.getValue("")); \
}
//if (query->specification) {
//    \
//        sql << " AND specification=?"; \
//        SQLPARAMS_PUSH(params, "s", std::string, query->specification.getValue("")); \
//}


int MaterialProductsDAO::updateMaterialProducts(const MaterialProductsDO& uObj)
{
	string sql = "UPDATE `qc_template_product` SET `item_name`=?,`item_code`=?,`specification`=?,`unit_of_measure`=?,`quantity_check`=?,`quantity_unqualified`=?,`cr_rate`=?,`maj_rate`=?,`min_rate`=?,`remark`=? WHERE `record_id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%s%s%i%i%d%d%d%s%ull", uObj.getitem_name(), uObj.getitem_code(), uObj.getspecification(), uObj.getunit_of_measure(), uObj.getquantity_check(), uObj.getquantity_unqualified(), uObj.getcr_rate(), uObj.getmaj_rate(), uObj.getmin_rate(), uObj.getremark(), uObj.getrecord_id());
}

uint64_t MaterialProductsDAO::insertMaterialProducts(const MaterialProductsDO& iObj)
{
	string sql = "INSERT INTO `qc_template_product` ( `item_code`, `template_id`,`item_id`,`item_name`, `specification`,`unit_of_measure`, `quantity_check`,`quantity_unqualified`,`cr_rate`,`maj_rate`,`min_rate`,`remark`)VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	return sqlSession->executeInsert(sql, "%s%ll%ll%s%s%s%i%i%d%d%d%s", iObj.getitem_code(), iObj.gettemplate_id(), iObj.getitem_id(),
		iObj.getitem_name(), iObj.getspecification(), iObj.getunit_of_measure(), iObj.getquantity_check(), iObj.getquantity_unqualified(),iObj.getcr_rate(), iObj.getmaj_rate(), iObj.getmin_rate(), \
		iObj.getremark());
}

int MaterialProductsDAO::deleteByRecordId(const oatpp::List<oatpp::UInt64>& record_ids)
{
    if (record_ids->empty()) {
        return 0; 
    }
    SqlParams params;
    std::string sql = "DELETE FROM `qc_template_product` WHERE `record_id` IN (";
    for (auto it = record_ids->begin(); it != record_ids->end(); ++it) {
        if (it != record_ids->begin()) {
            sql += ",";
        }
        sql += "?";
    }
    sql += ")";

    
    for (auto& id : *record_ids) {
        uint64_t x = id.getValue(0);
        SQLPARAMS_PUSH(params, "ull", uint64_t, x); 
    }

    auto result = sqlSession->executeUpdate(sql, params);

    return result;
}
