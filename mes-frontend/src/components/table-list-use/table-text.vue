//这是初始状态，可以添加更多东西
<script setup>
defineProps({
  title: {//引入的表格名，显示在上面
    required: true,
    type: String
  }

})
</script>

<template>
  <el-card class="page-container">
    <template #header>//插槽,头部，表明表格数据内容
      <div class="header">
        <span>{{ title }}</span>
        <div class="extra">
          <slot name="extra"></slot>//具名插槽
        </div>
      </div>
    </template>
    <slot></slot>//默认插槽，内容页
  </el-card>
</template>

<style lang="scss" scoped>
.page-container {
  min-height: 100%;
  box-sizing: border-box;
  .header {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
}
</style>
