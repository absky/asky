<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="span10 last">
    <div class="topNav clearfix">
        <ul>
            <!-- 若用户未登录 -->
           <%--  <c:if test=""> --%>
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a href="${ pageContext.request.contextPath }/userLogin">登录</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                	<a href="${ pageContext.request.contextPath }/userRegister">注册</a>|
                </li>
            <%-- </c:if> --%>
				<br><br>
            <!-- 若用户已登录 -->
            <%-- <c:if test=""> --%>
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <c:out value="用户名称"/>
                </li>
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a  href="#">我的订单</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                	<a href="">退出</a>|
                </li>
           <%--  </c:if> --%>
         </ul>
         
         <ul>
         	<li id="headerRegister" class="headerRegister" style="display: list-item;">
         		<a href="${ pageContext.request.contextPath }/admin">商户平台</a>
         	</li>
         </ul>
    </div>

    <div class="cart">
        <a href="#">购物车</a> 
    </div>

</div>

<div class="span24">
    <ul class="mainNav">
        <li><a href="${ pageContext.request.contextPath }/index">首页</a>|</li>
       <%--  <c:forEach items="" var="c"> --%>
            <li><a href="">一级类目1</a>
            </li>
            <li><a href="">一级类目2</a>
            </li>
            <li><a href="">一级类目3</a>
            </li>
            <li><a href="">一级类目4</a>
            </li>
       <%--  </c:forEach> --%>
    </ul>
</div>