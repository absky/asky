<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城管理系统首页</title>
<link rel="stylesheet" type="text/css" href="css/public.css" />
<link rel="stylesheet" type="text/css" href="css/page.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	   $("#myform").validate({
	        submitHandler:function(form){
	            form.submit();
	        }    
	    });
	});
</script>
</head>
<body>

	<!-- 登录页面头部 -->
	<div class="logHead">
		<img src="img/logLOGO.png" />
	</div>
	<!-- 登录页面头部结束 -->

	<!-- 登录body -->
	<div class="logDiv">
		<img class="logBanner" src="img/logBanner.png" />
		<div class="logGet">
			<!-- 头部提示信息 -->
			<div class="logD logDtip">
				<p class="p1">商城管理系统登录</p>
				<p class="p2"><a href="${ pageContext.request.contextPath }/index">返回商城</a></p>
			</div>
			<!-- 输入框 -->
			
			<form id="myform" action="adminLogin" method="POST">
			<div class="lgD">
				<img class="img1" src="img/logName.png" />
				<input type="text" name="username" placeholder="输入用户名" class="text required"/>
			</div>
			<div class="lgD">
				<img class="img1" src="img/logPwd.png" />
				<input type="password" name="password" placeholder="输入用户密码" class="text required"/>
			</div>
			
			<div class="lgD">
				<font color="red">${loginFlag }</font>
			</div>
			
			<div class="logC">
				<input type="submit" value="进入管理中心" class="logC" />
			</div>
			</form>
		</div>
	</div>
	<!-- 登录body  end -->

	<!-- 登录页面底部 -->
	<div class="logFoot">
		<p class="p1">版权所有：湖南省谭州教育科技有限公司</p>
		<p class="p2">湖南省谭州教育科技有限公司 @CopyRight 2007~2017</p>
	</div>
	<!-- 登录页面底部end -->
</body>
</html>