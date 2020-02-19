package cn.com.mvc.exception;

import java.io.IOException;

import cn.com.mvc.mvcUtil.ExceptionPropertyUtil;

//根据User类，创建自定义异常类
public class UserException extends Exception{
	
	private String message;//异常信息
	//构造方法
	public UserException(String message){
		super(message);
		this.message=message;
	}
	public String getMessage() {
		ExceptionPropertyUtil exceptionProp=new ExceptionPropertyUtil();
		//从通过异常code获取异常消息
		String msg=null;
		try {
			msg = exceptionProp.getExceptionMsg(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return msg;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
