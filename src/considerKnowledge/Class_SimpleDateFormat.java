package considerKnowledge;

import java.text.SimpleDateFormat;
import java.util.Date;

/**************************SimpleDateFormat*****************************
 *1.SimpleDateFormat是一个简单的日期格式格式化工具类
 *2.SimpleDateFormat 是一个各种项目中使用频度都很高的类，
 *主要用于时间解析与格式化，频繁使用的主要方法有parse和format
 **********************************构造方法*******************************
 *1.实例化SimpleDateFormat时间模板支持的格式：
	1）new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");//2020年02月10日 10时12分26秒
	2）new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//2020-02-10 10:13:45
	3）new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//2020/02/10 10:15:09
	4）new SimpleDateFormat("yyyy/MM/dd HH:mm");//2020/02/10 10:15
	5）new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E");//2020年02月10日 10时16分49秒 星期一
	6）new SimpleDateFormat("yyyy/MM/dd E");//2020/02/10 星期一
 **********************************方法**********************************
 *1.simpleDateFormat.format(date):将字符串String类型解析为日期Date类型
 *2.simpleDateFormat.parse(timeStr):将日期类型Date数据格式化为字符串String(需要指定时间字符串格式)
 *3.
 **/

public class Class_SimpleDateFormat {
	public static void main(String[] args) throws Exception{
		
		//实例化SimpleDateFormat()
		SimpleDateFormat date_format=new SimpleDateFormat();
		SimpleDateFormat date_format2=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		SimpleDateFormat date_format3=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat date_format4=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat date_format5=new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat date_format6=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E");
		SimpleDateFormat date_format7=new SimpleDateFormat("yyyy/MM/dd E");
		//System.out.println(date_format7.format(new Date()));
		
		//2.parse()
		Date date2=new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-10");
		String timeStr=date2.toString();
		System.out.println("时间为："+timeStr);
		
		//1.format(),格式化Date实例为指定的时间格式字符串于parse()相反
		Date current=new Date();//获取当前时间
		String time=date_format.format(current);
		//System.out.println("格式化的时间为："+time);
		
		
	}
}
