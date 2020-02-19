package considerKnowledge.util;

import java.util.UUID;



/**************************UUID类*****************************
 *1.一个表示不可变的通用唯一标识符（UUID）的类
 *2.UUID类是一个final类，不可以覆写和继承，用来创建唯一id的工具
 *
 **************************方法*****************************
 *1.randomUUID():[static],随机生成 uuid字符 
 **/
public class Class_UUID {
	
	public static void main(String[] args) {
		UUID uid=UUID.randomUUID();//随机产生uuid(base64格式Id)
		String uidStr=uid.toString();//"26c976ad-7881-498d-938f-f3a7b391f7bd"
		System.out.println("随机uuid："+uidStr);
	}
}
