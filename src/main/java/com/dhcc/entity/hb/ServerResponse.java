package com.dhcc.entity.hb;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 邵海楠
 */
@Data
public class ServerResponse<T> implements Serializable {
	private int status;
	private String msg;
	private T data;


    private ServerResponse(int status){
		this.status=status;
	}

    public ServerResponse(int status, String msg) {
		this.status=status;
		this.msg=msg;
	}

	private ServerResponse(int status,T data){
		this.status=status;
		this.data=data;
	}

	private ServerResponse(int status,String msg,T data){
		this.status=status;
		this.msg=msg;
		this.data=data;
	}

	public static <T> ServerResponse<T> createBySuccess(){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
	}

	/**
	 * 获取msg的方法
	 */
	public static <T> ServerResponse<T> createBySuccessMessage(String msg){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
	}

	public static <T> ServerResponse<T> createBySuccess(T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
	}

	/**
	 * 获取data的方法
	 */
	public static <T> ServerResponse<T> createBySuccessMessage(T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
	}

	/**
	 * 获取msg和data的方法
	 * @param msg
	 * @param data
	 * @param <T>
	 * @return
	 */
	public static <T> ServerResponse<T> createBySuccessMessage(String msg,T data){
		return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
	}

	public static <T> ServerResponse<T> createByError(){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),
				ResponseCode.ERROR.getMsg());
	}

	/**
	 * 提示信息
	 * @param errorMessage
	 * @param <T>
	 * @return
	 */
	public static <T>ServerResponse<T> createByErrorMessage(String errorMessage){
		return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMessage);
	}

	public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
		return new ServerResponse<T>(errorCode,errorMessage);
	}

}
