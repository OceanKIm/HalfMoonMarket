package com.halfmoon.market.model;

public class ReviewEntity {
	
	private int i_review;
	private int i_log;
	private int rating;
	private String ctnt;
	private String r_dt;
	
	public int getI_review() {
		return i_review;
	}
	public void setI_review(int i_review) {
		this.i_review = i_review;
	}
	public int getI_log() {
		return i_log;
	}
	public void setI_log(int i_log) {
		this.i_log = i_log;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
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
