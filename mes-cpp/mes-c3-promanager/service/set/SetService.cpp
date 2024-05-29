#include "stdafx.h"
#include "SetService.h"
#include "../../dao/set/SetDAO.h"
//分页查询所有数据
SetProListPageDTO::Wrapper SetService::listAll(const SetProListQuery::Wrapper& query)
{
	// 构建返回对象
	auto pages = SetProListPageDTO::createShared();
	pages->pageIndex = query->pageIndex;
	pages->pageSize = query->pageSize;

	// 查询数据总条数
	SetDAO dao;
	uint64_t count = dao.count(query);
	if (count <= 0)
	{
		return pages;
	}

	// 分页查询数据
	pages->total = count;
	pages->calcPages();
	list<ProProcessContentDO> result = dao.selectWithPage(query);
	// 将DO转换成DTO
	for (ProProcessContentDO sub : result)
	{
		auto dto = SetProListDTO::createShared();
				dto->processId = sub.getProcessId();
				dto->orderNum = sub.getOrderNum();
	 			dto->device = sub.getDevice();
				dto->contentText = sub.getContentText();
				dto->material = sub.getMaterial();
				dto->remark = sub.getRemark();
				dto->docUrl = sub.getDocUrl();
		//ZO_STAR_DOMAIN_DO_TO_DTO(dto, sub, contentId, ContentId, processId,ProcessId, orderNum,OrderNum, device, Device,
			 //contentText, ContentText,docUrl, DocUrl, material, Material, remark,Remark)
			pages->addData(dto);
	}
	return pages;
}
//添加工序
uint64_t SetService::saveData(const SetProAddTableDTO::Wrapper& dto)
{
	// 组装DO数据
	ProProcessDO data;
	// 	data.setName(dto->name.getValue(""));
	// 	data.setSex(dto->sex.getValue(""));
	// 	data.setAge(dto->age.getValue(1));
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto,ProcessId,processId,ProcessCode, processCode, ProcessName, processName,
		 EnableFlag, enableFlag, Attention, attention, Remark, remark);
		// 执行数据添加
		SetDAO dao;
	return dao.insertSet(data);
}
//添加工序步骤
uint64_t SetService::saveStepData(const SetProListDTO::Wrapper& dto)
{
	// 组装DO数据
	ProProcessContentDO data;
	// 	data.setName(dto->name.getValue(""));
	// 	data.setSex(dto->sex.getValue(""));
	// 	data.setAge(dto->age.getValue(1));
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, ContentId, contentId, ProcessId, processId, OrderNum, orderNum,ContentText, contentText,
		Device, device, DocUrl,docUrl,Material, material, Remark, remark);
	// 执行数据添加
	SetDAO dao;
	return dao.insertstepSet(data);
}

//修改工序
bool SetService::updateData(const SetProAddTableDTO::Wrapper& dto)
{
	// 组装DO数据
	ProProcessDO data;
	 	/*data.setProcessId(dto->processId.getValue(0));*/
	 	/*data.setName(dto->name.getValue(""));
	 	data.setSex(dto->sex.getValue(""));
	 	data.setAge(dto->age.getValue(1));*/
	ZO_STAR_DOMAIN_DTO_TO_DO(data, dto, ProcessId, processId, ProcessCode, processCode, ProcessName, processName,
		 EnableFlag, enableFlag,Attention,attention,Remark, remark);
		// 执行数据修改
		SetDAO dao;
	return dao.updateSet(data) == 1;
}