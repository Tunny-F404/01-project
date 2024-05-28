import { createRouter, createWebHistory } from 'vue-router';
import { ElMessage } from 'element-plus';
import { userStore } from '../stores/user';
import Station from '../views/Station.vue';


const routes = [
  {
    path: '/',
    name: 'Home',
    component: Station,
  },
  // 保留一个 404 路由以防止未匹配路由
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: () => import('../views/status/404.vue'),
  },
];

// 定义一个路由对象
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

// 添加一个路由的全局前置守卫
router.beforeEach(async function (to, from, next) {
  // 判断是否是登录页面或 404 页面
  if (to.name === 'Login' || to.name === 'NotFound') {
    next();
    return;
  }
  // 判断本地是否记录token值
  let store = userStore();
  let token = store.getToken;
  // 如果有token
  if (token) {
    // 判断是否已经加载数据
    let isLoaded = store.isLoaded;
    // 如果没有加载
    if (!isLoaded) {
      // 加载用户信息
      await store.loadUser();
      // 加载菜单资源
      await store.loadMenus();
      // 设置加载完毕
      store.setLoaded(true);
    }
    next();
  } 
  // 如果没有token值，直接进入登录
  else {
    next({ name: 'Login' });
    ElMessage.warning('在未登录时，禁止访问其他页面！');
  }
});

export default router;