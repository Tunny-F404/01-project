#pragma once
/*
* 
*/
#ifndef _DELETEPLANSUBJECT_H_
#define _DELETEPLANSUBJECT_H_

#include "../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 列表DTO，可以将DTO分装成List
 * 列表类的设计来自：。好
 */

 // 利用列表DTO，来支持批量删除，如果其他人也需要的话，可以把这个类放成公共的
template <typename T>
class ListDTO : public oatpp::DTO
{
	DTO_INIT(ListDTO, oatpp::DTO)
		// 数据列表
		API_DTO_FIELD(List<T>, item, ZH_WORDS_GETTER("list_dto"), false, {});
public:
	// 添加一条数据
	void addItem(const T& item) {
		this->item->push_back(item);
	}
};

/**
 * 删除设备DTO
 * 设计参考来自：。好
 */

 // 继承自ListDTO
class DeletePlanSubjectDTO : public ListDTO<oatpp::String>
{
	DTO_INIT(DeletePlanSubjectDTO, ListDTO<oatpp::String>);
};

#include OATPP_CODEGEN_END(DTO)

#endif // !_REMOVEDEVICEDTO_H_
