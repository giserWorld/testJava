package considerKnowledge;

import java.text.SimpleDateFormat;
import java.util.Date;

/**************************SimpleDateFormat*****************************
 *1.SimpleDateFormat是一个简单的日期格式格式化工具类
 *2.
 **/

public class Class_SimpleDateFormat {
	public static void main(String[] args) {
		
		//时间模板实例
		SimpleDateFormat date_format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//获取当前时间
		Date current=new Date();
		
		//1.格式化Date实例为指定的模板
		String time=date_format.format(current);
		System.out.println("格式化的时间为："+time);
	}
}
