<script setup lang="ts">
import { ref } from "vue";
import tableFrame from "@/components/table-list-use/table-text.vue";
import request from "@/apis/request.js";

const customerCode = ref("");
const customerName = ref("");
const customerShortName = ref("");
const customerEnglishName = ref("");
// defineOptions();
const toggleStatus = (row) => {
  row.isEnabled = !row.isEnabled;
};
const isEnabled = ref(null); // 定义是否启用的状态
const multipleSelection = ref([]);

//每一列数据，例子，后期接口对上再调整
//测试模拟数据
const tableList = ref([
    {
        customerCode: "C001",
        customerName: "广州科技有限公司",
        customerShortName: "广科",
        customerType: "科技",
        customerPhone: "020-12345678",
        contactPhone: "13812345678",
        isEnabled: true
    },
    {
        customerCode: "C002",
        customerName: "深圳创新科技有限公司",
        customerShortName: "深创",
        customerType: "创新",
        customerPhone: "0755-87654321",
        contactPhone: "13987654321",
        isEnabled: false
    },
    {
        customerCode: "C003",
        customerName: "北京网络科技有限公司",
        customerShortName: "北网",
        customerType: "网络",
        customerPhone: "010-12344321",
        contactPhone: "13712344321",
        isEnabled: true
			},
    {
        customerCode: "C004",
        customerName: "上海信息技术有限公司",
        customerShortName: "上信",
        customerType: "信息",
        customerPhone: "021-87654321",
        contactPhone: "13687654321",
        isEnabled: true
    },
    {
        customerCode: "C005",
        customerName: "杭州电子商务有限公司",
        customerShortName: "杭电",
        customerType: "电子",
        customerPhone: "0571-12345678",
        contactPhone: "13512345678",
        isEnabled: false
    },
    {
        customerCode: "C006",
        customerName: "南京软件开发有限公司",
        customerShortName: "南软",
        customerType: "软件",
        customerPhone: "025-87654321",
        contactPhone: "13487654321",
        isEnabled: true
    }
]);

//dialog联系到表格弹窗
const dialog = ref();

//测试新增对话框
const testDialogVisible = ref(false);
const openTestDialog = () => {
  testDialogVisible.value = true;
};
const formRef = ref();
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

const rules = {
  clientCode: [{ required: true, message: "请输入客户编码", trigger: "blur" }],
  clientName: [{ required: true, message: "请输入客户名称", trigger: "blur" }],
  clientNick: [{ required: true, message: "请输入客户简称", trigger: "blur" }],
  clientEn: [{ required: true, message: "请输入客户英文名称", trigger: "blur" }],
  clientType: [{ required: true, message: "请选择客户类型", trigger: "change" }],
  clientDes: [{ required: true, message: "请输入客户简介", trigger: "blur" }],
  address: [{ required: true, message: "请输入客户地址", trigger: "blur" }],
  website: [{ required: true, message: "请输入客户官网地址", trigger: "blur" }],
  email: [{ required: true, message: "请输入客户邮箱地址", trigger: "blur" }],
  tel: [{ required: true, message: "请输入客户电话", trigger: "blur" }],
  clientLogo: [{ required: true, message: "请输入客户LOGO", trigger: "blur" }],
  contact1: [{ required: true, message: "请输入联系人1", trigger: "blur" }],
  contact1Tel: [{ required: true, message: "请输入联系人1-电话", trigger: "blur" }],
  contact1Email: [{ required: true, message: "请输入联系人1-邮箱", trigger: "blur" }],
  contact2: [{ required: true, message: "请输入联系人2", trigger: "blur" }],
  contact2Tel: [{ required: true, message: "请输入联系人2-电话", trigger: "blur" }],
  contact2Email: [{ required: true, message: "请输入联系人2-邮箱", trigger: "blur" }],
  creditCode: [{ required: true, message: "请输入社会信用代码", trigger: "blur" }],
  enableFlag: [{ required: true, message: "请选择是否有效", trigger: "change" }],
  remark: [{ required: true, message: "请输入备注", trigger: "blur" }]
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
const cancelForm = () => {
  testDialogVisible.value = false;
};

//定义查询的数据
const loading = ref(false); //loading状态

//定义请求参数、
const parms = ref({
	pagenum: 1, //页数
	pagesize: 5, //当前每页面大小
	state: "", //状态
	classfiy: "",
});

//定义总条数
const total = ref(tableList.value.length); // 这里设置为模拟数据的总条数

//处理分页逻辑
//改变大小
// const onSizeChange = (size) => {
// 	//console.log('当前每页面条数',size);
// 	parms.value.pagenum = 1;
// 	parms.value.pagesize = size;
// 	//再利用接口渲染数据getPageList
// 	const Data = { pageSize: "parms.pagesize" };
// 	getPageList(Date);
// };

// //改变页数
// const onCurrentChange = (page) => {
// 	// console.log('页面变化了',page);
// 	parms.value.pagenum = page;
// 	//基于当前最新页渲染数据
// 	const Data = { pageIndex: "parms.pagenum" };
// 	getPageList(Data);
// };

//模拟分页
const originalTableList = ref([...tableList.value]);
const getPageList = () => {
  loading.value = true;
  const start = (parms.value.pagenum - 1) * parms.value.pagesize;
  const end = start + parms.value.pagesize;
  tableList.value =originalTableList.value.slice(start, end);
  loading.value = false;
};
const onSizeChange = (size) => {
  parms.value.pagenum = 1;
  parms.value.pagesize = size;
  getPageList();
};

const onCurrentChange = (page) => {
  parms.value.pagenum = page;
  getPageList();
};

// const tableList=ref([])
const onSortChannel = () => {
	console.log("排序");
};

//编辑
const onEditchannel = (row) => {
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

const onSubmit = () => {
	console.log("查询提交");
};

const reFresh = () => {
	customerCode= "";
	customerName= "";
	customerShortName= "";
	customerEnglishName= "";
};

const handleSelectionChange = (val) => {
	this.multipleSelection = val;
};
</script>
<template>
	<!--分类，页面只有基本的表现，没有实现数据绑定-->
	<tableFrame title="客户管理">
	<template #extra>
		<el-button @click="onExportData"
			>导出数据<el-icon :size="22"><UploadFilled /></el-icon>
		</el-button>
		<template>
  <div>
    <slot name="extra"></slot>
    <!-- 其他内容 -->
  </div>
</template>
		<!-- <el-button @click="onAddChannel"
			>添加
			<el-icon :size="20"> <Plus /><!--添加图标 </el-icon>
		</el-button> -->
	</template>
	

		<!--表单区域-->
		<el-form :inline="true" class="demo-form-inline">
    <el-row>
        <el-col :span="8">
            <el-form-item label="客户编码：">
                <el-input v-model="customerCode" placeholder="请输入客户编码" clearable />
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="客户名称：">
                <el-input v-model="customerName" placeholder="请输入客户名称" clearable />
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="客户简称：">
                <el-input v-model="customerShortName" 
              placeholder="请输入客户简称" clearable />
            </el-form-item>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="客户英文名称：">
                <el-input v-model="customerEnglishName" 
              placeholder="请输入客户英文名称" clearable />
            </el-form-item>
        </el-col>
				<el-col :span="8">
      <el-form-item label="是否启用：">
        <el-select v-model="isEnabled" placeholder="请选择">
          <el-option label="是" :value="true"></el-option>
          <el-option label="否" :value="false"></el-option>
        </el-select>
      </el-form-item>
    </el-col>
        <el-col :span="8">
            <el-form-item>
                <el-button type="primary" @click="onSubmit"> <el-icon><Search /></el-icon>查询</el-button>
                <el-button @click="reFresh"><el-icon><Refresh /></el-icon>重置</el-button>
            </el-form-item>
        </el-col>
    </el-row>
</el-form>

		<el-button type="primary" plain    @click="openTestDialog"
			><el-icon><Plus /></el-icon>新增</el-button
		>
		<el-button type="success" plain  @click="onEditchannel(row)"
			><el-icon><EditPen /></el-icon>修改</el-button
		>
		<el-button type="danger" plain
			><el-icon><Delete /></el-icon>删除</el-button
		>

		<!--表格区-->
		<el-table :data="tableList" style="width: 100%" v-loading="loading" @selection-change="handleSelectionChange" ref="multipleTable">
    <el-table-column type="selection" width="55" align="center"/>
    <el-table-column type="index" label="序号" width="55" align="center"></el-table-column>
    <el-table-column prop="customerCode" label="客户编码" width="100" align="center"></el-table-column>
    <el-table-column prop="customerName" label="客户名称" width="185" align="center"></el-table-column>
    <el-table-column prop="customerShortName" label="客户简称" width="125" align="center"></el-table-column>
    <el-table-column prop="customerType" label="客户类型" width="125" align="center"></el-table-column>
    <el-table-column prop="customerPhone" label="客户电话" width="150" align="center"></el-table-column>
    <el-table-column prop="contactPhone" label="联系人电话" width="150" align="center"></el-table-column>
    <el-table-column prop="isEnabled" label="是否启用" width="84" align="center">
			<template #default="{ row }">
    <el-tag
      :class="row.isEnabled ? 'status-enabled' : 'status-disabled'"
      @click="toggleStatus(row)"
      style="cursor: pointer;"
			class="status-tag"
    >
      {{ row.isEnabled ? '是' : '否' }}
    </el-tag>
  </template>
    </el-table-column>
    <el-table-column label="操作" width="150" align="center">
        <template #default="{ row, $index }">
            <el-button @click="onEditchannel(row, $index)" circle type="primary">
                <el-icon :size="20"> <Edit /></el-icon>
            </el-button>
            <el-button @click="onDelChannel(row, $index)" type="danger" circle>
                <el-icon> <Delete /></el-icon>
            </el-button>
        </template>
    </el-table-column>
</el-table>
		<el-pagination
			v-model:current-page="parms.pagenum"
			v-model:page-size="parms.pagesize"
			:page-sizes="[2, 3, 5, 10]"
			:background="true"
			layout="total, sizes, prev, pager, next, jumper"
			:total="total"
			@size-change="onSizeChange"
			@current-change="OnCurrentChange"
			style="margin-top: 20px; justify-content: flex-end"
		/>
		<!---->

		<!--空处理-->
		<template #empty>
			<el-empty description="没有数据"></el-empty>
		</template>
	</tableFrame>

	<el-dialog v-model="testDialogVisible" title="新增客户">
		<el-form ref="formRef" :model="formModel" :rules="rules" label-width="120px">
    <el-row>
      <el-col :span="8">
        <el-form-item label="客户编码" prop="clientCode">
          <el-input v-model="formModel.clientCode" placeholder="请输入客户编码" />
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="客户名称" prop="clientName">
          <el-input v-model="formModel.clientName" placeholder="请输入客户名称" />
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="客户简称" prop="clientNick">
          <el-input v-model="formModel.clientNick" placeholder="请输入客户简称" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="8">
        <el-form-item label="客户英文名称" prop="clientEn">
          <el-input v-model="formModel.clientEn" placeholder="请输入客户英文名称" />
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="客户类型" prop="clientType">
          <el-select v-model="formModel.clientType" placeholder="请选择客户类型">
            <el-option label="类型1" value="type1"></el-option>
            <el-option label="类型2" value="type2"></el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="8">
        <el-form-item label="客户简介" prop="clientDes">
          <el-input v-model="formModel.clientDes" placeholder="请输入客户简介" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <el-form-item label="客户地址" prop="address">
          <el-input v-model="formModel.address" placeholder="请输入客户地址" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="客户官网地址" prop="website">
          <el-input v-model="formModel.website" placeholder="请输入客户官网地址" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="客户邮箱地址" prop="email">
          <el-input v-model="formModel.email" placeholder="请输入客户邮箱地址" />
        </el-form-item>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-form-item label="客户电话" prop="tel">
          <el-input v-model="formModel.tel" placeholder="请输入客户电话" />
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item label="客户LOGO" prop="clientLogo">
					<el-input v-model="formModel.clientLogo" placeholder="请输入客户LOGO" />
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
	<!--引入的弹窗-->
	<!-- <pop-Up ref="dialog"> </pop-Up> -->
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
.status-enabled {
    background-color: rgba(64, 158, 255, 0.2);
    color: #409eff; 
    padding: 5px; 
    text-align: center; 
}

.status-disabled {
    background-color: rgba(245, 108, 108, 0.2);
    color:  #f56c6c;
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

.action-buttons {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
}
</style>
