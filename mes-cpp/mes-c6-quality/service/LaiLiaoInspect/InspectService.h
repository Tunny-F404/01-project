#pragma once
#ifndef _INSPECT_SERVICE_
#define _INSPECT_SERVICE_
#include <list>
#include "domain/vo/LaiLiaoInspect/InspectVO.h"
#include "domain/query/LaiLiaoInspect/InspectQuery.h"
#include "domain/dto/LaiLiaoInspect/InspectDTO.h"

/**
 * 物料信息的服务操作
 */
class InspectService
{
public:
	// 分页查询来料检验列表
	InspectPageDTO::Wrapper listAll(const InspectQuery::Wrapper& query);
	// 分页查询来料检验表详情
	Inspect_detailPageDTO::Wrapper list_detailAll(const Inspect_detailQuery::Wrapper& query);
	// 保存数据
	uint64_t saveData(const InspectDTO::Wrapper& dto);
	// 修改数据
	bool updateData(const InspectDTO::Wrapper& dto);
	// 通过ID删除数据
	bool removeData(uint64_t id);
};

#endif // !_INSPECT_SERVICE_
