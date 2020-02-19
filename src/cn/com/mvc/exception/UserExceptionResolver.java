package cn.com.mvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//异常解析器，创建SpringMVC全局异常处理器
public class UserExceptionResolver implements HandlerExceptionResolver{

	//解析异常的方法
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		UserException userException=null;
		
		
		//1.解析异常类型
		if(ex instanceof UserException){//判断异常是否为自定义的UserException异常类
			//2.如果异常类型为自定义异常类型，则直接取出异常信息，在错误页面显示
			userException=(UserException)ex;
		}
		else{//其他异常类型
			//3.如果异常类型不是自定义的异常，创建一个"未知错误"的异常
			userException=new UserException("未知错误");
		}
		//获取系统捕获的异常信息
		String message=userException.getMessage();
		//创建视图页面
		ModelAndView viewerPage=new ModelAndView();
		
		//该页面绑定全局变量
		viewerPage.addObject("message",message);
		viewerPage.setViewName("/errorPage/userError");
		
		return viewerPage;
	}
	
}
