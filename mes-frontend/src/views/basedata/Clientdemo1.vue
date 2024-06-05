<script setup lang="ts">
import { ref } from "vue";
import tableFrame from "@/components/table-list-use/table-text.vue";
import request from "@/apis/request.js";

const clientCode = ref("");
const clientName = ref("");
const clientNick = ref("");
const clientEn = ref("");
const enableFlag = ref(null);
//对话框标题
const dialogTitle = ref("");
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
    clientCode: "C001",
    clientName: "广州科技有限公司",
    clientNick: "广科",
    clientEn: "Guangzhou Tech Co., Ltd.",
    clientType: "科技",
    clientDes: "科技公司",
    address: "广州市天河区",
    website: "http://www.guangzhou-tech.com",
    email: "info@guangzhou-tech.com",
    tel: "020-12345678",
    clientLogo: "logo1.png",
    contact1: "张三",
    contact1Tel: "13812345678",
    contact1Email: "zhangsan@guangzhou-tech.com",
    contact2: "李四",
    contact2Tel: "13987654321",
    contact2Email: "lisi@guangzhou-tech.com",
    creditCode: "91440101MA5DXXXXXX",
    enableFlag: "yes",
    remark: "备注信息1",
    isEnabled: true
  },
  {
    clientCode: "C002",
    clientName: "深圳创新科技有限公司",
    clientNick: "深创",
    clientEn: "Shenzhen Innovation Tech Co., Ltd.",
    clientType: "创新",
    clientDes: "创新公司",
    address: "深圳市南山区",
    website: "http://www.shenzhen-innovation.com",
    email: "info@shenzhen-innovation.com",
    tel: "0755-87654321",
    clientLogo: "logo2.png",
    contact1: "王五",
    contact1Tel: "13987654321",
    contact1Email: "wangwu@shenzhen-innovation.com",
    contact2: "赵六",
    contact2Tel: "13876543210",
    contact2Email: "zhaoliu@shenzhen-innovation.com",
    creditCode: "91440300MA5DXXXXXX",
    enableFlag: "no",
    remark: "备注信息2",
    isEnabled: false
  },
  {
    clientCode: "C003",
    clientName: "北京网络科技有限公司",
    clientNick: "北网",
    clientEn: "Beijing Network Tech Co., Ltd.",
    clientType: "网络",
    clientDes: "网络公司",
    address: "北京市海淀区",
    website: "http://www.beijing-network.com",
    email: "info@beijing-network.com",
    tel: "010-12344321",
    clientLogo: "logo3.png",
    contact1: "孙七",
    contact1Tel: "13712344321",
    contact1Email: "sunqi@beijing-network.com",
    contact2: "周八",
    contact2Tel: "13612344321",
    contact2Email: "zhouba@beijing-network.com",
    creditCode: "91110108MA5DXXXXXX",
    enableFlag: "yes",
    remark: "备注信息3",
    isEnabled: true
  },
  {
    clientCode: "C004",
    clientName: "上海信息技术有限公司",
    clientNick: "上信",
    clientEn: "Shanghai Info Tech Co., Ltd.",
    clientType: "信息",
    clientDes: "信息公司",
    address: "上海市浦东新区",
    website: "http://www.shanghai-info.com",
    email: "info@shanghai-info.com",
    tel: "021-87654321",
    clientLogo: "logo4.png",
    contact1: "吴九",
    contact1Tel: "13687654321",
    contact1Email: "wuj@shanghai-info.com",
    contact2: "郑十",
    contact2Tel: "13587654321",
    contact2Email: "zhengshi@shanghai-info.com",
    creditCode: "91310115MA5DXXXXXX",
    enableFlag: "yes",
    remark: "备注信息4",
    isEnabled: true
  },
  {
    clientCode: "C005",
    clientName: "杭州电子商务有限公司",
    clientNick: "杭电",
    clientEn: "Hangzhou E-commerce Co., Ltd.",
    clientType: "电子",
    clientDes: "电子商务公司",
    address: "杭州市西湖区",
    website: "http://www.hangzhou-ecommerce.com",
    email: "info@hangzhou-ecommerce.com",
    tel: "0571-12345678",
    clientLogo: "logo5.png",
    contact1: "冯十一",
    contact1Tel: "13512345678",
    contact1Email: "fengshiyi@hangzhou-ecommerce.com",
    contact2: "陈十二",
    contact2Tel: "13412345678",
    contact2Email: "chenshiyi@hangzhou-ecommerce.com",
    creditCode: "91330108MA5DXXXXXX",
    enableFlag: "no",
    remark: "备注信息5",
    isEnabled: false
  },
  {
    clientCode: "C006",
    clientName: "南京软件开发有限公司",
    clientNick: "南软",
    clientEn: "Nanjing Software Dev Co., Ltd.",
    clientType: "软件",
    clientDes: "软件开发公司",
    address: "南京市鼓楼区",
    website: "http://www.nanjing-software.com",
    email: "info@nanjing-software.com",
    tel: "025-87654321",
    clientLogo: "logo6.png",
    contact1: "褚十三",
    contact1Tel: "13487654321",
    contact1Email: "chushisan@nanjing-software.com",
    contact2: "卫十四",
    contact2Tel: "13387654321",
    contact2Email: "weishisi@nanjing-software.com",
    creditCode: "91320108MA5DXXXXXX",
    enableFlag: "yes",
    remark: "备注信息6",
    isEnabled: true
  }
]);
// // 表格弹窗
// const dialog = ref();

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

const formRef = ref(null);

//测试新增对话框
const testDialogVisible = ref(false);
const openTestDialog = () => {
  dialogTitle.value = "添加客户信息";
  formModel.value = {
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
  };
  testDialogVisible.value = true;
};
//修改客户信息对话框
const onEditchannel = (row) => {
  dialogTitle.value = "修改客户信息";
  formModel.value = { ...row };
  testDialogVisible.value = true;
};
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

//模拟删除
const onDelChannel = (row) => {
  ElMessageBox.confirm("你确认要删除该单位么", "温馨提示", {
    type: "warning",
    confirmButtonText: "确认",
    cancelButtonText: "取消",
  })
    .then(() => {
      const index = originalTableList.value.findIndex(item => item.clientCode === row.clientCode);
      if (index !== -1) {
        originalTableList.value.splice(index, 1);
        total.value = originalTableList.value.length; // 更新总条数
        ElMessage.success("删除成功");
        getPageList(); // 重新渲染分页数据
      }
    })
    .catch(() => {
      ElMessage.info("已取消删除");
    });
		//后端
		// .then(() => {
    //   return request.delete(`/api/clients/${row.clientCode}`);
    // })
    // .then(response => {
    //   if (response.status === 200) {
    //     const index = originalTableList.value.findIndex(item => item.clientCode === row.clientCode);
    //     if (index !== -1) {
    //       originalTableList.value.splice(index, 1);
    //       total.value = originalTableList.value.length; // 更新总条数
    //       ElMessage.success("删除成功");
    //       getPageList(); // 重新渲染分页数据
    //     }
    //   } else {
    //     ElMessage.error("删除失败");
    //   }
    // })
    // .catch(() => {
    //   ElMessage.info("已取消删除");
    // });
};

// 模拟搜索筛选
const onSubmit = () => {
  // 模拟数据过滤
  const filteredList = originalTableList.value.filter(item => {
    return (
      (!clientCode.value || item.clientCode.includes(clientCode.value)) &&
      (!clientName.value || item.clientName.includes(clientName.value)) &&
      (!clientNick.value || item.clientNick.includes(clientNick.value)) &&
      (!clientEn.value || item.clientEn.includes(clientEn.value)) &&
      (enableFlag.value === null || item.enableFlag === (enableFlag.value ? "yes" : "no"))
    );
  });
  tableList.value = filteredList;
  total.value = filteredList.length;
  getPageList();
  
  // 后端接口调用
  // request.post('/api/search', {
  //   clientCode: clientCode.value,
  //   clientName: clientName.value,
  //   clientNick: clientNick.value,
  //   clientEn: clientEn.value,
  //   enableFlag: enableFlag.value
  // }).then(response => {
  //   tableList.value = response.data;
  //   total.value = response.data.length;
  //   getPageList();
  // });
};

// 重置搜索栏
const reFresh = () => {
  clientCode.value = "";
  clientName.value = "";
  clientNick.value = "";
  clientEn.value = "";
  enableFlag.value = null;
  tableList.value = [...originalTableList.value];
  total.value = originalTableList.value.length;
  getPageList();
};

const handleSelectionChange = (val) => {
	this.multipleSelection = val;
};
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
    clientCode: "C006",
    clientName: "南京软件开发有限公司",
    clientNick: "南软",
    clientEn: "Nanjing Software Dev Co., Ltd.",
    clientType: "软件",
    clientDes: "软件开发公司",
    address: "南京市鼓楼区",
    website: "http://www.nanjing-software.com",
    email: "info@nanjing-software.com",
    tel: "025-87654321",
    clientLogo: "logo6.png",
    contact1: "褚十三",
    contact1Tel: "13487654321",
    contact1Email: "chushisan@nanjing-software.com",
    contact2: "卫十四",
    contact2Tel: "13387654321",
    contact2Email: "weishisi@nanjing-software.com",
    creditCode: "91320108MA5DXXXXXX",
    enableFlag: "yes",
    remark: "备注信息6",
    isEnabled: true
  },
    ];
    originalTableList.value = [...tableList.value];
    getPageList();
    loading.value = false; // 隐藏加载动画
  }, 1000);
}
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
	

		<!--搜索表单区域-->
		<el-form v-if="showSearchBar" :inline="true" class="demo-form-inline">
    <el-row>
        <el-col :span="8">
            <el-form-item label="客户编码：">
                <el-input v-model="clientCode" placeholder="请输入客户编码" clearable />
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="客户名称：">
                <el-input v-model="clientName" placeholder="请输入客户名称" clearable />
            </el-form-item>
        </el-col>
        <el-col :span="8">
            <el-form-item label="客户简称：">
                <el-input v-model="clientNick" 
              placeholder="请输入客户简称" clearable />
            </el-form-item>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="8">
            <el-form-item label="客户英文名称：">
                <el-input v-model="clientEn" 
              placeholder="请输入客户英文名称" clearable />
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
                <el-button type="primary" @click="onSubmit"> <el-icon><Search /></el-icon>查询</el-button>
                <el-button @click="reFresh"><el-icon><Refresh /></el-icon>重置</el-button>
            </el-form-item>
        </el-col>
    </el-row>
</el-form>
       <!-- 操作按钮 -->
			 <div class="action-buttons">
		<el-button type="primary" plain    @click="openTestDialog"
			><el-icon><Plus /></el-icon>新增</el-button
		>
		<el-button type="success" plain  @click="onEditchannel(row)"
			><el-icon><EditPen /></el-icon>修改</el-button
		>
		<el-button type="danger" plain
			><el-icon><Delete /></el-icon>删除</el-button
		>
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

		<!--表格区-->
		<el-table :data="tableList" style="width: 100%" v-loading="loading" @selection-change="handleSelectionChange" ref="multipleTable" @sort-change="handleSortChange">
			<el-table-column type="selection" width="55" align="center"/>
			<el-table-column type="index" label="序号" width="55" align="center"></el-table-column>
			<el-table-column prop="clientCode" label="客户编码" width="120" align="center" sortable="custom"></el-table-column>
			<el-table-column prop="clientName" label="客户名称" width="185" align="center"></el-table-column>
			<el-table-column prop="clientNick" label="客户简称" width="125" align="center"></el-table-column>
			<el-table-column prop="clientType" label="客户类型" width="125" align="center"></el-table-column>
			<el-table-column prop="tel" label="客户电话" width="150" align="center" sortable="custom"></el-table-column>
			<el-table-column prop="contact1Tel" label="联系人电话" width="150" align="center" sortable="custom"></el-table-column>
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

	<el-dialog v-model="testDialogVisible" :title="dialogTitle">
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
.el-table {
  th,
  td {
    text-align: center;
  }
}

.action-buttons {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 10px;
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
