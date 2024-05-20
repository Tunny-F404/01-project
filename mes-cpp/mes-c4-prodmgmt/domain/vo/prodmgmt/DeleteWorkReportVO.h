#pragma once

#ifndef _DELETEWORKREPORT_VO_H
#define _DELETEWORKREPORT_VO_H

#include "../../GlobalInclude.h"
#include "../../dto/prodmgmt/DeleteWorkReportDTO.h"
#include OATPP_CODEGEN_BEGIN(DTO)

/**
* 删除报工的显示VO
*/
class DeleteWorkReportVO : public JsonVO<DeleteWorkReportDTO::Wrapper>
{
	DTO_INIT(DeleteWorkReportVO, JsonVO<DeleteWorkReportDTO::Wrapper>);
public:
	DeleteWorkReportVO() {
		this->data = {};
	}
};

#include OATPP_CODEGEN_END(DTO)

#endif // _DELETEWORKREPORT_VO_H