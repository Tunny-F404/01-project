#include "stdafx.h"
#include "EquipmentController.h"
#include "../../domain/vo/equipment/EquipmentTypeTreeVO.h"
#include "domain/do/equipment/EquipmentTypeDO.h"
#include "tree/TreeUtil.h"
#include "service/equipment/TreeEquipmentTypeMapper.h"
#include "service/equipment/EquipmentService.h"

EquipmentTypeTreeVO::Wrapper EquipmentController::executeGetEquipmentTypeTree(const PayloadDTO& payload)
{
	// 定义一个JsonVO对象
	auto vo = EquipmentTypeTreeVO::createShared();
	// 创建模拟设备类型数据（此数据应来源于数据库）
	list<EquipmentTypeDO> listData;
	listData.push_back(EquipmentTypeDO("1", "M_TYPE_000", u8"系统管理", '0', "/sm", ""));
	listData.push_back(EquipmentTypeDO("2", "M_TYPE_001", u8"用户管理", '0', "/sm/um", "1"));
	listData.push_back(EquipmentTypeDO("3", "M_TYPE_002", u8"角色管理", '0', "/sm/rm", "1"));
	listData.push_back(EquipmentTypeDO("4", "M_TYPE_003", u8"菜单管理", '0', "/sm/mm", "1"));
	listData.push_back(EquipmentTypeDO("5", "M_TYPE_004", u8"订单管理", '1', "/om", ""));
	listData.push_back(EquipmentTypeDO("6", "M_TYPE_005", u8"入库订单", '1', "/om/em", "5"));
	listData.push_back(EquipmentTypeDO("7", "M_TYPE_006", u8"出库订单", '1', "/om/om", "5"));
	listData.push_back(EquipmentTypeDO("8", "M_TYPE_007", u8"销售订单", '1', "/om/sm", "5"));
	listData.push_back(EquipmentTypeDO("9", "M_TYPE_008", u8"订单统计", '1', "/om/sm/t1", "8"));
	listData.push_back(EquipmentTypeDO("10", "M_TYPE_009", u8"订单报表", '1', "/om/sm/t2", "8"));
	// 转换为树形结构
	list<shared_ptr<TreeNode>> res = TreeUtil::listToTree<EquipmentTypeDO>(listData, TreeEquipmentMapper());
	// 将根节点存储到列表中
	for (auto one : res)
	{
		vo->data->push_back(EquipmentTypeDTO::Wrapper(dynamic_pointer_cast<EquipmentTypeDTO>(one), EquipmentTypeDTO::Wrapper::Class::getType()));
	}
	return vo;
}

EquipmentPageVO::Wrapper EquipmentController::execGetEquipmentList(const EquipmentQuery::Wrapper& query, const PayloadDTO& payload)
{
	// 定义一个Service
	EquipmentService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = EquipmentPageVO::createShared();
	jvo->success(result);
	return jvo;
}


