#pragma once
/*
* 
*/
#ifndef _PLANSUBJECTCONTROLLER_H_
#define _PLANSUBJECTCONTROLLER_H_

//#include "../../domin/vo/dept/DeptVO.h"
#include "../../domain/vo/planSubject/PlanSubjectVO.h"
#include "../../domain/query/planSubject/PlanSubjectQuery.h"



#include OATPP_CODEGEN_BEGIN(ApiController) 

/**
 * 部门管理 控制器
 */
class PlanSubjectController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(PlanSubjectController);
	// 3 定义接口
public:

	

private:
	// 3.3 演示分页查询数据
	PlanSubjectTablePageJsonVO::Wrapper execPlanSubjectTablePage(const PlanSubjectQuery::Wrapper& query);//最后那个参数先不要
	//接下来要写一个cpp文件，给execDeptTable
	//PlanSubjectDetailPageJsonVO::Wrapper execQuerySample(const PlanSubjectQuery::Wrapper& query, const PayloadDTO& payload);

	//暂时为空白对照，具体的操作函数没有定义
	PlanSubjectDetailPageJsonVO::Wrapper execPlanSubjectDetailPage(const PlanSubjectQuery::Wrapper& query);

};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_
