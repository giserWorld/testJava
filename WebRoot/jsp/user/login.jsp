<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 安装标签lib,在jsp中使用jstl语句，用前缀"c"表示-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%-- 设置该页面的基础路径,该页面所有url都会以该“basePath”作为相对路径 --%>
    <%-- <base href="<%=basePath%>"> --%>
    
    <title>登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<h1>登录页面</h1>
  	<form action="login.action" method="post">
  		<p>
  			<label for="name">账号：</label>
  			<input type="text" name="name" id="name"/>
  		<p/>
  		<p>
			<label for="password">密码：</label>
  			<input type="text" name="password" id="password"/>
  		<p/>
  		 <input type="submit" value="登录"/>
  		 <!--登录信息提示 -->
  		 <c:if test="${loginInfo!=null}">  
		        <font color="red">${loginInfo}</font>  
		 </c:if> 
		
  		 <!-- 如果登录有错误，则需要显示错误信息 -->
  		 <c:if test="${allErrors!=null}">  
		    <c:forEach items="${allErrors}" var="error">  
		        <br/>
		        <font color="red">${error.defaultMessage}</font>  
		    </c:forEach>  
		</c:if> 
  	</form>
  </body>
</html>
