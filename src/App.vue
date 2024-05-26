<script setup>
import { createApp } from 'vue';
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
import { createPinia } from 'pinia';
import router from './router';

// 创建 Vue 应用
const app = createApp({});

app.use(ElementPlus);
app.use(router);
app.use(createPinia());
app.mount('#app');
</script>

<template>
  <router-view />
</template>

<style scoped>
/* 这里可以添加全局样式 */
</style>
