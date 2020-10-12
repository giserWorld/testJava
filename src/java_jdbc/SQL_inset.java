package java_jdbc;

import java.sql.*;//导入包中的所有类

/*************************执行sql insert语句***************************
 *1.
 *2.
 **/
public class SQL_inset {

	public static void main(String[] args) {
		
		ConnectDB db=new ConnectDB();
		Connection con=db.getConnectDb();
		try{
			int res=insetIntoDatas(con);
			System.out.println("插入数据成功！");
		}catch(Exception e){
			System.out.println("插入数据失败！");
		}
	}
	
	public static int insetIntoDatas(Connection con) throws Exception{
		String insetsj="INSERT INTO personinfo (id,name,age) values(16,'come3',26)";
		Statement sql=con.createStatement();
		int res=sql.executeUpdate(insetsj);//执行插入数据操作
		return res;
	}

}
