import { createRouter, createWebHistory } from "vue-router";
import NotFound from "@/views/404/NotFound.vue";


const routes = [
  
  {
    path: '/404',
    name: '404page',
    component: NotFound,
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
});

router.afterEach((to, from) => {
  // 如果不存在匹配的路由，则重新定向到404页面
  if (!to.matched.length && !from.matched.length) {
    router.replace('/404');
  }
});

export default router;

