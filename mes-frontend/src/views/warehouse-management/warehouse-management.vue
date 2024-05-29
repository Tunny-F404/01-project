
<template>



    <div class="app-container">


        <TableTrue #extra>
            <el-form size="small" :inline="true" label-width="68px">
                <el-form-item label="仓库编码">
                    <el-input placeholder="请输入仓库编码" />
                </el-form-item>
                <el-form-item label="仓库名称">
                    <el-input placeholder="请输入仓库名称" />
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" icon="el-icon-search" size="small" @click="handleQuery">搜索</el-button>
                    <el-button icon="el-icon-refresh" size="small" @click="resetQuery">重置</el-button>
                </el-form-item>

            </el-form>

        </TableTrue>



    </div>

</template>
<script lang="ts" setup>
import { ElButton } from "element-plus"

import TableText from '@/components/table-list-use/table-text.vue';
import TableTrue from '@/components/table-list-use/table-true.vue';


const components = { TableText, TableTrue };


</script>

<style scoped>
.app-container{
    background-color: aliceblue;
    width: auto;
    height: 500px;
}
.body{
    margin: 0;
    padding: 0;
}
</style>