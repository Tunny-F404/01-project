#pragma once
#ifndef _MATERIAL_MAPPER_
#define _MATERIAL_MAPPER_

#include "Mapper.h"
#include "../../domain/do/materialsInformation/MaterialDO.h"

/**
 * Ê¾Àý±í×Ö¶ÎÆ¥ÅäÓ³Éä
 */
class MaterialMapper : public Mapper<MaterialDO>
{
public:
	 MaterialDO mapper(ResultSet* resultSet) const override
	{
		 MaterialDO data;
		data.setId(resultSet->getUInt64(1));
		data.setIssue_id(resultSet->getInt(2));
		data.setItem_code(resultSet->getString(3));
		data.setItem_name(resultSet->getString(4));
		data.setSpecification(resultSet->getString(5));
		data.setUnit_of_measure(resultSet->getString(6));
		data.setQuantity_issued(resultSet->getDouble(7));
		data.setBatch_code(resultSet->getString(8));
		data.setWarehouse_name(resultSet->getString(9));
		data.setLocation_name(resultSet->getString(10));
		data.setArea_name(resultSet->getString(11));
		data.setRemark(resultSet->getString(12));
		return data;
	}
};

#endif // !_MATERIAL_MAPPER_