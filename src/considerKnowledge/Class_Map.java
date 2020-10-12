package considerKnowledge;

import java.util.HashMap;
import java.util.Map;

/*********************Map类**********************
 *1.Map类是一个接口类型，不能直接被实例化
 *2.HashMap实现类:
   1)
 **/
public class Class_Map {
	public static void main(String[] args) {
		Map<String,String> hashMap=new HashMap<String,String>();
		hashMap.put("name", "小红");
		hashMap.put("age", "20");
		String result=hashMap.toString();
		System.out.println(result);
	}
}
