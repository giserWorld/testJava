package servlet.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Class_Cookie extends HttpServlet{
	//get请求
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//在服务器端创建cookie
		Cookie cki=new Cookie("name","tian");
		cki.setMaxAge(60);//有效期限
		resp.addCookie(cki);//将cookie添加到响应体中
		
		resp.setContentType("text/html;charset=utf-8");//解决乱码
		PrintWriter pWriter=resp.getWriter();//打印器
		//拼写html字符串
		pWriter.println("<html>");
		pWriter.println("<body>");
		pWriter.println("<h3>登陆页面</h3>");
		pWriter.println("<body>");
		pWriter.println("<form action='./logincl' method='POST' autocomplete='off'>");
		pWriter.println("用户名:<input type='text' name='username'/><br/>");
		pWriter.println("密    码:<input type='text' name='password'/><br/>");
		pWriter.println("<button>提交</button>");
		pWriter.println("</form>");
		pWriter.println("</body>");
		pWriter.println("</html>");
	}
}
