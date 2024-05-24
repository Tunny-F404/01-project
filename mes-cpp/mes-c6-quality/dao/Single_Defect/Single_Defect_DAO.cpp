//#include "stdafx.h"
//#include "Single_Defect_DAO.h"
//#include "Single_Defect_Mapper.h"
//#include <sstream>
//
////定义条件解析宏，减少重复代码
//#define SAMPLE_TERAM_PARSE(query, sql) \
//SqlParams params; \
//sql<<" WHERE 1=1"; \
//if (query->issue_id) { \
//	sql << " AND `issue_id`=?"; \
//	SQLPARAMS_PUSH(params, "s", std::string, query->issue_id.getValue("")); \
//} 
//
//