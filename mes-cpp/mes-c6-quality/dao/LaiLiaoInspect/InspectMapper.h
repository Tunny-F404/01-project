#pragma once
#ifndef _INSPECT_MAPPER_
#define _INSPECT_MAPPER_

#include "Mapper.h"
#include "../../domain/do/LaiLiaoInspect/InspectDO.h"

/**
 * Ê¾Àý±í×Ö¶ÎÆ¥ÅäÓ³Éä
 */
class InspectMapper : public Mapper<InspectDO>
{
public:
	InspectDO mapper(ResultSet* resultSet) const override
	{
		InspectDO data;
		data.setLine_id(resultSet->getUInt64(1));
		data.setCode(resultSet->getString(2));
		data.setName(resultSet->getString(3));
		data.setTemplate_id(resultSet->getUInt64(4));
		data.setVendor_id(resultSet->getUInt64(5));
		data.setVendor_nick(resultSet->getString(6));
		data.setVendor_batch(resultSet->getString(7));
		data.setItem_code(resultSet->getString(8));
		data.setItem_name(resultSet->getString(9));
		data.setQuantity_recived(resultSet->getInt64(10));
		data.setQuantity_check(resultSet->getInt64(11));
		data.setQuantity_unqualified(resultSet->getInt64(12));
		data.setCheck_result(resultSet->getString(13));
		data.setRecive_date(resultSet->getString(14));
		data.setInspect_date(resultSet->getString(15));
		data.setInspector(resultSet->getString(16));
		data.setList_status(resultSet->getString(17));
		return data;
	}
};

class Inspect_detailMapper : public Mapper<Inspect_detailDO>
{
public:
	Inspect_detailDO mapper(ResultSet* resultSet) const override
	{
		Inspect_detailDO data;
		data.setLine_id(resultSet->getUInt64(1));
		data.setCode(resultSet->getString(2));
		data.setName(resultSet->getString(3));
		data.setVendor_code(resultSet->getString(4));
		data.setVendor_nick(resultSet->getString(5));
		data.setVendor_batch(resultSet->getString(6));
		data.setItem_code(resultSet->getString(7));
		data.setItem_name(resultSet->getString(8));
		data.setUnit_of_measure(resultSet->getString(9));
		data.setQuantity_recived(resultSet->getInt64(10));
		data.setQuantity_check(resultSet->getInt64(11));
		data.setQuantity_unqualified(resultSet->getInt64(12));
		data.setCheck_result(resultSet->getString(15));
		data.setRecive_date(resultSet->getString(16));
		data.setInspect_date(resultSet->getString(17));
		data.setMaj_rate(resultSet->getString(18));
		data.setCr_rate(resultSet->getString(19));
		data.setMin_rate(resultSet->getString(20));
		data.setList_status(resultSet->getString(21));
		return data;
	}
};

#endif // !_INSPECT_MAPPER_
