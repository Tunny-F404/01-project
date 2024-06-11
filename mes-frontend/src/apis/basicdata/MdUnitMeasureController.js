import Request from "api/request";
import http from "axios";
// import {  }  from "@/plugins/https";

/** 删除单位 */
export function deleteUnitMeasure({ measureIds, success = () => {}, fail = () => {} }) {
	return Request.request(
		Request.DELETE,
		"/basicdata/md-unit-measure/delete-by-measureIds",
		{
			measureIds,
		},
		http.upType.json,
	)
		.then((res) => {
			if (res.status === 200) {
				success(res);
			} else {
				fail("shibai1");
			}
		})
		.catch((err) => {
			fail(err);
		});
}
