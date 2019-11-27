/**************************与postgreSQL数据库建立链接***********************/
package db;
import java.sql.*;
public class ConnectDB {
	
	public static void main(String[] args) {
		ConnectDB db=new ConnectDB();//类实例
		Connection con=db.getConnectDb();//连接数据库
	}
//***********************创建连接数据库的方法**********************
	public Connection getConnectDb(){
		Connection dbCon = null;
		try{
			
			 Class.forName("org.postgresql.Driver");//加载postgresql数据库驱动
			 //与数据库建立连接
			 String db="localhost:5432/javaDB";//数据库
			 String username="postgres";//用户名
			 String password="123456";//密码
			 String dbUrl="jdbc:postgresql://"+db;
			 dbCon=DriverManager.getConnection(dbUrl,username,password);//与数据库建立连接,返回连接实例
			 System.out.println("连接postgresql数据库成功！");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return dbCon;
	}

}
