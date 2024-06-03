#include "stdafx.h"
#include "MergeMenuController.h"
#include "oatpp/core/utils/ConversionUtils.hpp"
#include <iostream>
#include <sstream>
MergeMenuJsonVO::Wrapper MergeMenuController::executeQueryMergeMenu(const PayloadDTO& payload) {
	auto vo = MergeMenuJsonVO::createShared();
	//×ª»»ÎªÊ÷×´
	//list<shared_ptr<TreeNode>> res = TreeUtil::listToTree<MenuDO>(listData, TreeMenuMapper());
	return {};
}

