import { defineStore } from "pinia";
import Request from "@/apis/request";
// 测试菜单数据
const testMenus = [
	{
		id: 1,
		text: "基础数据",
		icon: "IconFolder",
		children: [
			{
				id: 2,
				text: "物料产品分类",
				href: "/un-1",
				icon: "IconSetting",
				pid: 1,
			},
			{
				id: 3,
				text: "物料产品管理",
				href: "/un-2",
				icon: "IconSetting",
				pid: 1,
			},
			{
				id: 4,
				text: "计量单位",
				href: "/un-3",
				icon: "IconSetting",
				pid: 1,
			},
			{
				id: 5,
				text: "客户管理",
				href: "/un-4",
				icon: "IconSetting",
				pid: 1,
			},
			{
				id: 6,
				text: "供应商管理",
				href: "/un-5",
				icon: "IconSetting",
				pid: 1,
			},
			{
				id: 7,
				text: "车间设置",
				href: "/un-6",
				icon: "IconSetting",
				pid: 1,
			},
			{
				id: 8,
				text: "工作站",
				href: "/un-7",
				icon: "IconSetting",
				pid: 1,
			},
		],
	},
	{
		id: 2,
		text: "生产管理",
		icon: "IconUser",
		children: [
			{
				id: 2,
				text: "生产工单",
				href: "/un-11",
				icon: "IconUser",
				pid: 2,
			},
			{
				id: 3,
				text: "工序设置",
				href: "/un-12",
				icon: "IconUser",
				pid: 2,
			},
			{
				id: 4,
				text: "用户管理3",
				href: "/un-13",
				icon: "IconUser",
				pid: 2,
			},
			{
				id: 5,
				text: "用户管理4",
				href: "/un-14",
				icon: "IconUser",
				pid: 2,
			},
			{
				id: 6,
				text: "用户管理5",
				href: "/un-15",
				icon: "IconUser",
				pid: 2,
			},
		],
	},
	{
		id: 3,
		text: "订单管理",
		icon: "IconTickets",
		children: [
			{
				id: 2,
				text: "订单管理1",
				href: "/un-21",
				icon: "IconTickets",
				pid: 3,
			},
			{
				id: 3,
				text: "订单管理2",
				href: "/un-22",
				icon: "IconTickets",
				pid: 3,
			},
			{
				id: 4,
				text: "订单管理3",
				href: "/un-23",
				icon: "IconTickets",
				pid: 3,
			},
			{
				id: 5,
				text: "订单管理4",
				href: "/un-24",
				icon: "IconTickets",
				pid: 3,
			},
			{
				id: 6,
				text: "订单管理5",
				href: "/un-25",
				icon: "IconTickets",
				pid: 3,
			},
		],
	},
	// 仓库管理侧边栏
	// views/warehouse-management
	{
		id: 4,
		text: "仓库管理",
		icon: "Management",
		children: [
			{
				id: 2,
				text: "仓库管理",
				href: "/un-31",
				icon: "Management",
				pid: 4,
			},
			{
				id: 3,
				text: "采购入库",
				href: "/un-32",
				icon: "Management",
				pid: 4,
			},
			{
				id: 4,
				text: "采购退货",
				href: "/un-33",
				icon: "Management",
				pid: 4,
			},
			{
				id: 5,
				text: "生产领料",
				href: "/un-34",
				icon: "Management",
				pid: 4,
			},
			{
				id: 6,
				text: "订单管理5",
				href: "/un-35",
				icon: "Management",
				pid: 4,
			},
		],
	},
	{
		id: 5,
		text: "质量管理",
		icon: "IconTickets",
		children: [
			{
				id: 2,
				text: "常见缺陷",
				href: "/un-51",
				icon: "IconTickets",
				pid: 5,
			},
			{
				id: 3,
				text: "检测项设置",
				href: "/un-52",
				icon: "IconTickets",
				pid: 5,
			},
			{
				id: 4,
				text: "检测模版",
				href: "/un-53",
				icon: "IconTickets",
				pid: 5,
			},
			{
				id: 5,
				text: "检测任务",
				href: "/un-54",
				icon: "IconTickets",
				pid: 5,
			},
			{
				id: 6,
				text: "来料检验",
				href: "/un-55",
				icon: "IconTickets",
				pid: 5,
			},
			{
				id: 7,
				text: "过程检验",
				href: "/un-55",
				icon: "IconTickets",
				pid: 5,
			},
			{
				id: 8,
				text: "出货检验",
				href: "/un-55",
				icon: "IconTickets",
				pid: 5,
			},
		],
	},
	//组织架构侧边栏
	{
		id: 6,
		text: "组织架构",
		icon: "Management",
		children: [
			{
				id: 2,
				text: "部门管理",
				href: "/dept",
				pid: 4,
			},
			{
				id: 3,
				text: "岗位管理",
				href: "/postManage",
				icon: "Management",
				pid: 4,
			},
			{
				id: 4,
				text: "角色管理",
				href: "/role",
				icon: "Management",
				pid: 4,
			},
			{
				id: 5,
				text: "用户管理",
				href: "/user",
				icon: "Management",
				pid: 4,
			},
		],
	},
];

export const userStore = defineStore("user", {
	state: () => ({
		// 记录token
		token: null,
		// 记录refreshToken
		refreshToken: null,
		// 保存一个标识信息，指示登陆后需要加载的初始化数据是否完成
		loaded: false,
		// 保存当前用户
		user: null,
		// 菜单数据
		menus: [],
	}),
	getters: {
		// 获取token
		getToken: (state) => state.token || localStorage.getItem("token"),
		// 是否已加载
		isLoaded: (state) => state.loaded,
		// 获取当前用户
		getUser: (state) => state.user,
		// 获取菜单
		getMenus: (state) => state.menus,
	},
	actions: {
		// 加载用户
		async loadUser() {
			// 发送获取当前用户信息请求
			let data = await Request.requestForm(Request.GET, "/login/current-user", null);
			this.user = data.data;
		},
		// 加载菜单
		async loadMenus() {
			// TODO[TEST_CODE]:此处写测试数据设定
			// 测试基础数据菜单板块
			this.menus = testMenus;

			// 发送获取菜单请求
			// let data = await Request.requestForm(
			//   Request.GET,
			//   '/login/get-menus',
			//   null
			// )
			// this.menus = data.data
		},
		// 加载刷新凭证
		loadRefreshToken() {
			if (!this.refreshToken) this.refreshToken = localStorage.getItem("refreshToken");
		},
		// 刷新token
		async reloadToken() {
			// 先加载刷新凭证
			this.loadRefreshToken();
			// 发送刷新凭证请求
			let data = await Request.requestForm(Request.POST, "/login/refresh-token", {
				refreshToken: this.refreshToken,
				clientId: import.meta.env.VITE_API_URL,
			});
			// 设置Token相关属性
			this.setToken(data.data);
		},
		// 设置是否加载完成
		setLoaded(loaded) {
			this.loaded = loaded;
		},
		// 设置token
		setToken(data) {
			this.token = data.token;
			this.refreshToken = data.refreshToken;
			localStorage.setItem("token", this.token);
			localStorage.setItem("refreshToken", this.refreshToken);
		},
		// 重置数据
		resetSaveData() {
			this.loaded = false;
			this.user = null;
			this.token = null;
			this.refreshToken = null;
			localStorage.removeItem("token");
			localStorage.removeItem("refreshToken");
		},
	},
});
