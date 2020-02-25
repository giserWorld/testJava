<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>josn数据发送器</title>
	<script type="text/javascript" src="../apiFiles/jquery/js/jquery-3.3.1.js"></script>
</head>
<body>
	<!-- 文本框数据框 -->
	<textarea id="textData" rows="15" cols="50" placeholder="请输入json格式信息">
	
	</textarea>
	<p/>
	<button id="submitMsg">发送json数据</button>
	<script type="text/javascript">
		//textArea填充json数据
		$("#textData").val('{"name":"jack","password":"123"}');
		
		//ajax提交数据
		$("#submitMsg").click(function(){
			//1.参数类型为:contentType:"application/json;charset=utf-8"
			var param=$("#textData").val()||"";
			
			//2.参数类型为:contentType:"application/x-www-form-urlencoded;charset=utf-8"
			var param2={
				name:"jack",
				password:"123",
			};
			//3.参数类型为:contentType:"application/x-www-form-urlencoded;charset=utf-8"
			var param3="name=jack&password=123";
			
			//jquer的ajax请求
			$.ajax({
				type:"post",
				url:"http://localhost:8082/testJava/JsonTest.action",
				//url:"http://localhost:8082/testJava/JsonTest2.action",
				//contentType:"application/json;charset=utf-8",//提交参数的数据类型
				contentType:"application/x-www-form-urlencoded;charset=utf-8",//默认
				data:param2,//数据参数
				success:function(result){
					console.log("***********请求的数据***********");
					console.log(result);
				}
			});
		});
	</script>
</body>
</html>