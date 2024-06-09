<template>
	<tableFrame title="类型管理">
		<template #extra>
			<el-button>导出数据<el-icon :size="22">
					<UploadFilled />
				</el-icon>
			</el-button>
			<template>
				<div>
					<slot name="extra"></slot>
					<!-- 其他内容 -->
				</div>
			</template>
		</template>
		<!-- 表单 -->
		<el-form class="demo-form-inline">
			<el-row>
				<el-col :span="8">
					<el-form-item label="类型编码">
						<el-input v-model="codingType" style="width: 260px" placeholder="请输入编码类型" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="类型名称">
						<el-input v-model="typeName" style="width: 260px" placeholder="请输入类型名称" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="保养维护类型">
						<div class="flex flex-wrap gap-4 items-center">
							<el-select v-model="SelectValue" placeholder="请选择保养维护类型" style="width: 240px">
								<el-option v-for="item in selectOptions" :key="item.value" :label="item.label" :value="item.value" />
							</el-select>
						</div>
					</el-form-item>
				</el-col>
				<el-col :span="6">
					<el-form-item>
						<el-button type="primary" @click="search"> <el-icon>
								<Search />
							</el-icon>查询</el-button>
						<el-button @click="reFresh"><el-icon>
								<Refresh />
							</el-icon>重置</el-button>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
		<!-- 表格 -->
		<el-button type="primary" plain @click="openTestDialog"><el-icon>
				<Plus />
			</el-icon>新增</el-button>
		<el-button type="success" plain @click="onEditchannel(row)"><el-icon>
				<EditPen />
			</el-icon>修改</el-button>
		<el-button type="danger" plain><el-icon>
				<Delete />
			</el-icon>删除</el-button>
		<el-table v-loading="loading" :data="typeList" @selection-change="handleSelectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
			<el-table-column prop="typeCode" label="类型编码" align="center"></el-table-column>
			<el-table-column prop="typeName" label="类型名称" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="是否编码管理" align="center">
				<template #default="{ row }">
					<el-tag :class="row.isEnabled ? 'status-enabled' : 'status-disabled'" @click="toggleStatus(row)"
						style="cursor: pointer;" class="status-tag">
						{{ row.isEnabled ? '是' : '否' }}
					</el-tag>
				</template>
			</el-table-column>
			<el-table-column prop="maintainType" label="保养维护类型" align="center"></el-table-column>
			<el-table-column prop="maintainPeriod" label="保养周期" align="center"></el-table-column>
			<el-table-column prop="remark" label="备注" align="center"></el-table-column>
			<el-table-column label="操作" width="150" align="center">
				<template #default="{ row, $index }">
					<el-button @click="onEditchannel(row, $index)" circle type="primary">
						<el-icon :size="20">
							<Edit />
						</el-icon>
					</el-button>
					<el-button @click="onDelChannel(row, $index)" type="danger" circle>
						<el-icon>
							<Delete />
						</el-icon>
					</el-button>
				</template>
			</el-table-column>
		</el-table>
	</tableFrame>
	<el-dialog v-model="dialogFormVisible" :title="dialogTitle" style="width:700px">
		<el-form :model="type" :rules="rules" label-width="120px">
			<el-row>
				<el-col :span="12">
					<el-form-item label="类型编码" prop="codingType">
						<el-input v-model="type.codingType" placeholder="请输入编码类型" autocomplete="off" />
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="类型名称" prop="typeName">
						<el-input v-model="type.typeName" placeholder="请输入类型名称" autocomplete="off" />
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="8">
					<el-form-item label="是否编码管理" prop="enableFlag">
						<div class="mb-2 flex items-center text-sm">
							<el-radio-group v-model="type.enableFlag" class="ml-4">
								<el-radio :value='true' label='是'>是</el-radio>
								<el-radio :value='false' label='否'>否</el-radio>
							</el-radio-group>
						</div>
					</el-form-item>
				</el-col>
				<el-col :span="8" v-if="type.enableFlag">
					<el-form-item label="请选择保养维护类型" prop="SelectValue">
						<div class="flex flex-wrap gap-4 items-center">
							<el-select v-model="SelectValue" placeholder="请选择保养维护类型" size="large" style="width: 120px">
								<el-option v-for="item in selectOptions" :key="item.value" :label="item.label" :value="item.value" />
							</el-select>
						</div>
					</el-form-item>
				</el-col>
				<el-col :span="8" v-if="type.enableFlag">
					<el-form-item label="保养周期" prop="maintainPeriod">
						<el-input v-model="type.maintainPeriod" placeholder="请选择保养周期" autocomplete="off" />
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="24">
					<el-form-item label="备注" prop="maintainPeriod">
						<el-input v-model="type.maintainPeriod" placeholder="请输入内容" style="width:1200px;" />
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
		<template #footer>
			<div class="dialog-footer">
				<el-button @click="dialogFormVisible = false">取消</el-button>
				<el-button type="primary" @click="dialogFormVisible = false">
					确定
				</el-button>
			</div>
		</template>
	</el-dialog>
</template>

<script setup>
import tableFrame from "components/std-table/src/table-text.vue";
import { ref, reactive } from 'vue'

const SelectValue = ref('')
const typeName = ref('');
let dialogFormVisible = ref(false);
const codingType = ref('');
let dialogTitle = ref('');
const reFresh = () => {
	SelectValue.value = '';
	typeName.value = '';
	codingType.value = '';
}
const selectOptions = [
	{
		value: 'Option1',
		label: '定期维护',
	},
	{
		value: 'Option2',
		label: '按使用次数维护',
	}
]
let typeList = reactive([
	{
		typeCode: 'TT003',
		typeName: '刀具',
		enableFlag: true,
		maintainType: '无',
		maintainPeriod: '无',
		remark: ''
	},
	{
		typeCode: 'TT022',
		typeName: '模具',
		enableFlag: true,
		maintainType: '按使用次数维护',
		maintainPeriod: '50次',
		remark: ''
	}
]);
const type = reactive({
	codingType: '',
	typeName: '',
	SelectValue: '',
	maintainPeriod: '',
	enableFlag: true
})
const rules = {
	codingType: [{ required: true, message: '类型编码不能为空', trigger: "blur" }],
	typeName: [{ required: true, message: '类型名称不能为空', trigger: "blur" }],
	enableFlag: [{ required: true, trigger: "blur" }],
	SelectValue: [{ required: false, trigger: "blur" }],
	maintainPeriod: [{ message: '请输入保养周期', trigger: "blur" }],
};
//函数
const toggleStatus = (row) => {
	row.isEnabled = !row.isEnabled
}
let openTestDialog = () => {
	dialogTitle.value = '新增工装夹具类型'
	dialogFormVisible.value = true
	type.value = {
		codingType: '',
		typeName: '',
		enableFlag: '',
		SelectValue: '',
		maintainPeriod: ''
	}
}
const onEditchannel = (row) => {
	dialogTitle.value = "修改工装夹具类型";
	type.value = { ...row };
	dialogFormVisible.value = true;
};
</script>

<style lang="scss" scoped>
.demo-form-inline {
	.el-input {
		--el-input-width: 220px;
	}

	.el-select {
		--el-select-width: 220px;
	}
}

.status-enabled {
	background-color: rgba(64, 158, 255, 0.2);
	color: #409eff;
	padding: 5px;
	text-align: center;
}

.status-disabled {
	background-color: rgba(245, 108, 108, 0.2);
	color: #f56c6c;
	padding: 5px;
	text-align: center;
}

.status-tag {
	display: inline-flex;
	align-items: center;
	justify-content: center;
	width: 35px;
	height: 35px;
	cursor: pointer;
}
</style>