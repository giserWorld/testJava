package considerKnowledge;

import java.util.ArrayList;

/*********************ArrayList类**********************
 *1.ArrayList是 Map的实现类，可以被实例化(泛型类)
 *2.Class ArrayList<E>
 *3.可调整大小的数组的实现List接口。 实现所有可选列表操作，并允许所有元素，包括null
 **********************成员方法**********************
 *arrayList.add(E e):将指定的元素追加到此列表的末尾
 *arrayList.get(int index):返回此列表中指定位置的元素
 *arrayList.size():返回此列表中的元素数
 **********************sampleDemo**********************
 *1.
 **/
public class Class_List_ArrayList {
	public static void main(String[] args) {
		//list对象
		ArrayList<String> list=new ArrayList<String>();
		list.add("wo");
		list.add("is");
		list.add("ok");
/**********************1.遍历list***********************/		
		for(int i=0;i<list.size();i++){
			String item=list.get(i);
			System.out.println(item);
		}
		
		
	}//main
}
