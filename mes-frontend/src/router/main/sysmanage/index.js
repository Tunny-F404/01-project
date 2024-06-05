const routes = [
	{
		path: "/un-1",
		name: "UN1",
		component: () => import("@/views/status/404.vue"),
	},
	{
		path: "/un-2",
		name: "UN2",
		component: () => import("@/views/basic-data/material-admin.vue"),
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
		component: () => import("@/views/basedata/supplier.vue"),
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
	{
		path: "/un-51",
		name: "UN51",
		component: () => import("@/views/quality-control/defect.vue"),
	},
	{
		path: "/un-52",
		name: "UN52",
		component: () => import("@/views/sample/detection/Detection.vue"),
	},
	{
		path: "/un-53",
		name: "UN53",
		component: () => import("@/views/status/404.vue"),
	},
	{
		path: "/un-54",
		name: "UN54",
		component: () => import("@/views/status/404.vue"),
	},
	{
		path: "/un-55",
		name: "UN55",
		component: () => import("@/views/status/404.vue"),
	},
	{
		path: "/un-56",
		name: "UN56",
		component: () => import("@/views/status/404.vue"),
	},
	{
		path: "/un-57",
		name: "UN57",
		component: () => import("@/views/status/404.vue"),
	},
	// 生产领料页面
	{
		path: "/un-34",
		name: "UN34",
		component: () => import("@/views/warehouse-management/Material.vue"),
	},
];

export default routes;
