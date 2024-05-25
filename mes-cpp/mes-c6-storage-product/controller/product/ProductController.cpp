#include "stdafx.h"
#include "ProductController.h"
#include "../../service/product/ProductService.h"
#include "../ApiDeclarativeServicesHelper.h"
ProductTableJsonVO::Wrapper ProductController::execProductTable(const ProductQuery::Wrapper& query,const PayloadDTO& payload)
{
	// 定义一个Service
	ProductTableService service;
	// 查询数据
	auto result = service.listAll(query);
	// 响应结果
	auto jvo = ProductTableJsonVO::createShared();
	jvo->success(result);
	return jvo;
}
ProductDetailJsonVO::Wrapper ProductController::execProductDetail(const ProductDetailQuery::Wrapper& query)
{
	auto jov = ProductDetailJsonVO::createShared();
	return jov;
}
