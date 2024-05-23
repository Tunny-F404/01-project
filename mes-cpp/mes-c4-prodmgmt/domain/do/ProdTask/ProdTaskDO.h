#pragma once

#include "../DoInclude.h"
/*
* 修改生产任务实体类
*/
class ProdTaskDO
{
	//任务Id , task_id ,Task_id
	CC_SYNTHESIZE(int, task_id, Task_id);
	//任务编号 , task_code ,Task_code
	CC_SYNTHESIZE(string, task_code, Task_code);
	//任务名称 , task_name ,Task_name
	CC_SYNTHESIZE(string , task_name, Task_name);
	//工单id , workorder_id ,Workorder_id
	CC_SYNTHESIZE(int, workorder_id, Workorder_id);
	//工单编号 , workorder_code ,Workorder_code
	CC_SYNTHESIZE(string , workorder_code, Workorder_code);
	//工单名称 , workorder_name ,Workorder_name
	CC_SYNTHESIZE(string , workorder_name, Workorder_name);
	//工作站id, workstation_id, Workstation_id
	CC_SYNTHESIZE(int, workstation_id, Workstation_id);
	//工作站编号 workstation_code Workstation_code
	CC_SYNTHESIZE(string, workstation_code, Workstation_code);
	//工作站名称 workstation_name Workstation_name
	CC_SYNTHESIZE(string, workstation_name, Workstation_name);
	//工艺ID route_id Route_id
	CC_SYNTHESIZE(int, route_id, Route_id);
	//工艺编号
	CC_SYNTHESIZE(string, route_code, Route_code);

	ProdTaskDO()
	{
		this->task_code = ;
    }
};