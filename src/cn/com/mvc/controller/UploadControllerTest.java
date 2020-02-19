package cn.com.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


//文件上传接口
@Controller
public class UploadControllerTest {
	
	
	//上传文件接口
	@RequestMapping("uploadImg")
	public String uploadImg(Model model,MultipartFile file,
			HttpServletRequest request) throws IllegalStateException, IOException{
		//MultipartFile file 文件上传字段
		
		//获取上传文件的名称
		String originalFilename=file.getOriginalFilename();
		String newFilename=null;//新的文件名称
		//文件上传
		if(file!=null&&originalFilename!=null&&originalFilename.length()>0){
			//存储文件的url
			String file_url="E:\\tomcat\\tomcat8-2\\webapps\\img_server\\";
			//随机产生uuid
			String uuid=UUID.randomUUID().toString();
			//截取文件后缀名
			int lastIdx=originalFilename.lastIndexOf(".");//获取最后"."字符的idx
			String filetype=originalFilename.substring(lastIdx);
			//新文件名
			newFilename=uuid+filetype;
			
			//在指定的目录下创建一个指定类型的文件
			File newFile=new File(file_url+newFilename);
			//将内存中的数据写入到新文件中
			file.transferTo(newFile);
		}
		String baseURL="../img_server/";//服务基础路径
		//回显刚才上传的图片名称
		model.addAttribute("image",baseURL+newFilename);
		return "/ImgUploadTest";
	}
	
	//跳转文件上传页面
	@RequestMapping("toUploadPage")
	public String toUploadPage(){
		//文件上传页面
		return "/ImgUploadTest";
	}
}
