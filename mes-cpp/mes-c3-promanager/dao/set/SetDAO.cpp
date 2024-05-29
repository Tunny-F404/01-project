#include "stdafx.h"
#include "SetDAO.h"
#include "SetMapper.h"
#include <sstream>

//定义条件解析宏，减少重复代码
#define SAMPLE_TERAM_PARSE(query, sql) \
SqlParams params; \
sql<<" WHERE 1=1"; \
if (query->processId) { \
	sql << " AND `process_id`=?"; \
	SQLPARAMS_PUSH(params, "i",int, query->processId.getValue(1)); \
};



uint64_t SetDAO::insertSet(const ProProcessDO& iObj)
{
	string sql = "INSERT INTO `pro_process` (`process_code`,`process_name`, `enable_flag`, `attention`,`remark`) VALUES (?, ?, ?, ?, ?)";
	return sqlSession->executeInsert(sql, "%s%s%s%s%s", iObj.getProcessCode(), iObj.getProcessName(), iObj.getEnableFlag(),
		iObj.getAttention(), iObj.getRemark());
}

int SetDAO::updateSet(const ProProcessDO& uObj)
{
	string sql = "UPDATE `pro_process` SET `process_code`= ?, `process_name`= ?, `enable_flag`= ?,`attention`= ?, `remark`= ? WHERE `process_id`= ?";
	return sqlSession->executeUpdate(sql, "%s%s%s%s%s%ull", uObj.getProcessCode(), uObj.getProcessName(),
		uObj.getEnableFlag(), uObj.getAttention(), uObj.getRemark(), uObj.getProcessId());
};

uint64_t SetDAO::count(const SetProListQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT COUNT(*) FROM pro_process_content";
	SAMPLE_TERAM_PARSE(query, sql);
	string sqlStr = sql.str();
	return sqlSession->executeQueryNumerical(sqlStr, params);
};

std::list<ProProcessContentDO> SetDAO::selectWithPage(const SetProListQuery::Wrapper& query)
{
	stringstream sql;
	sql << "SELECT process_id,order_num,content_text,device,material,doc_url,remark FROM pro_process_content";
	SAMPLE_TERAM_PARSE(query, sql);
	sql << " LIMIT " << ((query->pageIndex - 1) * query->pageSize) << "," << query->pageSize;
	SetStepMapper mapper;
	string sqlStr = sql.str();
	return sqlSession->executeQuery<ProProcessContentDO, SetStepMapper>(sqlStr, mapper, params);
};

std::list<ProProcessContentDO> SetDAO::selectById(const uint64_t& id)
{
	string sql = "SELECT order_num,content_text,material,device,remark FROM pro_process_content WHERE `process_id` LIKE CONCAT('%',?,'%')";
	SetStepMapper mapper;
	return sqlSession->executeQuery<ProProcessContentDO, SetStepMapper>(sql, mapper, "%ull", id);
};

uint64_t SetDAO::insertstepSet(const ProProcessContentDO& iObj)
{
	string sql = "INSERT INTO `pro_process_content` (`process_id`,`order_num`,`content_text`, `device`, `material`,`doc_url`,`remark`) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
	return sqlSession->executeInsert(sql, "%ull%d%s%s%s%s%s",iObj.getProcessId(),iObj.getOrderNum(),iObj.getContentText(),iObj.getDevice(),
		iObj.getMaterial(),iObj.getDocUrl(), iObj.getRemark());
}
