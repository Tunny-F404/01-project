#pragma once
#ifndef _RECEIPT_MAPPER_
#define _RECEIPT_MAPPER_

#include "Mapper.h"
#include "../../domain/do/Receipt/ReceiptDO.h"

/**
 * Ê¾Àý±í×Ö¶ÎÆ¥ÅäÓ³Éä
 */
class ReceiptMapper : public Mapper<ReceiptPageTableDO>
{
public:
	ReceiptPageTableDO mapper(ResultSet* resultSet) const override
	{
		ReceiptPageTableDO data;
		data.setRecptCode(resultSet->getString(1));
		data.setRecptName(resultSet->getString(2));
		data.setVendorName(resultSet->getString(3));
		data.setPoCode(resultSet->getString(4));
		data.setRecptDate(resultSet->getString(5));
		return data;
	}
};

#endif // !_RECEIPT_MAPPER_