package com.halfmoon.market.common;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.halfmoon.market.model.UserEntity;
import com.halfmoon.market.model.dto.UserDTO;

public class SecurityUtils {
	@Autowired
	private static HttpSession hs;
	
	
	//true: 로그인된 상태, false: 로그아웃 된 상태
	public static boolean isLogin() {
		return getLoginUser() != null;
	}
	
	public static UserEntity getLoginUser() {		
		return (UserEntity) hs.getAttribute(Const.KEY_LOGINUSER);
	}
	
	public static int getLoingUserPk() {
		UserEntity loginUser = getLoginUser();
		return loginUser == null ? -1 : loginUser.getI_user();
	}
	
	public static String getsalt() {
		return BCrypt.gensalt();
	}

	public static String hashPassword(String pw, String salt) {
		return BCrypt.hashpw(pw, salt);
	}
	
	public static boolean checkPassword(UserDTO p) {
		if (BCrypt.checkpw(p.getUser_pw(), p.getClk_pw())){
			return true;
		}
		return false;
	}
	
	// 인증코드 생성기.
	public static String authCode(int length) {
		String code = "";
		// 55개 문자 
		char[] ch = {'0','1','2','3','4','5','6','7','8','9',
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','w','x','y','z',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','W','X','Y','Z'};
		for (int i = 0; i < length; i++) {
			code += ch[(int)(Math.random() * 55)];
		}
		return code;
	}

}
