package cn.com.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.mvc.model.User;

//json数据格式参数处理
@Controller
public class JsonControllerTest {
	//创建日志对象
	Log log=LogFactory.getLog(this.getClass());
	
	//前端以"Content-Type:application/x-www-form-urlencoded;charset=UTF-8"发送
	//参数数据时，后台不需要进行类型转换
	@RequestMapping("JsonTest")
	public @ResponseBody User JsonTest(User user){
		//系统直接将json格式的参数，转换为User实例类
		String username=user.getName();
		String password=user.getPassword();
		//输出日志
		log.info("username:"+username);
		log.info("password:"+password);
		
		//@ResponseBody将User解析为json格式输出
		return user;
	}
	
	//处理json数据格式的参数,将请求body数据进行数据转换
	//前端以"Content-Type:application/json;charset=utf-8"发送
	//参数数据时，后台需要进行类型转换
	@RequestMapping("JsonTest2")
	public @ResponseBody User JsonTest2(@RequestBody User user){
		//系统直接将json格式的参数，转换为User实例类
		String username=user.getName();
		String password=user.getPassword();
		//输出日志
		log.info("username:"+username);
		log.info("password:"+password);
		
		//@ResponseBody将User解析为json格式输出
		return user;
	}
	
	
	
	//显示json测试页面
	@RequestMapping("toJosnTestPage")
	public String toJosnTestPage(Model model){
		//json测试页面
		return "/JsonTest";
	}
	
}
