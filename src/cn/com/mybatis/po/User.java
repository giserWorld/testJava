package cn.com.mybatis.po;
import java.io.Serializable;
import java.util.Date;
//创建user表的实体类
public class User implements Serializable{
	//定义实体类字段,类成员变量
	private int id;
	private String name;
	private String password;
	//构造方法
	public User(){
		
	}
	public User(int id,String username,String password,Date birthday){
		super();
		this.id=id;
		this.name=username;
		this.password=password;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
