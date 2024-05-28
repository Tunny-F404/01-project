const routes = [
	{
		path: '/sample',
		name: 'Sample',
		redirect: { path: '/sample/file' },
		component: () => import('@/views/sample/SampleView.vue'),
		children: [
			{
				path: '/sample/file',
				component: () => import('@/views/sample/file/FileUpload.vue')
			},
			{
				path: '/sample/excel',
				component: () => import('@/views/sample/excel/Excel.vue')
			},
			{
				path: '/sample/print',
				component: () => import('@/views/sample/print/Print.vue')
			},
			{
				path: '/sample/editor',
				component: () => import('@/views/sample/editor/Editor.vue')
			},
			{
				path: '/sample/pdfobject',
				component: () => import('@/views/sample/pdfobject/PdfObject.vue')
      		},
      		//表格组件
      		{
        		path: '/sample/table-list-use',
        		component: () => import('@/views/sample/table-list-use/table.vue')
			},
			//表格组件
			{
				path: '/sample/table-list-use',
				component: () => import('@/views/sample/table-list-use/table.vue')
			},
		   //阿门表格组件
		       {
			path: '/sample/table-list',
			component: () => import('@/components/table-list-use/table-true.vue')
				},
			// 搜索栏演示页
			{
				path: '/sample/search-bar',
				component: () => import('@/views/sample/search-bar/search-bar-page.vue')
			},
			// 表单弹窗演示页
			{
				path: '/sample/public-form',
				component: () =>import('@/views/sample/public-form/public-form-page.vue')
			},
			//计算单位演示页
			{
				path: '/sample/unit-account',
				component: () => import('@/views/sample/basic-data/unit-of-account.vue')
			}
		]
	}
]

export default routes
