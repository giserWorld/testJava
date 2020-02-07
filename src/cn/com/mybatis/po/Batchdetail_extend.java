package cn.com.mybatis.po;

//db_table batchdetail实体类
public class Batchdetail_extend extends Batchdetail{

	private FinacialProducts finacialProducts;
	
	public FinacialProducts getFinacialProducts() {
		return finacialProducts;
	}

	public void setFinacialProducts(FinacialProducts finacialProducts) {
		this.finacialProducts = finacialProducts;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		super.setId(id);
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
	public int getProduct_id() {
		// TODO Auto-generated method stub
		return super.getProduct_id();
	}

	@Override
	public void setProduct_id(int product_id) {
		// TODO Auto-generated method stub
		super.setProduct_id(product_id);
	}

	@Override
	public int getProduct_num() {
		// TODO Auto-generated method stub
		return super.getProduct_num();
	}

	@Override
	public void setProduct_num(int product_num) {
		// TODO Auto-generated method stub
		super.setProduct_num(product_num);
	}

	
}
