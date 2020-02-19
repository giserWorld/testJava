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
public class FindControllerTest2 {
	private FruitsService fruitsService = new FruitsServiceImpl();
	//显示所有数据
	@RequestMapping("/showAllList2")
    public String showAllList(Model model){
		//所有水果数据List
		List<Fruits> fruitsList=fruitsService.queryFruitsList();
		model.addAttribute("fruitsList",fruitsList);
		return "/fruits/FruitsList_Map.jsp";
	}
}
