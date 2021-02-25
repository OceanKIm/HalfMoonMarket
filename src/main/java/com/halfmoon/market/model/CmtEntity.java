package com.halfmoon.market.model;

public class CmtEntity {
	
	private int i_cmt;
	private int i_user;
	private int i_product;
	private String ctnt;
	private String r_dt;
	private int isSecret;
	
	
	public int getI_cmt() {
		return i_cmt;
	}
	public void setI_cmt(int i_cmt) {
		this.i_cmt = i_cmt;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getI_product() {
		return i_product;
	}
	public void setI_product(int i_product) {
		this.i_product = i_product;
	}
	public String getCtnt() {
		return ctnt;
	}
	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}
	public String getR_dt() {
		return r_dt;
	}
	public void setR_dt(String r_dt) {
		this.r_dt = r_dt;
	}
	public int getIsSecret() {
		return isSecret;
	}
	public void setIsSecret(int isSecret) {
		this.isSecret = isSecret;
	}
}
