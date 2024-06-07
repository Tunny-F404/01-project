<template>
	<tableFrame title="工装夹具台账">
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
		<el-form>
			<el-row>
				<el-col :span="8">
					<el-form-item label="工装夹具编码">
						<el-input v-model="equipmentLedgerCode" style="width: 260px" placeholder="请输入编码类型" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="工装夹具名称">
						<el-input v-model="equipmentLedgerName" style="width: 260px" placeholder="请输入类型名称" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="工装夹具类型">
						<div class="flex flex-wrap gap-4 items-center">
							<el-select v-model="equipmentLedgerType" placeholder="请选择类型" style="width: 240px">
								<el-option v-for="item in selectOptions" :key="item.value" :label="item.label" :value="item.value" />
							</el-select>
						</div>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
		<el-form>
			<el-row>
				<el-col :span="6">
					<el-form-item label="品牌">
						<el-input v-model="brand" style="width: 260px" placeholder="请输入编码类型" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="6">
					<el-form-item label="型号">
						<el-input v-model="model" style="width: 260px" placeholder="请输入型号" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="6">
					<el-form-item label="状态">
						<div class="flex flex-wrap gap-4 items-center">
							<el-select v-model="state" placeholder="请选择状态" style="width: 240px">
								<el-option v-for="item in stateOptions" :key="item.value" :label="item.label" :value="item.value" />
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
			<el-table-column prop="equipmentLedgerCode" label="编号" align="center"></el-table-column>
			<el-table-column prop="equipmentLedgerName" label="名称" align="center"></el-table-column>
			<el-table-column prop="brand" label="品牌" align="center"></el-table-column>
			<el-table-column prop="equipmentLedgerType" label="型号" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="类型" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="存货数量" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="可用数量" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="保养维护类型" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="下次保养周期" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="下次保养日期" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="状态" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="操作" align="center"></el-table-column>
		</el-table>
	</tableFrame>
</template>

<script setup>

import tableFrame from "components/std-table/src/table-text.vue";
import { ref, reactive } from 'vue'

const selectOptions = [
	{
		value: 'Option1',
		label: '刀具',
	},
	{
		value: 'Option2',
		label: '模具',
	},
	{
		value: 'Option3',
		label: '夹具',
	}
];
const stateOptions = [
	{
		value: 'Option1',
		label: '在线'
	},
	{
		value: 'Option2',
		label: '被领用'
	},
	{
		value: 'Option3',
		label: '报废'
	},
	{
		value: 'Option4',
		label: '维修中'
	},
]
const equipmentLedgerCode = ref('');
const equipmentLedgerName = ref('');
const equipmentLedgerType = ref('');
const brand = ref('');
const model = ref('');
const state = ref('');
const type = reactive({
	equipmentLedgerCode: '',
	equipmentLedgerName: '',
	equipmentLedgerType: '',
	brand: '',
	model: '',
	state: ''
})
const reFresh = () => {
	equipmentLedgerCode.value = '';
	equipmentLedgerName.value = '';
	equipmentLedgerType.value = '';
	brand.value = '';
	model.value = '';
	state.value = '';
}
</script>

<style></style>