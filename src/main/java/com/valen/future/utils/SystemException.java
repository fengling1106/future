package com.valen.future.utils;

/**
 * @author fengling
 * @create 2017-07-6
 * @Description 定义业务的异常，抛出错误码和原因
 */
public class SystemException extends Exception {
	private static final long serialVersionUID = 300002017070601L;
	
	public String ErrorCode ;
	public String ErorDesc;
	
	public SystemException(){};
	
	public SystemException(String ErrorCode, String ErrorDesc){
		this.ErrorCode = ErrorCode;
		this.ErorDesc = ErrorDesc;
	}
	

}
