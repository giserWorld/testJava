package considerKnowledge;

/**********************class.toString()方法**********************
 *1.快速生成toString()方法，通过toString()方法查看对象属性值
 *2.通过打印java实例时，java实例对象会自动调用toString()方法,所以有时候class中重写toString()方法是有必要的
 **/
public class test_function_toString {
	public static void main(String[] args) {
		Book englishbook=new Book();
		englishbook.setCode("1");
		englishbook.setName("英语书");
		System.out.println(englishbook);
	}
}

class Book{
	String name;
	String code;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", code=" + code + "]";
	}
	
}
