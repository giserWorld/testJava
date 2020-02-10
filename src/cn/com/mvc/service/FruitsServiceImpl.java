package cn.com.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import cn.com.mvc.model.Fruits;

//提供水果类表数据
public class FruitsServiceImpl implements FruitsService{
	
	public List<Fruits> fruitsList=null;
	
	public List<Fruits> init(){
		if(fruitsList==null){
			//初始化数据
			fruitsList = new ArrayList<Fruits>();  

			//苹果
			Fruits apple=new Fruits();
			apple.setId(1);
			apple.setName("红富士苹果");
			apple.setPrice(2.5);
			apple.setProducing_area("山东");
	          
			//香蕉
			Fruits banana=new Fruits();
			banana.setId(2);
			banana.setName("香蕉");
			banana.setPrice(1.5);
			banana.setProducing_area("上海");
	         
			//添加到数组列表中
	        fruitsList.add(apple);  
	        fruitsList.add(banana); 
	        return fruitsList;
		}
		else{
			return fruitsList;
		}
	}
	//查询水果类表
	public List<Fruits> queryFruitsList(){
		init();
        return fruitsList;
	}
	//通过id查询水果
	public Fruits queryFruitById(Integer id) {
		init();
		Fruits fruits=null;
		for (int i = 0; i < fruitsList.size(); i++) {
			Fruits fruits2=fruitsList.get(i);
			if(fruits2.getId()==id){
				fruits=fruits2;
			}
		}
		return fruits;
	}
	
	public List<Fruits> queryFruitsByCondition(Fruits fruits){
		init();
		String name=fruits.getName();
		String area=fruits.getProducing_area();
		List<Fruits> queryList=new ArrayList<Fruits>();
		Fruits f;
		for (int i = 0; i < fruitsList.size(); i++) {
			f=fruitsList.get(i);
			//有一项条件符合就返回
			if((!name.equals("")&&f.getName().contains(name))||
			   (!area.equals("")&&f.getProducing_area().contains(area))){
				queryList.add(f);
			}
		}
		return queryList.size()>0?queryList:null;
	}
}
