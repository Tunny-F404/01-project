#include "stdafx.h"
#include "ApprovalStageDAO.h"
#include "ApprovalStageMapper.h"
#include <sstream>

int ApprovalStageDAO::update(const ApprovalStageDO& uObj)
{
	string sql = "UPDATE `sample` SET `name`=?, `sex`=?, `age`=? WHERE `id`=?";
	return sqlSession->executeUpdate(sql, "%s%s%i%ull", uObj.getrecord_id(), uObj.getfeedback_type());
}
