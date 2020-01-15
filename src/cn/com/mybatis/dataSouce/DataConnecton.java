package cn.com.mybatis.dataSouce;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataConnecton {
	private String resource = "SqlMapConfig.xml";
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession sqlSession;
	//成员方法
	public SqlSession getSqlSession() throws IOException{
		//mybatis配置文件
		
		//从配置文件中读取数据，并且创建SqlSessionFactory实例
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//创建与数据库交互的sqlSession实例
		sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}
}
