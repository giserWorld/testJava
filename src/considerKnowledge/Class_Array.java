package considerKnowledge;


/**************************Array类*****************************
 *1.
 *2.遍历Array数据的方法:
 	1)for循环
 	2)foreach遍历
 **************************构造方法*****************************
 *1.String[] strArray=new String[5];
 *2.String[] strArray={"1","2"};
 **/
//List功能类
public class Class_Array {
	public static void main(String[] args) {

		String[] strArray={"wode","1","小红"};
		
		//1.for循环遍历数组
		for(int i=0;i<strArray.length;i++){
			String item=strArray[i];
			//System.out.println(item);
		}
		//2.foreach遍历
		for(String item:strArray){
			System.out.println(item);
		}
	}
}
