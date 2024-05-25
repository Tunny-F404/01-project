#pragma once
#ifndef _PRODUCT_MAPPER_
#define _PRODUCT_MAPPER_

#include "Mapper.h"
#include "../../domain/do/product/ProductDO.h"

/**
 * Ê¾Àý±í×Ö¶ÎÆ¥ÅäÓ³Éä
 */
class ProductTableMapper : public Mapper<ProductTableDO>
{
public:
	ProductTableDO mapper(ResultSet* resultSet) const override
	{
		ProductTableDO data;
		data.setPid(resultSet->getUInt64(1));
		data.setPnum(resultSet->getString(2));
		data.setPname(resultSet->getString(3));
		data.setPlist(resultSet->getString(4));
		data.setPcnum(resultSet->getString(5));
		data.setPcname(resultSet->getString(6));
		data.setPdate(resultSet->getString(7));
		data.setPstatus(resultSet->getString(8));
		return data;
	}
};
class ProductDetailMapper : public Mapper<ProductDetailDO>
{
public:
	ProductDetailDO mapper(ResultSet* resultSet) const override
	{
		ProductDetailDO data;
		data.setPid(resultSet->getUInt64(1));
		data.setPnum(resultSet->getString(2));
		data.setPname(resultSet->getString(3));
		data.setPlist(resultSet->getString(4));
		data.setPcnum(resultSet->getString(5));
		data.setPcname(resultSet->getString(6));
		data.setPdate(resultSet->getString(7));
		data.setPstatus(resultSet->getString(8));
		data.setPrname(resultSet->getString(9));
		data.setPremark(resultSet->getString(10));
		
		return data;
	}
};


#endif
