package considerKnowledge;

/**********************class类static块**********************
 *1.通过static关键字来定义静态代码块
 *2.static块可以置于类中的任何地方，类中可以有多个static块
 *3.多个static块会按照static块的顺序来执行每个static块，并且只会执行一次，
 *4.static块之所以可以用来优化程序性能，是因为它的特性:只会在类加载的时候执行一次
 **/
public class Test_staticBlock {
	public static void main(String[] args) {
		//在类加载的时候执行static块
		String result1=StaticBlock.name;
		System.out.println(result1);
	}
}//e

//static代码块
class StaticBlock{
	static String name="static代码块";
	//创建static块
	static{
		System.out.println("static块被执行！");
	}
}//e
