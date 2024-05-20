#pragma once
/*
* 
*/
#ifndef _STORAGEDTO_
#define _STORAGEDTO_
#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)

/**
 * 供应商退货单列表数据模型
 */
class StorageTableDTO : public oatpp::DTO
{
	DTO_INIT(StorageTableDTO, DTO);
	//退货单编号
	API_DTO_FIELD(UInt64, returnId， ZH_WORDS_GETTER("storage.fields.rtid"), true, 1);
	//退货单名称
	API_DTO_FIELD(String, returnName, ZH_WORDS_GETTER("storage.fields.rtname"), true, "01star");
	//状态
	API_DTO_FIELD(Int32, status, ZH_WORDS_GETTER("storage.fields.status"), true, 0);
};

class StorageDetailDTO : public StorageTableDTO
{
	DTO_INIT(StorageDetailDTO, StorageTableDTO);
	//退货日期
	API_DTO_FIELD(string, date, ZH_WORDS_GETTER("storage.fields.rtdate"), true, "2022-11-15");
};

#include OATPP_CODEGEN_END(DTO)
#endif // !_SAMPLE_DTO_