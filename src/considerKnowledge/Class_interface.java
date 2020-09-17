package considerKnowledge;

/**************************interface抽象类*****************************
 *1.interface是抽象类的延伸，接口中的所有方法都是抽象方法并且没有方法体，该类内定义的方法可以省略abstract关键字，系统会默认添加该关键字
 *2.接口中定义的属性字段是静态常量(属性都是自动是static和final的)所以可以通过接口类直接调用
 *3.如果一个类实现了接口，那么该子类必须实现父接口的所有方法,不需要继承属性
 **************************常用方法*****************************
 *1.
 **/

//定义公共接口
public interface Class_interface {
	String str="zhe shi yi ge str";
    void test();
}

//定义类
class Test_main implements Class_interface{
	public static void main(String[] args) {
		String str="zhe shi yi ge str";
		System.out.println(str);
		Test_main obj1=new Test_main();
		obj1.test();
	}

	@Override
	public void test() {
		
		String interface_attr=Class_interface.str;
		System.out.println("继承的接口方法:test()--"+interface_attr);
	}
}