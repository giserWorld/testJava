package considerKnowledge;

import java.util.HashMap;
import java.util.Map;



/**************************HashMap*****************************
 *1.Map是一个接口类，是抽象类，不能被实例化
 *2.HashMap继承Map,是 Map的实现类，可以被实例化
 *3.Map类型数据是键值对形式的数据，例如"{name=小红, userid=1, age=20}"
 *4.HashMap是基于哈希表的实现的Map接口的类。 提供了所有可选的地图操作，并允许null的值和null键
 *5.遍历HashMap数据的方法:
 	1)for遍历
 **************************常用方法*****************************
 *1.get(key):获取指定键所映射的值
 *2.
 **/
//List功能类
public class Class_Map_HashMap {
	public static void main(String[] args) {
		Map<String,String> hashMap=new HashMap<String,String>();//实例化一个空的HashMap
		//添加数据
		hashMap.put("name","tian");
		hashMap.put("password","123");
		
//*******************2.map.get()********************//
		String keyValue=hashMap.get("name");
		System.out.println(keyValue);
		
//*******************1.for遍历Map对象********************//
		for(String key:hashMap.keySet()){
            String value =hashMap.get(key);
            //System.out.println(key+":"+value);
        }
	}
}
