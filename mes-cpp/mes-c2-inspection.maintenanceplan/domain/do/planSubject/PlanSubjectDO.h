#pragma once
/*
* 
*/
#ifndef _PLANSUBJECT_DO_
#define _PLANSUBJECT_DO_
#include "../DoInclude.h"

/**
 * 示例数据库实体类
 */
class PlanSubjectDO
{
	// 项目编码
	CC_SYNTHESIZE(string, code, Code);
	// 项目名称
	CC_SYNTHESIZE(string, name, Name);
	// 项目类型
	CC_SYNTHESIZE(string, type, Type);
	// 项目内容
	CC_SYNTHESIZE(string, content, Content);
	// 项目标准
	CC_SYNTHESIZE(string, standard, Standard);
public:
	PlanSubjectDO() {
		code = "";
		name = "";
		type = "";
		content = "";
		standard = "";
	}
};

#endif // !_PLANSUBJECT_DO_
