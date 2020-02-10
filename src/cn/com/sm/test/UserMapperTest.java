package cn.com.sm.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.sm.mapper.TbUserMapper;
import cn.com.sm.mapper.UserQueryMapper;
import cn.com.sm.po.TbUser;
import cn.com.sm.po.TbUserExample;
import cn.com.sm.po.TbUserExample.Criteria;
import cn.com.sm.po.User;


public class UserMapperTest {
	private ApplicationContext applicationContext;
	//mapper自动生成器测试
	
	
	@Test
	//删除操作
	public void testDeleteUser() throws Exception{
		
		//mapper接口
		TbUserMapper userMapper=(TbUserMapper)applicationContext.getBean("tbUserMapper");
		userMapper.deleteByPrimaryKey(7);
		System.out.println("删除id为："+"7的用户成功，删除成功！");
	}
	
	@Test
	//修改操作
	public void testUpdateUser() throws Exception{
		
		TbUser user=new TbUser();
		user.setId(1);
		user.setEmail("888@qq.com");
		//mapper接口
		TbUserMapper userMapper=(TbUserMapper)applicationContext.getBean("tbUserMapper");
		userMapper.updateByPrimaryKeySelective(user);
		System.out.println("更新id为："+user.getId()+"的用户成功，更新成功！");
	}
	
	
	@Test
	//查询操作（自定义查询）
	public void testSelectUser() throws Exception{
		
		TbUserExample userExmaple=new TbUserExample();
		Criteria slectWhere=userExmaple.createCriteria();//条件实例
		//构造查询条件
		//slectWhere.andUsernameEqualTo("李磊磊");//1.查询条件,WHERE username='李磊磊'
		//slectWhere.andGenderNotEqualTo("男");//2.查询条件,usename！="男"
		//3.查询条件,WHERE birthday BETWEEN '1990-01-01' AND '1994-01-01';
		Date date_start=new SimpleDateFormat("yyyy-MM-dd").parse("1990-01-01");
		Date date_end=new SimpleDateFormat("yyyy-MM-dd").parse("1994-01-01");
		//slectWhere.andBirthdayBetween(date_start,date_end);
		slectWhere.andEmailIsNotNull();//
		//通过userExmaple进行信息查询
		TbUserMapper userMapper=(TbUserMapper)applicationContext.getBean("tbUserMapper");
		List<TbUser> userlist=userMapper.selectByExample(userExmaple);
		
		for(int i=0;i<userlist.size();i++){
			TbUser user=userlist.get(i);
			System.out.println(user.getId()+":"+user.getUsername());
		}
	}
	
	@Test
	//插入用户
	public void testInsertUser() throws Exception{
		
		TbUser user2=new TbUser();
		user2.setUsername("new user1");
		user2.setPassword("6666");
		user2.setGender("男");
		Date date=new SimpleDateFormat("yyyy-MM-dd").parse("1992-01-01");
		user2.setBirthday(date);
		user2.setProvince("云南");
		user2.setCity("大理");
		user2.setEmail("602574436@qq.com");
		//获取mapper接口
		TbUserMapper userMapper=(TbUserMapper)applicationContext.getBean("tbUserMapper");
		userMapper.insert(user2);
		
		System.out.println("1.插入了名为:"+user2.getUsername()+"的用户");
		
	}
	
	
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
