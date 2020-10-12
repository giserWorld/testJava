package dom4j;

import java.util.ArrayList;
import java.util.List;

//Bean类
public class Bean {
	private String name;
	private String className;
	private List<Property> prop=new ArrayList<Property>();
	
	
	public List<Property> getProp() {
		return prop;
	}
	public void setProp(List<Property> prop) {
		this.prop = prop;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
}
