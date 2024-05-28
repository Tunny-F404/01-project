#include "stdafx.h"
#include "DeviceResourceController.h"
#include "service/deviceResource/DeviceResourceService.h"



DeviceResourcePageVO::Wrapper DeviceResourceController::execGetDeviceResourceList( const PayloadDTO& payload)
{
	// 定义一个Service
	DeviceResourceService service;
	// 查询数据
	auto result = service.listAll();
	// 响应结果
	auto jvo = DeviceResourcePageVO::createShared();
	jvo->success(result);
	return jvo;
}


