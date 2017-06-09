package com.rt.rest;

public class UserResp {
	private int respid;
	private String msg;
	public int getRespid() {
		return respid;
	}
	public void setRespid(int respid) {
		this.respid = respid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "UserResp [respid=" + respid + ", msg=" + msg + "]";
	}
	

}
