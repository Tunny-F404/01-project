#pragma once

#include "stdafx.h"
#include "GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(ApiController)

namespace controller {

	class ApprovalController : public oatpp::web::server::api::ApiController {
	public:
		APPROVAL_CONTROLLER_INIT(ApprovalController);

	public: // Endpoints
		ENDPOINT("POST", "/api/approvals/submit", submitApproval);
		ENDPOINT("POST", "/api/approvals/approve", approveApproval);
		ENDPOINT("POST", "/api/approvals/reject", rejectApproval);

	private: // Handler methods
		Action submitApproval() override;
		Action approveApproval() override;
		Action rejectApproval() override;
	};

}

#include OATPP_CODEGEN_END(ApiController)