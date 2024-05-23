#include "stdafx.h"
#include "ProductController.h"

ProductTableJsonVO::Wrapper ProductController::execProductTable(const ProductQuery::Wrapper& query,const PayloadDTO& payload)
{
	auto jov = ProductTableJsonVO::createShared();
	return jov;
}
ProductDetailJsonVO::Wrapper ProductController::execProductDetail(const ProductDetailQuery::Wrapper& query)
{
	auto jov = ProductDetailJsonVO::createShared();
	return jov;
}
