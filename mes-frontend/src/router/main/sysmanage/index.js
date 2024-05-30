const routes = [
	{
		path: '/un-1',
		name: 'UN1',
		component: () => import('@/views/personal-center/personal-center.vue')
	},
	{
		path: '/un-2',
		name: 'UN2',
		component: () => import('@/views/status/403.vue')
	},
	{
		path: '/un-3',
		name: 'UN3',
		component: () => import('@/views/status/404.vue')
	},
	{
		path: '/un-4',
		name: 'UN4',
		component: () => import('@/views/status/403.vue')
	},
	{
		path: '/un-5',
		name: 'UN5',
		component: () => import('@/views/basic-data/supplier.vue')
	},
	{
		path: '/un-6',
		name: 'UN6',
		component: () => import('@/views/status/403.vue')
	},
	{
		path: '/un-7',
		name: 'UN7',
		component: () => import('@/views/status/403.vue')
  },
  // 仓库管理页面
  {
    path:'/un-31',
    name: 'UN31',
    component: () => import('@/views/warehouse-management/warehouse-management.vue')
	}
]

export default routes
