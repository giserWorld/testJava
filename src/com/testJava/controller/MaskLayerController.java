package com.testJava.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.testJava.dao.impl.MaskLayerDaoImpl;
import com.testJava.entity.MaskLayer;


@Controller
public class MaskLayerController {
	
	@Autowired
	MaskLayerDaoImpl maskLayerDaoImpl;
	
	
	//更新数据
	@RequestMapping("geo/updateData.action")
	@ResponseBody
	public Object updateData(Model model,
			@RequestBody Map<String,Object> param,
			HttpServletRequest request,HttpServletResponse response){
		//param
		String name=(String)param.get("name");
		String geo=(String)param.get("geo");
		//entity
		MaskLayer entity=new MaskLayer();
		entity.setId("1");
		entity.setName(name);
		entity.setGeom(geo);
		maskLayerDaoImpl.update(entity);
		//response
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("mgs","修改数据成功！");
		map.put("code","0");
		map.put("data","");
		return map;
	}
	
	//保存数据
	@RequestMapping("geo/saveGeoData.action")
	@ResponseBody
	public Object saveGeoData(Model model,
			@RequestBody Map<String,Object> param,
			HttpServletRequest request,HttpServletResponse response){
		String name=(String)param.get("name");
		String geo=(String)param.get("geo");
		String uuid=UUID.randomUUID().toString();
		
		MaskLayer entity=new MaskLayer();
		entity.setId(uuid);
		entity.setName(name);
		entity.setGeom(geo);
		maskLayerDaoImpl.insert(entity);
		
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("mgs","保存数据成功！");
		map.put("code","0");
		map.put("data","");
		return map;
	}
	
	//根据id查询数据
	@RequestMapping("geo/getDataById.action")
	@ResponseBody
	public Object getDataById(Model model,String id,
			HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap<String,Object>();
		
		//设置跨域访问设置
		response.setHeader("Access-Control-Allow-Origin","*");//指定允许其他域名访问
		response.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");//响应类型
		response.setHeader("Access-Control-Max-Age","3600");
		response.setHeader("Access-Control-Allow-Headers","x-requested-with");//响应头设置
		//response.setHeader("Access-Control-Allow-Headers","Origin,X-Requested-With,Content-Type,Accept,Authorization,authorization");//响应头设置
        response.setHeader("Access-Control-Allow-Credentials","true");
	    
	    MaskLayer data=maskLayerDaoImpl.get(id);
		map.put("mgs","获取数据成功！");
		map.put("code","0");
		map.put("data",data);
		return map;
	}
	
}

