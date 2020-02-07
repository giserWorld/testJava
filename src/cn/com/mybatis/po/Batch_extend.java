package cn.com.mybatis.po;

import java.util.Date;
import java.util.List;


//db_table Batch实体类
public class Batch_extend extends Batch{

	private List<Batchdetail_extend> batchdetailList2;
	
	
	public List<Batchdetail_extend> getBatchdetailList() {
		return batchdetailList2;
	}

	public void setBatchdetailList(List<Batchdetail_extend> batchdetailList) {
		this.batchdetailList2 = batchdetailList;
	}

	@Override
	public int getBatch_id() {
		// TODO Auto-generated method stub
		return super.getBatch_id();
	}

	@Override
	public void setBatch_id(int batch_id) {
		// TODO Auto-generated method stub
		super.setBatch_id(batch_id);
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
	public String getNumber() {
		// TODO Auto-generated method stub
		return super.getNumber();
	}

	@Override
	public void setNumber(String number) {
		// TODO Auto-generated method stub
		super.setNumber(number);
	}

	@Override
	public Date getCreatetime() {
		// TODO Auto-generated method stub
		return super.getCreatetime();
	}

	@Override
	public void setCreatetime(Date createtime) {
		// TODO Auto-generated method stub
		super.setCreatetime(createtime);
	}

	@Override
	public String getNote() {
		// TODO Auto-generated method stub
		return super.getNote();
	}

	@Override
	public void setNote(String note) {
		// TODO Auto-generated method stub
		super.setNote(note);
	}
	
	
}
