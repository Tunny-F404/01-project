import { createRouter, createWebHistory } from 'vue-router';
import TableView from '@/views/TableView.vue';

const routes = [
  { path: '/', name: 'Table', component: TableView },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
