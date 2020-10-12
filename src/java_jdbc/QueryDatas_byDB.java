package java_jdbc;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.ConnectDB;
public class QueryDatas_byDB {
	public static void main(String args[]){
		ConnectDB dbCon=new ConnectDB();
		Connection db=dbCon.getConnectDb();//数据库连接
		try {
			Statement queryStatement=db.createStatement();
			String sql="select * from user_table WHERE name='wxt'";
			ResultSet res=queryStatement.executeQuery(sql);//结果数据集
			int rowNum=0;
			while(res.next()){
				rowNum++;
			}
			System.out.println(rowNum);//获取当前行数据的name字段
			
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
