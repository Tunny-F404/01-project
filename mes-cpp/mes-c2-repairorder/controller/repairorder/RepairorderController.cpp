/*
 * Copyright Zero One Star. All rights reserved.
 *
 * @Author: Heng_Xin
 * @Date: 2024/5/18 16:01:19
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * */
#include "stdafx.h"
#include "RepairorderController.h"

RepairorderPageJsonVO::Wrapper RepairorderController::execQueryRepairorder(const RepairorderQuery::Wrapper& query)
{
    return RepairorderPageJsonVO::Wrapper();
}

RepairorderDetailsJsonVO::Wrapper RepairorderController::execQueryDetailsRepairorder(const RepairorderDetailsQuery::Wrapper& id)
{
    return RepairorderDetailsJsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RepairorderController::execAddRepairorder(const RepairorderDetailsDTO::Wrapper& dto)
{
    return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RepairorderController::execModifyRepairorder(const RepairorderDetailsDTO::Wrapper& dto)
{
    return Uint64JsonVO::Wrapper();
}

Uint64JsonVO::Wrapper RepairorderController::execRemoveRepairorder(const DeleteMultipleRepairersDTO::Wrapper& id)
{
    return Uint64JsonVO::Wrapper();
}
