#include "stdafx.h"
#include "ApprovalStageDAO.h"
#include "ApprovalStageMapper.h"
#include <sstream>

// 提交审批，变成审批中
int ApprovalStageDAO::SubmitForApproval(const ApprovalStageDO& uObj)
{
	string sql = "UPDATE `pro_feedback` SET `status`=? WHERE `record_id`=?";
	return sqlSession->executeUpdate(sql, "%s%ull", uObj.getc_status(), uObj.getc_record_id());
}
//审批通过，变成已完成
int ApprovalStageDAO::ApprovalPassed(const ApprovalStageDO& uObj)
{
	string sql = "UPDATE `pro_feedback` SET `status`=?  WHERE `record_id`=?";
	return sqlSession->executeUpdate(sql, "%s%ull", uObj.getc_status(), uObj.getc_record_id());
}
//审批不通过，审批不通过变草稿
int ApprovalStageDAO::ApprovalNotPassed(const ApprovalStageDO& uObj)
{
	string sql = "UPDATE `pro_feedback` SET `status`=? WHERE `record_id`=?";
	return sqlSession->executeUpdate(sql, "%s%ull", uObj.getc_status(), uObj.getc_record_id());
}