package com.halfmoon.market.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.halfmoon.market.common.Const;
import com.halfmoon.market.common.SecurityUtils;
import com.halfmoon.market.model.UserEntity;
import com.halfmoon.market.model.domain.UserDomain;
import com.halfmoon.market.model.dto.UserDTO;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	HttpSession hs;
	
	@GetMapping("/login")
	public void login() {
		
	}
	
	@GetMapping("/logout")
	public String logout() {
		hs.invalidate();
		return "redirect:/main/home";
	}
	
	@GetMapping("/join")
	public void join() {
		
	}
	
	@ResponseBody
	@PostMapping("/loginProc")
	public Map<String,Object> loginProc(@RequestBody UserDTO dto) {
		Map<String, Object> val = new HashMap<>();
		val.put(Const.KEY_RESULT, service.login(dto));
		return val;
	}
	
	@ResponseBody
	@PostMapping("/joinProc")
	public Map<String,Object> joinProc(@RequestBody UserDTO dto) {
		// proc : 일단회원가입(코드삽입) -> 코드와 i_user값 가져와서 ->  
		Map<String, Object> val = new HashMap<>();
		val.put(Const.KEY_RESULT, service.join(dto));
		return val;
	}
	
	@GetMapping("/joinSucess")
	public void joinSucess(Model model, UserDTO dto) {
		System.out.println("sucess : " + dto.getI_user());
		// 회원권한 승인 및 로그인 처리.
		UserDomain vo = service.updAuth(dto);
		model.addAttribute("user_nm", vo.getUser_nm());
	}
	
	/*  프로필,마이페이지,비밀번호 찾기 기능 추가해야함  */
	@GetMapping("/user/my/profile")
	public void profile() {}
	
	@GetMapping("/changePw")
	@ResponseBody
	public void changPw(UserDTO p) {
		
	}
	
	@ResponseBody
	@PostMapping("/updPw")
	public Map<String,Object> chPw(UserDTO p) {
		Map<String,Object> val = new HashMap<String, Object>();
		val.put(Const.KEY_RESULT, service.updPw(p));
		return val;
	}
	
	@ResponseBody
	@PostMapping("/user/my/updProfile")
	public int profileUpload(MultipartFile[] imgs) {
		System.out.println("imgs : " + imgs.length);
		return service.profileUpload(imgs);
	}
	
	@ResponseBody
	@PostMapping("/user/my/updUser")
	public Map<String,Object> chAddr(@RequestBody UserDTO p,MultipartFile[] imgs) {
		UserDomain vo1 = service.selUser(p);
		UserEntity vo2 = (UserEntity)hs.getAttribute(Const.KEY_LOGINUSER);
		
		
		System.out.println(imgs.length);
		System.out.println();
		p.setI_user(vo2.getI_user());
		Map<String,Object> val = new HashMap<String, Object>();
		if(p.getStatus()==1) {
			if(!BCrypt.checkpw(p.getUser_pw(), vo1.getUser_pw()))
			val.put(Const.KEY_RESULT, service.updPw(p));
		}
		else if(p.getStatus()==3) {
			val.put(Const.KEY_RESULT, service.updAddr(p));
		}
		else if(p.getStatus()==4) {
			val.put(Const.KEY_RESULT, service.updPh(p));
		}
		hs.invalidate();
		hs.setAttribute(Const.KEY_LOGINUSER, service.selUser(p));
		return val;	
	}
	
	
	
	@PostMapping("/profile")
	@ResponseBody
	public Map<String,Object> prfileProc(@RequestBody UserDTO p){
		Map<String,Object> val = new HashMap<String, Object>();
		
		return val;
	}
	
}


















