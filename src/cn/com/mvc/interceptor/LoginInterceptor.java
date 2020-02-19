package cn.com.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


//判断用户是否已经登录
public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		//获取请求的接口URL
		String url=request.getRequestURI();
		//判断当前请求的url是否为登录地址
		if(url.contains("Login")||url.contains("login")){
			//登录请求，直接放行
			return true;
		}
		else{//非登录请求
			HttpSession httpSession=request.getSession();//获取http请求的Session实例
			//判断http会话中是否有user属性
			if(httpSession.getAttribute("user")!=null){
				//如果包含"user"属性说明已经登录过，相当于token
				return true;
			}
			else{//还没有登录，直接跳转登录页面
				//直接跳转登录页面
				String baseURL=request.getContextPath();//项目根目录
				//response.sendRedirect(baseURL+"/user/toLogin.action");
			}
		}
		return true;//默认拦截
	} 
	
}
