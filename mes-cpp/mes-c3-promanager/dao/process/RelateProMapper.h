#pragma once
#ifndef _RELATEPRO_MAPPER_
#define _RELATEPRO_MAPPER_

#include "Mapper.h"
#include "../../domain/do/sample/SampleDO.h"

/**
 * 添加+修改关联产品字段匹配映射
 */
class ProRouteProductMapper : public Mapper<ProRouteProductDO>
{
public:
	SampleDO mapper(ResultSet* resultSet) const override
	{
		ProRouteProductDO data;
		data.setItem_Code(resultSet->getString(1));
		data.setItem_Name(resultSet->getString(2));
		data.setUnit_Of_Measure(resultSet->getString(3));
		data.setSpecification(resultSet->getString(4));
		data.setRemark(resultSet->getString(5));
		return data;
	}
};

#endif // !_RELATEPRO_MAPPER_