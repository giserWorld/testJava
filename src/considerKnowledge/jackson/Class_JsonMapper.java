package considerKnowledge.jackson;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.json.JsonMapper;




/***********************JsonMapper类************************
 *1.特定于JSON格式的ObjectMapper实现,继承了ObjectMapper类
 **************************构造方法*****************************
 *1.JsonMapper jsonMapper = new JsonMapper();
 *
 *******************************方法***************************
 *1.json字符串转Map:
 	1)Map map=jsonMapper.readValue(jsonStr,Map.class)
 	2)Map<String,Object> map=jsonMapper.readValue(jsonStr,new TypeReference<Map<String,Object>>(){});
 *2.json字符串转java对象:
 	User user=jsonMapper.readValue(jsonStr,User.class)
 **/

public class Class_JsonMapper {
	public static void main(String[] args) throws Exception{
		 String jsonStr="{\"name\":\"jack\",\"password\":123}";//json字符串
		 //创建JsonMapper实例
		 JsonMapper jsonMapper=new JsonMapper();
		
		 //2.json字符串转java对象
		 User2 user=jsonMapper.readValue(jsonStr,User2.class);
		 //System.out.println(user.getName());//User实例对象
		
		 //1.json字符串转Map(map值得类型和json中值得类型相同)
		 Map map=jsonMapper.readValue(jsonStr,Map.class);
		 //Map<String,Object> map=jsonMapper.readValue(jsonStr,new TypeReference<Map<String,Object>>(){});
		 Object name=map.get("name");//String类型
		 Object password=map.get("password");//Integer类型
		 //System.out.println(map);//{name=jack, password=123}
	}
	
}
	//一个实体类
	class User2{
		private String name;
		private String password;
		private String address;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}
