/*
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
#include "return/ReturnController.h"

#ifdef HTTP_SERVER_DEMO
#include "user/UserController.h"
#include "sample/SampleController.h"
#include "file/FileController.h"
#include "ws/WSController.h"
#endif

#include "controller/material/ReturnController.h"


#ifdef CLOSE_SWAGGER_DOC
// ï¿½ò»¯°ó¶¨¿ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ê¶¨ï¿½ï¿½
#define ROUTER_SIMPLE_BIND(__CLASS__) \
router->addController(__CLASS__::createShared())
#else
// ï¿½ò»¯°ó¶¨¿ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ê¶¨ï¿½ï¿½
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


	//#TIP :ÏµÍ³À©Õ¹Â·ÓÉ¶¨Òå£¬Ð´ÔÚÕâ¸öºóÃæ
	ROUTER_SIMPLE_BIND(ReturnController);

}

#ifdef HTTP_SERVER_DEMO
void Router::createSampleRouter()
{
	// ï¿½ï¿½Ê¾ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	ROUTER_SIMPLE_BIND(SampleController);
	// ï¿½ï¿½ï¿½Ã»ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	ROUTER_SIMPLE_BIND(UserController);
	// ï¿½ï¿½ï¿½Ä¼ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	ROUTER_SIMPLE_BIND(FileController);
	
	// ï¿½ï¿½WebSocketï¿½ï¿½ï¿½ï¿½ï¿½ï¿½
	router->addController(WSContorller::createShared());
}
#endif
