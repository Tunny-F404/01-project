#include "stdafx.h"
#include "RawMaterialOpController.h"
#include "../../service/RawMaterialOpService/RawMaterialOpService.h"
#include "../ApiDeclarativeServicesHelper.h"



Uint64JsonVO::Wrapper RawMaterialOpController::execRemoveRawMaterialOp(const UInt64& id)
{
	return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RawMaterialOpController::execModifyRawMaterialOp(const RawMaterialOpDTO::Wrapper& dto)
{
	// 定义返回数据对象
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}

std::shared_ptr<oatpp::web::server::api::ApiController::OutgoingResponse> RawMaterialOpController::execDownloadFile(const String& filename)
{
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
}
