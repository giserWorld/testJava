package com.testJava.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testJava.dao.impl.MaskLayerDaoImpl;
import com.testJava.entity.MaskLayer;


@Controller
public class MaskLayerController {
	
	@Autowired
	MaskLayerDaoImpl maskLayerDaoImpl;
	
	//根据id查询数据
	@RequestMapping("geo/getDataById.action")
	@ResponseBody
	public Object getDataById(Model model,String id,
			HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		
		MaskLayer data=maskLayerDaoImpl.get(id);
		map.put("mgs","获取数据成功！");
		map.put("code","0");
		map.put("data",data);
		return map;
	}
	
}

