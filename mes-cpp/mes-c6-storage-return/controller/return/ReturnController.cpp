/*
 Copyright Zero One Star. All rights reserved.

 @Author: awei
 @Date: 2023/02/20 16:29:31

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

/**
 * 注意：这里的部分代码本应该放到service层中，为了方便演示就写在一起了
 */

ReturnPageJsonVO::Wrapper ReturnController::executeQueryAll(const ReturnQuery::Wrapper& query)
{
	// 定义一个JsonVO对象
	auto vo = ReturnPageJsonVO::createShared();
	// 定义一个分页对象
	auto page = ReturnPageDTO::createShared();
	page->pageIndex = query->pageIndex;
	page->pageSize = query->pageSize;
	page->total = 20;
	page->calcPages();

	// 模拟计算分页数据
	int64_t start = (page->pageIndex.getValue(1) - 1) * page->pageSize.getValue(1);
	int64_t end = start + page->pageSize.getValue(1);
	// 边界值值处理
	if (start >= page->total.getValue(0) || start < 0) {
		vo->fail(page);
		return vo;
	}
	if (end > page->total.getValue(0)) end = page->total.getValue(0);
	// 循环生成测试数据
	for (int64_t i = start; i < end; i++)
	{
		auto return1 = ReturnDTO::createShared();
		return1->returnId = query->returnId;
		return1->returnName = "returnName";
		return1->purchaseId = "12345678901234567" + oatpp::utils::conversion::uint64ToStdStr(i);
		return1->vendorCode = "12345678901234567" + oatpp::utils::conversion::uint64ToStdStr(i);
		return1->vendorName = "vendorName";
		return1->returndate = "2024-5-21";
		return1->status = 0;
		page->addData(return1);
	}
	vo->success(page);
	return vo;
}

Uint64JsonVO::Wrapper ReturnController::executeModifyReturn(const ReturnDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	if (!dto->returnId || dto->returnId <= 0)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 定义一个Service
	ReturnService service;
	// 执行数据修改
	// if (service.updateData(dto))  //需要dao支持，还未定义
	if(true)//直接响应
	{
		jvo->success(dto->returnId);
	}
	else
	{
		jvo->fail(dto->returnId);
	}
	// 响应结果
	return jvo;
}

Uint64JsonVO::Wrapper ReturnController::executeRemoveReturn(const UInt64& id)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	// 参数校验
	if (!id || id <= 0)
	{
		jvo->init(UInt64(-1), RS_PARAMS_INVALID);
		return jvo;
	}
	// 定义一个Service
	ReturnService service;
	// 执行数据删除
	// if (service.removeData(id.getValue(0))) 

	if(true)
	{
		jvo->success(id);
	}
	else
	{
		jvo->fail(id);
	}
	// 响应结果
	return jvo;
}

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
