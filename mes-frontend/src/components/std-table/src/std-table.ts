import type { ButtonProps, TableProps } from "element-plus";

export interface Operations<T> extends ButtonProps {
	// ico
}

export interface TableTrueProps<T> extends TableProps<T> {
	/** 操作栏 */
	operations?: Operations<T>[];
}
