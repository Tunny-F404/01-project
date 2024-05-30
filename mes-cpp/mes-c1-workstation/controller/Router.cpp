#include "stdafx.h"
#include "Router.h"
#include "ApiHelper.h"
#include"controller/WorkStation/GetWorkStationListController.h"
#include"controller/WorkStation/AddWorkStationController.h"
#include"controller/WorkStation/ModifyWorkStationController.h"
#include"controller/WorkStation/ExportWorkStationController.h"
#include "humanresource/HumanResourceListController.h"
#include "add-wf-for-ws/AddWorkFixtureForWorkStationController.h"
#include "get-wf-for-ws/GetWorkFixtureForWorkStationController.h"
#ifdef HTTP_SERVER_DEMO
#include "user/UserController.h"
#include "sample/SampleController.h"
#include "file/FileController.h"
#include "ws/WSController.h"
#endif
#include "deviceResource/DeviceResourceController.h"
#include "equipment/EquipmentController.h"

// 如果定义了关闭Swagger文档宏
#ifdef CLOSE_SWAGGER_DOC
// 简化绑定控制器宏定义
#define ROUTER_SIMPLE_BIND(__CLASS__) \
router->addController(__CLASS__::createShared())
#else
// 简化绑定控制器宏定义
#define ROUTER_SIMPLE_BIND(__CLASS__) \
BIND_CONTROLLER(docEndpoints, router, __CLASS__)
#endif

Router::Router(Endpoints* docEndpoints, HttpRouter* router)
{
	this->docEndpoints = docEndpoints;
	this->router = router;
}

void Router::initRouter()
{
#ifdef HTTP_SERVER_DEMO
	createSampleRouter();
#endif

	//#TIP :系统扩展路由定义，写在这个后面
		// 绑定示例控制器
	ROUTER_SIMPLE_BIND(DeviceResourceController);
	ROUTER_SIMPLE_BIND(EquipmentController);

	ROUTER_SIMPLE_BIND(GetWorkStationListController); 
	ROUTER_SIMPLE_BIND(AddWorkStationController);
	ROUTER_SIMPLE_BIND(ModifyWorkStationController);
	ROUTER_SIMPLE_BIND(ExportWorkStationController);
	ROUTER_SIMPLE_BIND(ExportWorkStationController);
	ROUTER_SIMPLE_BIND(HumanResourceListController);
	ROUTER_SIMPLE_BIND(AddWorkFixtureForWorkStationController);
	ROUTER_SIMPLE_BIND(GetWorkFixtureForWorkStationController);
}

#ifdef HTTP_SERVER_DEMO
void Router::createSampleRouter()
{
	// 绑定示例控制器
	ROUTER_SIMPLE_BIND(SampleController);
	// 绑定用户控制器
	ROUTER_SIMPLE_BIND(UserController);
	// 绑定文件控制器
	ROUTER_SIMPLE_BIND(FileController);

	// 绑定WebSocket控制器
	router->addController(WSContorller::createShared());
}
#endif
