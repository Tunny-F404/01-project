<template>
  <div class="customer-form">
    <el-form ref="form" :model="form" label-width="120px">
      <el-form-item label="姓名" prop="name">
        <el-input v-model="form.name"></el-input>
      </el-form-item>
      <el-form-item label="电子邮件" prop="email">
        <el-input v-model="form.email" type="email"></el-input>
      </el-form-item>
      <el-form-item label="电话号码" prop="phone">
        <el-input v-model="form.phone" type="tel"></el-input>
      </el-form-item>
      <el-form-item label="地址" prop="address">
        <el-input v-model="form.address"></el-input>
      </el-form-item>
      <el-form-item label="简介" prop="introduction">
        <el-input type="textarea" v-model="form.introduction"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="remark">
        <el-input type="textarea" v-model="form.remark"></el-input>
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
