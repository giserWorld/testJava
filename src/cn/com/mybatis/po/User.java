package cn.com.mybatis.po;
import java.io.Serializable;
import java.util.Date;
//创建user表的实体类
public class User implements Serializable{
	//定义实体类字段,类成员变量
	private int id;
	private String username;
	private String password;
	private Date birthday;
	//构造方法
	public User(){
		
	}
	public User(int id,String username,String password,Date birthday){
		super();
		this.id=id;
		this.username=username;
		this.password=password;
		this.birthday=birthday;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
}
