<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城管理系统首页</title>
</head>
<frameset rows="103,*,43" frameborder=0 border="0" framespacing="0">
<!-- 引用头部 -->
  <frame src="adminTop" name="topFrame" scrolling="NO" noresize>
<!-- 左右的主体 -->
  <frameset rows="100*" cols="220,*" scrolling="No"
	        framespacing="0" frameborder="no" border="0"> 
		<frame src="adminLeft" name="leftFrame" noresize scrolling="YES">
		<frame src="adminWelcome" name="mainFrame" scrolling="yes" noresize>
  </frameset>
  <!-- 底部 -->
  <frame src="adminBottom" name="bottomFrame" scrolling="NO"  noresize>
</frameset>
</html>