package considerKnowledge.jackson;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;




/***********************ObjectMapper类************************
 *1.
 **************************构造方法*****************************
 *1.ObjectMapper objectMapper = new ObjectMapper();
 *
 *******************************方法***************************
 *1.json字符串转Map:
 	1)Map map=objectMapper.readValue(jsonStr,Map.class)
 	2)Map<String,Object> map= objectMapper.readValue(jsonStr,new TypeReference<Map<String,Object>>(){});
 *2.json字符串转java对象:
 	User user=objectMapper.readValue(jsonStr,User.class)
 **/

public class Class_ObjectMapper {
	public static void main(String[] args) throws Exception{
		String jsonStr="{\"name\":\"jack\",\"password\":123}";//json字符串
		//创建ObjectMapper实例
		ObjectMapper objectMapper=new ObjectMapper();
		
		//2.json字符串转java对象
		User user=objectMapper.readValue(jsonStr,User.class);
		//System.out.println(user.getName());//User实例对象
		
		 //1.json字符串转Map
		 Map map=objectMapper.readValue(jsonStr,Map.class);
		 Object name=map.get("name");//String类型
		 Object password=map.get("password");//Integer类型
		 System.out.println(map);//{name=jack, password=123}
	}
	
}
	//一个实体类
	class User{
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
