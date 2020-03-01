package servlet.test_jdbc;
import java.sql.*;//导入sql数据库包中的所有类


/*************************执行sql select查询语句***************************
 *1.con.createStatement():用于创建sql语句查询编辑器，用于执行sql语句
 *2.
 **/
//数据库的查询操作
public class SQL_select {

	public static void main(String[] args) {
		ConnectDB db=new ConnectDB();//连接数据库实例
		Connection dbCon=db.getConnectDb();//数据库连接实例
		ResultSet res;//结果数据集
		try{
			res = Statement_query(dbCon);
			//res = PreparedStatement_query(dbCon);
			while(res.next()){//res数据集中指针指向一条数据对象
				//String id=res.getString("id");//获取数据id字段值
				String name=res.getString("name");//获取数据name字段值
				//String sex=res.getString("sex");//获取数据id字段值
				//String age=res.getString("age");//获取数据age字段值
				//System.out.print("id:"+id+" ");
				System.out.print("name:"+name+" ");
				//System.out.print("sex:"+sex+" ");
				//System.out.print("age:"+age+" ");
				System.out.println();
				dbCon.close();//关闭数据库连接
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//2.通过预处理SQL进行数据查询(提高查询效率)
	public static ResultSet PreparedStatement_query(Connection connect) throws Exception{
		String sql_sj="SELECT * FROM personinfo";
		String sql_sj2="SELECT * FROM personinfo where id=?";
		PreparedStatement preSql=connect.prepareStatement(sql_sj2);//将sql语句进行预处理操作
		preSql.setObject(1,2);//动态参数赋值
		ResultSet res=preSql.executeQuery();//执行查询操作
		return res;
	}
	//1.通过Statement进行SQL语句的查询操作
	public static ResultSet Statement_query(Connection connect) throws Exception{
		Statement sql=connect.createStatement();//sql查询编辑器实例
		//1.查询所有数据
		String query_allsj = "SELECT * FROM personinfo ORDER BY id ASC";
		//2.模糊查询
		String query_mhcx = "select * from personinfo WHERE name LIKE '小%'";
		String sql_string = "select * from user_table";
		ResultSet res=sql.executeQuery(sql_string);//查询的数据结果数据集
		return res;
	}
}
