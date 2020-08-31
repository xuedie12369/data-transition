package com.dhcc.entity.hb;

/**
 * @author 邵海楠
 */
public enum ResponseCode {
	SUCCESS(0,"SUCCESS"),
	ERROR(1,"ERROR");

	private final int code;
	private final String msg;
	
	ResponseCode(int code,String desc){
		this.code=code;
		this.msg =desc;
	}

	public int getCode(){
		return code;
	}
	public String getMsg(){
		return msg;
	}
}
