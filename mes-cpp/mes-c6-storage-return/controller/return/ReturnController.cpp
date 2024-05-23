#include "stdafx.h"
#include "ReturnController.h"
#include "oatpp/core/utils/ConversionUtils.hpp"
#include <iostream>
#include <sstream>
#include "tree/TreeUtil.h"
#include "service/return/ReturnService.h"
#include "../ApiDeclarativeServicesHelper.h"

// FastDFS需要导入的头
#include "ServerInfo.h"
#include "NacosClient.h"
#include "FastDfsClient.h"

ReturnPageJsonVO::Wrapper ReturnController::executeQueryAll(const ReturnQuery::Wrapper& query, const PayloadDTO& payload)
{
	return {};
}

ReturnDetailJsonVO::Wrapper ReturnController::executeQueryDetail(const ReturnDetailQuery::Wrapper& returnDetailQuery)
{
	return {};
}

Uint64JsonVO::Wrapper ReturnController::execAddDetail(const ReturnAdd::Wrapper& dto)
{
	return {};
}
// 修改单据
Uint64JsonVO::Wrapper ReturnController::executeModifyReturn(const ReturnDTO::Wrapper& dto)
{
	return {};
}
// 执行单据
Uint64JsonVO::Wrapper ReturnController::executeExecuteReturn(const UInt64& id)
{
	return {};
}
// 删除单据
Uint64JsonVO::Wrapper ReturnController::executeRemoveReturn(const UInt64& id)
{
	return {};
}
// 导出单据
std::shared_ptr<oatpp::web::server::api::ApiController::OutgoingResponse> ReturnController::executeDownloadFile(const String& filename)
{
	// 构建文件全路径 // 相对路径无法加载
	std::string fullPath = "C:/Users/RHY/Desktop/C6/zero-one-08mes/mes-cpp/mes-c6-storage-return/public/static/" + URIUtil::urlDecode(filename.getValue(""));
	// 读取文件
	auto fstring = String::loadFromFile(fullPath.c_str());

	// 判断是否读取成功
	if (!fstring)
	{
		std::cerr << "Failed to open file: " << std::strerror(errno) << std::endl;
		return createResponse(Status::CODE_404, "File Not Found");
	}

	// 创建响应头
	auto response = createResponse(Status::CODE_200, fstring);

	// 设置响应头信息
	response->putHeader("Content-Disposition", "attachment; filename=" + filename.getValue(""));

	// 影响成功结果
	return response;
}