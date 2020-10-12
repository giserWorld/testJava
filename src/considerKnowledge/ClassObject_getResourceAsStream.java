package considerKnowledge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**********************class.getResourceAsStream()**********************
 *1.getResourceAsStream()用于读取资源(即数据文件)为流数据(二进制)
 *2.每一个java类都有getResourceAsStream()方法
 *3.Java中使用的路径，分为两种：绝对路径和相对路径
 *4.绝对路径
    1)URI形式的绝对资源路径,例如:"file:/D:/java/eclipse32/workspace/jbpmtest3/bin/aaa.txt"
    2)本地系统的绝对路径,例如:"D:/java/eclipse32/workspace/jbpmtest3/bin/aaa.txt"
 *5.相对路径
    1)相对于classpath的相对路径
      "file:/D:/java/eclipse32/workspace/jbpmtest3/bin/"这个路径的相对路径。其中，bin是本项目的classpath。
          所有的Java源文件编译后的.class文件复制到这个目录中
 *6.getResourceAsStream(String path):
   1)path 不以’/'开头时默认是从此类所在的包下取资源，以’/'开头则是从ClassPath根下获取。其只是通过path构造一个绝对路径，最终还是由ClassLoader获取资源
 **/
public class ClassObject_getResourceAsStream {
	public static void main(String[] args) throws IOException {
		String path="data/test.txt";//相对于该文件的路径
		//将文件数据读取为二进制格式的数据
		InputStream data_bin=ClassObject_getResourceAsStream.class.getResourceAsStream(path);

		//字符串构建器
		StringBuilder strBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(data_bin));
		String line;
		while ((line = br.readLine()) != null) {
			strBuilder.append(line);
		}
		String str = strBuilder.toString();
		System.out.println(str);
	}
}
