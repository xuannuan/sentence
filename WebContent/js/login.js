// alert('hellojs')
// var i=10;
// var f=false;
// var d=3.14;
// alert(i+d);

// 获取页面上的登录按钮
var btn=document.getElementById('btn-login');
// 为按钮绑定一个点击事件
btn.addEventListener('click',function(){
	// 获取用于输入账号密码的两个输入框中的值
	var name=document.getElementById('name').value;
	var pwd=document.getElementById('pwd').value;
	// alert(name+'==='+pwd);
	// 校验是否输入账号密码
	if(name.length<1){
		layer.msg('请输入账号');
		return false;
	}
	if(pwd.length<1){
		layer.msg('请输入密码');
		return false;
	}
	//提交表单
	document.forms[0].submit();
})