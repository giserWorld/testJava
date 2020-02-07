package cn.com.mybatis.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.com.mybatis.dataSouce.DataConnecton;
import cn.com.mybatis.po.User;

public class MybatisTest {
	//创建数据库连接实例
	public DataConnecton dataConn=new DataConnecton();
	
	
	@Test
	//select查询，SELECT * FROM tb_user WHERE id=1
	public void TestSelect() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		//通过sql映射关系，获取sql语句
		//sqlSession.selectOne()必须返回一个对象或 null 值
		User user=sqlSession.selectOne("test.findUserById",1);
		System.out.println("账号:"+user.getName());
		System.out.println("密码:"+user.getPassword());
		sqlSession.close();
	}
	@Test
	//模糊查询，SELECT * FROM tb_user WHERE name LIKE '%x%';
	public void TestFuzzySearch() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		//通过sql映射关系，获取sql语句
		//sqlSession.selectList()返回多个对象
		List<User> users=sqlSession.selectList("test.findUserByName","x");
		for(int i=0;i<users.size();i++){
			User user=users.get(i);
			System.out.print("id:"+user.getId());
			System.out.print(",账号:"+user.getName());
			System.out.println(",密码:"+user.getPassword());
		}
		sqlSession.close();
	}
	
	@Test
	//插入新数据，INSERT INTO tb_user(id, password) VALUES(8,'456');
	public void TestInsert() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		User user=new User();
		user.setId(18);
		user.setName("autoKey");
		user.setPassword("562");
		
		//通过sql映射关系，获取sql语句
		//sqlSession.insert("test.insertUser",user);
		sqlSession.insert("test.insertUser2",user);
		sqlSession.commit();//提交到数据库
		sqlSession.close();
	}
	
	@Test
	//删除数据，DELETE FROM tb_user WHERE id=18;
	public void TestDelete() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		
		//通过sql映射关系，获取sql语句
		sqlSession.delete("test.deleteUser",17);
		sqlSession.commit();//提交到数据库
		sqlSession.close();
	}
	
	@Test
	//更新数据，UPDATE tb_user SET name='xiaohong_update' WHERE id=9;
	public void TestUpdate() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		User user=new User();
		user.setId(15);
		user.setName("update数据");
		user.setPassword("88");
		
		
		//通过sql映射关系，获取sql语句
		sqlSession.update("test.updateUser",user);
		sqlSession.commit();//提交到数据库
		sqlSession.close();
	}
	
}
