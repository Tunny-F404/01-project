#include "stdafx.h"
#include "EquipmentService.h"
#include"../../dao/equipment/EquipmentDAO.h"
#include"../../domain/do/dv_machinery/dvMachineryDO.h"
#include"../../domain/dto/equipment/EquipmentDTO.h"
#include"../../domain/do/md_workshop/md_workshopDO.h"
EquipmentPageDTO::Wrapper EquipmentService::listAll(const EquipmentQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = EquipmentPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;
	

	// 查询数据总条数
	EquipmentDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<dvMachineryDO> result = dao.selectWithPage(query);
	// 将DO转换成DTO
	for (dvMachineryDO sub : result)
	{
		list<MdWorkshopDO> path= dao.getWorkshopByid(sub.getWorkshopId());
		auto dto = EquipmentDTO::createShared();
		if (!path.empty())
		{
			auto it = path.begin();
			dto->workshopCode = it->getWorkshopCode();
			dto->workshopName = it->getWorkshopName();
		}
		dto->eId = sub.getMachineryId();
		dto->eCode = sub.getMachineryCode();
		dto->eName = sub.getMachineryName();
		dto->brand = sub.getMachineryBrand();
		dto->spec = sub.getMachinerySpec();
		dto->workshopId = sub.getWorkshopId();
		dto->status = sub.getStatus();
		dto->createtime = sub.getCreateTime();
			pages->addData(dto);

	}
	return pages;
}

EquipmentDetailDTO::Wrapper EquipmentService::getDetail(const EquipmentDetailQuery::Wrapper& query)
{
	auto one = EquipmentDetailDTO::createShared();
	EquipmentDAO dao;
	//查询数据
	list<dvMachineryDO> result = dao.selectWithId(query);
	
	// 将DO转换成DTO
	for (dvMachineryDO sub : result)
	{

		auto dto = EquipmentDetailDTO::createShared();

		list<MdWorkshopDO> path = dao.getWorkshopByid(sub.getWorkshopId());
		if (!path.empty())
		{
			auto it = path.begin();
			dto->workshopCode = it->getWorkshopCode();
			dto->workshopName = it->getWorkshopName();
		}

		list<dvMachineryTypeDO>path1 = dao.getMachinerytypeByid(sub.getMachineryTypeId());
		if (!path1.empty())
		{
			auto it = path1.begin();
			dto->tCode = it->getMachineryTypeCode();
			dto->tName = it->getMachineryTypeName();
		}


		dto->eId = sub.getMachineryId();
		dto->eCode = sub.getMachineryCode();
		dto->eName = sub.getMachineryName();
		dto->brand = sub.getMachineryBrand();
		dto->tId = sub.getMachineryTypeId();
		dto->spec = sub.getMachinerySpec();
		dto->workshopId = sub.getWorkshopId();
		dto->note = sub.getRemark();
		
		return dto;
		
	}
	return {};
}

uint64_t EquipmentService::saveData(const addEquipmentDTO::Wrapper& dto)
{
	// 组装DO数据
	dvMachineryDO  data;
	data.setMachineryCode(dto->eCode.getValue(""));
	data.setMachineryName(dto->eName.getValue(""));
	data.setMachineryBrand(dto->brand.getValue(""));
	data.setMachineryTypeName(dto->tName.getValue(""));
	data.setMachinerySpec(dto->spec.getValue(""));
	data.setWorkshopName(dto->workshopName.getValue(""));
	data.setRemark(dto->note.getValue(""));
	
	EquipmentDAO dao;
	return dao.insert(data);
}

bool EquipmentService::modifyData(const modifyEquipmentDTO::Wrapper& dto)
{
	// 组装DO数据
	dvMachineryDO  data;
	data.setMachineryId(dto->eId.getValue(0));
	data.setMachineryCode(dto->eCode.getValue(""));
	data.setMachineryName(dto->eName.getValue(""));
	data.setMachineryBrand(dto->brand.getValue(""));
	data.setMachineryTypeName(dto->tName.getValue(""));
	data.setMachinerySpec(dto->spec.getValue(""));
	data.setWorkshopName(dto->workshopName.getValue(""));
	data.setRemark(dto->note.getValue(""));

	EquipmentDAO dao;
	return dao.modify(data);
}

