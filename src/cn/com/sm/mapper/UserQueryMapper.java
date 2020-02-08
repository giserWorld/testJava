package cn.com.sm.mapper;

import cn.com.sm.po.User;

//UserQueryMapper.xml mapper代理接口(接口方法需要与SQL配置类型相同)
public interface UserQueryMapper {
	//通过id查询用户信息接口
	public User findUserById(int id) throws Exception;
	
}
