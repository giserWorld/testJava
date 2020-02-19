package cn.com.mvc.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import cn.com.mvc.validator.group.FruitGroup1;
import cn.com.mvc.validator.group.FruitGroup2;

//水果类
public class Fruits {
	private int id;//pk
	
	@Size(min=1,max=20,message="{fruits.name.length.error}",groups=FruitGroup1.class)
	private String name;//水果名字(校验注解'@Size',长度在1~20之间)
	
	private double price;//水果价格
	
	@NotEmpty(message="{fruits.producing_area.isEmpty}",groups=FruitGroup2.class)
	private String producing_area;//水果产地(带校验注解'NotEmpty',不能为空)
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProducing_area() {
		return producing_area;
	}
	public void setProducing_area(String producing_area) {
		this.producing_area = producing_area;
	}
	
	
}
