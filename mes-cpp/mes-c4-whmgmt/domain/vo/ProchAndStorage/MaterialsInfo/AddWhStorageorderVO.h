#pragma once
#ifndef _ADDWHSTORAGEORDERVO_H_
#define _ADDWHSTORAGEORDERVO_H_

#include "../../../GlobalInclude.h"
#include "../../../dto/ProchAndStorage/MaterialsInfo/AddWhStorageorderDTO.h"


#include OATPP_CODEGEN_BEGIN(DTO)
/*
定义一个入库单行添加后显示的IsonVO对象，用于响应给客户端
*/

class AddWhStorageorderVO : public JsonVO<AddWhStorageorderDTO::Wrapper>
{
	DTO_INIT(AddWhStorageorderVO, JsonVO<AddWhStorageorderDTO::Wrapper>);
};


/*
定义一个添加后入库信息分页显示的IsonVO对象，用于响应给客户端
*/
class AddWhPageStorageorderVO : public JsonVO<AddWhPageStorageorderDTO::Wrapper>
{
	DTO_INIT(AddWhPageStorageorderVO, JsonVO<AddWhPageStorageorderDTO::Wrapper>);
};
#include OATPP_CODEGEN_END(DTO)
#endif // _ADDWHSTORAGEORDERVO_H_