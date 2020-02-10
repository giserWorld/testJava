package cn.com.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.mvc.model.Fruits;
import cn.com.mvc.service.FruitsService;
import cn.com.mvc.service.FruitsServiceImpl;

@Controller
@RequestMapping("/query")
public class FindControllerTest {
	
	private FruitsService fruitsService = new FruitsServiceImpl();
	
	@RequestMapping("/queryAllFruits")
    public String queryAllFruits(Model model,Fruits fruits,int type){
		List<Fruits> findList=fruitsService.queryFruitsList();
		model.addAttribute("fruitsList", findList);
		return "/fruits/FruitsList"+type;
	}
	
	//模糊查询水果
	@RequestMapping("/queryFruitsByCondition")
    public String queryFruitsByCondition(Model model,Fruits fruits){
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
    	return "/fruits/findFruits";
    }
	
	
	@RequestMapping("/fruitsArrayTest")
    public void FruitsArray(Model model,String fids){
//		for (int i = 0; i < fids.length; i++) {
//			System.out.println("fids["+i+"]="+fids[i]);
//		}
		System.out.println(fids);
	}
	
}
