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

#include "prodmgmt/RemoveWorkReportController.h"

#include "productionorder/ProductionOrderController.h"
#include "productioninvestigation/ProductionProcessController.h"
#ifdef HTTP_SERVER_DEMO
#include "user/UserController.h"
#include "sample/SampleController.h"
#include "file/FileController.h"
#include "ws/WSController.h"
<<<<<< < HEAD

#endif
#include "ProdOrder/ProdOrderController.h"



#include "../mes-c4-prodmgmt/controller/ProdWorkorder/ProdWorkorderController.h"
#include "../controller/ApprovalStage/ApprovalStage.h"
#include "controller/ProdWorkorder/ProWorkorderController.h"

#ifdef CLOSE_SWAGGER_DOC
// �򻯰󶨿������궨��
#define ROUTER_SIMPLE_BIND(__CLASS__) \
router->addController(__CLASS__::createShared())
#else
// �򻯰󶨿������궨��
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
	ROUTER_SIMPLE_BIND(ProdWorkorderController);
	ROUTER_SIMPLE_BIND(RemoveWorkReportController);
	ROUTER_SIMPLE_BIND(ApprovalStage);
	ROUTER_SIMPLE_BIND(ProWorkorderController);

	//#TIP :绯荤粺鎵╁睍璺敱瀹氫箟锛屽啓鍦ㄨ繖涓悗闈?
	ROUTER_SIMPLE_BIND(ProductionOrderController);
	ROUTER_SIMPLE_BIND(ProductionProcessController);
	ROUTER_SIMPLE_BIND(ProdOrderController);
}


