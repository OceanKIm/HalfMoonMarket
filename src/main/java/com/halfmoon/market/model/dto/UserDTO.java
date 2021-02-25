package com.halfmoon.market.model.dto;

import com.halfmoon.market.model.UserEntity;

public class UserDTO extends UserEntity{
	private String clk_pw;
	private int state;

	public String getClk_pw() {
		return clk_pw;
	}

	public void setClk_pw(String clk_pw) {
		this.clk_pw = clk_pw;
	}

	public int getStatus() {
		return state;
	}

	public void setStatus(int state) {
		this.state = state;
	}
	
	
}
