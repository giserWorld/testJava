package com.testJava.dao.impl;

import org.springframework.stereotype.Repository;

import com.testJava.entity.User;

//测试dao层
@Repository
public class TestDaoImpl extends BaseDaoImpl<User>{
	public TestDaoImpl(){
		//设置数据接口对应的mapper工作空间
		this.setNs("com.testJava.mapper.TestMapper");
	}
}
