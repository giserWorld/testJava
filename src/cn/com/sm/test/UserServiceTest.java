package cn.com.sm.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sm.dao.UserDao;
import cn.com.sm.po.User;


public class UserServiceTest {
	private ApplicationContext applicationContext;//spring配置文件对象
	//在执行测试方法之前首先获取Spring配置文件对象
	
	@Before
	//在执行本类所有测试方法之前先调用这个方法
	public void setUp() throws Exception{
		//spring配置文件路径
		String springConfig="classpath:spring/applicationContext.xml";
		//从spring配置文件中读取数据，并且创建applicationContext实例
		applicationContext=new ClassPathXmlApplicationContext(springConfig);
	}
	
	//通过id查询用户信息
	@Test
	public void testFindUserById() throws Exception{
		//通过spring配置对象获取userDao对象
		UserDao userDao=(UserDao)applicationContext.getBean("userDao");//获取id为“userDao”的Bean
		//调用UserDao的方法
		User user=userDao.findUserById(1);
		System.out.println("用户名:"+user.getUsername()+" | id:"+user.getId());
	}
}
