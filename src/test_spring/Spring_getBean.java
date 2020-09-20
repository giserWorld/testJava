package test_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring_getBean {
	public static void main(String[] args) {
		 ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("xml/applicationContext.xml");
		 Book b=(Book)ac.getBean("book");
		 System.out.println(b.name);
	}
}
