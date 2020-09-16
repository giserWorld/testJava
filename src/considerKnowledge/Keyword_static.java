package considerKnowledge;


/******************************static关键字*********************************
 *1.静态变量:static关键字修饰的变量
 *2.静态方法:static关键字修饰的方法
 *3.static代码块:在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次
 **********************************注意事项*************************************
 *1.static关键字修改的属性或方法，一般是通过类进行调用，如果通过类实例调用则会出现警告提示
 *2.static代码块中的变量只能为静态变量，并且在类初始化时执行代码
 **/

public class Keyword_static {

	public static void main(String[] args) {
		
	
		
	//*********************2.调用静态块中的变量**********************//
	System.out.println(Student.getPs());//类调用静态属性
	
	//*********************1.静态属性、方法**********************//
		Student st1=new Student("小红");
		System.out.println("**********st1.name***********");
		System.out.println(st1.name);//实例调用成员属性
		
		System.out.println("**********实例调用静态属性***********");
		//System.out.println(st1.Type);//实例调用静态属性(警告提示)
		System.out.println("**********类调用静态属性***********");
		System.out.println(Student.Type);//类调用静态属性
		
		System.out.println("**********实例调用静态方法***********");
		//System.out.println(st1.getPs());//实例调用静态属性(警告提示)
		System.out.println("**********类调用静态方法***********");
		System.out.println(Student.getPs());//类调用静态属性
	}
	
}
//Student类
class Student{
	
	static String Type="学生";//静态属性
	String name;//成员属性
	static String ps;//静态属性
	
	//static代码块
	static {
		ps="static代码块在类初次被加载的时候";
	}
	
	Student(String name){
		this.name=name;
	}
	//成员方法
	String getName(){
		return this.name;
	}
	//静态方法
	static String getPs(){
		return Student.ps;
	} 
}
