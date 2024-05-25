
<script setup >
import  tableFrame  from '@/components/table-list-use/table-text.vue' 
import popUp from '@/components/table-list-use/table-components/pop-up.vue'
import {ref} from 'vue'

//没有中文国际化
//每一列数据，例子，后期接口对上再调整
const tableList=ref([{
    "classify":"金属",
    "product":'螺丝',
    "sure":"正常",
    "time":"2024.5.22"
}
]) 

//dialog联系到表格弹窗
const dialog=ref()


//定义请求参数,后期完善
const parms=ref({
    pagenum:1,//页数
    pagesize: 5,//当前每页面大小
    state:'成功',//状态
    classfiy:'时间'
})
const getPageList=()=>{

}
//处理分页逻辑
//改变大小
const onSizeChange=(size)=>{
    //console.log('当前每页面条数',size);
  parms.value.pagenum=1
  parms.value.pagesize=size
  //再利用接口渲染数据getPageList
  getPageList()
}
//改变页数
const onCurrentChange=(page)=>{
   // console.log('页面变化了',page);
 parms.value.pagenum=page
//基于当前最新页渲染数据
  getPageList()
}

// const tableList=ref([])
const onSortChannel=()=>{
    console.log("排序");
}
const onEditchannel=(row,$index)=>{
    //编辑
    dialog.value.open({row})
    console.log(row);
}
const onDelChannel=(row,$index)=>{
    //删除
    console.log(row);
}
const onSubmit=()=>{
    console.log("查询提交");
}
//添加
const onAddChannel = () => {
  dialog.value.open({})
}
</script>


<template>
        <!--分类，页面只有基本的表现，没有实现数据绑定-->
        <tableFrame title="实验表格">
    <template #extra>
        <!-- 具名插槽例子实现 -->
      <el-button @click="onSortChannel">排序顺序    
        <el-icon :size="20">
    <Sort /><!--排序图标-->
        </el-icon>
    </el-button>
    <el-button @click="onAddChannel">添加    
        <el-icon :size="20">
    <Plus /><!--排序图标-->
        </el-icon>
    </el-button>
    </template>

    <!--表单区域-->
    <el-form :inline="true"  class="demo-form-inline">
  <el-form-item label="表格分类：" padding="50px">
    <!--label是用户看，value是收集给后台的-->
    <el-select v-model="parms.classfiy">
        <el-option label="按产品" value="001"> </el-option>
        <el-option label="按时间" value="002"> </el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="状态" >
    <el-select v-model="parms.state"><!--后台标记状态-->
      <el-option label="正常" value="正常"></el-option>
      <el-option label="失败" value="失败"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">查询</el-button>
  </el-form-item>
</el-form>

<!--表格区-->
    <el-table  :data="tableList" style="width: 100%">
   <el-table-column prop="classify" label="分类" width="100"></el-table-column>
   <el-table-column type="index" label="排序" width="50"></el-table-column>
   <el-table-column prop="product" label="物料/产品" width="150"></el-table-column>
   <el-table-column prop="sure"  label="是否启用" ></el-table-column>
   <el-table-column  prop="time"   label="创建时间" ></el-table-column>
   <el-table-column label="操作" >
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
      :total="11"
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
.demo-form-inline .el-input {
  --el-input-width: 220px;
}

.demo-form-inline .el-select {
  --el-select-width: 220px;
}
</style>