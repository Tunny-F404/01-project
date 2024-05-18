#pragma once
#ifndef _PRODUCTVO_H_
#define _PRODUCTVO_H_
#include "../../GlobalInclude.h"
#include "../../dto/product/ProductDTO.h"
#include OATPP_CODEGEN_BEGIN(DTO)
//定义一个生产领料列表显示VO
class ProductTableJsonVO : public JsonVO<oatpp::List<ProductTableDTO::Wrapper>>
{
	// 定义初始化
	DTO_INIT(ProductTableJsonVO, JsonVO<oatpp::List<ProductTableDTO::Wrapper>>);

public:
	ProductTableJsonVO() {
		this->data = {};
	}
};

#include OATPP_CODEGEN_END(DTO)
#endif 
