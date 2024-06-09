import type { ButtonProps, TableProps } from "element-plus";

export interface Operations<T> extends ButtonProps {
	// ico
}

/**
 * 标准表格的 props 类型
 * @author f1-阮喵喵
 */
export interface StdTableProps<T> extends TableProps<T> {
	/** 操作栏 */
	operations?: Operations<T>[];
}
