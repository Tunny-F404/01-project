#include "stdafx.h"
#include "Single_Defect_Controller.h"
#include "../../service/Single_Defect/Single_Defect_Service.h"
#include "../ApiDeclarativeServicesHelper.h"

SinglePageJsonVO::Wrapper Single_Defect_Controller::execQuerySingle(const SingleQuery::Wrapper& query, const PayloadDTO& payload)
{
	return{};
}

DefectPageJsonVO::Wrapper Single_Defect_Controller::execQueryDefect(const DefectQuery::Wrapper& query, const PayloadDTO& payload)
{
	return{};
}

Uint64JsonVO::Wrapper Single_Defect_Controller::execAddDefect(const DefectDTO::Wrapper& dto)
{
	return{};
}

Uint64JsonVO::Wrapper Single_Defect_Controller::execModifyDefect(const DefectDTO::Wrapper& dto)
{
	return{};
}

Uint64JsonVO::Wrapper Single_Defect_Controller::execRemoveDefect(const UInt64& id)
{
	return{};
}



