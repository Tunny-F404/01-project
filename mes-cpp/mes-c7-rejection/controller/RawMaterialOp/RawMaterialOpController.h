#pragma once
#ifndef _RawMaterialOp_CONTROLLER_
#define _RawMaterialOp_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "ServerInfo.h"
#include "domain/dto/RawMaterialOp/RawMaterialOpDTO.h"
#include "domain/query/RawMaterialOpQuery.h"
#include "domain/vo/RawMaterialOpVO.h"
#include "ApiHelper.h"

// 0 定义API控制器使用宏
#include OATPP_CODEGEN_BEGIN(ApiController) //<- Begin

/**
 * 示例控制器，演示基础接口的使用
 */
class RawMaterialOpController : public oatpp::web::server::api::ApiController // 1 继承控制器
{
	// 2 定义控制器访问入口
	API_ACCESS_DECLARE(RawMaterialOpController);
	// 3 定义接口
public:

	// 定义删除单据接口描述
	ENDPOINT_INFO(removeRawMaterialOp)
	{
		// 定义标题和返回类型以及授权支持
		API_DEF_ADD_COMMON_AUTH(ZH_WORDS_GETTER("RawMaterialOp.delete.summary"), Uint64JsonVO::Wrapper);
		// 定义其他路径参数说明
		API_DEF_ADD_PATH_PARAMS(UInt64, "id", ZH_WORDS_GETTER("RawMaterialOp.field.id"), 1, true);
	}
	//定义删除单据接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_DEL, "/RawMaterialOp/{id}", removeRawMaterialOp, PATH(UInt64, id), execRemoveRawMaterialOp(id));


	// 3.1 定义修改接口描述
	API_DEF_ENDPOINT_INFO_AUTH(ZH_WORDS_GETTER("RawMaterialOp.put.summary"), modifyRawMaterialOp, Uint64JsonVO::Wrapper);
	// 3.2 定义修改接口处理
	API_HANDLER_ENDPOINT_AUTH(API_M_PUT, "/RawMaterialOp/{oprator}", modifyRawMaterialOp, BODY_DTO(RawMaterialOpDTO::Wrapper, dto), execModifyRawMaterialOp(dto));



	// 定义文件下载接口
	ENDPOINT_INFO(downloadFile) {
		API_DEF_ADD_COMMON(ZH_WORDS_GETTER("RawMaterialOp.file.download.summary"), Void);
		API_DEF_ADD_QUERY_PARAMS(String, "filename", ZH_WORDS_GETTER("RawMaterialOp.file.download.filename"), "file/test.jpg", true);
	}
	// 定义端点
	ENDPOINT(API_M_GET, "/file/download", downloadFile, QUERY(String, filename)) {
		return execDownloadFile(filename);
	}




private:
	// 删除生产退料单行列表（支持批量删除）
	Uint64JsonVO::Wrapper execRemoveRawMaterialOp(const UInt64& id);

	// 3.3 修改生产退料单行数据
	Uint64JsonVO::Wrapper execModifyRawMaterialOp(const RawMaterialOpDTO::Wrapper& dto);

	// 执行文件下载处理
	std::shared_ptr<OutgoingResponse> execDownloadFile(const String& filename);
};

// 0 取消API控制器使用宏
#include OATPP_CODEGEN_END(ApiController) //<- End Codegen
#endif // _SAMPLE_CONTROLLER_