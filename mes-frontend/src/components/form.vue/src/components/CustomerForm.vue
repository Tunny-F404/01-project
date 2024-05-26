
<template>
  <div class="customer-form">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="姓名" prop="name">
        <el-input v-model="form.name" :rows="calculateRows(form.name)"></el-input>
      </el-form-item>
      <el-form-item label="电子邮件" prop="email">
        <el-input v-model="form.email" type="email" :rows="calculateRows(form.email)"></el-input>
      </el-form-item>
      <el-form-item label="电话号码" prop="phone">
        <el-input v-model="form.phone" type="tel" :rows="calculateRows(form.phone)"></el-input>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input v-model="form.address" :rows="calculateRows(form.address)"></el-input>
      </el-form-item>
      <el-form-item label="简介" prop="introduction">
        <el-input type="textarea" v-model="form.introduction" :rows="calculateRows(form.introduction)"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="remark">
        <el-input type="textarea" v-model="form.remark" :rows="calculateRows(form.remark)"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: 'CustomerForm',
  data() {
    return {
      form: {
        name: '',
        email: '',
        phone: '',
        address: '',
        introduction: '',
        remark: ''
      }
    };
  },
  methods: {
    submitForm() {
      console.log(this.form);
    },
    calculateRows(text) {
      // 根据文本内容计算行数
      const lineHeight = 22; // 假设每行的高度为 22px
      const lines = text.split('\n').length; // 换行符个数即为行数
      return Math.max(lines, 1); // 至少显示一行
    }
  }
};
</script>

<style scoped>
.customer-form {
  background-color: #f5f5f5;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}
</style>
