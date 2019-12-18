<%@ page language="java"  pageEncoding="utf-8"%>

<!-- html5页面的文档类型定义 -->
<!DOCTYPE html>
<!-- 网页根标签：有且只有一对 -->
<html>
	<!-- 头部定义：设置页面编码，网页标题，网页描述等设置信息 -->
	<head>
		<!-- 设置页面编码 -->
		<meta charset="utf-8" />
		<title>清茗・阅读——用户登录</title>
		<link rel="stylesheet" type="text/css" href="css/login.css"/>
		
		<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
	</head>
	<!-- 网页的主体部分，页面结构的核心编码区域 -->
	<body>
		<div class="login">
			<div class="login-title"><!-- /*div.login-title按tab键*/ -->
				<h2>清茗・阅读用户登录</h2>
			</div>
			<div class="login-form">
				<form action="doLogin.jsp">
					<div class="input-group">
						<i class="login-icon fa fa-user"></i>
						<input type="text" id="name" name="username" class="input-txt" placeholder="用户名">
					</div>
					<div class="input-group">
						<i class="login-icon fa fa-lock"></i>
						<input type="password" id="pwd" name="password" class="input-txt" placeholder="密码">
					</div>
                    
					<div class="btn-box">
						<a href="Reading.html"><button class="btn-login" id="btn-login" type="button">登&nbsp;&nbsp;录</button></a>
					</div>
				</form>
			</div>
		</div>
		<!-- 引入jQuery库 -->
		<script src="js/jquery-3.2.1.min.js"> </script>
		<script src="js/layer.js"></script>
		<!-- 引入外部的脚本文件（js） -->
		<script src="js/login.js"></script>
		
	    <script>
	             //当页面被加载时触发以下代码片段
	      window.onload=function(){
	            	 //判断request范围内是否存在msg变量
		    if('${msg}'){
		    	//layerjs弹框
			layer.alert('${msg}',{icon:2});
		    }
	      }
	</script>
	</body>
</html>
