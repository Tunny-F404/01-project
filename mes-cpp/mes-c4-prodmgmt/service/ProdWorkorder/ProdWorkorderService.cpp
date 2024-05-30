
#include "stdafx.h"
#include "ProdWorkorderService.h"
#include "../../dao/ProdWorkorder/ProdWorkorderDAO.h"

bool ProdWorkorderService::completeData(uint64_t id)
{
	ProdWorkorderDAO dao;
	return dao.completeById(id) == 1;
}

bool ProdWorkorderService::removeData(uint64_t id)
{
	ProdWorkorderDAO dao;
	return dao.deleteById(id)==1;
}

bool ProdWorkorderService::confirmData(uint64_t id)
{
	ProdWorkorderDAO dao;
	return dao.comfirmById(id)==1;
}
