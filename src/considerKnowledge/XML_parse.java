package considerKnowledge;

import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/********************XML_parse************************
 *1.
 **/
public class XML_parse {
	public static void main(String[] args) {
		SAXReader xmlParser=new SAXReader();
		String xmlUrl="data/applicationContext.xml";
		//读取数据流
		InputStream dataStream=XML_parse.class.getResourceAsStream(xmlUrl);
		try {
			Document xmlDoc=xmlParser.read(dataStream);
			List<Element> beans=xmlDoc.selectNodes("bean");//获取bean元素对象
			//for遍历list
			for(Element item:beans){
				String name=item.attributeValue("name");//获取标签元素属性值
				System.out.println("name"+name);
			}
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("读取文件错误！");
		}
	}
}
