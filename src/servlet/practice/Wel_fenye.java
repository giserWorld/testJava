package servlet.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.ConnectDB;

//分页
public class Wel_fenye extends HttpServlet{
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession hs=req.getSession();//获取已经存在的session
		String username=(String)hs.getAttribute("username");
		if(username==null){
			resp.sendRedirect("./login");
		}
		
		//分页算法
		int pageSize=3;//页面大小
		int currentPage=1;//当前页面
		int pageCount=0;//总的页面数
		int rowCounts=0;//总的数据条数
		
		//解决乱码
		resp.setContentType("text/html;charset=utf-8");
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		currentPage=Integer.parseInt(req.getParameter("currentPage"));
		PrintWriter pWriter=resp.getWriter();
		
		
		
		//登录成功后的欢迎界面
		pWriter.println("<html>");
		pWriter.println("<body style='text-align: center;'>");
		pWriter.println("<img src='./images/wrjgif.png' height='63'/></br>");
		pWriter.println("<h3>欢迎登录！</h3></br>");
		
		//显示分页
		pWriter.println("<div style='display: inline-block;'>");
		pWriter.println("<table border='1'>");
		pWriter.println("<thead>");
		pWriter.println("<tr>");
		pWriter.println("<td>id</td>");
		pWriter.println("<td>name</td>");
		pWriter.println("<td>password</td>");
		pWriter.println("</tr>");
		pWriter.println("</thead>");
		pWriter.println("<tbody>");
		try {
			ResultSet num=this.querySQl("SELECT count(*) from user_table");
			num.next();
			rowCounts=Integer.parseInt(num.getString("count"));
			if(rowCounts%pageSize==0){
				pageCount=rowCounts/pageSize;
			}
			else{
				pageCount=rowCounts/pageSize+1;
			}
			System.out.println(pageCount);
		    int offsetRows=(currentPage-1)*pageSize;//偏移的行数
			String sql="SELECT * from user_table ORDER BY id asc LIMIT "+pageSize+" OFFSET "+offsetRows;
			//System.out.println(sql);
			ResultSet res=this.querySQl(sql);
			while(res.next()){
				String id=res.getString("id");
				String name2=res.getString("name");
				String mm=res.getString("password");
				pWriter.println("<tr>");
				pWriter.println("<td>"+id+"</td>");
				pWriter.println("<td>"+name2+"</td>");
				pWriter.println("<td>"+mm+"</td>");
				pWriter.println("</tr>");
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		pWriter.println("</tbody>");
		pWriter.println("</table>");
		pWriter.println("</div><br>");
		pWriter.println("<div>");
		if(currentPage!=1){
			pWriter.println("<a href='?currentPage="+(currentPage-1)+"'>"+"上一页"+"</a>");
			pWriter.println("<a href='?currentPage="+"1"+"' style='margin-right: 10px;'>"+"首页"+"</a>");
		}
		for(int i=currentPage;i<=currentPage+2;i++){
			pWriter.println("<a href='?currentPage="+i+"'>"+i+"</a>");
		}
		if(currentPage!=pageCount){
			pWriter.println("<a href='?currentPage="+(currentPage+1)+"' style='margin-left: 10px;'>"+"下一页"+"</a>");
			pWriter.println("<a href='?currentPage="+pageCount+"'>"+"尾页"+"</a>");
		}
		pWriter.println("</div><br>");
		pWriter.println("<label>你的用户名:");
		pWriter.println(username);
		pWriter.println("</label></br>");
		pWriter.println("<a href='./login'>返回重新登录</a>");
		pWriter.println("</body>");
		pWriter.println("</html>");
	}
	
	public ResultSet querySQl(String sql) throws SQLException{
		ConnectDB db=new ConnectDB();
		Connection dbCon=db.getConnectDb();
		Statement st=dbCon.createStatement();
		ResultSet res=st.executeQuery(sql);
		return res;
	}

}
