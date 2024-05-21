<template>
    <div>
        <el-table :data="filteredData" :default-sort="{ prop: 'date', order: 'ascending' }" style="width: 100%">
            <el-table-column prop="date" label="日期" sortable width="180">
            </el-table-column>
            <el-table-column prop="name" label="姓名" sortable width="180">
            </el-table-column>
            <el-table-column prop="address" label="地址">
            </el-table-column>
        </el-table>
        <el-pagination v-show="totalPages > 1" @current-change="handleCurrentChange" :current-page="currentPage"
            :page-sizes="[10, 20, 30, 50]" :page-size="pageSize" :total="filteredData.length">
        </el-pagination>
    </div>
</template>

<script>
import { ElTable, ElTableColumn, ElPagination } from 'element-plus';
import { ref, reactive, computed } from 'vue';



export default {
    components: {
        ElTable,
        ElTableColumn,
        ElPagination
    },
    setup() {
        const tableData = ref([
            { date: '2024-05-01', name: '张三', address: '北京市朝阳区' },
            { date: '2024-05-02', name: '李四', address: '上海市浦东新区' },
            { date: '2024-05-03', name: '王五', address: '广州市天河区' },
            // 更多数据...
        ]);

        const filter = reactive({
            date: '',
            name: '',
            address: ''
        });

        const sort = reactive({
            prop: 'date',
            order: 'ascending'
        });

        const currentPage = ref(1);
        const pageSize = ref(10);

        const handleCurrentChange = (val) => {
            currentPage.value = val;
        };


        const filteredData = computed(() => {
            let result = tableData.value;

            // 过滤
            if (filter.date) {
                result = result.filter(item => item.date.includes(filter.date));
            }
            if (filter.name) {
                result = result.filter(item => item.name.includes(filter.name));
            }
            if (filter.address) {
                result = result.filter(item => item.address.includes(filter.address));
            }

            // 排序
            result.sort((a, b) => {
                const order = sort.order === 'ascending' ? 1 : -1;
                return order * (a[sort.prop] > b[sort.prop] ? 1 : -1);
            });

            // 分页
            const startIndex = (currentPage.value - 1) * pageSize.value;
            const endIndex = startIndex + pageSize.value;
            return result.slice(startIndex, endIndex);
        });


        const totalPages = computed(() => Math.ceil(filteredData.value.length / pageSize.value));

        return {
            filteredData,
            currentPage,
            pageSize,
            totalPages,
            handleCurrentChange
        };
    }
};
</script>
