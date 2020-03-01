package servlet.test_jdbc;
import java.sql.*;//导入包中的所有类

/*************************执行sql update添加语句***************************
 *1.
 *2.
 **/
public class SQL_update {

	public static void main(String[] args) {
		
		ConnectDB db=new ConnectDB();
		Connection con=db.getConnectDb();
		try{
			int res=updateData(con);
			System.out.println("更新数据成功！");
		}catch(Exception e){
			System.out.println("更新数据失败！");
		}
	}
	
	public static int updateData(Connection con) throws Exception{
		String updatesj2="UPDATE personinfo set name=? WHERE id=?";
		PreparedStatement pstament=con.prepareStatement(updatesj2);
		//动态赋值
		pstament.setObject(1, "wo");
		pstament.setObject(2, 16);
		return pstament.executeUpdate();
	}

}
