#pragma once
/*
* 
*/
#ifndef _DEPTCONTROLLER_H_
#define _DEPTCONTROLLER_H_

//#include "../../domin/vo/dept/DeptVO.h"
#include "../../domain/vo/dept/DeptVO.h"
#include "../../domain/query/dept/DeptQuery.h"



#include OATPP_CODEGEN_BEGIN(ApiController) 

/**
 * 部门管理 控制器
 */
class DeptController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(DeptController);
	// 3 定义接口
public:
	//这里可以定义很多个的接口
		// 3.1 定义查询接口描述
	ENDPOINT_INFO(queryDeptTable) {
		// 定义接口标题
		API_DEF_ADD_TITLE(ZH_WORDS_GETTER("dept.query.summary"));
		// 定义默认授权参数（可选定义，如果定义了，下面ENDPOINT里面需要加入API_HANDLER_AUTH_PARAME）
		API_DEF_ADD_AUTH();
		// 定义响应参数格式
		API_DEF_ADD_RSP_JSON_WRAPPER(DeptTableJsonVO);//ABF 响应格式是我们定义的那个VO
		// 定义分页查询参数描述
		//API_DEF_ADD_PAGE_PARAMS();//没有分页，不加这个

		// 定义其他查询参数描述，，，ABF 注意，这里要照着query对象来写
		API_DEF_ADD_QUERY_PARAMS(String, "deptName", ZH_WORDS_GETTER("dept.fields.dname"), "li ming", false);
		API_DEF_ADD_QUERY_PARAMS(Int32, "status", ZH_WORDS_GETTER("dept.fields.status"), 1, false);
	}
	// 3.2 定义查询接口处理                                  查询参数                          开启授权才能用
	ENDPOINT(API_M_GET, "/dept/query-dept-table", queryDeptTable, QUERIES(QueryParams, queryParams), API_HANDLER_AUTH_PARAME) {
		// 解析查询参数为Query领域模型
		API_HANDLER_QUERY_PARAM(query, DeptQuery, queryParams);//解析成Deptquery
		// 呼叫执行函数响应结果
		API_HANDLER_RESP_VO(execDeptTable(query));//改成DeptTable，并减少一个参数
	}

private:
	// 3.3 演示分页查询数据
	DeptTableJsonVO::Wrapper execDeptTable(const DeptQuery::Wrapper& query);//最后那个参数先不要
	//接下来要写一个cpp文件，给execDeptTable

};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_
