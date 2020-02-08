package cn.com.sm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sm.mapper.UserQueryMapper;
import cn.com.sm.po.User;


public class UserMapperTest {
	private ApplicationContext applicationContext;
	
	@Before
	//在执行本类所有测试方法之前先调用这个方法
	public void setUp() throws Exception{
		//spring配置文件路径
		String springConfig="classpath:spring/applicationContext.xml";
		//从spring配置文件中读取数据，并且创建applicationContext实例
		applicationContext=new ClassPathXmlApplicationContext(springConfig);
	}
	
	//mapper代理接口测试
	@Test
	public void testFindUserById() throws Exception{
		//spring mappser自动扫描获取mapper代理接口
		UserQueryMapper userQueryMapper=(UserQueryMapper)applicationContext.getBean("userQueryMapper");
		
		User user=userQueryMapper.findUserById(1);
		System.out.println("用户名:"+user.getUsername()+" | "+"id:"+user.getId());
		
	}
}
