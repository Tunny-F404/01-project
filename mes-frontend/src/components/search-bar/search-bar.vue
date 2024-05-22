<script lang="ts" setup>
import { ref, computed, watch } from 'vue'

import { ElForm, ElInput } from 'element-plus'

defineOptions({
	name: 'SearchBar'
})

type SearchBarProps = {
	/** 表格配置 */
	config: {}

	/** 双向绑定的表格数据 */
	data: Record<string, unknown>
	// data: string
}

const props = withDefaults(defineProps<SearchBarProps>(), {
	config: {}
})

const data = defineModel(<keyof SearchBarProps>'data')
</script>

<template>
	<section class="search-bar-root">
		<!-- <ElForm> </ElForm> -->

		<ElInput v-model="data.input"></ElInput>
	</section>
</template>

<style lang="scss" scoped>
.search-bar-root {
	background-color: red;
}
</style>
