package cn.com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.FruitsServiceImpl;

//加载水果商城的水果列表信息(实现Controller接口的控制类，处理逻辑)
public class FruitsControllerTest implements Controller{
	
	FruitsService fruitService=new FruitsServiceImpl();//提供水果数据

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		//获取水果列表数据
		List <Fruits> fruitsList=fruitService.queryFruitsList();
		
		//创建ModelAndView视图(用于存储视图信息和数据)
		ModelAndView modelAndView=new ModelAndView();
		
		//添加数据，将要在视图页面显示的数据，相当于request的setAttribut,在JSP页面中通过fruitsList变量获取数据
		modelAndView.addObject("fruitsList",fruitsList);
		
		//添加视图,即将要显示的视图页面
		modelAndView.setViewName("/WEB-INF/jsp/fruits/fruitsList.jsp");
		return modelAndView;
	}
	
}

