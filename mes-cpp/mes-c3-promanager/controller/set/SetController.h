#pragma once
#ifndef _SET_CONTROLLER_
#define _SET_CONTROLLER_

#include "domain/vo/BaseJsonVO.h"
#include "ApiHelper.h"
#include "ServerInfo.h"
//#include "domain/vo/set/DownloadFileVO.h"

#include OATPP_CODEGEN_BEGIN(ApiController)

/**
 * 文件操作示例接口
 */
class SetController : public oatpp::web::server::api::ApiController
{
	// 定义控制器访问入口
	API_ACCESS_DECLARE(SetController);
public:

	// 定义一个文件下载接口
	// 定义描述
	ENDPOINT_INFO(downloadFile) {
		API_DEF_ADD_COMMON(ZH_WORDS_GETTER("set.download.summary"), Void);
		API_DEF_ADD_QUERY_PARAMS(String, "filename", ZH_WORDS_GETTER("set.field.filename"), "file/test.jpg", true);
	}
	// 定义端点
	ENDPOINT(API_M_GET, "/file/download", downloadFile, QUERY(String, filename)) {
		return execDownloadFile(filename);
	}

private: // 定义接口执行函数	
	// 执行文件下载处理
	std::shared_ptr<OutgoingResponse> execDownloadFile(const String& filename);

};


#include OATPP_CODEGEN_END(ApiController)

#endif // !_FILECONTROLLER_H_