#pragma once
#ifndef _MATERIALPRODUCTS_DAO_
#define _MATERIALPRODUCTS_DAO_

#include "BaseDAO.h"
#include "../../../domain/do/DetectionTemplate/MaterialProductsDO.h"
#include "../../../domain/query/detectiontemplate/materialproductsQuery.h"
#include <oatpp/web/server/api/ApiController.hpp>
#include <oatpp/web/client/ApiClient.hpp>


class MaterialProductsDAO :public BaseDAO
{
public:

	// 修改数据
	int updateMaterialProducts(const MaterialProductsDO& uObj);
	// 插入数据
	uint64_t insertMaterialProducts(const MaterialProductsDO& iObj);
	// 删除数据
	int deleteByRecordId(const oatpp::List<oatpp::UInt64>& record_ids);

	
};

#endif // !_MATERIALPRODUCTS_DAO_