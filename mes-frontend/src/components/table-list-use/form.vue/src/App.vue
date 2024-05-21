<template>
  <div id="app">
    <el-button type="primary" @click="openDialog">打开表单</el-button>
    <CommonDialog ref="commonDialog" />
  </div>
</template>

<script>
import { ref } from 'vue';
import CommonDialog from './components/CommonDialog.vue';

export default {
  name: 'App',
  components: {
    CommonDialog
  },
  setup() {
    const commonDialog = ref(null);

    const openDialog = () => {
      commonDialog.value.openDialog();
    };

    return {
      commonDialog,
      openDialog
    };
  }
};
</script>

<style>
#app {
  padding: 20px;
}
</style>
