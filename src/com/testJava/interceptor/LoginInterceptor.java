package com.testJava.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.testJava.entity.User;

//接口请求拦截器
public class LoginInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获取请求的地址
		String uri=request.getRequestURI();
		//请求url为接口
		if(uri.contains(".action")){
			
			System.out.println("===========拦截器start:请求requestUrl===========");
			System.out.println(uri);
			System.out.println("====================拦截器end===================");
			//获取http会话
			HttpSession httpSession=request.getSession();
			//获取httpSession中的信息
		    User userInfo=(User)httpSession.getAttribute("user");
			if(userInfo!=null){//用户已经登录过
				return true;
			}
			else{//用户还没登录
				String projUrl=request.getContextPath();//获取项目环境url,即项目根目录
				//response.sendRedirect(projUrl+"/pages/login.jsp");//跳转到登录页面
			}
		}
		else{//请求的是静态资源
			return true;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {}
}
