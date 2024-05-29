﻿/*
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
#include "Macros.h"
#include "ExcelComponent.h"

#define TEST_EXCEL_SN ZH_WORDS_GETTER("productionorder.excel.sheet.s2")
ExportOrderPageDTO::Wrapper ProductionOrderService::listAll(const ExportOrderQuery::Wrapper& query)
{
	std::vector<std::vector<std::string>> data;
	stringstream ss;
	std::string fileName = "./public/excel/workorder.xlsx";
	std::string sheetName = ZH_WORDS_GETTER("productionorder.excel.sheet.s1");
	ExcelComponent excel;
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
		std::vector<std::string> row;
		row.push_back(sub.getworkOrderCode());
		row.push_back(sub.getworkOrderName());
		row.push_back(sub.getworkOrderType());
		row.push_back(sub.getorderSource());
		row.push_back(sub.getsourceCode());
		ss.clear();
		ss << sub.getproductId();
		row.push_back(ss.str());
		row.push_back(sub.getproductCode());
		row.push_back(sub.getproductName());
		row.push_back(sub.getproductSpc());
		row.push_back(sub.getunitOfMeasure());
		row.push_back(sub.getbatchCode());
		ss.clear();
		ss << sub.getpQuantity();
		row.push_back(ss.str());
		data.push_back(row);
		ss.clear();
		ss << sub.getquantityProduced();
		row.push_back(ss.str());
		ss.clear();
		ss << sub.getquantityChanged();
		row.push_back(ss.str());
		ss.clear();
		ss << sub.getquantityScheduled();
		row.push_back(ss.str());
		ss.clear();
		ss << sub.getclientId();
		row.push_back(ss.str());
		row.push_back(sub.getclientCode());
		row.push_back(sub.getclientName());
		ss.clear();
		ss << sub.getvendorId();
		row.push_back(ss.str());
		row.push_back(sub.getvendorCode());
		row.push_back(sub.getvendorName());
		row.push_back(sub.getfinishDate());
		row.push_back(sub.getrequestDate());
		row.push_back(sub.getstatus());
		data.push_back(row);
	}
	// 插入表头
	data.insert(data.begin(), {
		ZH_WORDS_GETTER("excel.header.h1") ,
		ZH_WORDS_GETTER("excel.header.h2") ,
		ZH_WORDS_GETTER("excel.header.h3") ,
		ZH_WORDS_GETTER("excel.header.h4") ,
		ZH_WORDS_GETTER("excel.header.h5") ,
		ZH_WORDS_GETTER("excel.header.h6") ,
		ZH_WORDS_GETTER("excel.header.h7") ,
		ZH_WORDS_GETTER("excel.header.h8") ,
		ZH_WORDS_GETTER("excel.header.h9") ,
		ZH_WORDS_GETTER("excel.header.h10") ,
		ZH_WORDS_GETTER("excel.header.h11") ,
		ZH_WORDS_GETTER("excel.header.h12") ,
		ZH_WORDS_GETTER("excel.header.h13") ,
		ZH_WORDS_GETTER("excel.header.h14") ,
		ZH_WORDS_GETTER("excel.header.h15") ,
		ZH_WORDS_GETTER("excel.header.h16") ,
		ZH_WORDS_GETTER("excel.header.h17") ,
		ZH_WORDS_GETTER("excel.header.h18") ,
		ZH_WORDS_GETTER("excel.header.h19") ,
		ZH_WORDS_GETTER("excel.header.h20") ,
		ZH_WORDS_GETTER("excel.header.h21") ,
		ZH_WORDS_GETTER("excel.header.h22") ,
		ZH_WORDS_GETTER("excel.header.h23") ,
		ZH_WORDS_GETTER("excel.header.h24") ,
		});
	excel.writeVectorToFile(fileName, sheetName, data);
	return pages;
}
ExportBomOrderPageDTO::Wrapper ProductionBomOrderService::listAll(const ExportBomOrderQuery::Wrapper& query)
{
	std::vector<std::vector<std::string>> data;
	stringstream ss;
	std::string fileName = "./public/excel/workorderbom.xlsx";
	std::string sheetName = TEST_EXCEL_SN;
	ExcelComponent excel;
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
		std::vector<std::string> row;
		ss.clear();
		ss<<sub.getworkOrderId();
		row.push_back(ss.str());
		ss.clear();
		ss << sub.getitemId();
		row.push_back(ss.str());
		row.push_back(sub.getitemCode());
		row.push_back(sub.getitemName());
		row.push_back(sub.getitemSpc());
		row.push_back(sub.getunitOfMeasure());
		row.push_back(sub.getitemOrProduct());
		ss.clear();
		ss << sub.getbQuantity();
		row.push_back(ss.str());
		data.push_back(row);
	}
	// 插入表头
	data.insert(data.begin(), {
		ZH_WORDS_GETTER("excel.header.h25") ,
		ZH_WORDS_GETTER("excel.header.h26") ,
		ZH_WORDS_GETTER("excel.header.h27") ,
		ZH_WORDS_GETTER("excel.header.h28") ,
		ZH_WORDS_GETTER("excel.header.h29") ,
		ZH_WORDS_GETTER("excel.header.h30") ,
		ZH_WORDS_GETTER("excel.header.h31") ,
		ZH_WORDS_GETTER("excel.header.h32") ,
		});
	excel.writeVectorToFile(fileName, sheetName, data);
	return pages;
}
