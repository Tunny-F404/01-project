#pragma once
#ifndef _PRODUCTDTO_H_
#define _PRODUCTDTO_H_

#include "../../GlobalInclude.h"

#include OATPP_CODEGEN_BEGIN(DTO)
//生产领料单列表数据模型
class ProductTableDTO :public oatpp::DTO
{
	DTO_INIT(ProductTableDTO, DTO);
	//唯一标识领料单id 隐藏
	API_DTO_FIELD(UInt64, pid, ZH_WORDS_GETTER("product.fields.pid"), true, 200);
	//领料单编号
	API_DTO_FIELD(String, pnum, ZH_WORDS_GETTER("product.fields.pnum"), true, "ISSUE20221115004");
	//领料单名称
	API_DTO_FIELD(String, pname, ZH_WORDS_GETTER("product.fields.pname"), true, "");
	//生产工单
	API_DTO_FIELD(String, plist, ZH_WORDS_GETTER("product.fields.plist"), true, "MO202211030003");
	//客户编号
	API_DTO_FIELD(String, pcnum, ZH_WORDS_GETTER("product.fields.pcnum"), true, "C00197");
	//客户名称
	API_DTO_FIELD(String, pcname, ZH_WORDS_GETTER("product.fields.pcname"), true, "");
	//领料日期
	API_DTO_FIELD(String, pdate, ZH_WORDS_GETTER("product.fields.pdate"), true, "2022-11-15 00:00:00");
	//单据状态
	API_DTO_FIELD(String, pstatus, ZH_WORDS_GETTER("product.fields.pstatus"), true, "FINISHED");
};
//部门详情数据模型
class ProductDetailDTO :public ProductTableDTO
{
	DTO_INIT(ProductDetailDTO, ProductTableDTO);
	//领料仓库
	API_DTO_FIELD(String, prname, ZH_WORDS_GETTER("product.fields.prname"), true, "");
	//备注
	API_DTO_FIELD(String, premark, ZH_WORDS_GETTER("product.fields.premark"), true, "");

};
class ProductPageDTO :public PageDTO<ProductTableDTO::Wrapper> {
	DTO_INIT(ProductPageDTO, PageDTO<ProductTableDTO::Wrapper>);
};



#include OATPP_CODEGEN_END(DTO)
#endif