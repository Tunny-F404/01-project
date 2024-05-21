#pragma once
/*
* 
*/
#ifndef _PLANSUBJECTQUERY_H_
#define _PLANSUBJECTQUERY_H_

#include "../../GlobalInclude.h"
#include "domain/query/PageQuery.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 设备点检/保养管理 查询条件对象
 */
class PlanSubjectQuery : public PageQuery
{
	DTO_INIT(PlanSubjectQuery, DTO);

	//项目编号，详细展开
	static v_int64 Z__PROPERTY_OFFSET_subCode() {
		char buffer[sizeof(Z__CLASS)]; auto obj = static_cast<Z__CLASS*>((void*)buffer); auto ptr = &obj->subCode; return (v_int64)ptr - (v_int64)buffer;
	} static oatpp::data::mapping::type::BaseObject::Property* Z__PROPERTY_SINGLETON_subCode() {
		static oatpp::data::mapping::type::BaseObject::Property* property = new oatpp::data::mapping::type::BaseObject::Property(Z__PROPERTY_OFFSET_subCode(), "subCode", String::Class::getType()); return property;
	} static bool Z__PROPERTY_INIT_subCode(...) {
		Z__CLASS_GET_FIELDS_MAP()->pushBack(Z__PROPERTY_SINGLETON_subCode()); return true;
	} static String Z__PROPERTY_INITIALIZER_PROXY_subCode() {
		static bool initialized = Z__PROPERTY_INIT_subCode(1, 1); (void)initialized; return String();
	} String subCode = Z__PROPERTY_INITIALIZER_PROXY_subCode(); static bool Z__PROPERTY_INIT_subCode(int, ...) {
		Z__PROPERTY_INIT_subCode(); Z__PROPERTY_ADD_INFO_subCode(&Z__PROPERTY_SINGLETON_subCode()->info); return true;
	} static void Z__PROPERTY_ADD_INFO_subCode(oatpp::data::mapping::type::BaseObject::Property::Info* info) {
		info->description = YamlHelper().getString(&(ServerInfo::getInstance().getZhDictNode()), "planSubject.fields.subCode");
	};
	//API_DTO_FIELD_DEFAULT(String, subCode, ZH_WORDS_GETTER("planSubject.fields.subCode"));

	//项目名称
	API_DTO_FIELD_DEFAULT(String, subName, ZH_WORDS_GETTER("planSubject.fields.subName"));

	//项目类型
	API_DTO_FIELD_DEFAULT(String, subType, ZH_WORDS_GETTER("planSubject.fields.subType"));
};

#include OATPP_CODEGEN_END(DTO)
#endif // 
