package com.halfmoon.market.model;

public class ProductBuyEntity {

	private int i_product;
	private int i_user;
	private int sug_price;
	private String ctnt;
	private String r_dt;
	
	
	public int getI_product() {
		return i_product;
	}
	public void setI_product(int i_product) {
		this.i_product = i_product;
	}
	public int getI_user() {
		return i_user;
	}
	public void setI_user(int i_user) {
		this.i_user = i_user;
	}
	public int getSug_price() {
		return sug_price;
	}
	public void setSug_price(int sug_price) {
		this.sug_price = sug_price;
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
}
