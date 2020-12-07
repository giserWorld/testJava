package considerKnowledge;

/**********************class类静态属性、方法**********************
 *1.静态属性、方法是通过类来访问的
 **/
public class Test_staticClass {
	public static void main(String[] args) {
		String result1=StaticClass.name;//访问静态属性
		System.out.println(result1);
		StaticClass.staticFun();//调用静态方法
	}
}

class StaticClass{
	//1.静态属性
	static String name="静态属性！";
	
	//2.静态方法
	static void staticFun(){
		System.out.println("静态方法！");
	}
	
}
