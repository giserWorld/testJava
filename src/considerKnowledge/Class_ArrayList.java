package considerKnowledge;

import java.util.ArrayList;
import java.util.List;

/**************************ArrayList*****************************
 *1.List是抽象类，不能被实例化
 *2.ArrayList继承List,是 List的实现类，可以被实例化
 *3.ArrayList是一个可调整大小的数组，当元素添加到ArrayList时，其容量会自动增长
 *4.遍历ArrayList数据的方法
 	1)for遍历
 	2)for循环
 **/
//List功能类
public class Class_ArrayList {
	public static void main(String[] args) {
		List<String> list_str=new ArrayList<String>();//实例化一个空的list
		list_str.add("1");//追加新元素
		list_str.add("2");
		list_str.add("3");
		list_str.add("4");
		list_str.add("5");
		
		//1.for遍历List
		for(String item:list_str){
			//System.out.println(item);
		}
		//2.for循环
		for(int i=0;i<list_str.size();i++){
			String item=list_str.get(i);
			System.out.println(item);
		}
	}
}
