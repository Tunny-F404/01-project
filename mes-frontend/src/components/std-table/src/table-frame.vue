<script setup>
defineOptions({
	/** TODO: 更新组件的名称 重设成合适的名称 阮喵喵 */
	name: "TableFrame",
});

defineProps({
	title: {
		//引入的表格名，显示在上面
		required: true,
		type: String,
	},
});
</script>

<template>
	<el-card class="page-container">
		<template #header>
			<!--插槽,头部，表明表格数据内容-->
			<div class="header">
				<span>{{ title }}</span>

				<div class="extra">
					<!-- //具名插槽-->
					<slot name="extra"></slot>
				</div>
			</div>
		</template>

		<!--//默认插槽，内容页-->
		<slot> </slot>
	</el-card>
</template>

<style lang="scss" scoped>
.page-container {
	min-height: 100%;
	box-sizing: border-box;
	.header {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
}
</style>
