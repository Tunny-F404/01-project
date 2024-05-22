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

//----------------abf，扩充，删除操作对单表应该知道表名和主键【进入页面时就给表名，勾选就给主键，发送就开始操作

/*用于只有一个主键的表（id）*/
class DeleteTableUniqueDTO :public ListDTO<oatpp::UInt64>
{
	//List
	DTO_INIT(DeleteTableUniqueDTO, ListDTO<oatpp::UInt64>)
	//表名
	API_DTO_FIELD_DEFAULT(String,tableName , ZH_WORDS_GETTER("planSubject.deleteTemplate.DESC.tableName"));
};

/*用于联表，有主次双主键（id，idList）*/
class DeleteTableSharedDTO :public ListDTO<oatpp::UInt64>
{
	//List（从属表的主键序列）
	DTO_INIT(DeleteTableSharedDTO, ListDTO<oatpp::UInt64>)
	//从属表的表名称
	API_DTO_FIELD_DEFAULT(String, tableNameSec, ZH_WORDS_GETTER("deleteTemplate.DESC.tableNameSec"));
	//keyPri主表主键
	API_DTO_FIELD_DEFAULT(UInt64, keyPri, ZH_WORDS_GETTER("deleteTemplate.DESC.keyPri"));
	//主表的表名称
	API_DTO_FIELD_DEFAULT(String, tableNamePri, ZH_WORDS_GETTER("deleteTemplate.DESC.tableNamePri"));




};

#include OATPP_CODEGEN_END(DTO)
//one - to - many
#endif // !_REMOVEDEVICEDTO_H_
