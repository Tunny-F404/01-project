#pragma once

#ifndef _MDPRODUCTBOM_MAPPER_
#define _MDPRODUCTBOM_MAPPER_

#include "Mapper.h"
#include "../../domain/do/MdProductBom/MdProductBomDO.h"


class MdProductBomMapper : public Mapper<MdProductBomDO>
{
public:
	MdProductBomDO mapper(ResultSet* resultSet) const override
	{
		MdProductBomDO data;
		
		data.setBomItemCode(resultSet->getString(1));
		data.setBomItemName(resultSet->getString(2));
		data.setBomItemSpc(resultSet->getString(3));
		data.setUnitOfMeasure(resultSet->getString(4));
		data.setItemOrProduct(resultSet->getString(5));
		data.setQuantity(resultSet->getDouble(6));

		return data;
	}
};

#endif // !_MDPRODUCTBOM_MAPPER_