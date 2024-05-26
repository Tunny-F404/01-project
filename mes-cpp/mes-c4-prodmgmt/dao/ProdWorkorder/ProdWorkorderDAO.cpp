#include "stdafx.h"
#include "../../mes-c4-prodmgmt/dao/ProdWorkorder/ProdWorkorderDAO.h"
#include "../../mes-c4-prodmgmt/dao/ProdWorkorder/ProdWorkorderMapper.h"
#include <sstream>

//获取生产工单详情
std::list<ProdWorkorderInfoDO> ProdWorkorderDAO::selectByWorkorderId(const ProdWorkorderInfoDO& Obj)
{
	string sql = "SELECT workorder_code,workorder_name,order_source,source_code,status,workorder_type,product_code,product_name,product_spc,unit_of_measure,quantity,request_date,batch_code,client_code,client_name,vendor_code,vendor_name,remark FROM ktgmes WHERE `workorder_id` LIKE CONCAT('%',?,'%')";
	ProdWorkorderInfoMapper mapper;
	return sqlSession->executeQuery<ProdWorkorderInfoDO, ProdWorkorderInfoMapper>(sql, mapper, "%ll", Obj.getWorkorder_id());
}