package considerKnowledge;

/******************************instance of方法*********************************
 *1.object instance of class:判断对象是否为该类实例
 *2.如果一个class类实例对象向上转型后，则转型对象即使本级的类型实例，也是下一级的类型实例
 *3.一个子类的实例对象即是本级的类型实例，也是上一级的类型实例
 **/
public class Function_instanceof {
	
	public static void main(String[] args) {
		
		//数据
		Integer integer1=new Integer(5);//Integer实例
		String str="aa5";//String实例
		//向上转型为Object
		Object obj1=(Object)integer1;
		Object obj2=(Object)str;
		//判断
		System.out.println("integer1是否为Object类型："+(integer1 instanceof Object));//true
		System.out.println("integer1是否为Integer类型："+(integer1 instanceof Integer));//true
		System.out.println("str是否为Object类型："+(str instanceof Object));//true
		System.out.println("str是否为String类型："+(str instanceof String));//true
		
		System.out.println("-----------");
		System.out.println("obj1是否为Object类型："+(obj1 instanceof Object));//true
		System.out.println("obj1是否为Integer类型："+(obj1 instanceof Integer));//true
		System.out.println("obj1是否为String类型："+(obj1 instanceof String));//false
		System.out.println("-----------");
		System.out.println("obj2是否为Object类型："+(obj2 instanceof Object));//true
		System.out.println("obj2是否为Integer类型："+(obj2 instanceof Integer));//false
		System.out.println("obj2是否为String类型："+(obj2 instanceof String));//true
		
		
		
		
	}
}
