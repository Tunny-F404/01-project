<template>
  <el-container>
    <el-header>
      <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
        <el-menu-item index="1">首页</el-menu-item>
        <el-menu-item index="2">工作站管理</el-menu-item>
      </el-menu>
    </el-header>

    <el-main>
      <el-row :gutter="20" class="input-row">
        <el-col :span="5">
          <span class="input-label">工作站编码：</span>
          <el-input v-model="workstationCode" placeholder="请输入工作站编码" class="input-size" />
        </el-col>
        <el-col :span="5">
          <span class="input-label">工作站名称：</span>
          <el-input v-model="workstationName" placeholder="请输入工作站名称" class="input-size" />
        </el-col>
        <el-col :span="5">
          <span class="input-label">车间名称：</span>
          <el-select v-model="selectedWorkshop" placeholder="请选择车间" class="input-size">
            <el-option v-for="workshop in workshops" :key="workshop.value" :label="workshop.label" :value="workshop.value" />
          </el-select>
        </el-col>
        <el-col :span="5">
          <span class="input-label">所属工序：</span>
          <el-select v-model="selectedOrder" placeholder="请选择工序" class="input-size">
            <el-option v-for="order in orders" :key="order.value" :label="order.label" :value="order.value" />
          </el-select>
        </el-col>
        <el-col :span="4" class="button-container">
          <el-button type="primary" @click="search">查询</el-button>
          <el-button @click="reset">重置</el-button>
        </el-col>
      </el-row>

      <el-row :gutter="20" class="action-row">
        <el-col :span="6">
          <el-button type="primary" @click="handleHumanResource" class="action-button">人力资源</el-button>
        </el-col>
        <el-col :span="6">
          <el-button type="primary" @click="handleEquipment" class="action-button">设备资源</el-button>
        </el-col>
        <el-col :span="6">
          <el-button type="primary" @click="handleTools" class="action-button">工装夹具</el-button>
        </el-col>
        </el-row>

      <el-row :gutter="20" style="margin-top: 20px;">
        <el-col :span="24">
          <el-button type="danger" @click="batchDelete">批量删除</el-button>
          <el-button type="success" @click="exportData">导出</el-button>
          <el-button type="primary" @click="addNew">新增</el-button>
        </el-col>
      </el-row>

      <el-row :gutter="20" style="margin-top: 20px;">
        <el-col :span="24">
          <el-table :data="tableData" :default-sort="{prop: 'code', order: 'ascending'}" :page-size="pageSize" style="width: 100%">
            <el-table-column prop="code" label="工作站编号" width="180" />
            <el-table-column prop="name" label="工作站名称" width="180" />
            <el-table-column prop="location" label="工作站地点" width="180" />
            <el-table-column prop="workshop" label="所在车间名称" width="180" />
            <el-table-column prop="order" label="所属工序" width="180" />
            <el-table-column prop="enabled" label="是否启用" width="100" />
            <el-table-column prop="note" label="备注" />
            <el-table-column label="操作" width="180">
              <template v-slot="scope">
                <el-button type="text" size="small" @click="handleEdit(scope.$index, scope.row)">修改</el-button>
                <el-button type="text" size="small" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-col>
      </el-row>


      <el-pagination
        v-show="tableData.length > pageSize"
        :current-page="currentPage"
        :page-sizes="[6, 12, 24, 48]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="tableData.length"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      ></el-pagination>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'Station',
  data() {
    return {
      activeIndex: '1',
      workstationCode: '',
      workstationName: '',
      selectedWorkshop: '',
      selectedOrder: '',
      pageSize: 6,
      currentPage: 1,
      workshops: [
        { value: 'workshop1', label: '车间1' },
        { value: 'workshop2', label: '车间2' },
      ],
      orders: [
        { value: 'order1', label: '工序1' },
        { value: 'order2', label: '工序2' },
      ],
      tableData: [
        { code: 'WS0707', name: '组装1号站', location: '--', workshop: '生产车间', order: '涂胶', enabled: '是', note: '--' },
        { code: 'WS0720', name: '151541515', location: '4545', workshop: '生产车间', order: '涂胶', enabled: '是', note: '--' },
        { code: 'WS0734', name: '111', location: '111', workshop: '方大二', order: '开料', enabled: '是', note: '1-111' },
        { code: 'WS0802', name: '包娟', location: '莆', workshop: '一车间',order: '安装', enabled: '是', note: '--' },
        { code: 'WS0831', name: 'AGV接驳', location: '--', workshop: '二车间', order: 'AGV与舱段2、3接驳', enabled: '是', note: '--' },
        { code: 'WS0835', name: '宣家机架中心', location: '--', workshop: '二车间', order: '工序1', enabled: '是', note:'--' },
],
};
},
methods: {
search() {
console.log('查询');
},
reset() {
this.workstationCode = '';
this.workstationName = '';
this.selectedWorkshop = '';
this.selectedOrder = '';
},
handleHumanResource() {
console.log('人力资源');
},
handleEquipment() {
console.log('设备资源');
},
handleTools() {
console.log('工装夹具');
},
handleEdit(index, row) {
console.log('修改', index, row);
},
handleDelete(index, row) {
console.log('删除', index, row);
},
handleSizeChange(val) {
this.pageSize = val;
this.currentPage = 1;
},
handleCurrentChange(val) {
this.currentPage = val;
},
batchDelete() {
console.log('批量删除');
},
exportData() {
console.log('导出');
},
addNew() {
console.log('新增');
},
},
};
</script>

<style scoped>
.el-header {
  background-color: #b3c0d1;
  color: #333;
  line-height: 60px;
}

.action-row {
  margin-top: 20px;
}

.input-label {
  font-weight: bold;
}

.input-row .el-input {
  width: calc(35% - 10px);
}

.action-row .el-button,
.input-row .el-select {
  width: calc(25% - 10px);
}



.input-size {
  width: 100%;
}

.action-row .el-button {
  margin-right: 10px;
}


</style>
