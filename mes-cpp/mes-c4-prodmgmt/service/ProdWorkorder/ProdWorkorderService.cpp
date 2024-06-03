<<<<<<< c4
#include "stdafx.h"
#include "ProdWorkorderService.h"
#include "../../dao/ProdWorkorder/ProdWorkorderDAO.h"
#include "../../dao/MdProductBom/MdProductBomDAO.h"
#include "../../dao/ProWorkorderBom/ProWorkorderBomDAO.h"
#include "../lib-common/include/SimpleDateTimeFormat.h"
//��ȡ������������
ProdWorkorderInfoDTO::Wrapper ProdWorkorderService::listDetail(const uint64_t& workorder_id) {
	
	ProdWorkorderDAO dao;
	list<ProdWorkorderInfoDO> result = dao.selectByWorkorderId(workorder_id);
	auto temp_dto = ProdWorkorderInfoDTO::createShared();
	for (ProdWorkorderInfoDO sub : result) {

		ZO_STAR_DOMAIN_DO_TO_DTO(temp_dto, sub, workorder_id, Workorder_id, workorder_code, Workorder_code, workorder_name, Workorder_name, order_source, Order_source, source_code, Source_code, status, Status, workorder_type, Workorder_type, product_code, Product_code, product_name, Product_name, product_spc, Product_spc, unit_of_measure, Unit_of_measure, quantity, Quantity, request_date, Request_date, batch_code, Batch_code, client_code, Client_code, client_name, Client_name, vendor_code, Vendor_code, vendor_name, Vendor_name, remark, Remark)

	}
	return temp_dto;
	//// ��װDO����
	//ProdWorkorderInfoDO data;
	//ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Workorder_id, workorder_id)
	////ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Workorder_id, workorder_id, Workorder_code, workorder_code, Workorder_name, workorder_name, Order_source, order_source, Source_code, source_code, Status, status, Workorder_type, workorder_type, Product_code, product_code, Product_name, product_name, Product_spc, product_spc, Unit_of_measure, unit_of_measure, Quantity, quantity, Request_date, request_date, Batch_code, batch_code, Client_code, client_code, Client_name, client_name, Vendor_code, vendor_code, Vendor_name, vendor_name, Remark, remark)
	//
	//// ִ����������
	//ProdWorkorderDAO dao;	
	// DOתDTO
	//list<ProdWorkorderInfoDO> result = dao.selectByWorkorderId(data);
	//auto temp_dto = ProdWorkorderInfoDTO::createShared();
	//for (ProdWorkorderInfoDO sub : result) {	
	//	
	//	ZO_STAR_DOMAIN_DO_TO_DTO(temp_dto, sub, workorder_id, Workorder_id, workorder_code, Workorder_code, workorder_name, Workorder_name, order_source, Order_source, source_code, Source_code, status, Status, workorder_type, Workorder_type, product_code, Product_code, product_name, Product_name, product_spc, Product_spc, unit_of_measure, Unit_of_measure, quantity, Quantity, request_date, Request_date, batch_code, Batch_code, client_code, Client_code, client_name, Client_name, vendor_code, Vendor_code, vendor_name, Vendor_name, remark, Remark)
	//	
	//}
	//return temp_dto;
}

//��ȡ���������б�
GetProdWorkorderListPageDTO::Wrapper ProdWorkorderService::listAll(const GetProdWorkorderListQuery::Wrapper& query) {
	// �������ض���
	auto pages = GetProdWorkorderListPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// ��ѯ����������
	ProdWorkorderDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return pages;
	}
	// ��ҳ��ѯ����
	pages->total = count;
	pages->calcPages();
	list<GetProdWorkorderListDO> result = dao.selectWithPage(query);
	// ��DOת����DTO
	for (GetProdWorkorderListDO sub : result)
	{
		auto dto = GetProdWorkorderListDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, workorder_id, Workorder_id, workorder_code, Workorder_code, workorder_name, Workorder_name, workorder_type, Workorder_type, order_source, Order_source, source_code, Source_code, product_code, Product_code, product_name, Product_name, product_spc, Product_spc, unit_of_measure, Unit_of_measure, quantity, Quantity, quantity_changed, Quantity_changed, quantity_produced, Quantity_produced, batch_code, Batch_code, client_code, Client_code, client_name, Client_name, request_date, Request_date, status , Status)
		pages->addData(dto);
	}
	return pages;
}

//��ȡ��������BOM�б�
ProdWorkorderBomListPageDTO::Wrapper ProdWorkorderService::listBom(const ProdWorkorderBomListQuery::Wrapper& query) {
	// �������ض���
	auto pages = ProdWorkorderBomListPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// ��ѯ����������
	ProdWorkorderDAO dao;
	uint64_t count = dao.countBom(query);
	if (count <= 0)
	{
		return pages;
	}
	// ��ҳ��ѯ����
	pages->total = count;
	pages->calcPages();
	list<ProdWorkorderBomListDO> result = dao.selectByBomId(query);
	// ��DOת����DTO
	for (ProdWorkorderBomListDO sub : result)
	{
		auto dto = ProdWorkorderBomListDTO::createShared();
		ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, line_id, Line_id, item_code, Item_code, item_name, Item_name, item_spc, Item_spc, unit_of_measure, Unit_of_measure, item_or_product, Item_or_product, quantity, Quantity)
		pages->addData(dto);
	}
	return pages;
}

//������������
uint64_t ProdWorkorderService::saveData(const AddProdWorkorderDTO::Wrapper& dto)
{
	// ��װDO����
	AddProdWorkorderDO data;
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, Workorder_id, workorder_id, Workorder_code, workorder_code, Workorder_name, workorder_name, Order_source, order_source, Status, status, Workorder_type, workorder_type, Product_code, product_code, Product_name, product_name, Product_spc, product_spc, Unit_of_measure, unit_of_measure, Quantity, quantity, Request_date, request_date, Batch_code, batch_code, Remark, remark, Product_id, product_id, Ancestors, ancestors)
	// ִ����������
	ProdWorkorderDAO dao;
	return dao.insert(data);
}



bool ProdWorkorderService::updateData(const ModifyProWorkorderDTO::Wrapper& dto)
{
	ProdWorkorderDAO d1;
	MdProductBomDAO d2;
	ProdWorkorderBomDAO d3;

	TransactionManager tm(&d1, &d2, &d3);

	//ɾ��
	uint64_t oldProductId = d1.selectByID(dto->workorderId.getValue(0));
	
	if (d2.countById(oldProductId) > 0) {
		//int row = d2.deleteById(productId);
		int row = d3.deleteByItemId(dto->workorderId.getValue(0));
		if (row <= 0) {
			tm.rollback();
			return false;
		}
	}
	//������BOM
	uint64_t productId = dto->productId.getValue(0);
	if(d2.countById(productId) > 0) {
		list<MdProductBomDO> mdBom = d2.selectByItemId(dto->productId.getValue(0));
		for (auto i : mdBom) {
			ProWorkOrderBomDO data;
			data.setworkOrderId(dto->workorderId.getValue(0));
			data.setitemId(i.getBomItemId());
			data.setitemCode(i.getBomItemCode());
			data.setitemName(i.getBomItemName());
			data.setitemSpc(i.getBomItemSpc());
			data.setunitOfMeasure(i.getUnitOfMeasure());
			data.setbQuantity(i.getQuantity() * dto->quantity.getValue(0));
			data.setitemOrProduct(i.getItemOrProduct());
			//����ʱ��
			data.setcreateTime(SimpleDateTimeFormat::format());
			int row = d3.insert(data);
			if (row <= 0) {
				tm.rollback();
				return false;
			}
		}
	}
	//�޸�
	ProdWorkorderDO dataDO;
	dataDO.setWorkOrderID(dto->workorderId.getValue(0));
	dataDO.setWorkOrderCode(dto->workorderCode.getValue(""));
	dataDO.setWorkOrderName(dto->workorderName.getValue(""));
	dataDO.setOrderSource(dto->orderSource.getValue(""));
	dataDO.setSourceCode(dto->sourceCode.getValue(""));
	dataDO.setWorkOrderType(dto->workorderType.getValue(""));
	dataDO.setQuantity(dto->quantity.getValue(0));
	dataDO.setRequestDate(dto->requestDate.getValue(""));
	dataDO.setBatchCode(dto->batchCode.getValue(""));
	dataDO.setClientId(dto->clientId.getValue(0));
	dataDO.setClientCode(dto->clientCode.getValue(""));
	dataDO.setProductId(dto->productId.getValue(0));
	dataDO.setProductCode(dto->productCode.getValue(""));
	dataDO.setProductSpc(dto->productSpc.getValue(""));
	dataDO.setUnitOfMeasure(dto->unitOfMeasure.getValue(""));
	dataDO.setClientName(dto->clientName.getValue(""));
	dataDO.setRemark(dto->remark.getValue(""));
	dataDO.setUpdateTime(SimpleDateTimeFormat::format());
	int row = d1.update(dataDO);
	if (row <= 0) {
		tm.rollback();
		return false;
	}
	tm.commit();
	return true;
}

bool ProdWorkorderService::completeData(uint64_t id)
{
	ProdWorkorderDO childData;
	childData.setParentId(id);
	childData.setStatus("FINISHED");

	ProdWorkorderDO data;
	data.setWorkOrderID(id);
	data.setStatus("CONFIRMED");
	ProdWorkorderDAO dao;
	if (dao.countById(childData) > 0 || dao.countById(data) <= 0) {
		return false;
	}
	return dao.completeById(id) == 1;
}

bool ProdWorkorderService::removeData(uint64_t id)
{
	ProdWorkorderDO data;
	data.setWorkOrderID(id);
	data.setStatus("PREPARE");
	ProdWorkorderDAO dao;
	if (dao.countById(data) <= 0) {
		return false;
	}
	return dao.deleteById(id)==1;
}

bool ProdWorkorderService::confirmData(uint64_t id)
{
	
	ProdWorkorderDAO dao;
	return dao.comfirmById(id)==1;
}

