package servlet.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import db.ConnectDB;//导入数据库连接类

//处理登陆的账号和密码
public class LoginCl extends HttpServlet{

	//post请求
	@Override
	protected void doPost(HttpServletRequest req,
			javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name=req.getParameter("username");
		String mm=req.getParameter("password");
		
		boolean loginReslut=LoginCl.querydb(name, mm);//通过用户名和密码查询数据库
		if(loginReslut){
			HttpSession hs=req.getSession();//获取session
			hs.setAttribute("username",name);
			resp.sendRedirect("./wel_fenye?currentPage=1&name="+name+"&"+"password="+mm);
		}
		else{
			resp.sendRedirect("./login");
		}
	}
	//通过用户名和密码查询数据库
	public static boolean querydb(String name,String password){
		boolean result=false;
		if(name!=null&&password!=null){
			ConnectDB Con=new ConnectDB();
			Connection dbCon=Con.getConnectDb();//sql查询编辑器实例
			try {
				//创建结果集可滚动的查询器
				Statement sql=dbCon.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				String sql_string = "select * from user_table WHERE name='"+name+"'";
				ResultSet res=sql.executeQuery(sql_string);//查询的数据结果数据集
				int num=0;
				while(res.next()){
					num++;
				}
				if(num>0){
					res.first();
					String mm=res.getString("password");//获取密码
					if(mm.equals(password)){
						result=true;
					}
					else{
						result=false;
					}
				}
				dbCon.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
