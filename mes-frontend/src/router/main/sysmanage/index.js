const routes = [
	{
		path: "/un-1",
		name: "UN1",
		component: () => import("@/views/status/404.vue"),
	},
	{
		path: "/un-2",
		name: "UN2",
		// component: () => import('@/views/')
		component: () => import("@/views/status/403.vue"),
	},
	{
		path: "/un-3",
		name: "UN3",
		component: () => import("@/views/sample/basic-data/unit-of-account.vue"),
	},
	{
		path: "/un-4",
		name: "UN4",
		component: () => import("@/views/basedata/Clientdemo1.vue"),
	},
	{
		path: "/un-5",
		name: "UN5",
		component: () => import("@/views/status/404.vue"),
	},
	{
		path: "/un-6",
		name: "UN6",
		component: () => import("@/views/sample/workshop/WorkshopSettings.vue"),
	},
	{
		path: "/un-7",
		name: "UN7",
		component: () => import("@/views/status/404.vue"),
	},
	// 仓库管理页面
	{
		path: "/un-31",
		name: "UN31",
		component: () => import("@/views/warehouse-management/warehouse-management.vue"),
	},
	// 采购入库页面
	{
		path: "/un-32",
		name: "UN32",
		component: () => import("@/views/warehouse-management/purchase-in.vue"),
	},
	// 采购退货页面
	{
		path: "/un-33",
		name: "UN33",
		component: () => import("@/views/warehouse-management/PurchaseReturn.vue"),
	},
];

export default routes;
