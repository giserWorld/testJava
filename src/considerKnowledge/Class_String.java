package considerKnowledge;

import java.util.ArrayList;
import java.util.List;

/**************************String类*****************************
 *1.String类代表字符串。 Java程序中的所有字符串文字都是此类的实例
 *2.
 **************************成员方法*****************************
 *1.string.equals(str2):判断该字符串是否与另一个字符串相等
 *2.string.contains(str2):判断该字符串是否包含指定的字符串片段
 *3.string.lastIndexOf(str2):返回指定子字符串最后一次出现的字符串中的索引
 *4.string.substring(str2):截取子字符串，以指定索引处的字符开头，并扩展到该字符串的末尾
 *5.string.replace(char searchChar,char newChar):通过用 newChar字符替换字符串中出现的所有 searchChar 字符，并返回替换后的新字符串
 ***************************sampleDemo*****************************
 *1.contains()
 *2.substring()
 *3.equals()
 **/
//List功能类
public class Class_String {
	public static void main(String[] args) {
		

/***************4.replace()******************/
		String str4="my is {name}";
		String result4=str4.replace("{name}","好人");
		System.out.println(result4);
		
/***************3.equals()******************/
		
		String str="zhe shi yi ge str";
		String str2="这是一个字符串";
		
		boolean result3=str.equals(str2);
		System.out.println("'判断字符串相等:'"+result3);
		
		
/***************2.substring()*****************/
		String result2=str.substring(3);
		//System.out.println("'substring字符串:'"+result3);
		
/***************1.contains()******************/
		boolean result1=str.contains("yi");
		//System.out.println("'"+str+"'字符串包含"+"'yi'子字符串:"+result1);
		boolean result1_2=str2.contains("字符");
		//System.out.println("'"+str+"'字符串包含"+"'字符'子字符串:"+result2);
	}
}
