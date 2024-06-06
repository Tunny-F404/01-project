<script lang="ts" setup>
import { computed, ref, watch } from "vue";

import TableTrue from "components/table-list-use/table-true.vue";

defineOptions({
	/** 列表页用的表格组件 演示页 */
	name: "TableListUseDemoPage",
});
</script>

<template>
	<section class="table-list-use-demo-page-root">
		<h1>你好，这是阮喵喵正在制作的组件。</h1>
	</section>
</template>

<style lang="scss" scoped>
.table-list-use-demo-page-root {
}
</style>
