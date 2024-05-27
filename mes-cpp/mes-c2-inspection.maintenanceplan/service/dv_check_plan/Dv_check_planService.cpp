///*
//* 
//*/
//#include "stdafx.h"
////#include "SampleService.h"
////#include "../../dao/sample/SampleDAO.h"
//#include "Dv_check_planService.h"
//#include "../../dao/dv_check_plan/Dv_check_planDAO.h"
//#include "../../../mes-c2-inspection.maintenanceplan/Macros.h"
//#include <cstdint>//debug
//MachineryPlanPageDTO::Wrapper Dv_check_planService::listAll(const MachineryPlanQuery::Wrapper& query)
//{
//	// 构建返回对象
//	auto pages = MachineryPlanPageDTO::createShared();
//	pages->pageIndex = query->pageIndex;
//	pages->pageSize = query->pageSize;
//
//	// 查询数据总条数
//	Dv_check_planDAO dao;
//	uint64_t count = dao.count(query);
//	if (count <= 0)
//	{
//		return pages;
//	}
//
//	// 分页查询数据
//	pages->total = count;
//	pages->calcPages();
//	list<Dv_check_planDO> result = dao.selectWithPage(query);
//	// 将DO转换成DTO
//	for (Dv_check_planDO sub : result)
//	{
//		auto dto = MachineryPlanDTO::createShared();
//		// 		dto->id = sub.getId();
//		// 		dto->name = sub.getName();
//		// 		dto->sex = sub.getSex();
//		// 		dto->age = sub.getAge();
//		// abf分析：要改变DTO类型的变量dto，使用DO的get函数取值来赋值
//		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, plan_id, Plan_id, plan_code, Plan_code,
//			plan_name, Plan_name, plan_type, Plan_type, start_date, Start_date,
//			end_date, End_date, cycle_type, Cycle_type, cycle_count, Cycle_count,
//			status, Status)
//
//		//注释掉内联展开的情况
//		//dto->plan_id = sub.getPlan_id(); dto->plan_code = sub.getPlan_code(); dto->plan_name = sub.getPlan_name(); dto->plan_type = sub.getPlan_type(); dto->start_date = sub.getStart_date(); dto->end_date = sub.getEnd_date(); dto->cycle_type = sub.getCycle_type(); 
//		//dto->cycle_count = sub.getCycle_count(); dto->status = sub.getStatus();
//
//			pages->addData(dto);
//
//	}
//	return pages;
//}
//
//
///*
//MachineryPlanDetailsDTO::Wrapper Dv_check_planService::listAll(const MachineryPlanDetailsQuery::Wrapper& query)
//{
//	// 构建返回对象
//	auto pages = MachineryPlanDetailsDTO::createShared();
//
//
//	// 查询数据总条数
//	Dv_check_planDAO dao;
//	//uint64_t count = dao.count(query);
//	//if (count <= 0)
//	//{
//	//	return pages;
//	//}
//	// 分页查询数据
//
//	list<Dv_check_planDO> result = dao.selectWithPage(query);
//	// 将DO转换成DTO
//	for (Dv_check_planDO sub : result)
//	{
//		auto dto = MachineryPlanDTO::createShared();
//		//展开转化宏
//		//ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, plan_id, Plan_id, plan_code, Plan_code,
//		//	plan_name, Plan_name, plan_type, Plan_type, start_date, Start_date,
//		//	end_date, End_date, cycle_type, Cycle_type, cycle_count, Cycle_count,
//		//	status, Status)
//		dto->plan_id = sub.getPlan_id();
//		dto->plan_code = sub.getPlan_code();
//		dto->plan_name = sub.getPlan_name(); 
//		dto->plan_type = sub.getPlan_type();
//		dto->start_date = sub.getStart_date();
//		dto->end_date = sub.getEnd_date();
//		dto->cycle_type = sub.getCycle_type();
//		dto->cycle_count = sub.getCycle_count();
//		dto->status = sub.getStatus();
//		pages->addData(dto);
//	}
//	return pages;
//}
//*/
////--------
//
///*
//DeletePlanQueryDTO::Wrapper Dv_check_planService::listAll(const DeletePlanQuery::Wrapper& query)
//{
//	// 构建返回对象
//	auto pages = MachineryPlanDetailsDTO::createShared();
//
//
//	// 查询数据总条数
//	Dv_check_planDAO dao;
//	//uint64_t count = dao.count(query);
//	//if (count <= 0)
//	//{
//	//	return pages;
//	//}
//	// 分页查询数据
//
//	list<Dv_check_planDO> result = dao.selectWithPage(query);
//	// 将DO转换成DTO
//	for (Dv_check_planDO sub : result)
//	{
//		auto dto = MachineryPlanDTO::createShared();
//		//展开转化宏
//		//ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, plan_id, Plan_id, plan_code, Plan_code,
//		//	plan_name, Plan_name, plan_type, Plan_type, start_date, Start_date,
//		//	end_date, End_date, cycle_type, Cycle_type, cycle_count, Cycle_count,
//		//	status, Status)
//		dto->plan_id = sub.getPlan_id();
//		dto->plan_code = sub.getPlan_code();
//		dto->plan_name = sub.getPlan_name();
//		dto->plan_type = sub.getPlan_type();
//		dto->start_date = sub.getStart_date();
//		dto->end_date = sub.getEnd_date();
//		dto->cycle_type = sub.getCycle_type();
//		dto->cycle_count = sub.getCycle_count();
//		dto->status = sub.getStatus();
//		pages->addData(dto);
//	}
//	return pages;
//}
//*/
//
////----
///*
//uint64_t SampleService::saveData(const MachineryPlanDTO::Wrapper& dto)
//{
//	// 组装DO数据
//	Dv_check_planDO data;
//	// 	data.setName(dto->name.getValue(""));
//	// 	data.setSex(dto->sex.getValue(""));
//	// 	data.setAge(dto->age.getValue(1));
//	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Name, name, Sex, sex, Age, age)
//		// 执行数据添加
//		Dv_check_planDAO dao;
//	return dao.insert(data);
//}
//
//bool SampleService::updateData(const MachineryPlanDTO::Wrapper& dto)
//{
//	// 组装DO数据
//	Dv_check_planDO data;
//	// 	data.setId(dto->id.getValue(0));
//	// 	data.setName(dto->name.getValue(""));
//	// 	data.setSex(dto->sex.getValue(""));
//	// 	data.setAge(dto->age.getValue(1));
//	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Name, name, Sex, sex, Age, age, Id, id);
//	//data.setName(dto->name.getValue({})); data.setSex(dto->sex.getValue({})); data.setAge(dto->age.getValue({})); data.setId(dto->id.getValue({}));;
//
//	// 执行数据修改
//	Dv_check_planDAO dao;
//	return dao.update(data) == 1;
//}
//*/
//bool Dv_check_planService::removeData(uint64_t id)
//{
//	Dv_check_planDAO dao;
//	return dao.deleteById(id) == 1;
//}
