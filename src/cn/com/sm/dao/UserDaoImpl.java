package cn.com.sm.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.com.sm.po.User;


public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public User findUserById(int id) throws Exception { 
		// 继承SqlSessionDaoSupport类，同过this.getSqlSession()得到sqlSession
		SqlSession sqlSession=this.getSqlSession();//获取mybatis SqlSession数据交互api
		User user=sqlSession.selectOne("test.findUserById",id);
		return user;
	}
	
}
