package com.halfmoon.market.model;

public class UserEntity {
	private int i_user;
	private String id_email;
	private String user_nm;
	private String user_pw;
	private String ph;
	
	// 주소
	private String postcode;
	private String roadAddr;
	private String jibunAddr;
	private String detailAddr;
	private String extraAddr;
	
	private int gender;
	private String r_dt;
	private String profile_img; 
	private String rating;
	
	// 회원가입 인증
	private String join_code;
	private String isAuth;
	
	
	public String getJoin_code() {
		return join_code;
	}
	public void setJoin_code(String join_code) {
		this.join_code = join_code;
	}
	public String getIsAuth() {
		return isAuth;
	}
	public void setIsAuth(String isAuth) {
		this.isAuth = isAuth;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public String getId_email() {
		return id_email;
	}
	public void setId_email(String id_email) {
		this.id_email = id_email;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getRoadAddr() {
		return roadAddr;
	}
	public void setRoadAddr(String roadAddr) {
		this.roadAddr = roadAddr;
	}
	public String getJibunAddr() {
		return jibunAddr;
	}
	public void setJibunAddr(String jibunAddr) {
		this.jibunAddr = jibunAddr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getExtraAddr() {
		return extraAddr;
	}
	public void setExtraAddr(String extraAddr) {
		this.extraAddr = extraAddr;
	}	
	public String getUser_nm() {
		return user_nm;
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}	
}
