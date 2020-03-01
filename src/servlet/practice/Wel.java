package servlet.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//显示登陆成功后的页面
public class Wel extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession hs=req.getSession();//获取已经存在的session
		String username=(String)hs.getAttribute("username");
		if(username==null){
			resp.sendRedirect("./login");
		}
		//解决乱码
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		PrintWriter pWriter=resp.getWriter();
		
		//登录成功后的欢迎界面
		pWriter.println("<html>");
		pWriter.println("<body style='text-align: center;'>");
		pWriter.println("<img src='./images/wrjgif.png' height='63'/></br>");
		pWriter.println("<h2>欢迎登录！</h2></br>");
		pWriter.println("<label>你的用户名:");
		pWriter.println(username);
		pWriter.println("</label></br>");
		pWriter.println("<a href='./login'>返回重新登录</a>");
		pWriter.println("</body>");
		pWriter.println("</html>");
	}

}
