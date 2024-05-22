#pragma once
#ifndef _PROWORKORDER_CONTROLLER_
#define _PROWORKORDER_CONTROLLER_
#include "domain/vo/BaseJsonVO.h"
#include "../mes-c4-prodmgmt/domain/vo/ProdWorkorder/ModifyProWorkorderVO.h"
#include "../mes-c4-prodmgmt/domain/dto/ProdWorkorder/ModifyProWorkorderDTO.h"

#include "../mes-c4-prodmgmt/domain/dto/ProdWorkorder/DeleteProWorkorderDTO.h"
#include "../mes-c4-prodmgmt/domain/vo/ProdWorkorder/DeleteProWorkorderVO.h"


// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin Codegen

/**
 * 生产工单
 */
class ProWorkorderController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(ProWorkorderController);
	// 3 定义接口
public:
	// 3.1 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("ProdWorkorder.put.summary"), modifyProWorkorder, ModifyProWorkorderJsonVO::Wrapper);
	// 3.2 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/ProdWorkorder/modify", modifyProWorkorder, BODY_DTO(ModifyProWorkorderDTO::Wrapper, dto), execModifyProWorkdorder(dto));

	// 3.1 定义删除接口描述
	ENDPOINT_INFO(removeProWorkorder) {
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("ProdWorkorder.delete.summary"), DeleteProWorkorderJsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "workorderId", ZH_WORDS_GETTER("ProdWorkorder.field.workorderId"), 1, true);
	}
	// 3.2 定义删除接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/ProdWorkorder/{workorderId}", removeProWorkorder, PATH(UInt64, workorderId), execRemoveProWorkorder(workorderId));


private:
	// 3.3 演示修改数据
	Uint64JsonVO::Wrapper execModifyProWorkdorder(const ModifyProWorkorderDTO::Wrapper& dto);

	// 3.3 演示删除数据
	Uint64JsonVO::Wrapper execRemoveProWorkorder(const UInt64& workorderId);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _PROWORKORDER_CONTROLLER_