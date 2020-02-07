package cn.com.mybatis.po;

import java.util.Date;

//db_table finacial_products表
public class FinacialProducts {
	private int product_id;
	private String name;//理财产品名字
	private double price;//理财产品价格
	private String detail;//理财产品描述
	private String pic;//理财产品图片
	private Date invasttime;//理财产品收益日期
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Date getInvasttime() {
		return invasttime;
	}
	public void setInvasttime(Date invasttime) {
		this.invasttime = invasttime;
	}
	
	
}
