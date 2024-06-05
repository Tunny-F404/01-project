<script setup lang="ts">
import { ref } from "vue";
import tableFrame from "@/components/table-list-use/table-text.vue";
import request from "@/apis/request.js";

// 搜索表单
const rtCode = ref("");
const rtName = ref("");
const poCode = ref("");
const vendorName = ref("");
// 存储对话框的标题
const dialogTitle = ref("");
// 表格数据
const tableList = ref([
  {
    rtCode: "RT001",
    rtName: "退货单1",
    poCode: "PO001",
    vendorCode: "V001",
    vendorName: "供应商1",
    rtDate: "2023-10-01",
    status: "PREPARE",
  },
  {
    rtCode: "RT002",
    rtName: "退货单2",
    poCode: "PO002",
    vendorCode: "V002",
    vendorName: "供应商2",
    rtDate: "2023-10-02",
    status: "CONFIRMED",
  },
  {
    rtCode: "RT003",
    rtName: "退货单3",
    poCode: "PO003",
    vendorCode: "V003",
    vendorName: "供应商3",
    rtDate: "2023-10-03",
    status: "PREPARE",
  },
  {
    rtCode: "RT004",
    rtName: "退货单4",
    poCode: "PO004",
    vendorCode: "V004",
    vendorName: "供应商4",
    rtDate: "2023-10-04",
    status: "CONFIRMED",
  },
  {
    rtCode: "RT005",
    rtName: "退货单5",
    poCode: "PO005",
    vendorCode: "V005",
    vendorName: "供应商5",
    rtDate: "2023-10-05",
    status: "PREPARE",
  },
  {
    rtCode: "RT006",
    rtName: "退货单6",
    poCode: "PO006",
    vendorCode: "V006",
    vendorName: "供应商6",
    rtDate: "2023-10-06",
    status: "CONFIRMED",
  },
]);

// 自定义排序逻辑
function handleSortChange({ prop, order }) {
  tableList.value.sort((a, b) => {
    if (order === "ascending") {
      return a[prop] > b[prop] ? 1 : -1;
    }
    else if (order === "descending") {
      return a[prop] < b[prop] ? 1 : -1;
    }
    else {
      return 0;
    }
  });
}
// 对话框
const dialogVisible = ref(false);
const formRef = ref();
const formModel = ref({
  rtId: "",
  rtCode: "",
  rtName: "",
  poCode: "",
  vendorId: "",
  vendorCode: "",
  vendorName: "",
  vendorNick: "",
  rtDate: "",
  status: "",
  remark: "",
  createBy: "",
  createTime: "",
  updateBy: "",
  updateTime: "",
});

const rules = {
  rtCode: [{ required: true, message: "请输入退货单编号", trigger: "blur" }],
  rtName: [{ required: true, message: "请输入退货单名称", trigger: "blur" }],
  vendorName: [{ required: true, message: "请输入供应商名称", trigger: "blur" }],
  rtDate: [{ required: true, message: "请选择退货日期", trigger: "change" }],
};

function submitForm() {
  formRef.value.validate((valid) => {
    if (valid) {
      console.log("提交成功", formModel.value);
      dialogVisible.value = false;
    }
    else {
      console.log("提交失败");
      return false;
    }
  });
}

function cancelForm() {
  dialogVisible.value = false;
}

// 分页
const loading = ref(false);
const parms = ref({
  pagenum: 1,
  pagesize: 5,
});
const total = ref(tableList.value.length);

const originalTableList = ref([...tableList.value]);
function getPageList() {
  loading.value = true;
  const start = (parms.value.pagenum - 1) * parms.value.pagesize;
  const end = start + parms.value.pagesize;
  tableList.value = originalTableList.value.slice(start, end);
  loading.value = false;
}

function onSizeChange(size) {
  parms.value.pagenum = 1;
  parms.value.pagesize = size;
  getPageList();
}

function onCurrentChange(page) {
  parms.value.pagenum = page;
  getPageList();
}

// 隐藏搜索栏
const showSearchBar = ref(true);
function toggleSearchBar() {
  showSearchBar.value = !showSearchBar.value;
}
// 模拟刷新数据
function refreshData() {
  loading.value = true; // 显示加载动画
  // 模拟刷新数据
  setTimeout(() => {
    // 调用后端接口获取最新数据
    // request.get('/api/refresh-data').then(response => {
    //   tableList.value = response.data;
    //   originalTableList.value = [...tableList.value];
    //   getPageList();
    // }).finally(() => {
    //   loading.value = false; // 隐藏加载动画
    // });

    // 模拟数据刷新
    tableList.value = [
      ...tableList.value,
      {
        rtCode: "RT007",
        rtName: "退货单7",
        poCode: "PO007",
        vendorCode: "V007",
        vendorName: "供应商7",
        rtDate: "2023-10-07",
        status: "PREPARE",
      },
    ];
    originalTableList.value = [...tableList.value];
    getPageList();
    loading.value = false; // 隐藏加载动画
  }, 1000);
}
// 新增退货单
function handleAdd() {
  formModel.value = {
    rtId: "",
    rtCode: "",
    rtName: "",
    poCode: "",
    vendorId: "",
    vendorCode: "",
    vendorName: "",
    vendorNick: "",
    rtDate: "",
    status: "",
    remark: "",
    createBy: "",
    createTime: "",
    updateBy: "",
    updateTime: "",
  };
  dialogTitle.value = "新增退货单";
  dialogVisible.value = true;
}

// 修改退货单
function handleUpdate(row) {
  formModel.value = { ...row };
  dialogTitle.value = "修改退货单";
  dialogVisible.value = true;
}

// 模拟删除操作
function handleDelete(row) {
  ElMessageBox.confirm("你确认要删除该退货单么", "温馨提示", {
    type: "warning",
    confirmButtonText: "确认",
    cancelButtonText: "取消",
  })
    .then(() => {
      // 模拟删除操作
      const index = tableList.value.findIndex(item => item.rtCode === row.rtCode);
      if (index !== -1) {
        tableList.value.splice(index, 1);
        originalTableList.value = [...tableList.value];
        ElMessage.success("删除成功");
      }

      // 后端接口调用
      // request.delete(`/api/returns/${row.rtCode}`)
      //   .then(response => {
      //     if (response.status === 200) {
      //       const index = tableList.value.findIndex(item => item.rtCode === row.rtCode);
      //       if (index !== -1) {
      //         tableList.value.splice(index, 1);
      //         originalTableList.value = [...tableList.value];
      //         ElMessage.success("删除成功");
      //       }
      //     } else {
      //       ElMessage.error("删除失败");
      //     }
      //   })
      //   .catch(error => {
      //     ElMessage.error("删除失败");
      //   });
    })
    .catch(() => {
      ElMessage.info("已取消删除");
    })
    .finally(() => {
      getPageList(); // 重新渲染分页数据
    });
}

//导出数据逻辑
function handleExport() {
  console.log("导出数据");
}

//模拟搜索筛选
function handleQuery() {
  // 模拟过滤数据
  tableList.value = originalTableList.value.filter(item => {
    return (
      (!rtCode.value || item.rtCode.includes(rtCode.value)) &&
      (!rtName.value || item.rtName.includes(rtName.value)) &&
      (!poCode.value || item.poCode.includes(poCode.value)) &&
      (!vendorName.value || item.vendorName.includes(vendorName.value))
    );
  });
  getPageList();
	// 调用后端接口获取过滤后的数据
  // request.get('/api/query', { params: { rtCode: rtCode.value, rtName: rtName.value, poCode: poCode.value, vendorName: vendorName.value } })
  //   .then(response => {
  //     tableList.value = response.data;
  //     originalTableList.value = [...tableList.value];
  //     getPageList();
  //   });
}

function resetQuery() {
  rtCode.value = "";
  rtName.value = "";
  poCode.value = "";
  vendorName.value = "";
  handleQuery();
}

function handleSelectionChange(val) {
  selectedRow.value = val.length === 1 ? val[0] : null;
  console.log("选中项变化", val);
}

// 执行退货
async function handleExecute(row) {
  try {
    await ElMessageBox.confirm("你确认要执行退货么", "温馨提示", {
      type: "warning",
      confirmButtonText: "确认",
      cancelButtonText: "取消",
    });
    ElMessage.success("执行退货成功");
    console.log("执行退货", row);
    // 执行退货的逻辑
  }
  catch (error) {
    console.log("取消执行退货");
  }
}
const selectedRow = ref(null);

</script>

<template>
  <tableFrame title="采购退货管理">
    <template #extra>
      <el-button @click="handleExport">导出数据<el-icon :size="22"><UploadFilled /></el-icon></el-button>
    </template>

    <!-- 搜索表单 -->
    <el-form v-if="showSearchBar" :inline="true" class="demo-form-inline">
      <el-row>
        <el-col :span="8">
          <el-form-item label="退货单编号：">
            <el-input v-model="rtCode" placeholder="请输入退货单编号" clearable />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="退货单名称：">
            <el-input v-model="rtName" placeholder="请输入退货单名称" clearable />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="供应商名称：">
            <el-input v-model="vendorName" placeholder="请输入供应商名称" clearable />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="订单编号：">
            <el-input v-model="poCode" placeholder="请输入订单编号" clearable />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item>
            <el-button type="primary" @click="handleQuery"><el-icon><Search /></el-icon>查询</el-button>
            <el-button @click="resetQuery"><el-icon><Refresh /></el-icon>重置</el-button>
          </el-form-item>
</el-col>
      </el-row>

    </el-form>

    <!-- 操作按钮 -->
		<div class="action-buttons">
    <el-button type="primary" plain @click="handleAdd">
      <el-icon><Plus /></el-icon>新增
    </el-button>
		<el-button type="success" plain @click="handleUpdate(selectedRow)">
  <el-icon><EditPen /></el-icon>修改
</el-button>
<el-button type="danger" plain @click="handleDelete(selectedRow)">
  <el-icon><Delete /></el-icon>删除
</el-button>
<div class="search-icons">
<el-tooltip content="隐藏搜索栏" placement="top">
  <el-button @click="toggleSearchBar" plain>
    <el-icon><Search /></el-icon>
  </el-button>
</el-tooltip>
<el-tooltip content="刷新" placement="top">
  <el-button @click="refreshData" plain>
    <el-icon><Refresh /></el-icon>
  </el-button>
</el-tooltip>
</div>
</div>
    <!-- 数据表格 -->
    <el-table ref="multipleTable" v-loading="loading" :data="tableList" style="width: 100%" @selection-change="handleSelectionChange"  @sort-change="handleSortChange">
			<el-table-column type="selection" width="40" />
      <el-table-column type="index" label="序号" width="55" align="center" sortable="custom"></el-table-column>
      <el-table-column prop="rtCode" label="退货单编号" width="120" align="center" sortable="custom"></el-table-column>
      <el-table-column prop="rtName" label="退货单名称" width="165" align="center" ></el-table-column>
      <el-table-column prop="poCode" label="采购订单编号" width="140" align="center" sortable="custom"></el-table-column>
      <el-table-column prop="vendorCode" label="供应商编码" width="120" align="center" sortable="custom"></el-table-column>
      <el-table-column prop="vendorName" label="供应商名称" width="150" align="center" sortable="custom"></el-table-column>
      <el-table-column prop="rtDate" label="退货日期" width="120" align="center" sortable="custom"></el-table-column>
      <el-table-column prop="status" label="单据状态" width="80" align="center">
        <template #default="{ row }">
          <el-tag :class="row.status === 'PREPARE' ? 'status-enabled' : 'status-disabled'" style="cursor: pointer;">
            {{ row.status === 'PREPARE' ? '草稿' : '已完成' }}
          </el-tag>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200" align="center">
        <template #default="{ row, $index }">
          <el-button circle type="primary" @click="handleUpdate(row, $index)">
            <el-icon :size="20"> <Edit /></el-icon>
          </el-button>
          <el-button type="danger" circle @click="handleDelete(row, $index)">
            <el-icon :size="20"> <Delete /></el-icon>
          </el-button>
          <el-button type="text" @click="handleExecute(row, $index)">
            <el-icon :size="10"><VideoPlay /></el-icon>执行退货
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页组件 -->
    <el-pagination
      v-model:current-page="parms.pagenum"
      v-model:page-size="parms.pagesize"
      :page-sizes="[2, 3, 5, 10]"
      :background="true"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
      style="margin-top: 20px; justify-content: flex-end"
      @size-change="onSizeChange"
      @current-change="onCurrentChange"
    />

    <!-- 添加或修改退货单对话框 -->
    <el-dialog v-model="dialogVisible" :title="dialogTitle">
      <el-form ref="formRef" :model="formModel" :rules="rules" label-width="120px">
        <el-row>
          <el-col :span="8">
            <el-form-item label="退货单编号" prop="rtCode">
              <el-input v-model="formModel.rtCode" placeholder="请输入退货单编号" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="退货单名称" prop="rtName">
              <el-input v-model="formModel.rtName" placeholder="请输入退货单名称" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="退货日期" prop="rtDate">
              <el-date-picker v-model="formModel.rtDate" type="date" placeholder="请选择退货日期" />
            </el-form-item>
          </el-col>
        </el-row>
        <el-row>
          <el-col :span="8">
            <el-form-item label="采购订单号" prop="poCode">
              <el-input v-model="formModel.poCode" placeholder="请输入采购订单号" />
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="单据状态" prop="status">
              <el-select v-model="formModel.status" placeholder="请选择单据状态">
                <el-option label="草稿" value="PREPARE"></el-option>
                <el-option label="已完成" value="CONFIRMED"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="供应商" prop="vendorName">
              <el-input v-model="formModel.vendorName" placeholder="请输入供应商名称" />
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
  </tableFrame>
</template>

<style lang="scss" scoped>
.demo-form-inline {
  .el-input {
    --el-input-width: 220px;
  }

  .el-select {
    --el-select-width: 220px;
  }
}
.status-disabled {
  background-color: rgba(64, 158, 255, 0.2);
  color: #409eff;
  padding: 5px;
  text-align: center;
}

.status-enabled {
  background-color: rgba(245, 108, 108, 0.2);
  color: #f56c6c;
  padding: 5px;
  text-align: center;
}
.search-icons {
  display: flex;
  justify-content: flex-end;
  align-items: center;
  margin-left: auto;

  .el-button {
    margin-left: 10px;
    border: none;
    box-shadow: none;
  }

  &.fixed {
    position: absolute;
    top: 10px;
    right: 10px;
  }
	}
</style>
