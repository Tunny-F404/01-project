#include "stdafx.h"
#include "WhStorageorderDAO.h"
#include <sstream>


//返回ID
uint64_t WhStorageorderDAO::insert(const AddWhStorageorderDO& iObj)
{
	string sql = "INSERT INTO `wm_item_recpt_line` (`item_id`,`item_code`,`item_name`,`unit_of_measure`,`quantity_recived`,`batch_code`,`expire_date`,`warehouse_name`,`iqc_check`,`iqc_code`,`iqc_id`,`remark`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	return sqlSession->executeInsert(sql, "%ull%s%s%s%d%s%s%s%s%s%ull%s", iObj.getItem_id(),iObj.getItem_code(), iObj.getItem_name(), iObj.getUnit_of_measure(), iObj.getQuantity_recived(), iObj.getBatch_code(), iObj.getExpire_date(), iObj.getWarehouse_name(), iObj.getIqc_check(), iObj.getIqc_code(), iObj.getIqc_id(), iObj.getRemark());;
}
//返回修改的当前行号
int WhStorageorderDAO::update(const ModifyWhStorageorderDO& uObj) {
	string sql = "UPDATE `wm_item_recpt_line` SET `item_code`=?,`item_name`=?,`unit_of_measure`=?,`quantity_recived`=?,`batch_code`=?,`expire_date`=?,`warehouse_name`=?,`iqc_check`=?,`iqc_code`=?,`iqc_id`=?,`remark`=? WHERE `line_id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%s%d%s%s%s%s%s%ull%s%ull", uObj.getItem_code(), uObj.getItem_name(), uObj.getUnit_of_measure(), uObj.getQuantity_recived(), uObj.getBatch_code(), uObj.getExpire_date(), uObj.getWarehouse_name(), uObj.getIqc_check(), uObj.getIqc_code(), uObj.getIqc_id(), uObj.getRemark(), uObj.getLine_id());
}
int WhStorageorderDAO::deleteById(const oatpp::List<UInt64>& ids) {
	
	string sql = "DELETE FROM `wm_item_recpt_line` WHERE `line_id` IN (";
	for (auto it = ids->begin(); it != ids->end(); ++it) {
		if (it != ids->begin()) {
			sql += ",";
		}
		sql += to_string(*it);
	}
	sql += ")";
	return sqlSession->executeUpdate(sql);
}


