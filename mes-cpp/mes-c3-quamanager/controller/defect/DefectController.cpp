#include "stdafx.h"
#include "DefectController.h"

// 1 ��ȡȱ���б�������+��ҳ��
DefectPageJsonVO::Wrapper DefectController::execQueryDefect(const DefectQuery::Wrapper& query, const PayloadDTO& payload)
{
	auto jvo = DefectPageJsonVO::createShared();
	return jvo;
}
// 2 ����ȱ��
Uint64JsonVO::Wrapper DefectController::execAddDefect(const DefectDTO::Wrapper& dto)
{
	auto jvo = Uint64JsonVO::createShared();
	return jvo;
}
// 3 �޸�ȱ��
Uint64JsonVO::Wrapper DefectController::execModifyDefect(const DefectUpdateDTO::Wrapper& dto)
{
	return {};
}
// 4 ɾ��ȱ��
Uint64JsonVO::Wrapper DefectController::execRemoveDefect(const String& removeList)
{
	return {};
}