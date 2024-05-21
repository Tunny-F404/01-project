/*
 Copyright Zero One Star. All rights reserved.

 @Author: กฃบร
 @Date: 2024/05/18 20:16:53

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
#include "EquipmentController.h"

EquipmentPageJsonVO::Wrapper EquipmentController::execEquipment(const EquipmentQuery::Wrapper& query)
{
	return {};
}

EquipmentDetailJsonVO::Wrapper EquipmentController::execEquipmentDetail(const EquipmentDetailQuery::Wrapper& query)
{
	auto res = EquipmentDetailJsonVO::createShared();
	auto equipmentDetail = EquipmentDetailDTO::createShared();
	
	equipmentDetail->eCode = "123";
	equipmentDetail->brand = "123";
	equipmentDetail->createtime = "2014";
	equipmentDetail->eId = 1;
	equipmentDetail->eName = "123";
	equipmentDetail->note = "123";
	equipmentDetail->spec = "123";
	equipmentDetail->status = "123";
	equipmentDetail->tName = "123";
	equipmentDetail->workshop = "123";
	res->success(equipmentDetail);
	return res;
}

Uint64JsonVO::Wrapper EquipmentController::execAddEquipment(const addEquipmentDTO::Wrapper& dto)
{
	auto res = Uint64JsonVO::createShared();
	res->success(true);
	return res;
}

Uint64JsonVO::Wrapper EquipmentController::executeModifyEquipment(const modifyEquipmentDTO::Wrapper& dto)
{
	auto res = Uint64JsonVO::createShared();
	res->success(true);
	return res;
}

EquipmentClassifyJsonVO::Wrapper EquipmentController::executeEquipmentClassify(const EquipmentClassifyDTO::Wrapper& dto)
{
	return {};
}
