#pragma once
#ifndef _PRODUCT_SERVICE_
#define _PRODUCT_SERVICE_
#include <list>
#include "domain/vo/product/ProductVO.h"
#include "domain/query/product/ProductQuery.h"
#include "domain/dto/product/ProductDTO.h"

/**
 * 生产领料的服务操作
 */
class ProductTableService
{
public:
	// 分页查询所有数据
	ProductPageDTO::Wrapper listAll(const ProductQuery::Wrapper& query);
};

#endif
