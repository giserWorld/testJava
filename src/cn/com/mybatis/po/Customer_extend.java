package cn.com.mybatis.po;

import java.io.Serializable;
import java.util.List;

//继承Customer类
public class Customer_extend extends Customer implements Serializable{

	List<Batch_extend> batchList;
	
	
	public List<Batch_extend> getBatchList() {
		return batchList;
	}

	public void setBatchList(List<Batch_extend> batchList) {
		this.batchList = batchList;
	}

	@Override
	public int getCus_id() {
		// TODO Auto-generated method stub
		return super.getCus_id();
	}

	@Override
	public void setCus_id(int cus_id) {
		// TODO Auto-generated method stub
		super.setCus_id(cus_id);
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getUsername();
	}

	@Override
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		super.setUsername(username);
	}

	@Override
	public String getAcno() {
		// TODO Auto-generated method stub
		return super.getAcno();
	}

	@Override
	public void setAcno(String acno) {
		// TODO Auto-generated method stub
		super.setAcno(acno);
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return super.getGender();
	}

	@Override
	public void setGender(String gender) {
		// TODO Auto-generated method stub
		super.setGender(gender);
	}

	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return super.getPhone();
	}

	@Override
	public void setPhone(String phone) {
		// TODO Auto-generated method stub
		super.setPhone(phone);
	}
	
}
