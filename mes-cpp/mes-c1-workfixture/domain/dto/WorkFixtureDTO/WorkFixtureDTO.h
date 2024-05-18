#pragma once
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 工装夹具列表数据模型（只包含关键数据）
 */
class WorkFixtureTableDTO : public oatpp::DTO
{
	DTO_INIT(WorkFixtureTableDTO, DTO);
	// 工装夹具唯一标识（注：唯一标识的获取需要和其他模块交互，调用外部接口）
	API_DTO_FIELD(UInt64, toolId, ZH_WORDS_GETTER("workfixture.fields.id"), true, 1);
	// 工装夹具编号
	API_DTO_FIELD(String, toolCode, ZH_WORDS_GETTER("workfixture.fields.code"), false, "");
	// 工装夹具名称
	API_DTO_FIELD(String, toolName, ZH_WORDS_GETTER("workfixture.fields.name"), true, "");
	// 品牌
	API_DTO_FIELD(String, brand, ZH_WORDS_GETTER("workfixture.fields.brand"), false, "");
	// 型号
	API_DTO_FIELD(String, spec, ZH_WORDS_GETTER("workfixture.fields.spec"), false, "");
	// 工装夹具类型
	API_DTO_FIELD(String, toolType, ZH_WORDS_GETTER("workfixture.fields.type"), true, "");
	// 数量（库存）
	API_DTO_FIELD(Int32, quantity, ZH_WORDS_GETTER("workfixture.fields.quantity"), true, 0);
};

/**
 * 工装夹具分页传输对象
 */
class WorkFixturePageDTO : public PageDTO<WorkFixtureTableDTO::Wrapper>
{
	DTO_INIT(WorkFixturePageDTO, PageDTO<WorkFixtureTableDTO::Wrapper>);
};

/**
 * 工装夹具详情数据模型
 */
class WorkFixtureDetailDTO : public WorkFixtureTableDTO
{
	DTO_INIT(WorkFixtureDetailDTO, WorkFixtureTableDTO);
	// 可用数量
	API_DTO_FIELD(Int32, availCount, ZH_WORDS_GETTER("workfixture.fields.aquantity"), false, 0);
	// 保养维护类型
	API_DTO_FIELD(String, maintenType, ZH_WORDS_GETTER("workfixture.fields.mtype"), false, "");
	// 下次保养周期
	API_DTO_FIELD(Int32, nextMaintenPeriod, ZH_WORDS_GETTER("workfixture.fields.mperiod"), false, 0);
	// 下次保养日期
	API_DTO_FIELD(String, nextMaintenDate, ZH_WORDS_GETTER("workfixture.fields.mdate"), false, "");
	// 状态
	API_DTO_FIELD(String, status, ZH_WORDS_GETTER("workfixture.fields.status"), false, "");
	// 备注
	API_DTO_FIELD(String, remark, ZH_WORDS_GETTER("workfixture.fields.remark"), false, "");
};

#include OATPP_CODEGEN_END(DTO)