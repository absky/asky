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
		
		<div class="page">
			<div class="banner">
				<div class="add">
					<a class="addA" href="${pageContext.request.contextPath}/gotoAddProduct">新增商品</a>
				</div>
			<!-- 一级类目 表格 显示 -->
				<div class="banShow">
					<table border="1" cellspacing="0" cellpadding="0">
						<tr>
							<td width="50px" class="tdColor tdC">序号</td>
							<td width="300px" class="tdColor">商品图片</td>
							<td width="100px" class="tdColor">商品名称</td>
							<td width="100px" class="tdColor">商品价格</td>
							<td width="100px" class="tdColor">序存量</td>
							<td width="100px" class="tdColor">是否热门</td>
							<td width="200px" class="tdColor">操作</td>
						</tr>
						
						<c:forEach items="${products }" var="item">
						<tr>
							<td>${item.pid}</td>
							<td><img width="200" height="150" src="${ pageContext.request.contextPath }/${item.image}"></td>
							<td>${item.pname }</td>
							<td>${item.shopPrice }</td>
							<td>${item.inventory }</td>
							<td>
							<c:if test="${item.isHot == 1}">
							是
							</c:if><c:if test="${item.isHot != 1}">
							否
							</c:if>
							</td>
							<td>
							<a href="${ pageContext.request.contextPath }/gotoEditProduct/<c:out value="${item.pid }" />">
							<img class="operation" src="${pageContext.request.contextPath}/img/update.png"></a> 
									
							<a href="${ pageContext.request.contextPath }/deleteProduct/<c:out value="${item.pid }" />/<c:out value="${curPage }" />">
							<img class="operation delban" src="${pageContext.request.contextPath}/img/delete.png"></a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<div class="paging">
						第<c:out value="${ curPage}" />页/共<c:out value="${totalPage}" />页
							 <c:if test="${curPage != 1 }">
									<a href="${pageContext.request.contextPath}/listProduct/1">首页</a>|
								<a href="${pageContext.request.contextPath}/listProduct/<c:out value="${curPage - 1 }"/>">上一页</a>|
							</c:if>
							 <c:if test="${curPage != totalPage }">
									<a href="${pageContext.request.contextPath}/listProduct/<c:out value="${curPage + 1 }"/>">下一页</a>|
									<a href="${pageContext.request.contextPath}/listProduct/<c:out value="${totalPage }"/>">尾页</a>|
							</c:if>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>