<script lang="ts" setup>
import { ref, computed, watch } from 'vue'

import { ElForm } from 'element-plus'

defineOptions({
	name: 'SearchBar'
})

type SearchBarProps = {
	/** 表格配置 */
	config: {}

	/** 双向绑定的表格数据 */
	data: Record<string, unknown>
}

const props = withDefaults(
	defineProps<SearchBarProps>(),

	{
		// config
	}
)
</script>

<template>
	<section class="search-bar-root">
		<ElForm> </ElForm>
	</section>
</template>

<style lang="scss" scoped>
.search-bar-root {
	background-color: red;
}
</style>
