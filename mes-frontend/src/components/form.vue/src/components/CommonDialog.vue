<template>
  <el-dialog v-model="dialogVisible" title="客户信息" width="50%">
    <CustomerForm ref="customerForm" />
    <template #footer>
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="handleSubmit">提交</el-button>
    </template>
  </el-dialog>
</template>

<script>
import CustomerForm from './CustomerForm.vue';

export default {
  name: 'CommonDialog',
  components: {
    CustomerForm
  },
  data() {
    return {
      dialogVisible: false
    };
  },
  methods: {
    openDialog() {
      this.dialogVisible = true;
    },
    handleSubmit() {
      this.$refs.customerForm.submitForm();
      this.dialogVisible = false;
    }
  }
};
</script>

<style scoped>
.dialog-footer {
  text-align: right;
}
</style>
