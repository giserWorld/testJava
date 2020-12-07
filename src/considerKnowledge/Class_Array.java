package considerKnowledge;


/**************************Array类*****************************
 *1.Array数组指的就是一组相关类型的变量集合，并且这些变量可以按照统一的方式进行操作，
 *2.数组是用来存储固定大小的同类型元素
 *3.遍历Array数据的方法:
 	1)for循环
 	2)foreach遍历
 **************************构造方法*****************************
 *1.数据类型 [] 数组名称 = new 数据类型[长度]
 	String[] strArray=new String[5];
 *2.直接初始化数据：
 	String[] strArray={"1","2"};
 *3.初始化Array时，必须指定数组长度
 **************************测试demo*****************************
 *1.for循环遍历数组
 *2.foreach遍历
 **/
//List功能类
public class Class_Array {
	public static void main(String[] args) {
		
		String[] strArray={"wode","1","小红"};
		//空的String数组
		String[] strArray2=new String[5];
		
/**************1.for循环遍历数组****************/
		for(int i=0;i<strArray.length;i++){
			String item=strArray[i];
			//System.out.println(item);
		}
/**************2.foreach遍历****************/
		for(String item:strArray){
			System.out.println(item);
		}
	}
}
