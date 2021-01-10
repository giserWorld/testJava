package java_servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("==============================================");
		System.out.println("ServletContextListener.contextInitialized方法被调用");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("==============================================");
		System.out.println("ServletContextListener.contextDestroyed方法被调用");
	}
}
