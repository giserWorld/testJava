package javaClass;

//调用不同的构造函数来实例化对象
public class Class_instance {

	public static void main(String[] args) {
	 AddPlus instance1=new AddPlus();
	 AddPlus instance2=new AddPlus(5);
	 AddPlus instance3=new AddPlus(5,3);
	}

}
class AddPlus{
	public AddPlus(){
		System.out.println("没有参数！");
	};
	public  AddPlus(int a){
		System.out.println("参数a:"+a);
	};
	public  AddPlus(int a,int b){
		System.out.println("参数a+b:"+a+b);
	};
}
