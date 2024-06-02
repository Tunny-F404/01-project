import axios from "axios";
import type { AxiosRequestConfig, AxiosStatic } from "axios";

/** 这是阿伟学长预设好的全局http状态码 */
interface HttpConfig {
	/** 数据上传数据类型 */
	upType: {
		/** 表单类型 */
		form: 0;

		/** json类型 */
		json: 1;

		/** 文件类型 */
		file: 3;

		/** 文件流类型 */
		stream: 4;
	};

	/** HTTP状态码 */
	httpcode: {
		/** 暂未登录或TOKEN已经过期 */
		UNAUTHORIZED: 401;

		/** 没有相关权限 */
		FORBIDDEN: 403;

		/** 访问页面未找到 */
		NOT_FOUND: 404;

		/** 服务器错误 */
		SERVER_ERROR: 9994;

		/** 上传参数异常 */
		PARAMS_INVALID: 9995;

		/** ContentType错误 */
		CONTENT_TYPE_ERR: 9996;

		/** 功能尚未实现 */
		API_UN_IMPL: 9997;

		/** 服务器繁忙 */
		SERVER_BUSY: 9998;

		/** 操作失败 */
		FAIL: 9999;

		/** 操作成功 */
		SUCCESS: 10000;
	};
}

declare module "axios" {
	interface AxiosStatic extends HttpConfig {}

	interface AxiosRequestConfig extends HttpConfig {}
}
