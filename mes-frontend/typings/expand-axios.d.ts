import axios from "axios";

// AxiosRequestConfig

declare module "axios" {
	interface AxiosStatic {
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
		httpcode: {
			UNAUTHORIZED: number;
			FORBIDDEN: number;
			NOT_FOUND: number;
			SERVER_ERROR: number;
			PARAMS_INVALID: number;
			CONTENT_TYPE_ERR: number;
			API_UN_IMPL: number;
			SERVER_BUSY: number;
			FAIL: number;
			SUCCESS: number;
		};
	}

	namespace Axios {}
}
