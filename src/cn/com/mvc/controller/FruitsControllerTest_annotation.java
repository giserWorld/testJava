package cn.com.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.FruitsServiceImpl;


/**************************@RequestMapping()注释方法***********************
 *1."@RequestMapping"实现对"@Controller"标识的类的方法和url进行映射,一个方法对应一个url
 *2.如果"@Controller"标识的类，没有设置 @RequestMapping(url) 注解路径"，则该类中
 *方法的映射路径url是相对于web应用的根目录，
 	例如:"http://localhost:8082/testJava/queryFruitsList.action"
 *如果"@Controller"标识的类，设置了 @RequestMapping("/test")注解路径，则该类中
 *方法的映射路径url都会添加一个前缀路径
 	例如:"@Controller"标识的类添加了@RequestMapping("test")，则该类中方法的映射路径url
 都会添加一个前缀"/test"
 	"http://localhost:8082/testJava/test/queryFruitsList.action"
 *3."@RequestMapping()"构造方法： 
	 1) @RequestMapping(param): 
	 	例如:
	  		@RequestMapping("/queryFruitsList")  
	  		public void editFruit(){
	  			//将url="/editFruit"和editFruit()方法进行映射
	  		}
	 2) @RequestMapping(value=""): 
	 	例如:
	  		@RequestMapping(value="/queryFruitsList")  
	  		public void editFruit(){
	  			//将url="/editFruit"和editFruit()方法进行映射
	  		}
     3) @RequestMapping(value="",method=""):限定请求方法 
	 	例如:
	  		@RequestMapping(value="/test",method=RequestMethod.GET)  
	  		public void editFruit(){
	  			//将url="/editFruit"和editFruit()方法进行映射
	  		}
	 4) @RequestMapping(value="",param=""):包含该请求参数时，才能进行响应 
	 	例如:
	  		@RequestMapping(value="/test",param="userId")  
	  		public void editFruit(){
	  			//将url="/editFruit"和editFruit()方法进行映射
	  		}
	 5) @RequestMapping(value="",headers=""):当请求头类型符合指定的值时，才能进行响应
	 	例如:
	  		@RequestMapping(value="/test",headers="Content-Type:text/html;charset=UTF-8")  
	  		public void editFruit(){
	  			//将url="/editFruit"和editFruit()方法进行映射
	  		}
	 6) @RequestMapping(value="",consumes=""):处理请求的提交内容类型(Content-Type)
	 	例如:该方法仅处理request的Content-Type为application/json类型的请求
	  		@RequestMapping(value="/test",consumes="application/json")  
	  		public void editFruit(){
	  			//将url="/editFruit"和editFruit()方法进行映射
	  		}
 	 7) @RequestMapping(value="",produces=""):表示返回的内容类型
	 	例如:该方法仅处理request的Accept头中包含"application/json"的请求,同时暗示返回的内容类型为"application/json"
	  		@RequestMapping(value="/test",produces="application/json")  
	  		public void editFruit(){
	  			//将url="/editFruit"和editFruit()方法进行映射
	  		}
 *4.当用户请求路径请传入参数时，springMVC会将请求的参数绑定到Controller处理器映射方法的形参上
 *5.
 * */


//通过@Controller注解的方法标识它是一个控制器
@Controller
@RequestMapping("test")//映射方法url前缀路径
public class FruitsControllerTest_annotation {
	
	private FruitsService fruitsService = new FruitsServiceImpl();
	
	
	//Spring MVC实现RESTful风格的接口,通过'@PathVariable'注解代码实现
	//通过id查询水果信息
	@RequestMapping(value="/queryFruit_id/{id}",method={RequestMethod.GET})  
	public @ResponseBody Fruits queryFruit_id(Model model,
			@PathVariable("id") Integer fruitId2) throws Exception{
		
		//通过id获取水果数据
		Fruits fruit=fruitsService.queryFruitById(fruitId2);
		//返回json数据格式
		return fruit;
	}
	
	
	//通过id查询水果数据,get请求
	@RequestMapping(value="/queryFruit",method=RequestMethod.GET)  
	public String queryFruitById(Model model,Integer id) throws Exception{
		//通过id获取水果数据
		Fruits fruit=fruitsService.queryFruitById(id);
		//通过形参中的model,将model数据传到页面
		model.addAttribute("fruit",fruit);
		return "/fruits/fruitsDetail";
	}
	
	//查询水果列表数据
	@RequestMapping("queryFruitsList")
	public ModelAndView queryFruitsList() throws Exception{
		//获取水果列表数据
		List <Fruits> fruitsList=fruitsService.queryFruitsList();
		//创建ModelAndView视图(用于存储视图信息和数据)
		ModelAndView modelAndView=new ModelAndView();
		//添加数据，将要在视图页面显示的数据，相当于request的setAttribut,在JSP页面中通过fruitsList变量获取数据
		modelAndView.addObject("fruitsList",fruitsList);
		//添加视图,即将要显示的视图页面
		modelAndView.setViewName("/fruits/fruitsList");
		return modelAndView;
	}
	
}



