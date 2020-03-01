package considerKnowledge.mvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//标准的返回格式
@Controller
public class HttpResponse_format {

	@RequestMapping("test/response_classObj.action")
	@ResponseBody
	public Object response_classObj(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> reponseMap=new HashMap<String,Object>();
		reponseMap.put("mgs","获取数据成功！");
		reponseMap.put("code","0");
		reponseMap.put("data","");
		return reponseMap;
	}
}
