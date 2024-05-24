#pragma once
#ifndef _APPROVALSTAGEDTO_MAPPER_
#define _APPROVALSTAGEDTO_MAPPER_

#include "Mapper.h"
#include "../../domain/do/ApprovalStage/ApprovalStageDO.h"

/**
 * …Û≈˙◊¥Ã¨◊÷∂Œ∆•≈‰”≥…‰
 */
class SampleMapper : public Mapper<ApprovalStageDO>
{
public:
	ApprovalStageDO mapper(ResultSet* resultSet) const override
	{
		ApprovalStageDO data;
		data.setrecord_id(resultSet->getUInt64(1));
		data.setstatus(resultSet->getString(2));
		return data;
	}
};
#endif // !_APPROVALSTAGEDTO_MAPPER_
