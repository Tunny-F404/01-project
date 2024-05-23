/*
 Copyright Zero One Star. All rights reserved.

 @Author: xinye
 @Date: 2024/5/22 23:00:00

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
/*
#include "stdafx.h"
#include "WmItemRecptController.h"

Uint64JsonVO::Wrapper WmItemRecptController::execWarehouseInbound(const WarehouseInboundDTO::Wrapper& dto)
{
    return {};
}

Uint64JsonVO::Wrapper WmItemRecptController::execRemoveWmItemRecpt(const UInt64& id)
{
    return {};
}

std::shared_ptr<oatpp::web::server::api::ApiController::OutgoingResponse> WmItemRecptController::execExportWmItemRecpt(const String& filename)
{
	/*

	// 构建文件全路径
	std::string fullPath = "public/static/" + URIUtil::urlDecode(filename.getValue(""));

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
		*/
/*
	return {};
}
*/