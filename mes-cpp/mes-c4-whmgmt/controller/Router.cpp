﻿/*
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
#include "productioninvestigation/ProductionProcessController.h"
#ifdef HTTP_SERVER_DEMO
#include "user/UserController.h"
#include "sample/SampleController.h"
#include "file/FileController.h"
#include "ws/WSController.h"
<<<<<< < HEAD

#endif

	// 濡傛灉瀹氫箟浜嗗叧闂璖wagger鏂囨。瀹?
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

	//#TIP :绯荤粺鎵╁睍璺敱瀹氫箟锛屽啓鍦ㄨ繖涓悗闈?
	ROUTER_SIMPLE_BIND(ProductionProcessController);
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
