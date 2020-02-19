package cn.com.mvc.mvcUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//通过“.Property”配置文件管理异常的中文信息，为了方便统一管理和编辑异常信息
public class ExceptionPropertyUtil {
	private Properties prop;//属性集合对象
	private InputStream fis;//属性文件文件输入流
	
	//将文件中的数据装载到Properties对象中
	public void init() throws IOException{
		//属性集合实例
		prop=new Properties();
		//将exceptionMapping.properties文件数据输入到内存中
		fis=this.getClass().getResourceAsStream("/exceptionMapping.properties");
		prop.load(fis);//将exceptionMapping.properties文件数据装载到prop对象中
		fis.close();
	}
	
	//获取异常代码获取对应的异常消息
	public String getExceptionMsg(String ExceptionCode) throws IOException{
		init();
		//根据异常代码从Properties对象中获取对应的消息
		String msg=prop.getProperty(ExceptionCode);
		if(msg==null)msg="未定义异常！";
		return msg;
	}
}
