import http from "axios";
import type { AxiosResponse } from "axios";
import Request from "api/request";

import type { SimpleBaseController } from "types/SimpleBaseController";
import type { JsonVO } from "types/JsonVO";

/** 单位相关操作 */
export interface MdUnitMeasureController extends SimpleBaseController {
	/** 删除单位 */
	deleteUnitMeasure(measureIds: number[]): Promise<AxiosResponse<JsonVO<string>>>;

	/** 根据单位ID获取单位信息 */
	getInfo(measureId: number): Promise<AxiosResponse<JsonVO<string>>>;
}

export const mdUnitMeasureController: MdUnitMeasureController = {
	RequestMapping: "/basicdata/md-unit-measure",

	deleteUnitMeasure(measureIds) {
		return Request.request(Request.DELETE, mdUnitMeasureController.RequestMapping, { measureIds }, http.upType.json);
	},

	getInfo(measureId) {
		return Request.request(
			Request.GET,
			`${mdUnitMeasureController.RequestMapping}/${measureId}`,
			{ measureId },
			http.upType.json,
		);
	},
};
