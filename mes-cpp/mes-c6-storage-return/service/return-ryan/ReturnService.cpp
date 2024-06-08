/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/10/25 11:13:11

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

	  https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
*/
#include "stdafx.h"
#include "ReturnService.h"
#include "../../domain/do/return-ryan/ReturnDO.h"
#include "../../dao/return-ryan/ReturnDAO.h"

ReturnPageDTO::Wrapper ReturnService::listAll_r(const ReturnQuery_r::Wrapper& query)
{
	return {};
}

uint64_t ReturnService::saveData_r(const ReturnDTO::Wrapper& dto)
{
	return 0;
}

bool ReturnService::updateData(const ReturnDTO::Wrapper& dto)//传ReturnDetailDTO报错
{
	// 组装DO数据
	ReturnDO data;
	//rt_code rt_name po_code vendor_name batch_code rt_date status remark
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Rt_code, rt_code, Rt_name, rt_name, Po_code, po_code, Vendor_name, vendor_name, 
		Batch_code, batch_code, Rt_date, rt_date, Status_, status,  Remark, remark)
	// 执行数据修改
	ReturnDAO dao;
	return dao.update(data) == 1;
}

bool ReturnService::removeData(uint64_t id)
{
	ReturnDAO dao;
	return dao.deleteById(id) == 1;
}

bool ReturnService::excuteData(uint64_t id)
{
	ReturnDAO dao;
	return dao.updateStatusById(id) == 1;
}

list<ReturnDO> ReturnService::listAllExort(const ReturnQuery_r::Wrapper& query)
{
	//ReturnDAO dao;
	////查看数据是否存在
	//auto count = dao.count(query);
	////不存在返回空
	//if (count < 1)
	//	return {};
	////查询所有数据
	//auto dos = dao.selectWithPage(query, 1);
	//return dos;
	return list<ReturnDO>();
}
