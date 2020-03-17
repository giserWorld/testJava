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
			HttpServletRequest request,HttpServletResponse response){
		
		//设置允许跨域访问
		response.setHeader("Access-Control-Allow-Origin","*");//指定允许其他域名访问
		response.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");//允许的响应类型
		response.setHeader("Access-Control-Max-Age","3600");//"3600",预检请求时间
		response.setHeader("Access-Control-Allow-Headers","x-requested-with");//响应头设置
		//response.setHeader("Access-Control-Allow-Headers","Origin,X-Requested-With,Content-Type,Accept,Authorization,authorization");//响应头设置
	    response.setHeader("Access-Control-Allow-Credentials","true");
		
		//param
		String name=request.getParameter("name");
		String geo=request.getParameter("geo");//wkt、wkb
		String geo_json=request.getParameter("geo_json");//geojson
		//entity
		MaskLayer entity=new MaskLayer();
		entity.setId("1");
		entity.setName(name);
		if(!"".equals(geo_json)&&geo_json!=null){//geojson字符串
			entity.setGeo_json(geo_json);
		}
		else{//wkt、wkb字符串
			entity.setGeo(geo);
		}
		maskLayerDaoImpl.update(entity);
		//response
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("mgs","修改数据成功！");
		map.put("code","0");
		map.put("data","");
		return map;
	}
	
	//保存为一条新数据("application/x-www-form-urlencoded")
	@RequestMapping("geo/insertOneGeoData.action")
	@ResponseBody
	public Object saveGeoData(Model model,
			HttpServletRequest request,HttpServletResponse response){
		
		//设置允许跨域访问
		response.setHeader("Access-Control-Allow-Origin","*");//指定允许其他域名访问
		response.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");//允许的响应类型
		response.setHeader("Access-Control-Max-Age","3600");//"3600",预检请求时间
		response.setHeader("Access-Control-Allow-Headers","x-requested-with");//响应头设置
		//response.setHeader("Access-Control-Allow-Headers","Origin,X-Requested-With,Content-Type,Accept,Authorization,authorization");//响应头设置
        response.setHeader("Access-Control-Allow-Credentials","true");
		
		String name=request.getParameter("name");
		String geo=request.getParameter("geo");//wkt、wkb
		String geo_json=request.getParameter("geo_json");//geojson
		String uuid=UUID.randomUUID().toString();
		//entity
		MaskLayer entity=new MaskLayer();
		entity.setId(uuid);
		entity.setName("新蒙版数据");
		if(!"".equals(geo_json)&&geo_json!=null){//geojson字符串
			entity.setGeo_json(geo_json);
		}
		else{//wkt、wkb字符串
			entity.setGeo(geo);
		}
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("mgs","新增数据成功！");
		map.put("code","0");
		map.put("data","");
		if(("".equals(geo_json)&&geo_json==null)||("".equals(geo)&&geo==null)){
			map.put("mgs","几何数据不能为空！");
		}
		else{
			maskLayerDaoImpl.insert(entity);
		}
		return map;
	}
	
	//根据id查询数据("application/x-www-form-urlencoded")
	@RequestMapping("geo/getDataById_form.action")
	@ResponseBody
	public Object getDataById_form(Model model,String id,
			HttpServletRequest request,HttpServletResponse response){
		//设置允许跨域访问
		response.setHeader("Access-Control-Allow-Origin","*");//指定允许其他域名访问
		response.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");//允许的响应类型
		response.setHeader("Access-Control-Max-Age","3600");//"3600",预检请求时间
		response.setHeader("Access-Control-Allow-Headers","x-requested-with");//响应头设置
		//response.setHeader("Access-Control-Allow-Headers","Origin,X-Requested-With,Content-Type,Accept,Authorization,authorization");//响应头设置
        response.setHeader("Access-Control-Allow-Credentials","true");
	    
        //接收参数测试
        String requestType=request.getMethod();
    	System.out.print("请求类型：");
    	System.out.println(requestType);
    	String param_id=request.getParameter("id");//通过“getParameter()”获取参数值
    	System.out.print("getParameter()获取参数值：");
    	System.out.println(param_id);
    	System.out.print("接口形参获取参数值：");
        System.out.println(id);
         
    	Map<String,Object> map=new HashMap<String,Object>();
        MaskLayer data=maskLayerDaoImpl.get(id);//形参获取参数值
		map.put("mgs","获取数据成功！");
		map.put("code","0");
		map.put("data",data);
		return map;
	}
	
	//根据id查询数据("application/json")
	@RequestMapping("geo/getDataById_json.action")
	@ResponseBody
	public Object getDataById_json(Model model,String id,
			@RequestBody Map<String,Object> paramMap,
			HttpServletRequest request,HttpServletResponse response){
		//设置允许跨域访问
		response.setHeader("Access-Control-Allow-Origin","*");//指定允许其他域名访问
		response.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");//允许的响应类型
		response.setHeader("Access-Control-Max-Age","1");//"3600",预检请求时间
		response.setHeader("Access-Control-Allow-Headers","x-requested-with");//响应头设置
		//response.setHeader("Access-Control-Allow-Headers","Origin,X-Requested-With,Content-Type,Accept,Authorization,authorization");//响应头设置
        response.setHeader("Access-Control-Allow-Credentials","true");
	    
        
        //接收参数测试
        String requestType=request.getMethod();
    	System.out.print("请求类型：");
    	System.out.println(requestType);
    	//将请求body的参数映射为map对象(只适用于POST请求参数，"")
    	String param_id=request.getParameter("id");//通过“getParameter()”获取参数值
    	System.out.print("getParameter()获取参数值：");
    	System.out.println(param_id);
    	System.out.print("接口形参获取参数值：");
        System.out.println(id);
        String paramMap_id=(String)paramMap.get("id");
    	System.out.print("@RequestBody映射Map获取参数值：");
        System.out.println(paramMap_id);
        
        Map<String,Object> map=new HashMap<String,Object>();
	    MaskLayer data=maskLayerDaoImpl.get(paramMap_id);
		map.put("mgs","获取数据成功！");
		map.put("code","0");
		map.put("data",data);
		return map;
	}
	
}

