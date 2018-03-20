<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上商城</title>
<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/css/product.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
</head>
<body>
	<!-- 商品页面头部 -->
	<div class="container header">
		<%@ include file="menu.jsp"%>
	</div>


	<div class="container productContent">

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

		<!-- 详细商品展示 -->
		<div class="span18 last">
			<div class="productImage">
				<a title="" style="outline-style: none; text-decoration: none;" id="zoom" rel="gallery">
					<img style="opacity: 1;" title="商品图片" class="medium"
							src="${pageContext.request.contextPath}/products/1/cs10001.jpg" />
				</a>
			</div>

			<!-- 商品的具体信息 -->
			<div class="name">某某商品</div>
			<div class="sn">
				<div>编号：cs10001</div>
			</div>

			<div class="info">
				<dl>
					<dt>活动价:</dt>
					<dd>
						<strong>￥：120元</strong> 参 考 价：
						<!-- 市场价 -->
						<del> ￥480元 </del>


					</dd>
				</dl>
				<dl>
					<dt>促销:</dt>
					<dd>
						<a target="_blank" title="限时抢购">限时抢购</a>
					</dd>
				</dl>

			</div>

			<!-- 加入购物车 -->
			<form id="cartForm" action="" method="post">

				<input type="hidden" name="pid" value="" />

				<div class="action">
					<dl class="quantity">
						<dt>购买数量:</dt>
						<dd>
							<input id="count" name="count" value="1" maxlength="5"
								type="number" min="0" onpaste="return false;" />
						</dd>
						<dd>件</dd>

						<dd>
							<input id="inventory" type="hidden" value="1" />
						</dd>
						<dd>&nbsp;&nbsp;库存&nbsp;1200&nbsp; 件</dd>
					</dl>

					<div class="buy">
						<input id="addCart" class="addCart" value="加入购物车" type="button" />
					</div>
				</div>
			</form>

			<!-- 商品介绍部分 -->
			<div id="bar" class="bar">
				<ul>
					<li id="introductionTab"><a href="#introduction">商品介绍</a></li>
				</ul>
			</div>
			<div id="introduction" class="introduction">
				<div class="title">
					<!-- 商品的描述 -->
					<strong>这里显示商品描述</strong>
				</div>
				<div>
					<!-- 商品图片 -->
					<img width="100%" src="${pageContext.request.contextPath}/products/1/cs10001.jpg" />
				</div>
			</div>
		</div>
	</div>

	<!-- 页脚  -->
	<div class="container footer">
		<div class="span24">
			<div class="copyright">谭州教育 Copyright © 2017-2017 版权所有</div>
		</div>
	</div>
</body>
</html>