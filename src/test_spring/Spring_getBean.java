package test_spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring_getBean {
	public static void main(String[] args) {
		//相对于class类路径
		 ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("test_spring/xml/applicationContext.xml");
		 Book b=(Book)ac.getBean("book");
		 Persion p=(Persion)ac.getBean("persion");
		 
		 System.out.println("bookBean:"+b.name);
		 System.out.println("persion:"+p.getB().name);
	}
}
