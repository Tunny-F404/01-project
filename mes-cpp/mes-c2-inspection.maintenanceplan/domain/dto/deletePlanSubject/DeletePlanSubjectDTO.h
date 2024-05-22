#pragma once
/*
* 
*/
#ifndef _DELETEPLANSUBJECT_H_
#define _DELETEPLANSUBJECT_H_

#include "../mes-c2-inspection.maintenanceplan/domain/GlobalInclude.h"

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
	//
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

//在联表情况下是两个表的主键字段，一对多时是id+idList
// 除了list还要另一个主键，id
class DeletePlanSubjectOneToManyDTO :public ListDTO<oatpp::String>
{
	DTO_INIT(DeletePlanSubjectOneToManyDTO, ListDTO<oatpp::String>)
	API_DTO_FIELD_DEFAULT(UInt64, primaryKey, ZH_WORDS_GETTER("planSubject.inputDESC.delOneToMany.primaryKey"));
};
#include OATPP_CODEGEN_END(DTO)
//one - to - many
#endif // !_REMOVEDEVICEDTO_H_
