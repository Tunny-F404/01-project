<template>
	<el-row :gutter="20">
		<!-- 栏1 -->
		<el-col :span="8">
			<div class="grid-content ep-bg-purple">
				<!-- 用户信息栏 -->
				<el-card style="max-width: 480px">
					<template #header>
						<div class="card-header">
							<span>个人信息</span>
						</div>
					</template>
					<!-- 用户信息展示 -->
					<el-row justify="center">
						<div class="demo-type">
							<el-avatar :size="100" fit="cover" @error="false" :src="url"
								><img src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png" />
							</el-avatar>
						</div>
					</el-row>
					<el-divider />
					<el-row justify="space-between">
						<span>用户名称</span>
						<span>{{ infoform.nickName }}</span>
					</el-row>
					<el-divider />
					<el-row justify="space-between">
						<span>手机号码</span>
						<span>{{ infoform.phoneNum }}</span>
					</el-row>
					<el-divider />
					<el-row justify="space-between">
						<span>用户邮箱</span>
						<span>{{ infoform.email }}</span>
					</el-row>
					<el-divider />
					<span>所属部门</span>
					<div>****</div>
					<span>所属角色</span>
					<div>****</div>
					<el-row justify="space-between">
						<span>创建日期</span>
						<span>2023-11-20 21:19:01</span>
					</el-row>
				</el-card>
			</div>
		</el-col>
		<el-col :span="16">
			<div class="grid-content ep-bg-purple">
				<el-card>
					<template #header>
						<div class="card-header">
							<span>基本信息</span>
						</div>
					</template>
					<!-- 基本资料/修改密码 -->
					<el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick">
						<el-tab-pane label="基本资料" name="first">
							<!-- 基本资料表单 -->
							<el-form :model="infoform" label-width="80px" :inline="false" size="normal" hide-required-asterisk="true">
								<el-form-item label="用户名称">
									<el-input v-model="infoform.nickName"></el-input>
								</el-form-item>
								<el-form-item label="手机号码">
									<el-input v-model="infoform.phoneNum"></el-input>
								</el-form-item>
								<el-form-item label="邮箱">
									<el-input v-model="infoform.email"></el-input>
								</el-form-item>
								<el-form-item label="性别">
									<el-radio-group v-model="infoform.gender">
										<el-radio value="male">男</el-radio>
										<el-radio value="female">女</el-radio>
									</el-radio-group>
								</el-form-item>
								<el-form-item>
									<el-button type="primary" @click="onSubmit">保存</el-button>
									<el-button type="danger">关闭</el-button>
								</el-form-item>
							</el-form>
						</el-tab-pane>

						<el-tab-pane label="修改密码" name="second">
							<!-- 修改密码表单 -->
							<el-form :model="passwd" label-width="80px" :inline="false" size="normal">
								<el-form-item label="旧密码">
									<el-input v-model="passwd.old"></el-input>
								</el-form-item>
								<el-form-item label="新密码">
									<el-input v-model="passwd.new"></el-input>
								</el-form-item>
								<el-form-item label="确认密码">
									<el-input v-model="passwd.confirm"></el-input>
								</el-form-item>
								<el-form-item>
									<el-button type="primary" @click="onSubmit">保存</el-button>
									<el-button type="danger">关闭</el-button>
								</el-form-item>
							</el-form>
						</el-tab-pane>
					</el-tabs>
				</el-card>
			</div>
		</el-col>
	</el-row>
</template>

<script setup>
import { ref } from "vue";

//tabs配置
const activeName = ref("first");
const handleClick = (tab, event) => {
	console.log(tab, event);
};

//基本资料表单
const infoform = ref({
	nickName: "",
	phoneNum: "",
	email: "",
	gender: "男",
});
const onSubmit = () => {
	console.log("表单发送成功");
};

//修改密码表单
const passwd = ref({
	old: "",
	new: "",
	confirm: "",
});

const url = ref("");
</script>

<style scoped>
/* layout样式 */
.el-row {
	margin-bottom: 20px;
}

.el-row:last-child {
	margin-bottom: 0;
}

.el-col {
	border-radius: 4px;
}

.grid-content {
	border-radius: 4px;
	min-height: 36px;
}

/* 头像样式 */
.demo-type {
	display: flex;
}

.demo-type > div {
	flex: 1;
	text-align: center;
}

.demo-type > div:not(:last-child) {
	border-right: 1px solid var(--el-border-color);
}

/* 输入框 */
</style>
