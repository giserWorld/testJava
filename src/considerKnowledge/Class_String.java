package considerKnowledge;

import java.util.ArrayList;
import java.util.List;

/**************************String类*****************************
 *1.String类代表字符串。 Java程序中的所有字符串文字都是此类的实例
 *2.
 **************************常用方法*****************************
 *1.str.equals(str2):判断该字符串是否与另一个字符串相等
 *2.str.contains(str2):判断该字符串是否包含指定的字符串片段
 *3.str.lastIndexOf(str2):返回指定子字符串最后一次出现的字符串中的索引
 *4.str.substring(str2):截取子字符串，以指定索引处的字符开头，并扩展到该字符串的末尾
 **/
//List功能类
public class Class_String {
	public static void main(String[] args) {
		String str="zhe shi yi ge str";
		String str2="这是一个字符串";
		
		//2.substring()
		String result3=str.substring(3);
		System.out.println("'substring字符串:'"+result3);
		
		//1.contains()
		boolean result1=str.contains("yi");
		//System.out.println("'"+str+"'字符串包含"+"'yi'子字符串:"+result1);
		
		boolean result2=str2.contains("字符");
		//System.out.println("'"+str+"'字符串包含"+"'字符'子字符串:"+result2);
	}
}
