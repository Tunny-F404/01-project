#include "stdafx.h"
#include "Router.h"
#include "ApiHelper.h"
#include "warehousemanagement/WarehouseManagementController.h"
#include "detectiontemplate/DetectionTemplateController.h"

#ifdef HTTP_SERVER_DEMO
#include "user/UserController.h"
#include "sample/SampleController.h"
#include "file/FileController.h"
#include "ws/WSController.h"
#endif

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

<<<<<<<< HEAD:mes-cpp/c5-materialproduct/controller/Router.cpp
	//#TIP :ϵͳ��չ·�ɶ��壬д���������
	
========
	//#TIP :系统扩展路由定义，写在这个后面
	// 绑定控制器
	ROUTER_SIMPLE_BIND(WarehouseManagementController);
	ROUTER_SIMPLE_BIND(DetectionTemplateController);
>>>>>>>> remotes/origin/c5-obtain&exportwarehousemanagement-wuren:mes-cpp/c5-obtainexportwarehousemanagement-wuren/controller/Router.cpp
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
