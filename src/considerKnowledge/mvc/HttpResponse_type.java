package considerKnowledge.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*****************HttpResponse:返回的数据类型*********************
 *1.
 *3.
 * */
@Controller
public class HttpResponse_type {
	
	//3.返回结果为java类实例对象,对象格式:{name:"",password:""}
	@RequestMapping("test/response_classObj.action")
	@ResponseBody
	public Object response_classObj(HttpServletRequest request,HttpServletResponse response){
		//类实例对象
		Student sdt1=new Student("xiaohong","123");
		return sdt1;
	}
	//2.返回结果为List类型,对象数组格式:[{name:""},{name:""}]
	@RequestMapping("test/response_list.action")
	@ResponseBody
	public List response_list(HttpServletRequest request,HttpServletResponse response){
		
		List<Student> list=new ArrayList<Student>();
		Student sdt1=new Student("xiaohong","123");
		Student sdt2=new Student("hua","123");
		list.add(sdt1);
		list.add(sdt2);
		return list;
	}
	
	//1.返回结果为map类型,对象格式:{name:"",type:""}
	@RequestMapping("test/response_map.action")
	@ResponseBody
	public Object response_json(HttpServletRequest request,HttpServletResponse response){
		//返回的数据
		Map<String,Object> map=new HashMap<String,Object>();
		
		List<Object> list=new ArrayList<Object>();
		Student sdt1=new Student("小黑","123");
		Student sdt2=new Student("hua","123");
		list.add(sdt1);
		list.add(sdt2);
		map.put("mgs","获取数据成功！");
		map.put("code","0");
		map.put("data",list);
		return map;
	}
	
	
	//该方法仅处理request的Accept头中包含"application/json"的请求,同时暗示返回的内容类型为"application/json"
	@RequestMapping(value="test/response_map2.action",produces="application/json")
	@ResponseBody
	public Map response_json2(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		
		Student sdt3=new Student("小明", "789");
		Student sdt4=new Student("小花", "789");
		map.put("type", "Map数据类型");
		map.put("sdt3", sdt3);
		map.put("sdt4", sdt4);
		return map;
	}
	
}


//Student类
class Student{
	private String name;
	private String phone;
	
	Student(String name,String phone){
		this.name=name;
		this.phone=phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
