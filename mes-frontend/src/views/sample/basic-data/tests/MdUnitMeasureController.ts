import Request from "api/request";

import type { SimpleBaseController } from "types/SimpleBaseController";
import type { JsonVO } from "types/JsonVO";

// export class MdUnitMeasureController extends SimpleBaseController {
// 	public static RequestMapping: "/basicdata/md-unit-measure";
// }

export interface MdUnitMeasureController extends SimpleBaseController {
	deleteUnitMeasure(measureIds: number[]): Promise<JsonVO<string>>;
}

export const mdUnitMeasureController: MdUnitMeasureController = {
	RequestMapping: "/basicdata/md-unit-measure",

	deleteUnitMeasure() {
		return Request.request(Request.DELETE, mdUnitMeasureController.RequestMapping, { measureIds: [1, 2] });
	},
};
