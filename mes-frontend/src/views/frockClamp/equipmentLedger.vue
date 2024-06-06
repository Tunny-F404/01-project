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
					<el-form-item label="工装夹具类型">
						<el-input v-model="codingType" style="width: 260px" placeholder="请输入编码类型" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="工装夹具名称">
						<el-input v-model="typeName" style="width: 260px" placeholder="请输入类型名称" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="工装夹具类型">
						<div class="flex flex-wrap gap-4 items-center">
							<el-select v-model="SelectValue" placeholder="Select" style="width: 240px">
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
						<el-input v-model="codingType" style="width: 260px" placeholder="请输入编码类型" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="6">
					<el-form-item label="型号">
						<el-input v-model="typeName" style="width: 260px" placeholder="请输入类型名称" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="6">
					<el-form-item label="状态">
						<div class="flex flex-wrap gap-4 items-center">
							<el-select v-model="SelectValue" placeholder="Select" style="width: 240px">
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
	</tableFrame>
</template>

<script setup>

import tableFrame from "components/std-table/src/table-text.vue";
import { ref, reactive } from 'vue'

</script>

<style></style>