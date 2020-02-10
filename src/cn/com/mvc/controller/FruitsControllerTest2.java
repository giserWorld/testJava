package cn.com.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.FruitsServiceImpl;

//加载水果商城的水果列表信息(实现Controller接口的控制类，处理逻辑)
public class FruitsControllerTest2 implements HttpRequestHandler{
	FruitsService fruitService=new FruitsServiceImpl();//提供水果数据

	@Override
	//HttpServlet的http请求包含请求报文和响应报文
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取水果列表数据
		List <Fruits> fruitsList=fruitService.queryFruitsList();
		
		//1.response返回的数据是带有fruitsList数据对象jsp页面
		request.setAttribute("fruitsList",fruitsList);//设置模型数据，请求报文
		//request.getRequestDispatcher("/WEB-INF/jsp/fruits/fruitsList.jsp").forward(request,response);  
		
		//2.response返回的数据json数据
		String jsonStr=convertListToJson(fruitsList);//将fruitsList数据转为json字符串
		//设置response响应报文
		response.setCharacterEncoding("utf-8");//设置response的字符编码，避免数据乱码
		response.setContentType("application/json;charset=utf-8");//设置返回数据格式的字符编码，避免数据乱码
		//写入响应数据
		response.getWriter().write(jsonStr);
	}
	
	//将list数据格式转为json字符串
	public String convertListToJson(List<Fruits> fruitsList){
		//构建json字符串数据
		StringBuilder builder=new StringBuilder();
 	    builder.append('[');
 	    for(Fruits fruits:fruitsList){
 		   builder.append('{');
 		   builder.append("\"name\":\"").append(fruits.getName()).append("\",");
 		   builder.append("\"price\":\"").append(fruits.getPrice()).append("\",");
 		   builder.append("\"producing_area\":\"").append(fruits.getProducing_area()).append("\"");
 		   builder.append("},");
 	    }
 	    builder.deleteCharAt(builder.length()-1);
 	    builder.append(']');
		return builder.toString();
	}
}


