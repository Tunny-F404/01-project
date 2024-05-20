//#pragma once
///*
//* 
//*/
//#ifndef _PLANSUBJECT_MAPPER_
//#define _PLANSUBJECT_MAPPER_
//
//#include "Mapper.h"
//#include "../../domain/do/planSubject/SlanSubjectDO.h"
//
///**
// * Ê¾Àý±í×Ö¶ÎÆ¥ÅäÓ³Éä
// */
//class SlanSubjectMapper : public Mapper<SlanSubjectDO>
//{
//public:
//	SlanSubjectDO mapper(ResultSet* resultSet) const override
//	{
//		SlanSubjectDO data;
//		data.setId(resultSet->getUInt64(1));
//		data.setName(resultSet->getString(2));
//		data.setSex(resultSet->getString(3));
//		data.setAge(resultSet->getInt(4));
//		return data;
//	}
//};
//
//#endif // !_SAMPLE_MAPPER_
