package cn.com.mvc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.model.ListQryModel;
import cn.com.mvc.model.MapQuyModel;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.FruitsServiceImpl;
import cn.com.mvc.validator.group.FruitGroup1;

@Controller
//@RequestMapping("/query")
public class FindControllerTest {
	
	private FruitsService fruitsService = new FruitsServiceImpl();
	
	
	//显示所有数据
	@RequestMapping("/showAllList")
    public String showAllList(Model model){
		//所有水果数据List
		List<Fruits> fruitsList=fruitsService.queryFruitsList();
		model.addAttribute("fruitsList",fruitsList);
		return "/fruits/FruitsList_Map";
	}
	
	
	//自动将提交的数据转为Map对象
	@RequestMapping("/fruitsMapTest")
    public void fruitsMapTest(Model model,MapQuyModel mapQuyModel){
		
		Map<String,Object> fruitMap=mapQuyModel.getFruitMap();
		
		//遍历map数据
		for(String key:fruitMap.keySet()){
			Object value=fruitMap.get(key);
			System.out.println("fruitMap["+key+"]="+value);
		}
	}
	
	//自动将提交的多条数据转为List对象
	@RequestMapping("/fruitsListTest")
    public void fruitsListText(Model model,ListQryModel listQryModel){
		List<Fruits> fruitList=listQryModel.getFruitList();
		for(int i=0;i<fruitList.size();i++){
			Fruits f=fruitList.get(i);
			System.out.println("fruitList["+i+"].name="+f.getName());
		}
	}
	
	@RequestMapping("/queryAllFruits")
    public String queryAllFruits(Model model,Fruits fruits,int type){
		List<Fruits> findList=fruitsService.queryFruitsList();
		model.addAttribute("fruitsList", findList);
		return "/fruits/FruitsList"+type;
	}
	
	//模糊查询水果,添加fruits实例类数据校验
	@RequestMapping("/queryFruitsByCondition")
    public String queryFruitsByCondition(Model model,
    		@Validated(value=FruitGroup1.class) Fruits fruits,BindingResult bindingResult){
		
		List<ObjectError> allErrors = null;
		//获取校验错误信息  
        if(bindingResult.hasErrors()){  
            allErrors=bindingResult.getAllErrors();  
            for(ObjectError objectError:allErrors){  
                //输出错误信息  
                System.out.println(objectError.getDefaultMessage());  
            }  
        }  
		
		//水果类表数据
		List<Fruits> findList=null;
		if(fruits==null || (fruits.getName()==null&&fruits.getProducing_area()==null)){
			//如果fruits或查询条件为空，默认查询所有
			findList=fruitsService.queryFruitsList();
		}else{
			//如果fruits查询条件不为空，按条件查询
			findList=fruitsService.queryFruitsByCondition(fruits);
		}
    	//将model数据传到页面
        model.addAttribute("fruitsList", findList);
        
       //将错误传到页面  
        if(allErrors!=null){
        	model.addAttribute("allErrors",allErrors); 
        }
    	return "/fruits/findFruits";
    }
	
		
	//传值为多条数据
	@RequestMapping("/fruitsArrayTest")
    public void FruitsArray(Model model,int[] fids){
		for (int i = 0; i < fids.length; i++) {
			System.out.println("fids["+i+"]="+fids[i]);
		}
	}
	
}
