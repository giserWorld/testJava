package considerKnowledge;

import java.util.HashSet;
import java.util.Set;

/**********************HashSet类**********************
 *1.HashSet类继承Set,是Set的实现类，可以被实例化
 *2.HashSet类是一个泛型类
 	Set<E> hashset=new HashSet<E>;
 *3.HashSet是基于哈希表的实现的Set接口的类,保存的集合元素是无序的
 *4.遍历HashSet集合方法:
   1)for增强,不支持for遍历
   2)迭代器
 ***********************测试demo*********************
 *1.遍历集合
 **/
public class Class_Set_HashSet {
	public static void main(String[] args) {
	
	//*************1.遍历集合**************
		Set<String> hashset=new HashSet<String>();
		hashset.add("小红");
		hashset.add("2");
		hashset.add("上海");
		
		//1.for增强遍历
		for(String str:hashset){
			System.out.println(str);
		}
	}//e
}
