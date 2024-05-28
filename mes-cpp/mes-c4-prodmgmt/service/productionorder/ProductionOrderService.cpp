/*
 Copyright Zero One Star. All rights reserved.

 @Author: amie
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
#include "ProductionOrderService.h"
#include "../../dao/productionorder/ProductionOrderDAO.h"
ExportOrderPageDTO::Wrapper ProductionOrderService::listAll(const ExportOrderQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = ExportOrderPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// 查询数据总条数
	ProWorkOrderDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<ProWorkOrderDO> result = dao.selectWithPage(query);
	// 将DO转换成DTO
	for (ProWorkOrderDO sub : result)
	{
		auto dto = ExportOrderDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, workOrderCode, workOrderCode, workOrderName, workOrderName, workOrderType, workOrderType, orderSource, orderSource, sourceCode, sourceCode, productId, productId, productCode, productCode, productName, productName, productSpc, productSpc, unitOfMeasure, unitOfMeasure, batchCode, batchCode, pQuantity, pQuantity, quantityProduced, quantityProduced, quantityChanged, quantityChanged, quantityScheduled, quantityScheduled);
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub,clientId, clientId, clientCode, clientCode, clientName,clientName, vendorId, vendorId, vendorCode,vendorCode, vendorName, vendorName, finishDate, finishDate, requestDate, requestDate,status,status);
			pages->addData(dto);

	}
	return pages;
}
ExportBomOrderPageDTO::Wrapper ProductionBomOrderService::listAll(const ExportBomOrderQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = ExportBomOrderPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// 查询数据总条数
	ProWorkOrderBomDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<ProWorkOrderBomDO> result = dao.selectWithPage(query);
	// 将DO转换成DTO
	for (ProWorkOrderBomDO sub : result)
	{
		auto dto = ExportBomOrderDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub,itemCode, itemCode, itemName, itemName, itemSpc, itemSpc,unitOfMeasure,unitOfMeasure,itemOrProduct,itemOrProduct,quantity,bQuantity,itemId,itemId,workOrderId,workOrderId);
		pages->addData(dto);

	}
	return pages;
}
