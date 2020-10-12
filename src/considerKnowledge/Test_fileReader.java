package considerKnowledge;

import java.io.IOException;
import java.io.InputStream;

/**********************文件读取**********************
 *1.相对路径:
       在project中，相对路径的根目录是project的根文件夹
 ************************测试***********************
 *1.相对路径读取数据(相对于该文件)
 **/
public class Test_fileReader {
	public static void main(String[] args) throws IOException {
		
	  /***************1.相对路径读取数据(相对于该文件)********************/
	  InputStream dataStream=Test_fileReader.class.getResourceAsStream("data/test.txt");
	  System.out.println(dataStream); 
	  dataStream.close();
	}
}
