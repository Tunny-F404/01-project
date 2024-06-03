/*
>>>>>>> 68ca23adf7d849ebe7f628a278360730cc296bae
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2022/12/03 14:58:34

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
#include "Router.h"
#include "ApiHelper.h"
#include"controller/purchasereceiving/AddListController.h"
#include"controller/purchasereceiving/ModifyListController.h"
#include"controller/purchasereceiving/information/GetListController.h"


#include "PurchaseReceipt/GetReceiptController.h"


#ifdef HTTP_SERVER_DEMO
#include "user/UserController.h"
#include "sample/SampleController.h"
#include "file/FileController.h"
#include "ws/WSController.h"
<<<<<< < HEAD

#endif 

	// 濡傛灉瀹氫箟浜嗗叧闂璖wagger鏂囨。瀹?
#include "controller/ProchAndStorage/MaterialsInfo/AddWhStorageorderController.h"
#include "controller/ProchAndStorage/MaterialsInfo/ModifyWhStorageorderController.h"
#include "controller/ProchAndStorage/MaterialsInfo/DeleteWhStorageorderController.h"
// ��������˹ر�Swagger�ĵ���
#ifdef CLOSE_SWAGGER_DOC
// 绠€鍖栫粦瀹氭帶鍒跺櫒瀹忓畾涔?
#define ROUTER_SIMPLE_BIND(__CLASS__) \
router->addController(__CLASS__::createShared())
#else
#endif

// 如果定义了关闭Swagger文档宏
#ifdef CLOSE_SWAGGER_DOC
// 简化绑定控制器宏定义
#define ROUTER_SIMPLE_BIND(__CLASS__) \
router->addController(__CLASS__::createShared())
#else
#endif
#include "WarehouseInbound/WarehouseInboundController.h"
#include "WarehouseDelete/WarehouseDeleteController.h"
#include "WarehouseExport/WarehouseExportController.h"

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

Router::Router(Endpoints * docEndpoints, HttpRouter * router)
{
	this->docEndpoints = docEndpoints;
	this->router = router;
}

void Router::initRouter()
{
#ifdef HTTP_SERVER_DEMO
	createSampleRouter();
#endif

	//#TIP :ϵͳ��չ·�ɶ��壬д���������
	ROUTER_SIMPLE_BIND(GetReceiptController);
	//#TIP :绯荤粺鎵╁睍璺敱瀹氫箟锛屽啓鍦ㄨ繖涓悗闈?
	
	//#TIP :ϵͳ��չ·�ɶ��壬д���������
	ROUTER_SIMPLE_BIND(AddWhStorageorderController);
	ROUTER_SIMPLE_BIND(ModifyWhStorageorderController);
	ROUTER_SIMPLE_BIND(DeleteWhStorageorderController);
	////#TIP :ϵͳ��չ·�ɶ��壬д���������
	ROUTER_SIMPLE_BIND(ModifyListController);
	ROUTER_SIMPLE_BIND(AddListController);
	ROUTER_SIMPLE_BIND(GetListController);
	//#TIP :系统扩展路由定义，写在这个后面
	ROUTER_SIMPLE_BIND(WarehouseInboundController);

	ROUTER_SIMPLE_BIND(WarehouseDeleteController);

	ROUTER_SIMPLE_BIND(WarehouseExportController);
	
}

#ifdef HTTP_SERVER_DEMO
void Router::createSampleRouter()
{
	<<<<<< < HEAD
		// 缁戝畾绀轰緥鎺у埗鍣?
		ROUTER_SIMPLE_BIND(SampleController);
	// 缁戝畾鐢ㄦ埛鎺у埗鍣?
	ROUTER_SIMPLE_BIND(UserController);
	// 缁戝畾鏂囦欢鎺у埗鍣?
	ROUTER_SIMPLE_BIND(FileController);

	// 缁戝畾WebSocket鎺у埗鍣?
	====== =
		// 绑定示例控制器
		ROUTER_SIMPLE_BIND(SampleController);
	// 绑定用户控制器
	ROUTER_SIMPLE_BIND(UserController);
	// 绑定文件控制器
	ROUTER_SIMPLE_BIND(FileController);

	// 绑定WebSocket控制器
	>>>>>> > 68ca23adf7d849ebe7f628a278360730cc296bae
		router->addController(WSContorller::createShared());
}
#endif
	

