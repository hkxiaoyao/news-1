<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link href="${pageContext.request.contextPath}/style/news.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
</head>
<body>
<div class="container">
<!-- 头部 -->
<jsp:include page="/foreground/common/head.jsp"/>
<!-- 主体第一行 -->
<c:forEach begin="1" end="${typenumber}" var="i">
	<c:if test="${i==1||(i-1)%3==0}">
		<div class="row-fluid">
	</c:if>
		<div class="span4">
			<div class="data_list news_list" >
				<div class="dataHeader">${types[i-1].type}
					<span class="more">
						<a href="${pageContext.request.contextPath}/newslist.html?type=${types[i-1].id}&currPage=1" target="_blank">更多...</a>
					</span>
				</div>
				<div class="datas">
					<ul>
						<c:forEach items="${types[i-1].pageBean.beanList}" var="beanlist">
						<li><a href="${pageContext.request.contextPath}/content.html?id=${beanlist.id}&type=${beanlist.type}" title="">${beanlist.title}</a></li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<c:if test="${i%3==0||i==typenumber}">
			</div>
		</c:if>
</c:forEach>
	<!-- 导航及网页尾部 -->
<jsp:include page="/foreground/common/link.jsp"/>
<jsp:include page="/foreground/common/foot.jsp"/>
</div>
</body>
</html>