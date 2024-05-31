<template>
    <div class="app-container">
        <!-- Search Form -->
        <el-form size="small" inline>
            <el-form-item label="部门名称">
                <el-input placeholder="请输入部门名称" clearable />
            </el-form-item>
            <el-form-item label="状态">
                <el-select placeholder="部门状态" clearable>
                    <el-option label="激活" value="active" />
                    <el-option label="禁用" value="disabled" />
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" icon="el-icon-search" size="mini">搜索</el-button>
                <el-button icon="el-icon-refresh" size="mini">重置</el-button>
            </el-form-item>
        </el-form>

        <!-- Action Buttons -->
        <el-row :gutter="10" class="mb8">
            <el-col :span="1.5">
                <el-button type="primary" plain icon="el-icon-plus" size="mini">新增</el-button>
            </el-col>
            <el-col :span="1.5">
                <el-button type="info" plain icon="el-icon-sort" size="mini">展开/折叠</el-button>
            </el-col>
        </el-row>

        <!-- Department Table -->
        <el-table :data="deptList" row-key="deptId" :default-expand-all="isExpandAll"
            :tree-props="{ children: 'children', hasChildren: 'hasChildren' }">
            <el-table-column prop="deptName" label="部门名称" width="260" />
            <el-table-column prop="orderNum" label="排序" width="200" />
            <el-table-column prop="status" label="状态" width="100" />
            <el-table-column label="创建时间" align="center" prop="createTime" width="200" />
            <el-table-column label="操作" align="center" class-name="small-padding fixed-width" />
        </el-table>

        <!-- Add/Edit Department Dialog -->
        <el-dialog title="部门详情" :visible.sync="open" width="600px">
            <el-form ref="form" :model="form" :rules="rules" label-width="80px">
                <el-row>
                    <el-col :span="24">
                        <el-form-item label="上级部门">
                            <el-input placeholder="上级部门" />
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="部门名称">
                            <el-input placeholder="请输入部门名称" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="显示排序">
                            <el-input-number controls-position="right" :min="0" />
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="负责人">
                            <el-input placeholder="请输入负责人" maxlength="20" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="联系电话">
                            <el-input placeholder="请输入联系电话" maxlength="11" />
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="邮箱">
                            <el-input placeholder="请输入邮箱" maxlength="50" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="部门状态">
                            <el-radio-group>
                                <el-radio label="active">激活</el-radio>
                                <el-radio label="disabled">禁用</el-radio>
                            </el-radio-group>
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
            <div class="dialog-footer">
                <el-button type="primary">确 定</el-button>
                <el-button>取 消</el-button>
            </div>
        </el-dialog>
    </div>
</template>


<script>

export default {
    name: "Dept",

    data() {
        return {
            loading: false, // Set to false for static data
            showSearch: true,
            deptList: [
                // Static data for testing
                { deptId: 1, deptName: 'Research', children: [{ deptId: 2, deptName: 'Development' }] },
                { deptId: 3, deptName: 'Sales', children: [{ deptId: 4, deptName: 'Marketing' }] }
            ],
            deptOptions: [
                // Static data for department options
                { deptId: 1, deptName: 'Headquarters', children: [] },
                { deptId: 2, deptName: 'Operations', children: [] }
            ],
            title: "",
            open: false,
            isExpandAll: true,
            refreshTable: true,
            queryParams: {
                deptName: undefined,
                status: undefined
            },
            form: {
                deptId: undefined,
                parentId: undefined,
                deptName: '',
                orderNum: 0,
                leader: '',
                phone: '',
                email: '',
                status: '0'
            },
            rules: {
                parentId: [
                    { required: true, message: "上级部门不能为空", trigger: "blur" }
                ],
                deptName: [
                    { required: true, message: "部门名称不能为空", trigger: "blur" }
                ],
                orderNum: [
                    { required: true, message: "显示排序不能为空", trigger: "blur" }
                ],
                email: [
                    {
                        type: "email",
                        message: "请输入正确的邮箱地址",
                        trigger: ["blur", "change"]
                    }
                ],
                phone: [
                    {
                        pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
                        message: "请输入正确的手机号码",
                        trigger: "blur"
                    }
                ]
            }
        };
    },
    methods: {
        getList() {
            // Static data, no loading state needed
        },
        normalizer(node) {
            if (node.children && !node.children.length) {
                delete node.children;
            }
            return {
                id: node.deptId,
                label: node.deptName,
                children: node.children
            };
        },
        cancel() {
            this.open = false;
            this.reset();
        },
        reset() {
            this.form = {
                deptId: undefined,
                parentId: undefined,
                deptName: '',
                orderNum: 0,
                leader: '',
                phone: '',
                email: '',
                status: "0"
            };
        },
        handleQuery() {
            // Static data, no query logic needed
        },
        resetQuery() {
            this.reset();
        },
        handleAdd(row) {
            this.reset();
            if (row !== undefined) {
                this.form.parentId = row.deptId;
            }
            this.open = true;
            this.title = "添加部门";
        },
        toggleExpandAll() {
            this.isExpandAll = !this.isExpandAll;
        },
        handleUpdate(row) {
            this.reset();
            this.form = Object.assign({}, row);
            this.open = true;
            this.title = "修改部门";
        },
        submitForm() {
            // Static data, no submission logic needed
            this.open = false;
        },
        handleDelete(row) {
            // Static data, no delete logic needed
            console.log(`Deleted department: ${row.deptName}`);
        }
    }
};
</script>

