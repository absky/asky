<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
	<div id="pageAll">
		<div class="pageTop">
			<div class="page">
				<img src="${pageContext.request.contextPath}/img/coin02.png" /><span><a href="#">首页</a>&nbsp;-&nbsp;<a
					href="#">商品管理</a>&nbsp;-</span>&nbsp;商品管理
			</div>
		</div>
		
		<div class="page ">
			<!-- 修改类目页面样式 -->
			<div class="banneradd bor">
				<div class="baTop">
					<span>新增商品</span>
				</div>
				<form action="${pageContext.request.contextPath}/addProduct" method="post" enctype="multipart/form-data">
					<div class="baBody">
						<div class="bbD">
							商品名称：<input type="text" name="pname" class="input1"/>
						</div>
						<div class="bbD">
							是否热门：<select name=isHot>
							<option value="1">是</option>
							<option value="0">否</option>
							</select>
						</div>
						<div class="bbD">
							市场价格：<input type="text" name="marketPrice" class="input1"/>
						</div>
						<div class="bbD">
							商品价格：<input type="text" name="shopPrice" class="input1"/>
						</div>
						<div class="bbD">
							库存量：<input type="text" name="inventory" class="input1"/>
						</div>
						上传商品图片：
						<div class="bbDd">
							<div class="bbDImg">+</div>
							<input type="file" class="file" name="upload"/>
						</div>
					
						<div class="bbD">
							所属二级分类：
							<select name="csid">
								<c:forEach items="${categotySeconds}" var="c">
							  		<option value="${c.csId }"/><c:out value="${c.csName }" />
								</c:forEach>
							</select>
						</div>
						<div class="bbD">
							商品描述：<textarea name="pdesc" rows="5" cols="100"></textarea>
						</div>
					
						<div class="bbD">
							<p class="bbDP">
								<button class="btn_ok btn_yes" type="submit">新增</button>
								<a class="btn_ok btn_no" href="#" onclick="history.go(-1)">取消</a>
							</p>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>