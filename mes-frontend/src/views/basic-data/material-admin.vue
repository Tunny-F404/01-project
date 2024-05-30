<script setup >
import {ref} from 'vue'
import  tableFrame  from '@/components/table-list-use/table-text.vue' 
import popUp from '@/components/table-list-use/table-components/pop-up.vue'
import Request  from '@/apis/request.js'

const tableList=ref([{
    "ancestors": "1",
  "createBy": "阿伟",
  "enableFlag": "T",
  "itemOrProduct": "os",
  "itemTypeCode": "awnb",
  "itemTypeId": 114514,
  "itemTypeName": "金属",
  "orderNum": 1,
  "parentTypeId": 0,
  "remark": "0x3f",
  "updateBy": "东东哥"
}
]) 

//dialog联系到表格弹窗
const dialog=ref()

//定义总条数
const total=ref(13)

//定义查询的数据
const myInput=ref()

const loading=ref(false)//loading状态

//定义分类的请求参数
const parms=ref({
    // pagenum:1,//页数
    // pagesize: 5,//当前每页面大小
    // state:'',//状态
    // classfiy:''
    enableFlag: "",
  itemOrProduct: "os",
  itemTypeCode: "awnb",
  itemTypeId: '',
  itemTypeName: "金属",
  orderNum: '', 
  page:'', 
  parentTypeId: '',
  size:''
})

const getPageList= async (data)=>{
  //不知道跟着接口写的对不对，希望大佬看一看
  loading.value=true
 try {
  const res=await Request.request(Request.GET,'/mes/md/itemtype/{itemTypeId}',data)
  tableList.value=res.data.data
 } catch (error) {
  console.log('错误或者超时');
 } 

  loading.value=false
}
getPageList()//进来就加载一遍
//处理分页逻辑
//改变大小
const onSizeChange=(size)=>{
    //console.log('当前每页面条数',size);
  parms.value.pagenum=1
  parms.value.pagesize=size
  //再利用接口渲染数据getPageList
 const Data={pageSize:'parms.pagesize'}
  getPageList(Date)
}
//改变页数
const onCurrentChange=async (page)=>{
 parms.value.page=page
//基于当前最新页渲染数据
loading.value=true
 try {
  const res=await request(request.GET,'/mes/md/itemtype/list',{page:page})
  tableList.value=res.data.data
 } catch (error) {
  console.log('错误或者超时');
 } 
  loading.value=false
}
 


const onEditchannel=(row,$index)=>{
    //编辑
    dialog.value.open({row})
    console.log(row);
}
const onDelChannel=async (row)=>{
    //删除
    await ElMessageBox.confirm('你确认要删除该单位么', '温馨提示', {
    type: 'warning',
    confirmButtonText: '确认',
    cancelButtonText: '取消'
  })
  try {
  const res=await Request.request(Request.DELETE,'/mes/md/itemtype/{itemTypeId}',{itemTypeId:row.data.itemTypeId})
 } catch (error) {
  console.log('错误或者超时');
 } 
 if(res.code===200){
    ElMessage.success('删除成功')
 }
  
  //  console.log(row)
    //删除后再渲染数据
    getPageList()
}
const onSubmit=()=>{
    getPageList(myInput)
    console.log("查询提交");
}
//添加
const onAddChannel = () => {
  dialog.value.open({})
}

const reFresh=()=>{
  myInput=''
}

const multipleSelection=ref([])
const  handleSelectionChange=(val)=> {
        this.multipleSelection = val;
 }
</script>


<template>
        
        <tableFrame title="物料产品管理">
   


    <!--表单区域-->
    <el-form :inline="true"  class="demo-form-inline">
  <el-form-item label="分类名称：" padding="50px">
    <!--label是用户看，value是收集给后台的.这个输入框输入查询分类的ID-->
    <el-input v-model="myInput" clearable/>
        
  </el-form-item>
  <el-form-item label="是否启用" >
    <el-select v-model="parms.state"><!--后台标记状态-->
      <el-option label="正常" value="true"></el-option>
      <el-option label="失败" value="false"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit"><el-icon><Search /></el-icon>查询</el-button>
  </el-form-item>
  <el-form-item>
    <el-button plain @click="reFresh"><el-icon><RefreshLeft /></el-icon>重置</el-button>
  </el-form-item>
</el-form>

<el-button type="primary" plain><el-icon><Plus /></el-icon>新增</el-button>
<el-button type="success" plain><el-icon><EditPen /></el-icon>修改</el-button>
<el-button type="danger" plain><el-icon><Delete /></el-icon>删除</el-button>

<!--表格区-->
    <el-table  :data="tableList" style="width: 100%" v-loading="loading"
    @selection-change="handleSelectionChange"
    ref="multipleTable">
    <el-table-column type="selection" width="55" />
   <el-table-column prop="ancestors" label="祖先节点列表" width="100"></el-table-column>
   <el-table-column prop="createBy" label="创建者" width="100"></el-table-column>
   <el-table-column prop="enableFlag" label="启用标识" width="100"></el-table-column>
   <el-table-column prop="itemOrProduct" label="产品物料标识" width="100"></el-table-column>
   <el-table-column prop="itemTypeCode" label="分类编码" width="100"></el-table-column>
   <el-table-column  prop="itemTypeId"   label="分类ID" ></el-table-column>
   <el-table-column  prop="itemTypeName"   label="分类名称" ></el-table-column>
   <el-table-column  prop="orderNum"   label="排序号" ></el-table-column>
   <el-table-column  prop="parentTypeId"   label="父分类ID" ></el-table-column>
   <el-table-column  prop="remark"   label="备注" ></el-table-column>
   <el-table-column  prop="updateBy"   label="更新者" ></el-table-column>
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
.demo-form-inline{
    .el-input {
  --el-input-width: 220px;
}
.el-select {
  --el-select-width: 220px;
}
} 

</style>