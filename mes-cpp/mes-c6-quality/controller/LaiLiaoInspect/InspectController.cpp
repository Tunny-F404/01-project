#include "stdafx.h"
#include "InspectController.h"
#include "../../service/LaiLiaoInspect/InspectService.h"
#include "../ApiDeclarativeServicesHelper.h"

InspectPageJsonVO::Wrapper InspectController::execQueryInspect(const InspectQuery::Wrapper& query, const PayloadDTO& payload)
{
	return {};
}
Inspect_detailPageJsonVO::Wrapper InspectController::execQueryInspect_detail(const Inspect_detailQuery::Wrapper& query, const PayloadDTO& payload)
{
	return {};
}

StringJsonVO::Wrapper InspectController::execLookTable(const oatpp::List<UInt64>& ids)
{
	return StringJsonVO::Wrapper();
}


Uint64JsonVO::Wrapper InspectController::execAddInspect(const InspectDTO::Wrapper& dto)
{
	
	return {};
}

Uint64JsonVO::Wrapper InspectController::execModifyInspect(const InspectDTO::Wrapper& dto)
{
	
	return {};
}

Uint64JsonVO::Wrapper InspectController::execRemoveInspect(const UInt64& id)
{
	
	return {};
}

StringJsonVO::Wrapper InspectController::execExportInspect(const oatpp::List<UInt64>& ids)
{
	return StringJsonVO::Wrapper();
}

Uint64JsonVO::Wrapper InspectController::execIs_OkInspect(const Item_idDTO::Wrapper& dto)
{
	return{};
}

Uint64JsonVO::Wrapper InspectController::execIs_FinishedInspect(const Item_idDTO::Wrapper& dto)
{
	return{};
}
