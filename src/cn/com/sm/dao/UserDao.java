package cn.com.sm.dao;

import cn.com.sm.po.User;

//数据访问接口
public interface UserDao {
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
}
