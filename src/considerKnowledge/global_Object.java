package considerKnowledge;

/******************************顶级类Object*********************************
 *1.Object类java的顶级类
 *2.java中的所有类都继承Object类
 *3.Object类位于java.lang包中，java.lang包包含着Java最基础和核心的类
 *即在java.lang包中所有的子包和类都是全局的，所有的Java程序自动导入包“java.lang”，可直接使用
 **********************************方法*************************************
 *1.toString():返回对象的字符串表示形式
 **/

public class global_Object {

	public static void main(String[] args) {
		Object int_num=56;
		String str1=int_num.toString();
		System.out.println(str1);

	}

}
