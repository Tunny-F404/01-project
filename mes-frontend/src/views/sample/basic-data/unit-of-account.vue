<script setup lang="ts">
import {ref} from 'vue'
import  tableFrame  from '@/components/table-list-use/table-text.vue' 
import popUp from '@/components/table-list-use/table-components/pop-up.vue'
import Request  from '@/apis/request.js'
// defineOptions();

const multipleSelection = ref([]);

//没有中文国际化
//每一列数据，例子，后期接口对上再调整
const tableList = ref([
	{
		attr1: "自定义值1",
		attr2: "自定义值2",
		attr3: 100,
		attr4: 200,
		changeRate: 1,
		enableFlag: "Y",
		measureCode: "METER",
		measureName: "米",
		primaryFlag: "Y",
		primaryId: 1,
		remark: "这是主单位",
	},

	{
		attr1: "自定义值1",
		attr2: "自定义值2",
		attr3: 100,
		attr4: 200,
		changeRate: 1,
		enableFlag: "Y",
		measureCode: "METER",
		measureName: "米",
		primaryFlag: "Y",
		primaryId: 1,
		remark: "这是主单位",
	},
]);

//dialog联系到表格弹窗
const dialog = ref();

//定义总条数
const total = ref(13);

//定义查询的数据
let myInput=ref('')
let unitName=ref('')
const loading=ref(false)//loading状态

//定义请求参数,后期完善
const parms = ref({
	pagenum: 1, //页数
	pagesize: 5, //当前每页面大小
	state: "", //状态
	classfiy: "",
});

const getPageList = async (data) => {
	//不知道跟着接口写的对不对，希望大佬看一看
	loading.value = true;
	try {
		const res = await Request.request(Request.GET, "/basicdata/md-unit-measure/list", data, null);
		tableList.value = res.data.rows.data;
		parms.value.pagenum = res.data.pageIndex;
		parms.value.pagesize = res.data.pageSize;
		total.value = res.data.total;
	} catch (error) {
		console.log("错误或者超时");
	}

	loading.value = false;
};
getPageList(); //进来就加载一遍
//处理分页逻辑
//改变大小
const onSizeChange = (size) => {
	//console.log('当前每页面条数',size);
	parms.value.pagenum = 1;
	parms.value.pagesize = size;
	//再利用接口渲染数据getPageList
	const Data = { pageSize: "parms.pagesize" };
	getPageList(Date);
};

//改变页数
const onCurrentChange = (page) => {
	// console.log('页面变化了',page);
	parms.value.pagenum = page;
	//基于当前最新页渲染数据
	const Data = { pageIndex: "parms.pagenum" };
	getPageList(Data);
};

// const tableList=ref([])
const onSortChannel = () => {
	console.log("排序");
};

const onEditchannel = (row, $index) => {
	//编辑
	dialog.value.open({ row });
	console.log(row);
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
	getPageList(null);
};

const onSubmit = () => {
	console.log("查询提交");
};

//添加
const onAddChannel = () => {
	dialog.value.open({});
};

const reFresh = () => {
	myInput = "";
	unitName = "";
};

const handleSelectionChange = (val) => {
	this.multipleSelection = val;
};
</script>

<template>
	<!--分类，页面只有基本的表现，没有实现数据绑定-->
	<tableFrame title="计算单位">
		<template #extra>
			<el-button @click="onSortChannel"
				>导出数据
				<el-icon :size="20"> <UploadFilled /><!--排序图标--> </el-icon>
			</el-button>
			<el-button @click="onAddChannel"
				>添加
				<el-icon :size="20"> <Plus /><!--添加图标--> </el-icon>
			</el-button>
		</template>

		<!--表单区域-->
		<el-form :inline="true" class="demo-form-inline">
			<el-form-item label="单位编码：" padding="50px">
				<!--label是用户看，value是收集给后台的-->
				<el-input v-model="myInput" clearable />
			</el-form-item>
			<el-form-item label="单位名称">
				<el-input v-model="unitName" clearable />
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSubmit"
					><el-icon><Search /></el-icon>查询</el-button
				>
			</el-form-item>
			<el-form-item>
				<el-button plain @click="reFresh"
					><el-icon><RefreshLeft /></el-icon>重置</el-button
				>
			</el-form-item>
		</el-form>

		<el-button type="primary" plain
			><el-icon><Plus /></el-icon>新增</el-button
		>
		<el-button type="success" plain
			><el-icon><EditPen /></el-icon>修改</el-button
		>
		<el-button type="danger" plain
			><el-icon><Delete /></el-icon>删除</el-button
		>
<el-button type="primary"   @click="onAddChannel" plain><el-icon><Plus /></el-icon>新增</el-button>
<el-button type="success" plain><el-icon><EditPen /></el-icon>修改</el-button>
<el-button type="danger" plain><el-icon><Delete /></el-icon>删除</el-button>

<!--表格区-->
    <el-table  :data="tableList" style="width: 100%" v-loading="loading"
    @selection-change="handleSelectionChange"
    ref="multipleTable">
    <el-table-column type="selection" width="55" />
  <el-table-column type="index" label="序号" ></el-table-column>
   <el-table-column prop="attr1" label="预留字段1" width="100"></el-table-column>
   <el-table-column prop="attr2" label="预留字段2" width="100"></el-table-column>
   <el-table-column prop="attr3" label="预留字段3" width="100"></el-table-column>
   <el-table-column prop="attr4" label="预留字段4" width="100"></el-table-column>
   <el-table-column prop="changeRate" label="与主单位换算比例" width="100"></el-table-column>
   <el-table-column prop="enableFlag"  label="是否启用" >
    <template v-slot="{ row }">
					<el-tag :type="row.enableFlag === 'Y' ? 'success' : 'info'">{{
						row.enableFlag === "Y" ? "启用" : "未启用"
					}}</el-tag>
				</template>
  </el-table-column>
   <el-table-column  prop="measureCode"   label="单位编码" ></el-table-column>
   <el-table-column  prop="measureName"   label="单位名称" ></el-table-column>
   <el-table-column  prop="primaryFlag"   label="是否是主单位" >
    <template v-slot="{ row }">
					<el-tag :type="row.enableFlag === 'Y' ? 'success' : 'info'">{{
						row.enableFlag === "Y" ? "主单位" : "非主单位"
					}}</el-tag>
				</template>
   </el-table-column>
   <el-table-column  prop="primaryId"   label="主单位ID" ></el-table-column>
   <el-table-column  prop="remark"   label="备注" ></el-table-column>
   <el-table-column label="操作" width="100" >
    <!-- row是当前一行数据 index是下标-->
    <template #default="{row,$index}">
        <el-button @click="onEditchannel(row,$index)" 
         circle
        type="primary"> 
        <el-icon :size="20">
    <Edit /><!--修改图标-->
        </el-icon>
</el-button>
        <el-button @click="onDelChannel(row,$index)" 
        type="danger"
         circle>
         <el-icon>
    <Delete /><!--删除图标-->
       </el-icon>
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
      style="margin-top:20px;justify-content: flex-end;"
    />
<!---->

		<!--空处理-->
		<template #empty>
			<el-empty description="没有数据"></el-empty>
		</template>
	</tableFrame>

	<!--引入的弹窗-->
	<pop-Up ref="dialog"> </pop-Up>
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
</style>
