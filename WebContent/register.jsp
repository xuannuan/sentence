<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>清茗・阅读会员注册</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />

<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/jquery.validate2.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<link rel="stylesheet" type="text/css" href="css/headerfooter.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.alerts.css" />
<link rel="stylesheet" type="text/css" href="css/headerfooterindex.css" />

<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />


<style>
body {
	background:url(img/2.jpg);
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>

</head>
<script type="text/javascript">
$(function(){

	//js

	// document.getElementById("btn").onclick = function(){

	// 	window.location="http://www.baidu.com";

	// }

	//jq

	$("#btn").click(function(){

		//window.location="http://www.baidu.com";
		alert("注册成功，请返回登录");

	})

});

$.validator.addMethod(
"checkUsername",
function(value,element,params){
var flag = true;
$.ajax({
   "async":false,
   "url":"${pageContext.request.contextPath}/checkUsername",
   "type":"POST",
   "data":{"username":value},
   "dataType":"json",
   "success":function(data){
      flag = data.isExist;
   }
});
      return !flag ;
} );
$.validator.addMethod(
		"checkout",
		function(value,element,params){
		var flag = true;
		$.ajax({
		   "async":false,
		   "url":"${pageContext.request.contextPath}/checkCode",
		   "type":"POST",
		   "data":{"code":value},
		   "dataType":"json",
		   "success":function(data){
		      flag = data.isEqual;
		   }
		});
		      return flag ;
		});

	$(function (){
		$("#registForm").validate({
			rules:{//当前属于校验规则
				"username":{
					"required":true,
					//"checkUsername":true
				},
				"upwd":{
					"required":true,
					"rangelength":[2,16]
				},
				"confirmpwd":{
					"required":true,
					"rangelength":[2,16],
				    "equalTo":"#upwd"//这个password取得是password的input标签中的id值*****
				},
				"email":{
					"required":true,
				},
				"telephone":{
					"maxlength":11
				},
				"name":{
					"required":true,
					"rangelength":[2,4]
				},
				"birthday":{
					"date":true,
					"dateISO":true
				},
				"code" :{
					"required":true,
					"checkout":true
					},
			},
			messages:{//针对校验规则进行信息提示
				"username":{
					"required":"当前用户名不能为空", 	
					//"checkUsername":"当前用户已存在"
				},
				"upwd":{
					"required":"当前密码不能为空",
					"rangelength":"密码长度必须是2和16之间的长度"
				},
				"confirmpwd":{
					"required":"当前确认密码不能为空",
					"rangelength":"确认密码长度必须是2和16之间的长度",
				    "equalTo":"两次输入的密码需要相同"
				},
				"email":{
					"required":"请输入正确的邮件格式",
				},
				"telephone":{
					"maxlength":"电话号码格式不正确"
				},
				"name":{
					"required":"当前姓名不能为空",
					"rangelength":"姓名长度需要符合规则"
				},
				"birthday":{
					"dateISO":"请输入正确的日期格式"
				},
				"code" : {
					"required" : "必须输入验证码",
					"checkout" : "验证码错误"
				},
			},
			
		});  //键值对  键：值（{}）
	});

	function checkForm(f){
		var s = f.AgreeId.checked;
		if(s==false){
		alert("请选择同意协议");
		f.ch.focus();
		return false;
		}
		return true;
		}
	
</script>


<body>

	<!-- 引入header.jsp -->
		<div class="header">
			
		</div>


	<div class="container"
		style="width: 100%; background: url('img/2.jpg');">
	<span style=" font-family:'宋体'; font-size:20px; "><a href="${pageContext.request.contextPath }/login.jsp" >已注册，请登录</a></span>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: url('img/3.jpg'); padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>清茗・阅读会员注册</font>
				<form id="registForm" class="form-horizontal" action="${pageContext.request.contextPath}/register" method="post"  onsubmit="return checkForm(this)"  style="margin-top: 5px;"  >
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="usercaption" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="请输入姓名">
						</div>
					</div>
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="sex" id="sex1" value="男">
								男
							</label> <label class="radio-inline"> <input type="radio"
								name="sex" id="sex2" value="女">
								女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-sm-2 control-label">出生日期</label>
						<div class="col-sm-6">
							<input type="date" class="form-control" id="birthday" name="birthday">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="upwd" name="upwd"
								placeholder="请输入密码">
						</div>
					</div>
					<div class="form-group">
						<label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmpwd" name="confirmpwd"
								placeholder="请输入确认密码">
						</div>
					</div>
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email" name="email"
								placeholder="Email">
						</div>
					</div>
					<div class="form-group">
						<label for="inputTel" class="col-sm-2 control-label">电话</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="telephone" name="telephone"
								placeholder="请输入电话号码">
						</div>
					</div>
					
					

	         		<div class="form-group">
						<span  class="regM" style="margin-left:29px">
						
							
							 <a href="" target="_blank"  class="checkTitle">我已阅读并同意<font style="font-size:12px;">《清茗・阅读用户注册协议》</font></a>
						</span>
                	<span  id="AgreeIdErr" ></span>
          			</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" id="btn" value="注册" width="100"/>
						<input type="submit" id="submit" width="100" value="注册" name="submit"
								style="background: url('./img/3.jpg'); height: 35px; width: 100px; color: white;">
						
							</div>
					</div>
				</form>
         

			</div>

			<div class="col-md-2"></div>

		</div>
		<input type="hidden" id="regist" name="regist"  value="${regist}">
		
	
		<div class="footer">
			<span>
				<a href="#">关于我们</a> | 
				<a href="#">联系我们</a> 
			
			</span>
			<p> 
				清茗・阅读<br />
				
			</p>
		</div>
		<!-- /footer -->
	</div>



</body>
</html>




