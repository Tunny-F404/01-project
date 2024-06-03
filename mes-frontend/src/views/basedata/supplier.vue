<template>
	<tableFrame title="供应商管理">
		<template #extra>
			<el-button @click="onExportData">导出数据<el-icon :size="22">
					<UploadFilled />
				</el-icon>
			</el-button>
			<template>
				<div>
					<slot name="extra"></slot>
					<!-- 其他内容 -->
				</div>
			</template>
			<!-- <el-button @click="onAddChannel"
			>添加
			<el-icon :size="20"> <Plus />
				添加图标 </el-icon>
		</el-button> -->
		</template>
		<!--表单-->
		<el-form :inline="true" class="demo-form-inline">
			<el-row>
				<el-col :span="8">
					<el-form-item label="供应商编码：">
						<el-input v-model="supplierCode" placeholder="请输入供应商编码" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="供应商名称：">
						<el-input v-model="supplierName" placeholder="请输入供应商名称" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="供应商简称：">
						<el-input v-model="supplierNick" placeholder="请输入供应商简称" clearable />
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="8">
					<el-form-item label="供应商英文名称：">
						<el-input v-model="supplierEn" placeholder="请输入供应商英文名称" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="是否启用：">
						<el-select v-model="enableFlag" placeholder="请选择">
							<el-option label="是" :value="true"></el-option>
							<el-option label="否" :value="false"></el-option>
						</el-select>
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item>
						<el-button type="primary" @click="onSubmit"> <el-icon>
								<Search />
							</el-icon>查询</el-button>
						<el-button @click="reFresh"><el-icon>
								<Refresh />
							</el-icon>重置</el-button>
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>

		<el-button type="primary" plain @click="openTestDialog"><el-icon>
				<Plus />
			</el-icon>新增</el-button>
		<el-button type="success" plain @click="onEditchannel(row)"><el-icon>
				<EditPen />
			</el-icon>修改</el-button>
		<el-button type="danger" plain><el-icon>
				<Delete />
			</el-icon>删除</el-button>
		<!-- 表格 -->
		<el-table v-loading="loading" :data="supplierList" @selection-change="handleSelectionChange">
			<el-table-column type="selection" width="55"></el-table-column>
			<el-table-column prop="supplierCode" label="供应商编码" align="center"></el-table-column>
			<el-table-column prop="supplierName" label="供应商名称" align="center"></el-table-column>
			<el-table-column prop="supplierForshort" label="供应商简称" align="center"></el-table-column>
			<el-table-column prop="supplierGrade" label="供应商等级" align="center"></el-table-column>
			<el-table-column prop="supplierScore" label="供应商评分" align="center"></el-table-column>
			<el-table-column prop="supplierTel" label="供应商电话" align="center"></el-table-column>
			<el-table-column prop="enableFlag" label="是否启用" align="center">
				<template #default="{ row }">
					<el-tag :class="row.isEnabled ? 'status-enabled' : 'status-disabled'" @click="toggleStatus(row)"
						style="cursor: pointer;" class="status-tag">
						{{ row.isEnabled ? '是' : '否' }}
					</el-tag>

				</template>
			</el-table-column>

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

		<!--空处理-->
		<template #empty>
			<el-empty description="没有数据"></el-empty>
		</template>
	</tableFrame>
	<el-dialog v-model="testDialogVisible" :title="dialogTitle">
		<el-form ref="formRef" :model="formModel" :rules="rules" label-width="120px">
			<el-row>
				<el-col :span="8">
					<el-form-item label="供应商编码" prop="supplierCode">
						<el-input v-model="formModel.supplierCode" placeholder="请输入供应商编码" />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="供应商名称" prop="supplierName">
						<el-input v-model="formModel.supplierName" placeholder="请输入供应商名称" />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="供应商简称" prop="supplierNick">
						<el-input v-model="formModel.supplierNick" placeholder="请输入供应商简称" />
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="8">
					<el-form-item label="供应商英文名称" prop="supplierEn">
						<el-input v-model="formModel.supplierEn" placeholder="请输入供应商英文名称" />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<!-- <el-form-item label="供应商类型" prop="supplierType">
						<el-select v-model="formModel.supplierType" placeholder="请选择供应商类型">
							<el-option label="类型1" value="type1"></el-option>
							<el-option label="类型2" value="type2"></el-option>
						</el-select>
					</el-form-item> -->
				</el-col>
				<el-col :span="8">
					<el-form-item label="供应商简介" prop="supplierDes">
						<el-input v-model="formModel.supplierDes" placeholder="请输入供应商简介" />
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="18">
					供应商等级
				</el-col>
				<el-col :span="18">
					供应商评分
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="12">
					<el-form-item label="供应商官网地址" prop="website">
						<el-input v-model="formModel.website" placeholder="请输入供应商官网地址" />
					</el-form-item>
				</el-col>

				<el-col :span="12">
					<el-form-item label="供应商邮箱地址" prop="email">
						<el-input v-model="formModel.email" placeholder="请输入供应商邮箱地址" />
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="供应商电话" prop="call">
						<el-input v-model="formModel.call" placeholder="请输入供应商电话" />
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="12">
					<el-form-item label="供应商电话" prop="tel">
						<el-input v-model="formModel.tel" placeholder="请输入供应商电话" />
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="供应商LOGO" prop="supplierLogo">
						<el-input v-model="formModel.supplierLogo" placeholder="请输入供应商LOGO" />
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="8">
					<el-form-item label="联系人1" prop="contact1">
						<el-input v-model="formModel.contact1" placeholder="请输入联系人1" />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="联系人1-电话" prop="contact1Tel">
						<el-input v-model="formModel.contact1Tel" placeholder="请输入联系人1-电话" />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="联系人1-邮箱" prop="contact1Email">
						<el-input v-model="formModel.contact1Email" placeholder="请输入联系人1-邮箱" />
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="8">
					<el-form-item label="联系人2" prop="contact2">
						<el-input v-model="formModel.contact2" placeholder="请输入联系人2" />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="联系人2-电话" prop="contact2Tel">
						<el-input v-model="formModel.contact2Tel" placeholder="请输入联系人2-电话" />
					</el-form-item>
				</el-col>
				<el-col :span="8">
					<el-form-item label="联系人2-邮箱" prop="contact2Email">
						<el-input v-model="formModel.contact2Email" placeholder="请输入联系人2-邮箱" />
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="12">
					<el-form-item label="社会信用代码" prop="creditCode">
						<el-input v-model="formModel.creditCode" placeholder="请输入社会信用代码" />
					</el-form-item>
				</el-col>
				<el-col :span="12">
					<el-form-item label="是否有效" prop="enableFlag">
						<el-radio-group v-model="formModel.enableFlag">
							<el-radio label="是" value="yes">是</el-radio>
							<el-radio label="否" value="no">否</el-radio>
						</el-radio-group>
					</el-form-item>
				</el-col>
			</el-row>
			<el-row>
				<el-col :span="24">
					<el-form-item label="备注" prop="remark">
						<el-input v-model="formModel.remark" type="textarea" placeholder="请输入备注" />
					</el-form-item>
				</el-col>
			</el-row>
		</el-form>
		<template #footer>
			<el-button @click="cancelForm">取消</el-button>
			<el-button type="primary" @click="submitForm">确定</el-button>
		</template>
	</el-dialog>
</template>

<script setup>
import { ref } from "vue";
import tableFrame from "@/components/table-list-use/table-text.vue";

let value = "";
let options = [
	{
		value: "Option1",
		label: "是",
	},
	{
		value: "Option2",
		label: "否",
	},
];
let input = "";
let open = ref(true);
let queryParams = {
	supplierCode: "",
	supplierName: "",
	supplierForshort: "",
	supplierGrade: "",
	supplierScore: "",
	supplierTel: "",
	enableFlag: "",
	pageNum: 1,
	pageSize: 10,
};

let supplierList = [
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
	},
	{
		supplierCode: "V0063",
		supplierName: "瑞丽物资有限公司",
		supplierForshort: "",
		supplierGrade: "正常",
		supplierScore: "0",
		supplierTel: "",
		enableFlag: "",
		comment: '',
		enableFlag: "Y",
	},
	{
		supplierCode: "V0067",
		supplierName: "DB供应商",
		supplierForshort: "",
		supplierGrade: "正常",
		supplierScore: "0",
		supplierTel: "",
		enableFlag: "",
		comment: '',
		enableFlag: "Y",
	},
];
//对话框标题
const dialogTitle = ref("");
let total = 10;
let loading = false;
let single = true;
let multiple = true;
const formModel = ref({
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
	clientLogo: "",
	contact1: "",
	contact1Tel: "",
	contact1Email: "",
	contact2: "",
	contact2Tel: "",
	contact2Email: "",
	creditCode: "",
	enableFlag: "",
	remark: ""
});
const testDialogVisible = ref(false);
const openTestDialog = () => {
	dialogTitle.value = "添加供应商信息";
	console.log(11)
	formModel.value = {
		supplierCode: "",
		supplierName: "",
		supplierNick: "",
		supplierEn: "",
		supplierDes: "",
		website: "",
		email: "",
		call: '',
		tel: "",
		supplierLogo: "",
		contact1: "",
		contact1Tel: "",
		contact1Email: "",
		contact2: "",
		contact2Tel: "",
		contact2Email: "",
		creditCode: "",
		enableFlag: "",
		remark: ""
	};
	testDialogVisible.value = true;
};
//修改供应商信息对话框
const onEditchannel = (row) => {
	dialogTitle.value = "修改供应商信息";
	formModel.value = { ...row };
	testDialogVisible.value = true;
};
const onDelChannel = async (row) => {
	//删除
	await ElMessageBox.confirm("你确认要删除该单位么", "温馨提示", {
		type: "warning",
		confirmButtonText: "确认",
		cancelButtonText: "取消",
	});
	ElMessage.success("删除成功");
	console.log(row);
	//删除后再渲染数据
	getPageList();
};
const rules = {
	supplierCode: [{ required: true, message: "请输入供应商编码", trigger: "blur" }],
	supplierName: [{ required: true, message: "请输入供应商名称", trigger: "blur" }],
	supplierNick: [{ required: false, message: "请输入供应商简称", trigger: "blur" }],
	supplierEn: [{ required: false, message: "请输入供应商英文名称", trigger: "blur" }],
	// supplierType: [{ required: false, message: "请选择供应商类型", trigger: "change" }],
	supplierDes: [{ required: false, message: "请输入内容", trigger: "blur" }],
	address: [{ required: false, message: "请输入内容", trigger: "blur" }],
	website: [{ required: false, message: "请输入供应商官网地址", trigger: "blur" }],
	email: [{ required: false, message: "请输入供应商邮箱地址", trigger: "blur" }],
	tel: [{ required: false, message: "请输入供应商电话", trigger: "blur" }],
	supplierLogo: [{ required: false, message: "请输入供应商LOGO", trigger: "blur" }],
	contact1: [{ required: false, message: "请输入联系人1", trigger: "blur" }],
	contact1Tel: [{ required: false, message: "请输入联系人1-电话", trigger: "blur" }],
	contact1Email: [{ required: false, message: "请输入联系人1-邮箱", trigger: "blur" }],
	contact2: [{ required: false, message: "请输入联系人2", trigger: "blur" }],
	contact2Tel: [{ required: false, message: "请输入联系人2-电话", trigger: "blur" }],
	contact2Email: [{ required: false, message: "请输入联系人2-邮箱", trigger: "blur" }],
	creditCode: [{ required: false, message: "请输入社会信用代码", trigger: "blur" }],
	enableFlag: [{ required: false, message: "请选择是否有效", trigger: "change" }],
	remark: [{ required: false, message: "请输入备注", trigger: "blur" }]
};
const handleQuery = () => {
	console.log("查询操作");
};
const resetQuery = () => {
	this.queryParams = {
		supplierCode: 'V0060',
		supplierName: '大特点',
		supplierForshort: '迪飞斯',
		supplierScore: '0',
		supplierTel: '',
		enableFlag: '',
	};
};
const handleSelectionChange = (selection) => {
	this.single = selection.length !== 1;
	this.multiple = selection.length === 0;
};
const reset = () => {
	// 假设一个表单数据对象叫做 form
	this.form = {
		supplierCode: "",
		supplierName: "",
		supplierNick: "",
		supplierEn: "",
		supplierType: "",
		supplierDes: "",
		address: "",
		website: "",
		email: "",
		tel: "",
		enableFlag: "",
		remark: "",
	};
};
const cancel = () => {
	this.open = false;
	this.reset();
};
const submitForm = () => {
	formRef.value.validate((valid) => {
		if (valid) {
			console.log("提交成功", formModel.value);
			testDialogVisible.value = false;
		} else {
			console.log("提交失败");
			return false;
		}
	});
};

// 这是一个模拟的异步请求，实际应用中应该是一个 API 调用
const getsupplier = (supplierId) => {
	return new Promise((resolve, reject) => {
		if (!supplierId) {
			reject("supplier ID is undefined");
			return;
		}
		const supplierData = this.supplierList.find((supplier) => supplier.supplierCode === supplierId);
		if (supplierData) {
			resolve({ data: supplierData });
		} else {
			reject("No data found for supplier with ID: " + supplierId);
		}
	});
};
const handleAdd = () => {
	//触发新增操作
	this.open = true;
	this.reset();
	// 重置表单到初始状态
	console.log("新增操作");
	this.title = "添加供应商";
	this.optType = "add";
};

// this.form = Object.assign({}, row);

// handleUpdate(row) {
//   console.log('Triggering handleUpdate with row:', row);
//   this.reset();
//   const supplierId = row.supplierCode; // 属性来获取 supplierId
//   this.getsupplier(supplierId).then(response => {
//     console.log('Data received from getsupplier:', response.data);
//     if (response.data) {
//       this.form = response.data;
//       this.open = true;
//       this.title = "修改供应商";
//       this.optType = "edit";
//     } else {
//       console.error('No data found for supplier with ID:', supplierId);
//     }
//   }).catch(error => {
//     console.error('Failed to fetch supplier data:', error);
//   });
// },
const handleUpdate = (row) => {
	this.open = true;
	console.log("Triggering handleUpdate with row:", row);
	this.reset();
	const supplierId = row.supplierCode;
	this.getsupplier(supplierId)
		.then((response) => {
			console.log("Data received from getsupplier:", response.data);
			this.form = response.data;
			this.open = true;
			this.title = "修改供应商";
			this.optType = "edit";
		})
		.catch((error) => {
			console.error("Failed to fetch supplier data:", error);
		});
};
const handleDelete = (row) => {
	console.log("删除操作", row);
	// 模拟删除操作
	this.supplierList = this.supplierList.filter((supplier) => supplier.supplierCode !== row.supplierCode);
};
const getList = () => {
	console.log("页面加载和查询列表");
	// 模拟数据加载
	this.loading = false;
};
const created = () => {
	this.getList();
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

	.el-table th,
	.el-table td {
		text-align: center;
	}
}
</style>
