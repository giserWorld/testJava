package test_jdbc;

import java.sql.*;//导入包中的所有类


/*************************执行sql delete语句***************************
 *1.
 *2.
 **/
public class SQL_delete {

	public static void main(String[] args) {
		ConnectDB db=new ConnectDB();
		Connection con=db.getConnectDb();
		try{
			int res=deleteData(con);
			System.out.println("删除数据成功！");
		}catch(Exception e){
			System.out.println("删除数据失败！");
		}
	}
	
	public static int deleteData(Connection con) throws Exception{
		String deletesj="DELETE from personinfo WHERE id=?";
		PreparedStatement sql=con.prepareStatement(deletesj);
		sql.setObject(1, 16);
		int res=sql.executeUpdate();
		return res;
	}

}
