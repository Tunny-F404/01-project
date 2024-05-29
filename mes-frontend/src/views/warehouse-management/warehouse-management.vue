
<template>



    <div class="app-container">


        <TableTrue>
            <template #extra>
                <div class="wareHouseSearchDiv">
                    <el-form size="small" :inline="true" label-width="82px">
                        <el-form-item label="仓库编码" size="default">
                            <el-input placeholder="请输入仓库编码" />
                        </el-form-item>
                        <el-form-item label="仓库名称" size="default">
                            <el-input placeholder="请输入仓库名称" />
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary"   size="default"
                                @click="handleQuery">搜索</el-button>
                            <el-button  size="default" @click="resetQuery">重置</el-button>
                        </el-form-item>
                    </el-form>
                </div>

            </template>
            <template #empty>
                待定内容
            </template>
        </TableTrue>



    </div>

</template>
<script lang="ts" setup>
import { ElButton } from "element-plus"

import TableText from '@/components/table-list-use/table-text.vue';
import TableTrue from '@/components/table-list-use/table-true.vue';


const components = { TableText, TableTrue };
const handleQuery = () => {
    console.log('执行搜索');
    // 在这里添加搜索逻辑

}

const resetQuery = () => {
    console.log('重置查询条件');
    // 在这里添加重置逻辑
  
}

</script>

<style scoped>
.app-container{
    background-color: aliceblue;
    width: auto;
    height: 400px;
}
.body{
    margin: 0;
    padding: 0;
}
.el-input {
    --el-input-width: 220px;
    height:35px;
}
.el-button {
  display: flex !important;
  justify-content: center !important;
  align-items: center !important;
}


</style>