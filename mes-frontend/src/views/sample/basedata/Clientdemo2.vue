<template>
  <div class="app-container">
    <!-- 搜索表单 -->
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" label-width="100px">
      <el-row>
        <el-col :span="8">
          <el-form-item label="客户编码" prop="clientCode">
            <el-input v-model="queryParams.clientCode" placeholder="请输入客户编码" clearable />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="客户名称" prop="clientName">
            <el-input v-model="queryParams.clientName" placeholder="请输入客户名称" clearable />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="客户简称" prop="clientNick">
            <el-input v-model="queryParams.clientNick" placeholder="请输入客户简称" clearable />
          </el-form-item>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="8">
          <el-form-item label="客户英文名称" prop="clientEn">
            <el-input v-model="queryParams.clientEn" placeholder="请输入客户英文名称" clearable />
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label="是否启用" prop="enableFlag">
            <el-select v-model="queryParams.enableFlag" placeholder="是否启用" clearable>
              <el-option label="是" value="Y"></el-option>
              <el-option label="否" value="N"></el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item>
            <el-button type="primary" @click="handleQuery">搜索</el-button>
            <el-button @click="resetQuery">重置</el-button>
          </el-form-item>
        </el-col>
      </el-row>
    </el-form>

    <!-- 操作按钮 -->
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
      <el-table-column prop="clientCode" label="客户编码" align="center"></el-table-column>
      <el-table-column prop="clientName" label="客户名称" align="center"></el-table-column>
      <el-table-column prop="clientNick" label="客户简称" align="center"></el-table-column>
      <el-table-column prop="clientType" label="客户类型" align="center"></el-table-column>
      <el-table-column prop="tel" label="客户电话" align="center"></el-table-column>
      <el-table-column prop="contact1" label="联系人" align="center"></el-table-column>
      <el-table-column prop="contact1Tel" label="联系人-电话" align="center"></el-table-column>
      <el-table-column prop="enableFlag" label="是否启用" align="center">
        <template v-slot="{ row }">
          <el-tag :type="row.enableFlag === 'Y' ? 'success' : 'info'">{{ row.enableFlag === 'Y' ? '启用' : '未启用' }}</el-tag>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" align="center">
  <template v-slot="{ row }">
    <el-button size="mini" type="text" @click="handleUpdate(row)">修改</el-button>
    <el-button size="mini" type="text" @click="handleDelete(row)">删除</el-button>
  </template>
</el-table-column>
    </el-table>

    <!-- 分页 -->
    <!-- <pagination :total="total" :page.sync="queryParams.pageNum" :limit.sync="queryParams.pageSize" @pagination="getList"></pagination>
		<el-dialog :title="title" :visible.sync="open" width="30%">
  <div>测试对话框是否显示</div>
  <span slot="footer" class="dialog-footer">
    <el-button @click="open = false">关闭</el-button>
  </span>
</el-dialog> -->
    <!-- 新增对话框 -->
		<el-dialog :title="title" :visible.sync="open" width="960px" append-to-body>
  <el-form ref="form" :model="form" :rules="rules" label-width="120px">
    <!-- 客户编码 -->
    <el-form-item label="客户编码" prop="clientCode">
      <el-input v-model="form.clientCode" placeholder="请输入客户编码" />
    </el-form-item>
    <!-- 客户名称 -->
    <el-form-item label="客户名称" prop="clientName">
      <el-input v-model="form.clientName" placeholder="请输入客户名称" />
    </el-form-item>
    <!-- 客户简称 -->
    <el-form-item label="客户简称" prop="clientNick">
      <el-input v-model="form.clientNick" placeholder="请输入客户简称" />
    </el-form-item>
    <!-- 客户英文名称 -->
    <el-form-item label="客户英文名称" prop="clientEn">
      <el-input v-model="form.clientEn" placeholder="请输入客户英文名称" />
    </el-form-item>
    <!-- 客户类型 -->
    <el-form-item label="客户类型" prop="clientType">
      <el-select v-model="form.clientType" placeholder="请选择客户类型">
        <el-option v-for="dict in dict.type.mes_client_type" :key="dict.value" :label="dict.label" :value="dict.value" />
      </el-select>
    </el-form-item>
    <!-- 客户简介 -->
    <el-form-item label="客户简介" prop="clientDes">
      <el-input type="textarea" v-model="form.clientDes" placeholder="请输入客户简介" />
    </el-form-item>
    <!-- 客户地址 -->
    <el-form-item label="客户地址" prop="address">
      <el-input type="textarea" v-model="form.address" placeholder="请输入客户地址" />
    </el-form-item>
    <!-- 客户官网地址 -->
    <el-form-item label="客户官网地址" prop="website">
      <el-input v-model="form.website" placeholder="请输入客户官网地址" />
    </el-form-item>
    <!-- 客户邮箱地址 -->
   <el-form-item label="客户邮箱地址" prop="email">
      <el-input v-model="form.email" placeholder="请输入客户邮箱地址" />
    </el-form-item> 
    <!-- 客户电话 -->
     <el-form-item label="客户电话" prop="tel">
      <el-input v-model="form.tel" placeholder="请输入客户电话" />
    </el-form-item>
    <!-- 是否有效 -->
     <el-form-item label="是否有效" prop="enableFlag">
      <el-radio-group v-model="form.enableFlag">
        <el-radio v-for="dict in dict.type.sys_yes_no" :key="dict.value" :label="dict.value">{{ dict.label }}</el-radio>
      </el-radio-group> 
    </el-form-item>
    <!-- 备注 -->
    <el-form-item label="备注" prop="remark">
      <el-input type="textarea" v-model="form.remark" placeholder="请输入备注" />
    </el-form-item> 
     <div slot="footer" class="dialog-footer">
      <el-button @click="cancel">取消</el-button>
      <el-button type="primary" @click="submitForm">确定</el-button>
    </div>
  </el-form>
</el-dialog> 
  </div>
</template>

<script>
export default {
  data() {
    return {
			open: true,
      queryParams: {
        clientCode: '',
        clientName: '',
        clientNick: '',
        clientEn: '',
        enableFlag: '',
        pageNum: 1,
        pageSize: 10
      },
      clientList: [
        { clientCode: '001', clientName: '客户A', clientNick: 'A公司', clientType: '类型1', tel: '1234567890', contact1: '张三', contact1Tel: '1234567890', enableFlag: 'Y' },
        { clientCode: '002', clientName: '客户B', clientNick: 'B公司', clientType: '类型2', tel: '0987654321', contact1: '李四', contact1Tel: '0987654321', enableFlag: 'N' },
				{ clientCode: '003', clientName: '客户A', clientNick: 'A公司', clientType: '类型1', tel: '1234567890', contact1: '张三', contact1Tel: '1234567890', enableFlag: 'Y' },
        { clientCode: '004', clientName: '客户B', clientNick: 'B公司', clientType: '类型2', tel: '0987654321', contact1: '李四', contact1Tel: '0987654321', enableFlag: 'N' },
				{ clientCode: '005', clientName: '客户A', clientNick: 'A公司', clientType: '类型1', tel: '1234567890', contact1: '张三', contact1Tel: '1234567890', enableFlag: 'Y' },
        { clientCode: '006', clientName: '客户B', clientNick: 'B公司', clientType: '类型2', tel: '0987654321', contact1: '李四', contact1Tel: '0987654321', enableFlag: 'N' },
				{ clientCode: '007', clientName: '客户A', clientNick: 'A公司', clientType: '类型1', tel: '1234567890', contact1: '张三', contact1Tel: '1234567890', enableFlag: 'Y' },
        { clientCode: '008', clientName: '客户B', clientNick: 'B公司', clientType: '类型2', tel: '0987654321', contact1: '李四', contact1Tel: '0987654321', enableFlag: 'N' },
				{ clientCode: '009', clientName: '客户A', clientNick: 'A公司', clientType: '类型1', tel: '1234567890', contact1: '张三', contact1Tel: '1234567890', enableFlag: 'Y' },
        { clientCode: '010', clientName: '客户B', clientNick: 'B公司', clientType: '类型2', tel: '0987654321', contact1: '李四', contact1Tel: '0987654321', enableFlag: 'N' }
      ],
      total: 10,
      loading: false,
      single: true,
      multiple: true
    };
  },
  methods: {
    handleQuery() {
      console.log('查询操作');
    },
    resetQuery() {
      this.queryParams = {
        clientCode: '',
        clientName: '',
        clientNick: '',
        clientEn: '',
        enableFlag: '',
        pageNum: 1,
        pageSize: 10
      };
    },
    handleSelectionChange(selection) {
      this.single = selection.length !== 1;
      this.multiple = selection.length === 0;
    },
		reset() {
    // 假设一个表单数据对象叫做 form
    this.form = {
      clientCode: '',
      clientName: '',
      clientNick: '',
      clientEn: '',
      clientType: '',
      clientDes: '',
      address: '',
      website: '',
      email: '',
      tel: '',
      enableFlag: '',
      remark: ''
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
      reject('Client ID is undefined');
      return;
    }
    const clientData = this.clientList.find(client => client.clientCode === clientId);
    if (clientData) {
      resolve({ data: clientData });
    } else {
      reject('No data found for client with ID: ' + clientId);
    }
  });
},
handleAdd() {
	//触发新增操作
	this.open = true;
	this.reset();
	
	  // 重置表单到初始状态
  console.log('新增操作');
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
  console.log('Triggering handleUpdate with row:', row);
  this.reset();
  const clientId = row.clientCode;
  this.getClient(clientId).then(response => {
    console.log('Data received from getClient:', response.data);
    this.form = response.data;
    this.open = true;
    this.title = "修改客户";
    this.optType = "edit";
  }).catch(error => {
    console.error('Failed to fetch client data:', error);
  });
},
handleDelete(row) {
  console.log('删除操作', row);
  // 模拟删除操作
  this.clientList = this.clientList.filter(client => client.clientCode !== row.clientCode);
},
getList() {
  console.log('页面加载和查询列表');
  // 模拟数据加载
  this.loading = false;
}
},
created() {
  this.getList();
}
};
</script>