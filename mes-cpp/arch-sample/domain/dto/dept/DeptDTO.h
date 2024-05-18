#pragma once
#ifndef _DEPTDTO_H_
#define _DEPTDTO_H_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)
//部门列表数据模型
class DeptTableDTO :public oatpp::DTO
{
	DTO_INIT(DeptTableDTO, DTO);
	//唯一标识 隐藏
	API_DTO_FIELD(UInt64, deptId, ZH_WORDS_GETTER("dept.fields.id"), true, 1);
	//部门名称
	API_DTO_FIELD(String, deptName, ZH_WORDS_GETTER("dept.fields.dname"), true, "01star");
	//部门排序
	API_DTO_FIELD(Int32, orderName, ZH_WORDS_GETTER("dept.fields.order"), true, 0);
	//状态
	API_DTO_FIELD(Int32, status, ZH_WORDS_GETTER("dept.fields.dstatus"), true, 0);
	//创建时间
	API_DTO_FIELD(String, createTime, ZH_WORDS_GETTER("dept.fields.ctime"), true, "2024-05-17 00:00:00");
	
};
//部门详情数据模型
class DeptDetailDTO :public DeptTableDTO
{
	DTO_INIT(DeptDetailDTO, DeptTableDTO);
	//负责人
	API_DTO_FIELD(String, leader, ZH_WORDS_GETTER("dept.fields.leader"), true, "张三");
	

};

#include OATPP_CODEGEN_END(DTO)
#endif