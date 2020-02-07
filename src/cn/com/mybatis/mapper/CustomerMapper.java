package cn.com.mybatis.mapper;

import cn.com.mybatis.po.Customer;

//mapper代理接口
public interface CustomerMapper {
	//根据id查询用户信息
	public Customer findCustomerById(int id) throws Exception;
	//添加用户信息
	public Customer insertCustomer(Customer customer) throws Exception;
	//删除用户信息
	public void deleteCustomer(int id) throws Exception;
	//修改用户信息
	public void updateCustomer(Customer customer) throws Exception;
}
