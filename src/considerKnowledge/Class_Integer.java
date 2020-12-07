package considerKnowledge;

/**********************Integer包装类**********************
 *1.Integer类是基本数据类型int的包装器类，是抽象类Number的子类，位于java.lang包中
 *2.Integer类位于java.lang包中,属于全局类
 ***********************静态方法**********************
 *1.Integer.parseInt(String s):将字符串参数解析为带符号的十进制整数,s必须为整数字符串，不能为小数字符串
 ************************测试demo**********************
 **/
public class Class_Integer {
	public static void main(String[] args) {
		
		
		/**************1.parseInt()************/
		String str1="15.21";//小数字符串,解析报错NumberFormatException
		String str2="18";
		int result=Integer.parseInt(str1);
		System.out.println("结果："+result);
	}
}
