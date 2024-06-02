/**
 * 简单基础 Controller 接口
 * @author f1-阮喵喵
 * @description
 * ### *设计理由*
 *
 * 用于约束任意业务用的 Controller 类，约束其在配置声明异步接口时，所必须要提供的属性
 *
 */
export interface SimpleBaseController {
	/**
	 * 接口请求的路径
	 * @description
	 * 就是后端的 `@RequestMapping` 注解
	 */
	RequestMapping: string;
}
