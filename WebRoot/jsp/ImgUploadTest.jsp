<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传页面</title>
</head>
<body>
	<h2>文件上传页面</h2>
	<form action="uploadImg.action" method="post" enctype="multipart/form-data">  
	    <c:if test="${image !=null}">
			<img src="${image}" width=100 height=100/>
			<br/>
		</c:if>
		<input type="file" name="file" /><p/> 
		<input type="submit" value="上传" />
	</form>  
</body>
</html>