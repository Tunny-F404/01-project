#pragma once
/*
 Copyright Zero One Star. All rights reserved.

 @Author: xinye
 @Date: 2024/5/22 20:00:00

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
#ifndef _WM_ITEM_RECPT_DO_
#define _WM_ITEM_RECPT_DO_
#include "../DoInclude.h"

/**
 * 物料入库单数据表对应的实体类
 */
class WmItemRecptDO
{
    // 入库单编号: recpt_id
    CC_SYNTHESIZE(int, recpt_id, Recpt_id);
    // 入库单代码: recpt_code
    CC_SYNTHESIZE(string, recpt_code, Recpt_code);
    // 入库单名称: recpt_name
    CC_SYNTHESIZE(string, recpt_name, Recpt_name);
    // 来料检验单ID: iqc_id
    CC_SYNTHESIZE(optional<int>, iqc_id, Iqc_id);
    // 来料检验单代码: iqc_code
    CC_SYNTHESIZE(optional<string>, iqc_code, Iqc_code);
    // 采购订单编号: po_code
    CC_SYNTHESIZE(optional<string>, po_code, Po_code);
    // 供应商ID: vendor_id
    CC_SYNTHESIZE(int, vendor_id, Vendor_id);
    // 供应商代码: vendor_code
    CC_SYNTHESIZE(string, vendor_code, Vendor_code);
    // 供应商名称: vendor_name
    CC_SYNTHESIZE(string, vendor_name, Vendor_name);
    // 供应商简称: vendor_nick
    CC_SYNTHESIZE(string, vendor_nick, Vendor_nick);
    // 仓库ID: warehouse_id
    CC_SYNTHESIZE(optional<int>, warehouse_id, Warehouse_id);
    // 仓库代码: warehouse_code
    CC_SYNTHESIZE(optional<string>, warehouse_code, Warehouse_code);
    // 仓库名称: warehouse_name
    CC_SYNTHESIZE(optional<string>, warehouse_name, Warehouse_name);
    // 库区ID: warehouse_area_id
    CC_SYNTHESIZE(optional<int>, warehouse_area_id, Warehouse_area_id);
    // 库区代码: warehouse_area_code
    CC_SYNTHESIZE(optional<string>, warehouse_area_code, Warehouse_area_code);
    // 库区名称: warehouse_area_name
    CC_SYNTHESIZE(optional<string>, warehouse_area_name, Warehouse_area_name);
    // 库位ID: warehouse_location_id
    CC_SYNTHESIZE(optional<int>, warehouse_location_id, Warehouse_location_id);
    // 库位代码: warehouse_location_code
    CC_SYNTHESIZE(optional<string>, warehouse_location_code, Warehouse_location_code);
    // 库位名称: warehouse_location_name
    CC_SYNTHESIZE(optional<string>, warehouse_location_name, Warehouse_location_name);
    // 入库日期: recpt_date
    CC_SYNTHESIZE(string, recpt_date, Recpt_date);
    // 单据状态: status
    CC_SYNTHESIZE(string, status, Status);
    // 备注: remark
    CC_SYNTHESIZE(optional<string>, remark, Remark);
    // 属性1: attr1
    CC_SYNTHESIZE(optional<string>, attr1, Attr1);
    // 属性2: attr2
    CC_SYNTHESIZE(optional<string>, attr2, Attr2);
    // 属性3: attr3
    CC_SYNTHESIZE(optional<string>, attr3, Attr3);
    // 属性4: attr4
    CC_SYNTHESIZE(optional<string>, attr4, Attr4);
    // 创建人: create_by
    CC_SYNTHESIZE(string, create_by, Create_by);
    // 创建时间: create_time
    CC_SYNTHESIZE(string, create_time, Create_time);
    // 更新人: update_by
    CC_SYNTHESIZE(optional<string>, update_by, Update_by);
    // 更新时间: update_time
    CC_SYNTHESIZE(optional<string>, update_time, Update_time);
public:
    WmItemRecptDO()
    {
        recpt_id = 0;
        recpt_code = "";
        recpt_name = "";
        iqc_id = std::nullopt;
        iqc_code = std::nullopt;
        po_code = std::nullopt;
        vendor_id = 0;
        vendor_code = "";
        vendor_name = "";
        vendor_nick = "";
        warehouse_id = std::nullopt;
        warehouse_code = std::nullopt;
        warehouse_name = std::nullopt;
        warehouse_area_id = std::nullopt;
        warehouse_area_code = std::nullopt;
        warehouse_area_name = std::nullopt;
        warehouse_location_id = std::nullopt;
        warehouse_location_code = std::nullopt;
        warehouse_location_name = std::nullopt;
        recpt_date = "";
        status = "PREPARE";
        remark = std::nullopt;
        attr1 = std::nullopt;
        attr2 = std::nullopt;
        attr3 = std::nullopt;
        attr4 = std::nullopt;
        create_by = "";
        create_time = "";
        update_by = std::nullopt;
        update_time = std::nullopt;
    }
};

#endif // !_WM_ITEM_RECPT_DO_
