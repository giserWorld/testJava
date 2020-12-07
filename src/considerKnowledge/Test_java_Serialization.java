package considerKnowledge;

import java.io.Serializable;

/**********************java对象序列化**********************
 *1.javaBean按照规范应该序列化，目的是可以唯一的标识该对象
 *2.java实体类对象序列化后，该对象可以在网络上进行传输
 *3.java对象序列化实现方法:
   1)直接实现"Serializable"接口,通过"implements Serializable"代码实现java对象序列化
   2)
 **/

//javaBean序列化，实现Serializable序列接口
public class Test_java_Serialization implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;//序列版本号,自动生成
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Test_java_Serialization [name=" + name + ", age=" + age + "]";
	}
	
}//e
