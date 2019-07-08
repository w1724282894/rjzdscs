<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//项目的发布路径，例如:  /rabc
	String path = request.getContextPath();
	/*
	全路径，形式如下: http://127.0.0.1:8001/rbac/
	request.getScheme()      ——> http 获取协议
	request.getServerName()  --> 127.0.0.1 获取服务名
	request.getServerPort()  --> 8001 获取端口号
	path                     --> /rbac 获取访问的路径 路
	*/
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%-- 
    <base/>标签解决路径问题
    参考文章:http://www.cnblogs.com/muqianying/archive/2012/03/16/2400280.html
--%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>H+ 后台主题UI框架 - 登录</title>
<meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
<meta name="description"
	content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

<link rel="shortcut icon" href="favicon.ico">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">

<link href="css/animate.css" rel="stylesheet">
<link href="css/style1.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js" />
<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
<script>
	if (window.top !== window.self) {
		window.top.location = window.location;
	}
</script>
</head>


<body class="gray-bg">

	<div class="middle-box text-center loginscreen  animated fadeInDown">
		<div>
			<div>

				<h1 class="logo-name" style="font-size: 150px;">HU</h1>

			</div>
			<h3>欢迎使用 智慧校园应用系统 找回密码功能</h3>

			<p>
				请输入六位安全码和绑定手机号<br /> 请使用IE9以上，或最新版的 <a
					href="https://www.firefox.com.cn/" target="_blank"
					style="text-decoration: none; color: royalblue;">火狐</a> / <a
					href="https://www.google.cn/intl/zh-CN/chrome/" target="_blank"
					style="text-decoration: none; color: royalblue;">谷歌</a> 浏览器
			</p>

			<form class="m-t" id="form1">
				<div class="form-group">
					<input id="txt_account" type="text" class="form-control"
						placeholder="请输入账号" required="">
				</div>

                <div class="form-group">
                    <input id="txt_account" type="text" class="form-control"
                        placeholder="请输入手机号" required="">
                </div>
                
                <div class="form-group">
                    <input id="txt_account" type="text" class="form-control"
                        placeholder="请输入六位安全码" required="">
                </div>
                
				<div class="form-group row">
					<input id="txt_code" class="form-control" maxlength="4" type="text"
						placeholder="验证码" required="" style="width: 190px; float: left;">
					<div
						style="width: 110px; float: right; padding-top: 10px; padding-left: 14px;">
						看不清？<a id="switchCode" href="javascript:void();"
							style="text-decoration: none;">换一张</a> <img id="imgcode"
							class="authcode" src="captcha.jpg"
							onclick="this.src='captcha.jpg?'+Math.random()" width="80"
							height="25" />
					</div>
				</div>


				<button id="login_button" type="button"
					class="btn btn-primary block full-width m-b">
					<span>登 录</span>
				</button>


				<p class="text-muted text-center">
					<a href="<%=path%>/toLogin"><small>找回密码</small></a>
				</p>

			</form>

			<div id="login_tips" class="login_tips"></div>
		</div>


	</div>

	<div class="copyright ">
		<a href="http://www.hezeu.edu.cn/" target="_blank"
			style="text-decoration: none; color: royalblue;">人间正道是沧桑</a>
		请使用最新版的下列浏览器，否则可能因为版本问题点击按钮无任何相应，或无法保存数据。 <br>
		适用最新版浏览器：IE9以上、360、FireFox（火狐）、Chrome（谷歌）、QQ浏览器、Safari、Opera等。
	</div>


	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>

	<script type="text/javascript"
		src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
	<!--统计代码，可删除-->
	<script type="text/javascript">
		$("#switchCode").click(function() {
			$("#imgcode").attr("src", "captcha.jpg?time=" + Math.random());
		});

		$('#login_button').on(
				'click',
				function() {
					var txt_code = $("#txt_code").val();
					var txt_account = $("#txt_account").val();
					var txt_password = $("#txt_password").val();
					var num = 0;
					if (txt_account == "") {

						$("#login_tips").html("请输入账号").css("color", "red");
						num++;
					} else if (txt_password == "") {
						$("#login_tips").html("请输入密码").css("color", "red");
						num++;
					} else if (txt_code == "") {
						$("#login_tips").html("请输入验证码").css("color", "red");
						num++;
					}
					if (num > 0) {
						return false;
					} else {
						$.ajax({
							url : "adminLogin",
							type : "POST",
							data : {
								code : txt_code,
								User_Account : txt_account,
								User_Password : txt_password
							},
							dataType : "json",
							success : function(result) {
								if (result.msg == "1") {
									$("#login_tips").html("用户名/邮箱或密码错误").css(
											"color", "red");
									return;
								} else if (result.msg == "0") {
									$("#login_tips").html("验证码输入错误").css(
											"color", "red");
									return;
								} else {
									$("#login_button").find('span').html(
											"登录成功，正在跳转...");
									window.setTimeout(function() {
										window.location.href = "Index";
									}, 1000);
								}
							},
						});
					}
				});
	</script>
</body>

</html>
