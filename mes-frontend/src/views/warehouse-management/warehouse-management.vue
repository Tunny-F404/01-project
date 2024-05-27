
<template>



    <div class="app-container">
        <el-form size="small" :inline="true" label-width="68px">
            <el-form-item label="仓库编码">
                <el-input placeholder="请输入仓库编码" />
            </el-form-item>
            <el-form-item label="仓库名称">
                <el-input placeholder="请输入仓库名称" />
            </el-form-item>

            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>

        </el-form>

        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini" @click="handleAdd"
                    v-hasPermi="['mes:wm:warehouse:add']">新增</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="success" plain icon="el-icon-edit" size="mini" :disabled="single" @click="handleUpdate"
                    v-hasPermi="['mes:wm:warehouse:edit']">修改</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="danger" plain icon="el-icon-delete" size="mini" :disabled="multiple"
                    @click="handleDelete" v-hasPermi="['mes:wm:warehouse:remove']">删除</el-button>
            </el-col>
            <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>



          <TableTrue />
   
  
    </div>

</template>
<script lang="ts" setup>
import { ElButton } from "element-plus"

import TableText from '@/components/table-list-use/table-text.vue';
import TableTrue from '@/components/table-list-use/table-true.vue';
import PopUp from '@/components/table-list-use/table-components/pop-up.vue';

const components = { TableText, TableTrue };


</script>

<style scoped>
.app-container{
    background-color: aliceblue;
    width: 800px;
    height: 500px;
}
.body{
    margin: 0;
    padding: 0;
}
</style>