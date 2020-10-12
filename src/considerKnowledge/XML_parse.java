package considerKnowledge;

import java.io.IOException;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/********************XML_parse************************
 *1.解析xml文档
 **/
public class XML_parse {
	public static void main(String[] args) throws DocumentException, IOException {
		
		//创建xml读取器
		SAXReader xmlParser=new SAXReader();
		//xml文档url,
		String xmlUrl="data/applicationContext.xml";
		//读取为而二进制数据
		InputStream dataStream=XML_parse.class.getResourceAsStream(xmlUrl);
		//将xml文档数据读取为doc文档树对象
		Document xmlDoc=xmlParser.read(dataStream);
		System.out.println(xmlDoc.toString());	
			
			
			//获取bean元素对象
/*			List<Element> beans=xmlDoc.selectNodes("//bean");//查询bean节点
			System.out.println(beans);
			//for遍历list
			for(Element item:beans){
				String name=item.attributeValue("name");//获取标签元素属性值
				System.out.println("name"+name);
			}*/
	}
}
