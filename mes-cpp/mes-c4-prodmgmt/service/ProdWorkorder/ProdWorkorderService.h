#pragma once
#ifndef _PRODWORKORDER_SERVICE_
#define _PRODWORKORDER_SERVICE_
#include <list>
#include "../mes-c4-prodmgmt/domain/vo/ProdWorkorder/ProdWorkorderInfoVO.h"
#include "../mes-c4-prodmgmt/domain/vo/ProdWorkorder/ProdWorkorderBomListVO.h"
#include "../mes-c4-prodmgmt/domain/vo/ProdWorkorder/GetProdWorkorderListVO.h"
#include "../mes-c4-prodmgmt/domain/vo/ProdWorkorder/AddProdWorkorderVO.h"

#include "../mes-c4-prodmgmt/domain/query/ProdWorkorder/GetProdWorkorderListQuery.h"

#include "../mes-c4-prodmgmt/domain/dto/ProdWorkorder/AddProdWorkorderDTO.h"
#include "../mes-c4-prodmgmt/domain/dto/ProdWorkorder/ProdWorkorderInfoDTO.h"
#include "../mes-c4-prodmgmt/domain/dto/ProdWorkorder/ProdWorkorderBomListDTO.h"
#include "../mes-c4-prodmgmt/domain/dto/ProdWorkorder/GetProdWorkorderListDTO.h"

class ProdWorkorderService {
public:
	// 获取生产工单详情
	ProdWorkorderInfoDTO::Wrapper listDetail(const ProdWorkorderInfoDTO::Wrapper& dto);
	//获取生产工单BOM组成列表(条件+分页)
	ProdWorkorderBomListDTO::Wrapper listBomDetail(const ProdWorkorderBomListDTO::Wrapper& dto);
	//获取生产工单列表(条件+分页)
	GetProdWorkorderListDTO::Wrapper listAll(const GetProdWorkorderListQuery::Wrapper& query);
	//添加生产工单
	uint64_t saveData(const AddProdWorkorderDTO::Wrapper& dto);
};



#endif // !_PRODWORKORDER_SERVICE_