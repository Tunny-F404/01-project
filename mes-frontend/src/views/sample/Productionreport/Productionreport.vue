<template>
	<el-container>
		<el-main>
			<!-- 搜索条件 -->
			<el-row :gutter="20" class="input-row">
				<el-col :span="4">
					<span class="input-label">报工类型：</span>
					<el-select v-model="orderStatus" placeholder="请选择报工类型" class="input-size">
						<el-option label="自行报工" value="自行报工"></el-option>
						<el-option label="统一报工" value="统一报工"></el-option>
					</el-select>
				</el-col>
				<el-col :span="4">
					<span class="input-label">工作站名称：</span>
					<el-input v-model="workOrderName" placeholder="请输入工作站名称" class="input-size" />
				</el-col>
				<el-col :span="4">
					<span class="input-label">生产工单编号：</span>
					<el-input v-model="workOrderType" placeholder="请选择生产工单编号" class="input-size" />
				</el-col>
				<el-col :span="4">
					<span class="input-label">产品物料编码：</span>
					<el-input v-model="productCode" placeholder="请输入产品物料编码" class="input-size" />
				</el-col>
				<el-col :span="4">
					<span class="input-label">产品物料名称：</span>
					<el-input v-model="productName" placeholder="请输入产品物料名称" class="input-size" />
				</el-col>
				<el-col :span="4">
					<span class="input-label">报工人：</span>
					<el-input v-model="sourceOrder" placeholder="请输入报工人名称" class="input-size" />
				</el-col>
			</el-row>
			<el-row :gutter="20" class="input-row">
				<el-col :span="4">
					<span class="input-label">记录人：</span>
					<el-input v-model="noteKepper" placeholder="请输入记录人名称" class="input-size" />
				</el-col>
				<el-col :span="4">
					<span class="input-label">状态：</span>
					<el-select v-model="states" placeholder="请选择状态" class="input-size">
						<el-option label="草稿" value="草稿"></el-option>
						<el-option label="已确认" value="已确认"></el-option>
						<el-option label="审批中" value="审批中"></el-option>
						<el-option label="已审批" value="已审批"></el-option>
						<el-option label="已完成" value="已完成"></el-option>
					</el-select>
				</el-col>
				<el-col :span="4" class="button-container">
					<el-button type="primary" @click="search">搜索</el-button>
					<el-button @click="reset">重置</el-button>
				</el-col>
			</el-row>

			<!-- 操作按钮 -->
			<el-row :gutter="20" style="margin-top: 20px">
				<el-col :span="24">
					<el-button type="primary" @click="addNew">新增</el-button>
					<el-button type="success" @click="exportData">导出</el-button>
					<el-button type="danger" @click="batchDelete">批量删除</el-button>
				</el-col>
			</el-row>

			<!-- 数据表格 -->
			<el-row :gutter="20" style="margin-top: 20px">
				<el-col :span="24">
					<el-table :data="paginatedData" @selection-change="handleRowSelectionChange" style="width: 100%">
						<el-table-column type="selection" width="40"></el-table-column>
						<el-table-column prop="workOrderCode" label="报工类型" width="180"></el-table-column>
						<el-table-column prop="workOrderName" label="工作站名称" width="180"></el-table-column>
						<el-table-column prop="workOrderType" label="生产工单编号" width="100"></el-table-column>
						<el-table-column prop="productCode" label="产品物料编码" width="180"></el-table-column>
						<el-table-column prop="productName" label="产品物料名称" width="180"></el-table-column>
						<el-table-column prop="models" label="规格型号" width="80"></el-table-column>
						<el-table-column prop="sourceOrder" label="报工人" width="100"></el-table-column>
						<el-table-column prop="sourceQty" label="报工数量" width="120"></el-table-column>
						<el-table-column prop="sourceTime" label="报工时间" width="120"></el-table-column>
						<el-table-column prop="noteKeeper" label="记录人" width="120"></el-table-column>
						<el-table-column prop="states" label="状态" width="120"></el-table-column>
						<el-table-column label="操作" width="180">
							<template v-slot="scope">
								<el-button type="text" size="small" @click="handleEdit(scope.row)">修改</el-button>
								<el-button type="text" size="small" @click="handleDelete(scope.row)">删除</el-button>
							</template>
						</el-table-column>
					</el-table>
				</el-col>
			</el-row>

			<!-- 分页 -->
			<el-pagination
				:current-page="currentPage"
				:page-sizes="[10, 20, 30, 40]"
				:page-size="pageSize"
				layout="total, sizes, prev, pager, next, jumper"
				:total="tableData.length"
				@size-change="handleSizeChange"
				@current-change="handleCurrentChange"
			></el-pagination>
		</el-main>

		<!-- 编辑弹窗 -->
		<el-dialog title="编辑工单" :visible.sync="editDialogVisible">
			<el-form :model="editingRow">
				<el-form-item label="工单编码">
					<el-input v-model="editingRow.workOrderCode" disabled></el-input>
				</el-form-item>
				<el-form-item label="工单名称">
					<el-input v-model="editingRow.workOrderName"></el-input>
				</el-form-item>
				<el-form-item label="工单类型">
					<el-select v-model="editingRow.workOrderType">
						<el-option label="自产" value="自产"></el-option>
						<el-option label="外购" value="外购"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="来源单据">
					<el-input v-model="editingRow.sourceOrder"></el-input>
				</el-form-item>
				<el-form-item label="产品编号">
					<el-input v-model="editingRow.productCode"></el-input>
				</el-form-item>
				<el-form-item label="产品名称">
					<el-input v-model="editingRow.productName"></el-input>
				</el-form-item>
				<el-form-item label="单位">
					<el-input v-model="editingRow.unit"></el-input>
				</el-form-item>
				<el-form-item label="工单数量">
					<el-input v-model="editingRow.workOrderQty" type="number"></el-input>
				</el-form-item>
				<el-form-item label="调整数量">
					<el-input v-model="editingRow.adjustedQty" type="number"></el-input>
				</el-form-item>
				<el-form-item label="已生产量">
					<el-input v-model="editingRow.producedQty" type="number"></el-input>
				</el-form-item>
				<el-form-item label="批次号">
					<el-input v-model="editingRow.batchNo"></el-input>
				</el-form-item>
				<el-form-item label="客户编码">
					<el-input v-model="editingRow.customerCode"></el-input>
				</el-form-item>
				<el-form-item label="客户名称">
					<el-input v-model="editingRow.customerName"></el-input>
				</el-form-item>
				<el-form-item label="需求日期">
					<el-date-picker v-model="editingRow.demandDate" type="date"></el-date-picker>
				</el-form-item>
				<el-form-item label="状态">
					<el-select v-model="editingRow.orderStatus">
						<el-option label="已确认" value="已确认"></el-option>
						<el-option label="未确认" value="未确认"></el-option>
						<el-option label="草稿" value="草稿"></el-option>
						<el-option label="已确认" value="已确认"></el-option>
						<el-option label="审批中" value="审批中"></el-option>
						<el-option label="已审批" value="已审批"></el-option>
						<el-option label="已完成" value="已完成"></el-option>
					</el-select>
				</el-form-item>
			</el-form>
			<span slot="footer" class="dialog-footer">
				<el-button @click="cancelEdit">取消</el-button>
				<el-button type="primary" @click="saveEdit">保存</el-button>
			</span>
		</el-dialog>
	</el-container>
</template>

<script>
export default {
	data() {
		return {
			workOrderCode: "",
			workOrderName: "",
			workOrderType: "",
			demandDate: "",
			productCode: "",
			productName: "",
			sourceOrder: "",
			customerCode: "",
			customerName: "",
			orderStatus: "",
			pageSize: 10,
			currentPage: 1,
			tableData: [
				// 数据示例
				{
					workOrderCode: "MO202406020003",
					workOrderName: "test.洛斯达",
					workOrderType: "自产",
					sourceOrder: "库存备货",
					productCode: "IF2022082439",
					productName: "螺丝刀",
					unit: "PCS",
					workOrderQty: 400,
					adjustedQty: 0,
					producedQty: 0,
					batchNo: "BN20240602",
					customerCode: "C20240602",
					customerName: "客户A",
					demandDate: "2024-06-02",
					orderStatus: "已确认",
				},
				// 其他数据...
			],
			editDialogVisible: false,
			editingRow: {},
			selectedRows: [],
		};
	},
	computed: {
		paginatedData() {
			const start = (this.currentPage - 1) * this.pageSize;
			const end = this.currentPage * this.pageSize;
			return this.tableData.slice(start, end);
		},
	},
	methods: {
		search() {
			const filters = {
				workstationCode: this.workstationCode.trim(), // 去除输入内容两端的空白字符
				workstationName: this.workstationName.trim(), // 去除输入内容两端的空白字符
				selectedWorkshop: this.selectedWorkshop,
				selectedOrder: this.selectedOrder,
			};

			// 如果两个输入框都为空，则恢复显示所有数据
			if (!filters.workstationCode && !filters.workstationName) {
				this.reset();
				return;
			}

			// 对表格数据进行过滤
			const filteredData = this.tableData.filter((item) => {
				if (filters.workstationCode && !item.code.includes(filters.workstationCode)) {
					return false;
				}

				if (filters.workstationName && !item.name.includes(filters.workstationName)) {
					return false;
				}

				return true;
			});

			// 更新表格数据为过滤后的数据
			this.tableData = filteredData;
		},
		reset() {
			this.workOrderCode = "";
			this.workOrderName = "";
			this.workOrderType = "";
			this.demandDate = "";
			this.productCode = "";
			this.productName = "";
			this.sourceOrder = "";
			this.customerCode = "";
			this.customerName = "";
			this.orderStatus = "";
		},
		addNew() {
			// 新增逻辑
			console.log("新增");
		},
		exportData() {
			// 导出逻辑
			console.log("导出");
		},
		batchDelete() {
			// 批量删除逻辑
			console.log("批量删除", this.selectedRows);
		},
		handleRowSelectionChange(selectedRows) {
			this.selectedRows = selectedRows;
		},
		handleSizeChange(size) {
			this.pageSize = size;
		},
		handleCurrentChange(page) {
			this.currentPage = page;
		},
		handleEdit(row) {
			this.editingRow = { ...row };
			this.editDialogVisible = true;
		},
		handleDelete(row) {
			const index = this.tableData.indexOf(row);
			if (index !== -1) {
				this.tableData.splice(index, 1);
			}
		},
		cancelEdit() {
			this.editDialogVisible = false;
		},
		saveEdit() {
			// 保存编辑逻辑
			const index = this.tableData.findIndex((item) => item.workOrderCode === this.editingRow.workOrderCode);
			if (index !== -1) {
				this.tableData.splice(index, 1, this.editingRow);
			}
			this.editDialogVisible = false;
		},
	},
};
</script>

<style scoped>
.input-row {
	margin-bottom: 20px;
}
.input-size {
	width: 50%;
}
.button-container {
	display: flex;
	justify-content: flex-start;
	align-items: center;
}
.dialog-footer {
	text-align: right;
}
</style>
