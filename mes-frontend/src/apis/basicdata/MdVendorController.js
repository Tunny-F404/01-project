import Request from "api/request";
import http from "axios";

/** 添加供应商 */
export function addVendor({ vendorAddDTO, success = () => {}, fail = () => {} }) {
	return Request.request(Request.POST, "/basicdata/md-vendor/add-vendor", { vendorAddDTO }, http.upType.json)
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

/** 导入供应商 */
export function importVendors({ MultipartFile, success = () => {}, fail = () => {} }) {
	return Request.request(Request.POST, "/basicdata/md-vendor/importVendors", { MultipartFile }, http.upType.file)
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
