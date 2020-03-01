package considerKnowledge;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**************************ArrayList*****************************
 *1.List是抽象接口，不能被实例化
 *2.ArrayList继承List,是 List的实现类，可以被实例化,所以ArrayList实例是List类型
 *3.ArrayList没有继承Array,所以ArrayList实例不是是Array类型
 *4.ArrayList是一个可调整大小的数组，当元素添加到ArrayList时，其容量会自动增长
 *5.遍历ArrayList数据的方法:
 	1)for遍历
 	2)for循环
 *6.
 ****************************方法*****************************	
 *1.
 **/
//List功能类
public class Class_ArrayList {
	public static void main(String[] args) {
		//实例化一个空的list
		List<String> list_str=new ArrayList<String>();
		//添加数据
		list_str.add("1");
		list_str.add("2");
		list_str.add("3");
		list_str.add("4");
		list_str.add("五");
		
		//3.List 转换为Array
		String[] strArray = new String[list_str.size()];//初始化数组
		list_str.toArray(strArray);
		//遍历Array
		for(String item:strArray){
			System.out.println(item);
		}
		
		
		//2.for遍历List
		for(String item:list_str){
			//System.out.println(item);
		}
		//1.for循环
		for(int i=0;i<list_str.size();i++){
			String item=list_str.get(i);
			//System.out.println(item);
		}
	}
}
