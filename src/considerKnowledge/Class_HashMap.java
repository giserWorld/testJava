package considerKnowledge;

import java.util.HashMap;
import java.util.Map;



/**************************HashMap*****************************
 *1.Map是一个接口类，是抽象类，不能被实例化
 *2.HashMap继承Map,是 Map的实现类，可以被实例化
 *3.HashMap是基于哈希表的实现的Map接口。 提供了所有可选的地图操作，并允许null的值和null键
 *4.遍历HashMap数据的方法:
 	1)for遍历
 **/
//List功能类
public class Class_HashMap {
	public static void main(String[] args) {
		Map<String,String> mapObj=new HashMap<String,String>();//实例化一个空的HashMap
		//添加数据
		mapObj.put("name","tian");
		mapObj.put("password","123");
		
		//1.for遍历List
		for(String key:mapObj.keySet()){
            String value =mapObj.get(key);
            System.out.println(key+":"+value);
        }
	}
}
