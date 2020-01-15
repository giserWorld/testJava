package cn.com.mybatis.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;


import cn.com.mybatis.dataSouce.DataConnecton;
import cn.com.mybatis.po.User;
import org.junit.Test;

public class MybatisTest {
	//创建数据库连接实例
	public DataConnecton dataConn=new DataConnecton();
	@Test
	public void TestSelect() throws IOException{
		SqlSession sqlSession=dataConn.getSqlSession();
		//通过sql映射关系，获取sql语句
		User user=sqlSession.selectOne("test.findUserById",1);
		System.out.println("name:"+user.getName());
		System.out.println("password:"+user.getPassword());
		sqlSession.close();
	}
	
}
