package cn.com.mybatis.po;

//Batch Customer 实体信息
public class BatchCustomer extends Batch{
	private String username;
	private String acno;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAcno() {
		return acno;
	}
	public void setAcno(String acno) {
		this.acno = acno;
	}
	
	
}
