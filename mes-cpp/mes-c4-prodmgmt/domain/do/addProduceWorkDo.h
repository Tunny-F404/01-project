//#pragma once
///*
// Copyright Zero One Star. All rights reserved.
//
// @Author: awei
// @Date: 2023/02/17 16:25:30
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//	  https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//*/
//#ifndef _SAMPLEMENUDO_H_
//#define _SAMPLEMENUDO_H_
//
//#include "../DoInclude.h"
///**
// * 测试菜单数据库实体
// */
//class MenuDO
//{
//	// 报工类型
//	CC_SYNTHESIZE(string, feedback_type, Feedback_type);
//
//	//生产工单  - 返回工单编码
//	CC_SYNTHESIZE(string, feedback_code, Feedback_code);
//
//	//生产任务 - 返回 生产任务编号
//	CC_SYNTHESIZE(string, task_code, Task_code);
//
//	//产号编码
//	CC_SYNTHESIZE(string, product_code, Product_code);
//
//	//产品名称
//	CC_SYNTHESIZE(string, product_name, Product_name);
//
//	//单位
//	CC_SYNTHESIZE(string, unit_of_measure, Unit_of_measure);
//
//	//规格类型
//	CC_SYNTHESIZE(string, product_spc, Product_spc);
//
//	//报工数量
//	CC_SYNTHESIZE(string, quantity_feedback, Quantity_feedback);
//
//	//待检测数量
//	CC_SYNTHESIZE(string, quantity_uncheck, Quantity_uncheck);
//
//	//报工人 -昵称
//	CC_SYNTHESIZE(string, nick_name, Nick_name);
//
//	//报工时间
//	CC_SYNTHESIZE(string, feedback_time, Feedback_time);
//
//	//审核人 -昵称
//	CC_SYNTHESIZE(string,nick_name ,Nick_name );
//
//	//备注
//	CC_SYNTHESIZE(string, remark, Remark);
//
//
//public:
//	MenuDO() {}
//	MenuDO(string feedback_type, string feedback_code, 
//		string task_code, string product_code,
//		string product_name, string unit_of_measure,
//		string product_spc,string quantity_feedback,
//		string quantity_uncheck, string feedback_time,
//		string remark,
//	
//	)
//	{
//		this->feedback_type = feedback_type;
//		this->feedback_code = feedback_code;
//		this->task_code = task_code;
//		this->product_code = product_code;
//		this->product_name = product_name;
//		this->unit_of_measure = unit_of_measure;
//		this->product_spc = product_spc;
//		this->quantity_feedback = quantity_feedback;
//		this->quantity_uncheck = quantity_uncheck;
//		this->feedback_time = feedback_time;
//		this->remark = remark;
//	}
//};
//
//#endif // !_SAMPLEMENUDO_H_