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
					<el-text class="mx-1" size="small">&nbsp;&nbsp;&nbsp;英文名称</el-text>
					<el-input size="small" v-model="input" style="width: 180px" placeholder="&nbsp;&nbsp;请输入供应商英文名称" />
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
	<el-row :gutter="10">
		<el-col :span="8">
			<el-button type="primary" @click="handleAdd">新增</el-button>
			<el-button type="success" :disabled="single" @click="handleUpdate">修改</el-button>
			<el-button type="danger" :disabled="multiple" @click="handleDelete">删除</el-button>
		</el-col>
	</el-row>
	<!-- 数据表格 -->
	<el-table v-loading="loading" :data="clientList" @selection-change="handleSelectionChange">
		<el-table-column type="selection" width="55"></el-table-column>
		<el-table-column prop="supplierCode" label="供应商编码" align="center"></el-table-column>
		<el-table-column prop="supplierName" label="供应商名称" align="center"></el-table-column>
		<el-table-column prop="supplierForshort" label="供应商简称" align="center"></el-table-column>
		<el-table-column prop="supplierGrade" label="供应商等级" align="center"></el-table-column>
		<el-table-column prop="supplierScore" label="供应商评分" align="center"></el-table-column>
		<el-table-column prop="supplierTel" label="供应商电话" align="center"></el-table-column>
		<el-table-column prop="enableFlag" label="是否启用" align="center">
			<template v-slot="{ row }">
				<el-tag :type="row.enableFlag === 'Y' ? 'success' : 'info'">{{
					row.enableFlag === "Y" ? "是" : "否"
				}}</el-tag>
			</template>
		</el-table-column>
		<el-table-column prop="comment" label="备注" align="center"></el-table-column>

		<el-table-column fixed="right" label="操作" align="center">
			<template v-slot="{ row }">
				<el-button size="mini" type="text" @click="handleUpdate(row)"><el-icon>
						<EditPen />
					</el-icon>修改</el-button>
				<el-button size="mini" type="text" @click="handleDelete(row)"><el-icon>
						<Delete />
					</el-icon>删除</el-button>
			</template>
		</el-table-column>
	</el-table>
</template>

<script>
import { ref } from "vue";
export default {
	data() {
		return {
			value: "",
			options: [
				{
					value: "Option1",
					label: "是",
				},
				{
					value: "Option2",
					label: "否",
				},
			],
			input: "",
			open: ref(true),
			queryParams: {
				supplierCode: "",
				supplierName: "",
				supplierForshort: "",
				supplierGrade: "",
				supplierScore: "",
				supplierTel: "",
				enableFlag: "",
				pageNum: 1,
				pageSize: 10,
			},
			clientList: [
				{
					supplierCode: "V0060",
					supplierName: "大特点",
					supplierForshort: "迪飞斯",
					supplierGrade: "正常",
					supplierScore: "0",
					supplierTel: "",
					enableFlag: "",
					comment: '',
					enableFlag: "Y",
				}
			],
			total: 10,
			loading: false,
			single: true,
			multiple: true
		}
	},
	methods: {
		handleQuery() {
			console.log("查询操作");
		},
		resetQuery() {
			this.queryParams = {
				supplierCode: 'V0060',
				supplierName: '大特点',
				supplierForshort: '迪飞斯',
				supplierScore: '0',
				supplierTel: '',
				enableFlag: '',
			};
		},
		handleSelectionChange(selection) {
			this.single = selection.length !== 1;
			this.multiple = selection.length === 0;
		},
		reset() {
			// 假设一个表单数据对象叫做 form
			this.form = {
				clientCode: "",
				clientName: "",
				clientNick: "",
				clientEn: "",
				clientType: "",
				clientDes: "",
				address: "",
				website: "",
				email: "",
				tel: "",
				enableFlag: "",
				remark: "",
			};
		},
		cancel() {
			this.open = false;
			this.reset();
		},
		// submitForm() {
		//   this.$refs['form'].validate(valid => {
		//     if (valid) {
		//       // 假设有一个提交表单的方法submitForm
		//       submitForm(this.form).then(response => {
		//         // 处理响应
		//         this.open = false;
		//         this.getList();
		//       });
		//     }
		//   });
		// },

		// 这是一个模拟的异步请求，实际应用中应该是一个 API 调用
		getClient(clientId) {
			return new Promise((resolve, reject) => {
				if (!clientId) {
					reject("Client ID is undefined");
					return;
				}
				const clientData = this.clientList.find((client) => client.clientCode === clientId);
				if (clientData) {
					resolve({ data: clientData });
				} else {
					reject("No data found for client with ID: " + clientId);
				}
			});
		},
		handleAdd() {
			//触发新增操作
			this.open = true;
			this.reset();

			// 重置表单到初始状态
			console.log("新增操作");
			this.title = "添加客户";
			this.optType = "add";
		},

		// this.form = Object.assign({}, row);

		// handleUpdate(row) {
		//   console.log('Triggering handleUpdate with row:', row);
		//   this.reset();
		//   const clientId = row.clientCode; // 属性来获取 clientId
		//   this.getClient(clientId).then(response => {
		//     console.log('Data received from getClient:', response.data);
		//     if (response.data) {
		//       this.form = response.data;
		//       this.open = true;
		//       this.title = "修改客户";
		//       this.optType = "edit";
		//     } else {
		//       console.error('No data found for client with ID:', clientId);
		//     }
		//   }).catch(error => {
		//     console.error('Failed to fetch client data:', error);
		//   });
		// },
		handleUpdate(row) {
			this.open = true;
			console.log("Triggering handleUpdate with row:", row);
			this.reset();
			const clientId = row.clientCode;
			this.getClient(clientId)
				.then((response) => {
					console.log("Data received from getClient:", response.data);
					this.form = response.data;
					this.open = true;
					this.title = "修改客户";
					this.optType = "edit";
				})
				.catch((error) => {
					console.error("Failed to fetch client data:", error);
				});
		},
		handleDelete(row) {
			console.log("删除操作", row);
			// 模拟删除操作
			this.clientList = this.clientList.filter((client) => client.clientCode !== row.clientCode);
		},
		getList() {
			console.log("页面加载和查询列表");
			// 模拟数据加载
			this.loading = false;
		},
	},
	created() {
		this.getList();
	},
}

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
