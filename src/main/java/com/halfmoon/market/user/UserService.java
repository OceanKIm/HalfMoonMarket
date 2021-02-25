package com.halfmoon.market.user;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.halfmoon.market.common.Const;
import com.halfmoon.market.common.FileUtils;
import com.halfmoon.market.common.MailUtils;
import com.halfmoon.market.common.SecurityUtils;
import com.halfmoon.market.model.UserEntity;
import com.halfmoon.market.model.domain.UserDomain;
import com.halfmoon.market.model.dto.UserDTO;

@Service
public class UserService {
	
	@Autowired
	private UserMapper mapper;
	
	@Autowired
	private HttpSession hs;
	
	@Autowired
	private MailUtils mUtils;
	@Autowired
	private FileUtils fUtils;
	
	public UserDomain selUser(UserDTO p) {
		return mapper.selUser(p);
	}
	
	public int login(UserDTO p) {
		UserDomain vo = selUser(p);
		if(vo == null) {
			return 2;
		}
		p.setUser_pw(vo.getUser_pw());
		if(!BCrypt.checkpw(p.getClk_pw(), vo.getUser_pw())) {
			return 3;
		}
		vo.setUser_pw(null);
		hs.setAttribute(Const.KEY_LOGINUSER, vo);
		return 1;
	}
	
	public int chkJoinMail(UserDTO dto) {
		return mUtils.sendJoinEmail(dto.getId_email(), dto);
	}
	
	public int join(UserDTO dto) {
		int result = 0;
		// 비밀번호 암호화
		String encryptPw = SecurityUtils.hashPassword(dto.getUser_pw(), SecurityUtils.getsalt());
		dto.setUser_pw(encryptPw);
		
		// 정보 입력
		result = mapper.insUser(dto);
		System.out.println("join i_user : " + dto.getI_user());
		if (result == 0) {
			return 2; // 2: 정보입력 실패 : 중복된 ID
		}
		// 인증메일 전송	
		System.out.println("send mail...");
		result = chkJoinMail(dto);
		System.out.println("result : " + result);
		return result;
	}
	
	UserDomain updAuth(UserDTO dto) {
		// 권한 승인
		mapper.updAuth(dto);
		// 로그인 처리
		UserDomain vo = mapper.selUser(dto);
		vo.setUser_pw(null);
		hs.setAttribute(Const.KEY_LOGINUSER, vo);
		return vo;
	}
	
/* profile 작업*/
	
	public int updPw(UserDTO p) {
		p.setStatus(1);
		return mapper.updUser(p);
	}
	
	public int profileUpload(MultipartFile[] imgs) {	
		UserEntity vo2 = (UserEntity)hs.getAttribute(Const.KEY_LOGINUSER);
		vo2.getI_user();
		UserDTO p = new UserDTO();
		if(vo2.getI_user() < 1 || imgs.length == 0) {
			return 0;
		}
		
		String folder = "/resources/img/user/" + vo2.getI_user();		
				
		try {
			for(int i=0; i<imgs.length; i++) { //반복문 필요없을거 같음
				MultipartFile file = imgs[i];
				String fileNm = fUtils.saveFile(file, folder);
				if(fileNm == null) {
					return 0;
				}
				if(i==0) { //메인 이미지 업데이트
					p.setI_user(vo2.getI_user());
					p.setProfile_img(fileNm);	
					mapper.updProfileImg(p);
				}				
			}
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
	
	public int updAddr(UserDTO p) {
		int result = mapper.updUser(p);
		return 1;
	}
	public int updPh(UserDTO p) {
		int result = mapper.updUser(p);
		return 1;
	}
	

}














