<template>
  <div>
    <!-- 表单 -->
    <el-row :gutter="20">
      <el-col :span="5">
        <el-form :inline="true" size="small">
          <el-form-item label="工艺路线编号">
            <el-input placeholder="请输入工艺路线编号" v-model="form.routeNumber" style="width: 185px;"></el-input>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col :span="5">
        <el-form :inline="true" size="small">
          <el-form-item label="工艺路线名称">
            <el-input placeholder="请输入工艺路线名称" v-model="form.routeName" style="width: 185px;"></el-input>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col :span="5">
        <el-form :inline="true" size="small">
          <el-form-item label="是否启用">
            <el-select v-model="form.isEnabled" placeholder="请选择" style="width: 200px;">
              <el-option label="是" value="是"></el-option>
              <el-option label="否" value="否"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
      </el-col>
      <el-col :span="4" class="button-col">
        <el-form :inline="true" size="small">
          <el-form-item>
            <el-button type="primary" @click="search">搜索</el-button>
            <el-button @click="reset">重置</el-button>
          </el-form-item>
        </el-form>
      </el-col>
    </el-row>

    <!-- 按钮组 -->
    <el-row :gutter="20" style="margin-top: 10px;">
      <el-col :span="20">
        <el-button type="success" size="small" @click="add">新增</el-button>
        <el-button type="warning" size="small" @click="edit" :disabled="!hasSelection">修改</el-button>
        <el-button type="danger" size="small" @click="deleteSelected" :disabled="!hasSelection">删除</el-button>
        <el-button type="info" size="small" @click="exportData">导出</el-button>
      </el-col>
    </el-row>

    <!-- 表格 -->
    <el-table :data="paginatedData" border stripe style="margin-top: 20px;" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="routeNumber" label="工艺路线编号" width="150"></el-table-column>
      <el-table-column prop="routeName" label="工艺路线名称" width="150"></el-table-column>
      <el-table-column prop="routeDescription" label="工艺路线说明" width="180"></el-table-column>
      <el-table-column prop="isEnabled" label="是否启用" width="100">
        <template #default="scope">
          <span class="status" :class="scope.row.isEnabled === '是' ? 'enabled' : 'disabled'">
            {{ scope.row.isEnabled }}
          </span>
        </template>
      </el-table-column>
      <el-table-column prop="remarks" label="备注" width="180"></el-table-column>
      <el-table-column label="操作" width="180">
        <template #default="scope">
          <el-button link type="primary" size="small" @click.prevent="handleEdit(scope.row)">修改</el-button>
          <el-button link type="primary" size="small" @click.prevent="deleteSingleRow(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <!-- 分页 -->
    <el-pagination
      background
      layout="prev, pager, next"
      :total="tableData.length"
      :page-size="pageSize"
      @current-change="handlePageChange"
      style="margin-top: 20px;"
    ></el-pagination>
  </div>
</template>

<script lang="ts" setup>
import { ref, computed } from 'vue'
import { ElMessage } from 'element-plus'

const form = ref({
  routeNumber: '',
  routeName: '',
  isEnabled: ''
})

const tableData = ref([
  { routeNumber: '001', routeName: '路线1', routeDescription: '说明1', isEnabled: '是', remarks: '备注1' },
  { routeNumber: '002', routeName: '路线2', routeDescription: '说明2', isEnabled: '否', remarks: '备注2' },
  { routeNumber: '003', routeName: '路线3', routeDescription: '说明3', isEnabled: '是', remarks: '备注3' },
  { routeNumber: '004', routeName: '路线4', routeDescription: '说明4', isEnabled: '否', remarks: '备注4' },
  { routeNumber: '005', routeName: '路线5', routeDescription: '说明5', isEnabled: '是', remarks: '备注5' },
  { routeNumber: '006', routeName: '路线6', routeDescription: '说明6', isEnabled: '否', remarks: '备注6' },
  { routeNumber: '007', routeName: '路线7', routeDescription: '说明7', isEnabled: '是', remarks: '备注7' },
  { routeNumber: '008', routeName: '路线8', routeDescription: '说明8', isEnabled: '否', remarks: '备注8' },
  { routeNumber: '009', routeName: '路线9', routeDescription: '说明9', isEnabled: '是', remarks: '备注9' },
  { routeNumber: '010', routeName: '路线10', routeDescription: '说明10', isEnabled: '否', remarks: '备注10' },
])

const selectedItems = ref([])
const currentPage = ref(1)
const pageSize = ref(10)
const rowToDelete = ref(null)

const paginatedData = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value
  const end = currentPage.value * pageSize.value
  return tableData.value.slice(start, end)
})

const hasSelection = computed(() => {
  return selectedItems.value.length > 0
})

const search = () => {
  // 搜索逻辑
}

const reset = () => {
  form.value.routeNumber = ''
  form.value.routeName = ''
  form.value.isEnabled = ''
}

const add = () => {
  // 新增逻辑
}

const edit = () => {
  if (selectedItems.value.length === 1) {
    handleEdit(selectedItems.value[0])
  } else {
    ElMessage.warning('请选择一项进行编辑')
  }
}

const deleteSelected = () => {
  console.log('删除选中的项:', selectedItems.value); // 调试输出
  selectedItems.value.forEach(item => {
    const index = tableData.value.indexOf(item)
    if (index > -1) {
      tableData.value.splice(index, 1)
    }
  })
  ElMessage.success('删除成功')
}

const deleteSingleRow = (row) => {
  console.log('删除单行:', row); // 调试输出
  const index = tableData.value.indexOf(row)
  if (index > -1) {
    tableData.value.splice(index, 1)
  }
  ElMessage.success('删除成功')
}

const exportData = () => {
  // 导出逻辑
}

const handleEdit = (row) => {
  // 编辑逻辑
}

const handleSelectionChange = (val) => {
  console.log('选中项变化:', val); // 调试输出
  selectedItems.value = val
}

const handlePageChange = (page) => {
  console.log('分页变化:', page); // 调试输出
  currentPage.value = page
}
</script>

<style scoped>
.form-inline {
  margin-bottom: 10px;
}

.button-group {
  margin-bottom: 10px;
}

.dialog-footer {
  text-align: right;
}

.button-col .el-form-item {
  margin-right: 10px; /* 增加表单和按钮之间的间距 */
}

.status {
  display: inline-block;
  padding: 2px 5px;
  border-radius: 3px;
  color: #409EFF;
  border: 1px solid #409EFF;
}

.status.enabled {
  background-color: #409EFF;
  color: white;
}

.status.disabled {
  background-color: #e0e0e0;
  color: #b0b0b0;
}

.el-button[disabled] {
  cursor: not-allowed !important;
}
</style>
