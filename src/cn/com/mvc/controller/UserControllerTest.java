package cn.com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.mvc.exception.UserException;
import cn.com.mvc.model.User;
import cn.com.mvc.validator.UserValidator;


//登录用户
@Controller
@RequestMapping("user")
public class UserControllerTest {
	
	
	//给cotroller绑定一个校验器
	@InitBinder
	public void InitBinder(DataBinder binder){
		UserValidator validator=new UserValidator();//校验器实例
		binder.setValidator(validator);//设置校验器
	}
	
	//退出登录
	@RequestMapping("loginout")
	public String loginout(Model model,HttpServletRequest request){
		//移除user信息
		request.getSession().removeAttribute("user");
		return "/user/login";
	}
	
	//处理登录逻辑
	@RequestMapping("login")
	public String login(Model model,
			User user,HttpServletRequest request,HttpServletResponse response) throws UserException{
		String userName=user.getName();
		boolean isBlack=this.isBlackUser(userName);
		if(isBlack){
			throw new UserException("user.not.have.power");
		}
		
		//判断登录用户账号密码
		boolean result2=checkUser(user);
		if(result2){
			//获取session
			HttpSession session=request.getSession();
			session.setAttribute("user",session);
		}
		else{//账号密码错误
			if(user.getName()!=null&&user.getPassword()!=null){
				model.addAttribute("loginInfo", "账号或密码错误！");
			}
			return "/user/login";//返回登录成功页面
		}
		return "/user/loginSuccess";//返回登录成功页面
	}
	
	
	//处理登录逻辑
	@RequestMapping("login2")
	public String login2(Model model,
			@Valid User user,BindingResult bindingResult) throws UserException{
		String result=null;
		String userName=user.getName();
		boolean isBlack=this.isBlackUser(userName);
		if(isBlack){
			throw new UserException("user.not.have.power");
		}
		
		//判断校验结果是否有错误
		if(bindingResult.hasErrors()){
			//获取所有的错误信息对象
			List<ObjectError> allErrors=bindingResult.getAllErrors();
			
			//将错误信息对象传给前端
			model.addAttribute("allErrors",allErrors);
			result="/user/login";
		}
		else{
			result="/user/loginSuccess";//返回登录成功页面
		}
		return result;//返回登录成功页面
	}
	
	//登录页面
	@RequestMapping("toLogin")
	public String toLogin(Model model){
		//返回登录页面
		return "/user/login";
	}
	
	//判断用户账号密码是否正确
	public boolean checkUser(User user){
		String name=user.getName();
		String password=user.getPassword();
		if(name.equals("xt")&&password.equals("123")){
			return true;
		}
		return false;
	}
	
	
	//判断用户是是否为黑名单用户
	public boolean isBlackUser(String userName){
		//创建字符串数组
		String str[]={"xiaoming","ali"};
		boolean result=false;
		for(int i=0;i<str.length;i++){
			if(userName.equals(str[i])){
				result=true;
				break;
			}
		}
		return result;
	}
	
}
