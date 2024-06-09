import StdTable from "./src/std-table.vue";

/** TODO: 重命名为标准表单弹框 */
import StdFormDialog from "./src/pop-up.vue";

/** TODO: 更新组件的名称 重设成合适的名称 阮喵喵 */
import TableFrame from "./src/table-text.vue";

import type { Operations, StdTableProps } from "./src/std-table";

export {
	/** 标准表格 */
	StdTable,
	StdFormDialog,
	TableFrame,
};
export type { Operations, StdTableProps as TableTrueProps };
