<script lang="ts" setup generic="DataType extends Record<string, unknown>">
import { ref, computed, watch } from 'vue'

import { ElForm, ElInput } from 'element-plus'

type ElInputPropsType = InstanceType<typeof ElInput>['props']

const formType = <const>[
	'input',
	'select',
	'date',
	'range',
	'cascader',
	'radio',
	'checkbox',
	'switch',
	'slider',
	'rate',
	'color-picker',
	'time-picker',
	'date-picker',
	'upload',
	'input-number',
	'autocomplete',
	'checkbox-button',
	'radio-button',
	'time-select',
	'time-range-picker',
	'date-range-picker',
	'select-tree',
	'transfer',
	'form'
]

type FormType = (typeof formType)[number]

type FormConfigMap = {
	input: ElInputPropsType
	[k: string]: any
}

defineOptions({
	name: 'SearchBar'
})

type KeyDataType = keyof DataType

type FormItems<T extends FormType = 'input'> = {
	type: T
	label: string
	prop: KeyDataType
	config: FormConfigMap[T]
}

// FormConfigMap['input']

type SearchBarConfig = {
	formItems: FormItems[]
}

type SearchBarProps<T = DataType, K = KeyDataType> = {
	/** 表格配置 */
	config: {}

	/** 双向绑定的表格数据 */
	data: T
	// data: string
}

const props = withDefaults(defineProps<SearchBarProps<DataType>>(), {
	config: function () {
		return {}
	}
})

const data = defineModel<DataType>(<keyof SearchBarProps>'data')
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
