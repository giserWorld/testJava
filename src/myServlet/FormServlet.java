package myServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		//设置响应的编码格式为UTF-8编码，否则发生中文乱码现象
		resp.setContentType("text/html;charset=UTF-8");
	    //1.获得请求方式
	    String method = req.getMethod();
	    //2.获得请求的资源相关的内容
	    String requestURI = req.getRequestURI();//获得请求URI			
	    StringBuffer requestURL = req.getRequestURL();
	    String webName = req.getContextPath();//获得应用路径（应用名称）
	    String querryString = req.getQueryString();//获得查询字符串
	
	    resp.getWriter().write("<h3>下面是获得的字符串</h3>");
	    resp.getWriter().write("<h3>method(HTTP方法):<h3>");
	    resp.getWriter().write("<h3>"+method+"</h3><br>");
	    resp.getWriter().write("<h3>requestURi(请求URI）:</h3>");
	    resp.getWriter().write("<h3>" + requestURI + "</h3><br>");
	    resp.getWriter().write("<h3>webname(应用名称):</h3>");
	    resp.getWriter().write("<h3>" + webName + "</h3><br>");
	    resp.getWriter().write("<h3>querrystring(查询字符串):</h3>");
	    resp.getWriter().write("<h3>" + querryString + "</h3>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}
}
