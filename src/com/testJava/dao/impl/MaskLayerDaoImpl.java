package com.testJava.dao.impl;

import org.springframework.stereotype.Repository;

import com.testJava.entity.MaskLayer;

//测试dao层
@Repository
public class MaskLayerDaoImpl extends BaseDaoImpl<MaskLayer>{
	public MaskLayerDaoImpl(){
		//设置数据接口对应的mapper工作空间
		this.setNs("com.testJava.mapper.maskLayerMapper");
	}
}
