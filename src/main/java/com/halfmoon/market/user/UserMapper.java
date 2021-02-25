package com.halfmoon.market.user;

import org.apache.ibatis.annotations.Mapper;

import com.halfmoon.market.model.UserEntity;
import com.halfmoon.market.model.domain.UserDomain;
import com.halfmoon.market.model.dto.UserDTO;

@Mapper
public interface UserMapper {
	
	int insUser(UserDTO dto);
	int updAuth(UserDTO dto);
	int updUser(UserDTO p);
	int updAddr(UserDTO p);
	UserDomain selUser(UserDTO dto);
	
	int updProfileImg(UserDTO p);
	

	


	

}
