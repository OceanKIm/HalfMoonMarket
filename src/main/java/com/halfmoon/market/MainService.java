package com.halfmoon.market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.halfmoon.market.model.domain.ProductTypeDomain;

@Service
public class MainService {
	
	@Autowired
	private MainMapper mapper;
	
	List<ProductTypeDomain> selMenuList() {
		return mapper.selMenuList();
	}
	
	
	
	
	
	
	
}
