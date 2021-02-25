package com.halfmoon.market;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.halfmoon.market.model.domain.ProductTypeDomain;

@Mapper
public interface MainMapper {

	List<ProductTypeDomain> selMenuList();
		
	
	
	
	
}
