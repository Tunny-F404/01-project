#pragma once
#ifndef _DETECTIONTEMPLATE_DAO_
#define _DETECTIONTEMPLATE_DAO_
#include "BaseDAO.h"
#include "../../domain/do/DetectionTemplate/DetectionTemplateDO.h"
#include "../../domain/query/detectiontemplate/DetectionTemplateQuery.h"
/**
 * 示例表数据库操作实现
 */
class DetectionTemplateDAO : public BaseDAO
{
public:

	// 通过ID删除数据
	//int deleteById(uint64_t id);
	// 统计检测模板数据条数
	uint64_t count(const DetectionTemplateQuery::Wrapper& query);
	// 检测模板列表函数, 分页查询数据
	//list<DetectionTemplateDO> selectTemplateListWithPage(const DetectionTemplateQuery::Wrapper& query);
	// 插入数据
	//uint64_t insert(const DetectionTemplateDO& iObj);
};
#endif // !_Ddt_DAO_