<template>
	<el-row :gutter="21">
		<el-col :span="7">
			<div class="grid-content ep-bg-purple">
				<label>
					<el-text class="mx-1" size="small">供应商编码&nbsp;&nbsp;</el-text><el-input size="small" v-model="input"
						style="width: 180px" placeholder="&nbsp;&nbsp;请输入供应商编码" />
				</label>
			</div>
		</el-col>
		<el-col :span="7">
			<div class="grid-content ep-bg-purple">
				<label>
					<el-text class="mx-1" size="small">供应商名称&nbsp;&nbsp;</el-text><el-input v-model="input" size="small"
						style="width: 180px" placeholder="&nbsp;&nbsp;请输入供应商名称" />
				</label>
			</div>
		</el-col>
		<el-col :span="7">
			<div class="grid-content ep-bg-purple">
				<label>
					<el-text class="mx-1" size="small">供应商简称&nbsp;&nbsp;</el-text><el-input size="small" v-model="input"
						style="width: 180px" placeholder="&nbsp;&nbsp;请输入供应商简称" />
				</label>
			</div>
		</el-col>


	</el-row>
	<el-row>
		<el-col :span="7">
			<div class="grid-content ep-bg-purple">
				<label>
					<el-text class="mx-1" size="small">&nbsp;&nbsp;&nbsp;英文名称</el-text> <el-input size="small"
						v-model="input" style="width: 180px" placeholder="&nbsp;&nbsp;请输入供应商英文名称" />
				</label>
			</div>
		</el-col>
		<el-col :span="7">
			<div class="grid-content ep-bg-purple">
				<el-text id="is" class="mx-1" size="small">是否启用&nbsp;</el-text>
				<div class="flex flex-wrap gap-4 items-center" id="select">
					<el-select v-model="value" placeholder="&nbsp;&nbsp;是否启用" size="small" style="width: 180px">
						<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value" />
					</el-select>
				</div>
			</div>
		</el-col>
		<el-col :span="7">
			<div class="mb-4">
				<el-button type="primary" size="small">
					<el-icon>
						<Search />
					</el-icon>
					&nbsp;搜索
				</el-button>
				<el-button size="small">
					<el-icon>
						<RefreshRight />
					</el-icon>
					&nbsp;重置
				</el-button>
			</div>
		</el-col>
	</el-row>
	表格
</template>

<script lang="ts" setup>
import { ref } from 'vue'


const value = ref('')

const options = [
	{
		value: 'Option1',
		label: '是',
	},
	{
		value: 'Option2',
		label: '否',
	}
]
const input = ref('')
</script>


<style scoped>
#is {
	margin-left: 13px;
}

#select {
	float: right;
	margin-right: 86px;
}

.el-row {
	margin-bottom: 20px;
}

.el-row:last-child {
	margin-bottom: 0;
}

.el-col {
	border-radius: 4px;
}

.grid-content {
	border-radius: 4px;
	min-height: 36px;
}

.example-showcase .el-dropdown-link {
	cursor: pointer;
	color: var(--el-color-primary);
	display: flex;
	align-items: center;
}

.mx-1 {
	font-weight: bold;
}
</style>