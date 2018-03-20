<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上商城</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container header">
		<!-- 包含进去首页头部的文件 -->
		<%@ include file="menu.jsp"%>
	</div>
	
	<div class="container productList">
	
		<!-- 左侧商品分类 -->
		<div class="span6">
			<div class="hotProductCategory">
				<c:forEach items="${sessionScope.cList}" var="c">
				<dl>
					<dt>
						<a href="${ pageContext.request.contextPath }/findByCid/<c:out value="${ c.cid }"/>/1"><c:out value="${ c.cname }"></c:out></a>
					</dt>

					<c:forEach items="${c.categorySeconds }" var="cs">
					<dd>
						<a href="${ pageContext.request.contextPath }/findByCsid/<c:out value="${ cs.csId }"/>/1"><c:out value="${ cs.csName }"></c:out></a>
					</dd>
					</c:forEach>
				</dl>
				</c:forEach>
			</div>
		</div>
		
		<div class="span18 last">

			<!-- 各项商品 -->

			<div id="result" class="result table clearfix">
				<ul>
					<c:forEach var="p" items="${ products }">
					<li><a href="${pageContext.request.contextPath}/findByPid/1">
							<img src="${pageContext.request.contextPath}/<c:out value="${p.image }"/>" width="170" height="170"
							style="display: inline-block;" /> <span style='color: green'><c:out value="${p.pname }"/></span>
							<span class="price"> 商城价： ￥<c:out value="${p.shopPrice }"/> </span>
					</a></li>
					</c:forEach>
				</ul>
			</div>


			<!-- 基于一类目和二级类目分页 -->
			<div class="pagination">

				<!-- 根据一级分类的cid是不是为空来显示上一页下一页的状况 -->
				<c:if test="true">
					<span>第 1页/共1页</span>

					<!-- 首页 -->
					<span><a class="firstPage" href="#"></a></span>

					<!-- 上一页 -->
					<c:if test="true">
						<span><a class="previousPage" href="#"></a></span>
					</c:if>

					<c:forEach var="i" begin="1" end="5">
						<span> <!-- 如果是当前页则不能够点击 --> <c:if test="true">
								<span class="currentPage">1</span>
							</c:if> <c:if test="true">
								<a href="#">1</a>
							</c:if>
						</span>
					</c:forEach>

					<!-- 下一页 -->
					<c:if test="true">
						<span><a class="nextPage" href="#"></a></span>
					</c:if>

					<!-- 尾页 -->
					<a class="lastPage" href="#"></a>
				</c:if>
			</div>
		</div>
	
	</div>
	<!-- 页脚 -->
	<div class="container footer">
		<div class="span24">
			<div class="copyright">谭州教育   Copyright © 2017-2017 版权所有</div>
		</div>
	</div>
</body>
</html>