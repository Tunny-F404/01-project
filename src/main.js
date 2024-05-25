import { createApp } from 'vue';
import App from './App.vue';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import router from './router'; // 确保你的项目已经设置了 vue-router
import { createPinia } from 'pinia';

const app = createApp(App);

app.use(ElementPlus);
app.use(router);
app.use(createPinia());
app.mount('#app');
