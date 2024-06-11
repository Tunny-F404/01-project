<template>
    <div class="app-container">
        <el-form :model="queryParams" ref="queryForm" size="small" inline v-show="showSearch" label-width="68px">
            <el-form-item label="规则名称" prop="ruleName">
                <el-input v-model="queryParams.ruleName" placeholder="请输入规则名称" clearable style="width: 240px"
                    @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="规则编码" prop="ruleCode">
                <el-input v-model="queryParams.ruleCode" placeholder="请输入规则编码" clearable style="width: 240px"
                    @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="启用状态" prop="enableFlag">
                <el-select v-model="queryParams.enableFlag" placeholder="请选择" clearable style="width: 240px">
                    <el-option v-for="item in yesNoOptions" :key="item.value" :label="item.label" :value="item.value" />
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
            </el-form-item>
        </el-form>

        <!-- 表格和其他组件... -->

        <!-- 表格显示规则列表 -->
        <el-table :data="ruleList" style="width: 100%" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="ruleCode" label="规则编码" sortable width="120"></el-table-column>
            <el-table-column prop="ruleName" label="规则名称" sortable width="120"></el-table-column>
            <el-table-column prop="enableFlag" label="启用状态" width="100">
                <template #default="{ row }">
                    <el-tag :type="row.enableFlag === 'Y' ? 'success' : 'info'">{{ row.enableFlag === 'Y' ? '启用' : '禁用'
                        }}</el-tag>
                </template>
            </el-table-column>
            <el-table-column label="操作" width="180">
                <template #default="{ row }">
                    <el-button size="mini" @click="handleUpdate(row)">编辑</el-button>
                    <el-button size="mini" type="danger" @click="handleDelete(row)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-dialog :title="title" v-model="open" width="500px">
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <!-- 表单元素... -->
            </el-form>
            <span slot="footer">
                <el-button type="primary" @click="submitForm">确 定</el-button>
                <el-button @click="cancel">取 消</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script setup>
import { ref, reactive, toRefs, onMounted } from 'vue';
import { ElForm, ElInput, ElSelect, ElOption, ElButton, ElTable, ElTableColumn, ElPagination, ElDialog, ElInputNumber, ElRadioGroup, ElRadio, ElMessage, ElMessageBox } from 'element-plus';

// 定义响应式状态
const state = reactive({
    loading: false,
    ids: [],
    single: true,
    multiple: true,
    showSearch: true,
    total: 0,
    // 模拟规则列表数据
    ruleList: [
        { ruleId: 1, ruleCode: 'R001', ruleName: '规则一', enableFlag: 'Y' },
        { ruleId: 2, ruleCode: 'R002', ruleName: '规则二', enableFlag: 'N' }
        // 更多模拟数据...
    ],
    title: '',
    open: false,
    dateRange: [],
    queryParams: {
        pageNum: 1,
        pageSize: 10,
        ruleCode: '',
        ruleName: '',
        enableFlag: ''
    },
    form: {},
    rules: {
        ruleCode: [
            { required: true, message: '规则编码不能为空', trigger: 'blur' }
        ],
        ruleName: [
            { required: true, message: '规则名称不能为空', trigger: 'blur' }
        ]
    }
});

// 解构响应式状态以便在模板中使用
const { loading, ids, single, multiple, showSearch, total, ruleList, title, open, dateRange, queryParams, form, rules } = toRefs(state);

// 方法定义
const getList = () => {
    loading.value = true;
    setTimeout(() => {
        loading.value = false;
        total.value = ruleList.value.length;
    }, 500);
};
// // 方法定义
// const getList = async () => {
//     loading.value = true;
//     try {
//         const response = await listRule(queryParams.value);
//         ruleList.value = response.rows;
//         total.value = response.total;
//     } catch (error) {
//         ElMessage.error('获取列表失败');
//     } finally {
//         loading.value = false;
//     }
// };
const reset = () => {
    // 重置表单
    state.form = {
        ruleId: undefined,
        ruleCode: '',
        ruleName: '',
        enableFlag: 'Y'
    };
};
// 使用Element Plus的原生方法
const messageSuccess = (msg) => {
    ElMessage.success(msg);
};

const messageError = (msg) => {
    ElMessage.error(msg);
};

const confirm = (msg, callback) => {
    ElMessageBox.confirm(msg)
        .then(() => {
            callback();
        })
        .catch(() => { });
};
// 生命周期钩子
onMounted(() => {
    getList();
});
const handleQuery = () => {
    queryParams.value.pageNum = 1;
    getList();
};

const resetQuery = () => {
    dateRange.value = [];
    reset();
    handleQuery();
};

const handleAdd = () => {
    reset();
    open.value = true;
    title.value = "添加编码规则";
};

const handleSelectionChange = (selection) => {
    ids.value = selection.map(item => item.ruleId);
    single.value = selection.length !== 1;
    multiple.value = !selection.length;
};

const handleUpdate = async (row) => {
    reset();
    const ruleId = row.ruleId || ids.value;
    try {
        const response = await getRule(ruleId);
        form.value = response.data;
        open.value = true;
        title.value = "修改编码规则";
    } catch (error) {
        ElMessage.error('获取规则详情失败');
    }
};

const submitForm = async () => {
    const valid = await form.value.validate();
    if (valid) {
        try {
            if (form.value.ruleId !== undefined) {
                await updateRule(form.value);
                ElMessage.success("修改成功");
            } else {
                await addRule(form.value);
                ElMessage.success("新增成功");
            }
            open.value = false;
            getList();
        } catch (error) {
            ElMessage.error('操作失败');
        }
    }
};

const handleDelete = async (row) => {
    const ruleIds = row.ruleId || ids.value;
    try {
        await ElMessageBox.confirm(`是否确认删除编码规则为"${ruleIds}"的数据项？`);
        await delRule(ruleIds);
        ElMessage.success("删除成功");
        getList();
    } catch (error) {
        // Handle cancel or error
    }
};

const handleRefreshCache = async () => {
    try {
        await refreshCache();
        ElMessage.success("刷新成功");
    } catch (error) {
        ElMessage.error('刷新缓存失败');
    }
};

// 其他方法...
</script>
