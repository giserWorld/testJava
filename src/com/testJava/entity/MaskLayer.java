package com.testJava.entity;


public class MaskLayer {
	private String id;//pk
	private String name;//名称
	private String geo;//几何数据
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGeom() {
		return geo;
	}
	public void setGeom(String geo) {
		this.geo = geo;
	}
	
	
}