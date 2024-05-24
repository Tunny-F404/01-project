<template>
    <div class="cl-PaginationTable">
        <el-table :data="tableData" height="320">
            <el-table-column v-for="col of tableColumns" :key="col.data" :prop="col.data" :label="col.label" />
        </el-table>
    </div>
</template>

<script setup>
import { ElTable, ElTableColumn } from "element-plus";

import { onMounted, ref } from "vue";

// t- 初始化表格数据
const tableData = ref([]);
const tableColumns = [
    {
        label: "人员",
        data: "name",
    },
    {
        label: "地址",
        data: "address",
    },
    {
        label: "签到时间",
        data: "time",
    },
];
async function getTableData() {
    const res = await getPeopleInfo();
    tableData.value = res.data;
}
onMounted(async () => {
    getTableData();
});
</script>

<style lang="less" scoped>
.cl-PaginationTable {
    width: 500px;
    height: 300px;
    border: 3px solid;
    margin: 0 auto;
    padding-bottom: 40px;
}
</style>