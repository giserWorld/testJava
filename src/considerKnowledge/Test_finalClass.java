package considerKnowledge;

/**********************final类**********************
 *1.final类不能被继承，不能被覆盖,final类可以被实例化
 *2.当一个类被定义为final时，它的所有方法都自动成为final方法，但不影响对变量的定义
 **/
public class Test_finalClass {
	public static void main(String[] args) {
		//实例化final类
		FinalClass instance1=new FinalClass();
		System.out.println(instance1.name);
	}
}

//定义final类
final class FinalClass{
	String name="final类";
	public void addPlus(){
		System.out.println("FinalClass.addPlus()");
	}
}
