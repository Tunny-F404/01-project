#include "stdafx.h"
#include "RelateProDAO.h"
#include <sstream>
#include "../../dao/process/RelateProMapper.h"

// 插入
uint64_t RelateProDAO::insert(const ProRouteProductDO & iObj)
{
	string sql = "INSERT INTO `pro_route_product` (`record_id`, `route_id`, `item_id`, `item_code`, `item_name`, `specification`, `unit_of_measure`, `quantity`, `production_time`, `time_unit_type`, `remark`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	return sqlSession->executeInsert(sql, "%ull%ull%ull%s%s%s%s%ui%d%s%s", iObj.getRecord_Id(),iObj.getRoute_Id(),iObj.getItem_Id(),iObj.getItem_Code(), iObj.getItem_Name(), iObj.getSpecification(), iObj.getUnit_Of_Measure(), iObj.getQuantity(), iObj.getProduction_Time(),iObj.getTime_Unit_Type(),iObj.getRemark());
}
// 修改
int RelateProDAO::update(const ProRouteProductDO& uObj)
{
	string sql = "UPDATE `pro_route_product` SET `item_code`=?, `item_name`=?, `unit_of_measure`=?, `specification`=?,`remark`=? WHERE `record_id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%s%s%s%ull", uObj.getItem_Code(), uObj.getItem_Name(), uObj.getUnit_Of_Measure(), uObj.getSpecification(), uObj.getRemark(), uObj.getRecord_Id());
}
// 删除
int RelateProDAO::deleteById(uint64_t id)
{
	string sql = "DELETE FROM `pro_route_product` WHERE `record_id`=?";
	return sqlSession->executeUpdate(sql, "%ull", id);
}
// 导出
list<ProRouteProductDO> RelateProDAO::selectById(uint64_t id)
{
	stringstream sql;
	sql << "SELECT record_id,route_id,item_id,item_code,item_name,specification,unit_of_measure,quantity,production_time,time_unit_type,remark FROM pro_route_product";
	SqlParams params; sql << " WHERE 1=1";
	if (id) {
		sql << " AND `record_id`=?"; params.emplace_back(SqlParam("i", std::make_shared<int>(id)));
	};
	exportRouteProductMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ProRouteProductDO, exportRouteProductMapper>(sqlStr, mapper, params);
}
