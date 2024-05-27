#include "stdafx.h"
#include "SetController.h"
#include "../../service/set/ProcessExportService.h"
#include "Macros.h"
#include "ExcelComponent.h"

// 注意：用到FastDfs的地方都要在最后在导入DFS的头文件
#include "ServerInfo.h"
#include "NacosClient.h"
#include "FastDfsClient.h"

// 1 导出工序
StringJsonVO::Wrapper SetController::execProcessExport(const ProcessExportQuery::Wrapper& query)
{
	// 定义一个Service
	ProcessExportService service;
	// 查询数据
	list<SetProAddTableDTO::Wrapper> result = service.listAll(query);
	std::vector<std::vector<std::string>> data;

	// DTO数据转换为vector
	for (auto sub : result) {
		std::vector<std::string> tmp;
		tmp.emplace_back(sub->processCode);
		tmp.emplace_back(sub->processName);
		tmp.emplace_back(sub->attention);
		tmp.emplace_back(sub->enableFlag);
		data.emplace_back(tmp);
	}

	// 插入表头
	data.insert(data.begin(), {
		ZH_WORDS_GETTER("excel.header.h1"),
		ZH_WORDS_GETTER("excel.header.h2"),
		ZH_WORDS_GETTER("excel.header.h3"),
		ZH_WORDS_GETTER("excel.header.h4"),
		});

	// 保存到文件
	std::string fileName = "./public/excel/process.xlsx";
	std::string sheetName = ZH_WORDS_GETTER("excel.sheet.s1");
	ExcelComponent excel;
	excel.writeVectorToFile(fileName, sheetName, data);

	// 文件上传---下面没有用宏定义去写
	//// 定义一个Nacos客户端对象，用于获取配置
	//NacosClient ns("192.168.186.137:8848", "4833404f-4b82-462e-889a-3c508160c6b4");
	//// DFS客户端连接对象
	//FastDfsClient* client = nullptr;
	//// 文件下载地址前缀
	//std::string urlPrefix = "";
	//// 声明一个上传文件的文件名
	//std::string filename = "";
	//// 定义一个临时变量用于存储上次上传成功后的文件field名称
	//std::string tmpField = "";
	//// 读取配置数据节点
	//auto thirdServerConfig = ns.getConfig("./conf/third-services.yaml");
	//// +FastDFS客户端配置数据
	//std::string ipPort = YamlHelper().getString(&thirdServerConfig, "fastdfs.tracker-servers");
	//std::string ip = ipPort.substr(0, ipPort.find(":"));
	//int port = stoi(ipPort.substr(ipPort.find(":") + 1));
	//// 设置客户端对象
	//client = new FastDfsClient(ip, port);
	//// 设置一个文件上传地址
	//filename = "./public/excel/process.xlsx";
	//// 设置url前缀
	//urlPrefix = "http://" + YamlHelper().getString(&thirdServerConfig, "fastdfs.nginx-servers") + "/";
	//tmpField = client->uploadFile(filename);
	//// 输出文件下载地址
	//std::string downloadUrl = urlPrefix + tmpField;
	//std::cout << "download url: " << downloadUrl << std::endl;

	std::string filename = "";
	filename = "./public/excel/process.xlsx";
	// 创建一个fastdfs对象及前缀
	ZO_CREATE_DFS_CLIENT_URL(dfs, urlPrefix);
	// 获取文件后缀名
	string suffix = "";
	size_t pos = filename.rfind(".");
	if (pos != string::npos)
	{
		suffix = filename.substr(pos + 1);
	}
	// 上传文件
	string downloadUrl = dfs.uploadFile(filename);
	downloadUrl = urlPrefix + downloadUrl;
	OATPP_LOGD("Multipart", "download url='%s'", downloadUrl.c_str());

	// 响应结果
	auto jvo = StringJsonVO::createShared();
	if (downloadUrl != "") {
		jvo->success(downloadUrl);
	}
	else {
		jvo->fail(downloadUrl);
	}

	return jvo;
}
// 2 添加工艺
Uint64JsonVO::Wrapper SetController::execAddSet(const SetProAddTableDTO::Wrapper& dto)
{
	return {};
}
// 3 修改工艺
Uint64JsonVO::Wrapper SetController::execModifySet(const SetProAddTableDTO::Wrapper& dto)
{
	return {};
}
// 4 获取工艺步骤列表
SetProListPageJsonVO::Wrapper SetController::execQuerySet(const SetProListQuery::Wrapper& query, const PayloadDTO& payload) {
	return {};
}
// 5 添加工序步骤
Uint64JsonVO::Wrapper SetController::execAddStepSet(const SetProListDTO::Wrapper& dto)
{
	return {};
}
// 6 获取工序列表
ProListJsonVO::Wrapper SetController::execQueryProList(const ProListQuery::Wrapper& query)
{
	return ProListJsonVO::Wrapper();
}
// 7 获取工序名称列表
ProListJsonVO::Wrapper SetController::execQueryProNameList()
{
	return ProListJsonVO::Wrapper();
}
// 8 获取工序详情
ProDetailJsonVO::Wrapper SetController::execQueryProDetail(const ProDetailQuery::Wrapper& query)
{
	return ProDetailJsonVO::Wrapper();
}
// 9 修改工序步骤
Uint64JsonVO::Wrapper SetController::execModifyStepSet(const SetProListDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}
// 10 删除工序步骤
Uint64JsonVO::Wrapper SetController::execDeleteStepSet(const SetProListDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}
// 11 导出工序步骤
StringJsonVO::Wrapper SetController::execExportStepSet(const SetStepExportQuery::Wrapper& dto)
{
	return StringJsonVO::Wrapper();
}
// 12 删除工序
Uint64JsonVO::Wrapper SetController::execDeleteSet(const SetProAddTableDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}