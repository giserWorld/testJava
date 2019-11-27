package practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//登录请求
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//解决乱码
		resp.setContentType("text/html;charset=utf-8");
		
		PrintWriter pWriter=resp.getWriter();//打印器
		//拼写html字符串
		pWriter.println("<html>");
		pWriter.println("<body>");
		pWriter.println("<h3>登陆页面</h3>");
		pWriter.println("<body>");
		pWriter.println("<form action='./logincl' method='POST'>");
		pWriter.println("用户名:<input type='text' name='username'/><br/>");
		pWriter.println("密    码:<input type='text' name='password'/><br/>");
		pWriter.println("<button>提交</button>");
		pWriter.println("</form>");
		pWriter.println("</body>");
		pWriter.println("</html>");
	}

}
