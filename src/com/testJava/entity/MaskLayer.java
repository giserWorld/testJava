package com.testJava.entity;


public class MaskLayer {
	private String id;//pk
	private String name;//名称
	private String geo;//wkt或wkb几何数据
	private String geo_json;//geojson几何数据
	
	
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
	public String getGeo() {
		return geo;
	}
	public void setGeo(String geo) {
		this.geo = geo;
	}
	public String getGeo_json() {
		return geo_json;
	}
	public void setGeo_json(String geo_json) {
		this.geo_json = geo_json;
	}
	
	
}
