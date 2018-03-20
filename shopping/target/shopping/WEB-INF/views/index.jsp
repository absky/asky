<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商城首页</title>
<link href="${pageContext.request.contextPath}/css/slider.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/index.css"
	rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container header">
		<!-- 包含进去首页头部的文件 -->
		<%@ include file="menu.jsp"%>
	</div>
	
	<div class="container index">

		<div class="span24">
			<div id="hotProduct" class="hotProduct clearfix">

				<div class="title">
					<strong>热门商品</strong>
					<!-- <a  target="_blank"></a> -->
				</div>
				<ul class="tab">
					<li class="current"><a href="#" target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>

				<ul class="tabContent" style="display: block;">
					<%-- <c:forEach var="p" items="${hList}"> --%>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10001.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10002.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10003.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10004.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10005.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10006.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10007.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10008.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10009.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank"> 
							<img src="${pageContext.request.contextPath }/products/cs10010.jpg" style="display: block;" />
							</a>
						</li>
					<%-- </c:forEach> --%>
				</ul>
			</div>
		</div>

		<div class="span24">
			<div id="newProduct" class="newProduct clearfix">
				<div class="title">
					<strong>最新商品</strong> <a target="_blank"></a>
				</div>
				<ul class="tab">
					<li class="current"><a href="#" target="_blank"></a></li>
					<li><a target="_blank"></a></li>
					<li><a target="_blank"></a></li>
				</ul>

				<ul class="tabContent" style="display: block;">
					<%-- <c:forEach items="${nList }" var="p"> --%>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30001.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30002.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30003.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30004.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30005.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30006.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30007.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30008.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30009.jpg" style="display: block;" />
							</a>
						</li>
						<li><a href="" target="_blank">
							<img src="${pageContext.request.contextPath }/products/cs30010.jpg" style="display: block;" />
							</a>
						</li>
					<%-- </c:forEach> --%>
				</ul>
			</div>
		</div>

		<div class="span24">
			<div class="friendLink">
				<dl>
					<dt>新手指南</dt>
					<dd>
						<a target="_blank">支付方式</a> |
					</dd>
					<dd>
						<a target="_blank">配送方式</a> |
					</dd>
					<dd>
						<a target="_blank">售后服务</a> |
					</dd>
					<dd>
						<a target="_blank">购物帮助</a> |
					</dd>
					<dd>
						<a target="_blank">蔬菜卡</a> |
					</dd>
					<dd>
						<a target="_blank">礼品卡</a> |
					</dd>
					<dd>
						<a target="_blank">银联卡</a> |
					</dd>
					<dd>
						<a target="_blank">谭州卡</a> |
					</dd>

					<dd class="more">
						<a>更多</a>
					</dd>
				</dl>
			</div>
		</div>
	</div>

	<div class="container footer">
		<div class="span24">
			<div class="copyright">谭州教育   Copyright © 2017-2017 版权所有</div>
		</div>
	</div>
</body>
</html>