<%@ page  pageEncoding="UTF-8"%>
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
<jsp:include page="/foreground/common/head.jsp"/>

<div class="row-fluid">
	<div class="span8">
		<div class="data_list">
	<div class="dataHeader navi">
		<a href="${pageContext.request.contextPath}">首页</a>><a href="${pageContext.request.contextPath}/newslist.html?type=${contentBean.news.type}">${contentBean.type}</a>><a href="${pageContext.request.contextPath}/content.html?id=${contentBean.news.id}&type=${contentBean.news.type}">${contentBean.news.title}</a>
	</div>
	<div>
		<div class="news_title"><h3>${contentBean.news.title}</h3></div>
		<div class="news_info">
			日期：${contentBean.news.dates}&nbsp;&nbsp;作者：${contentBean.news.writer}
			&nbsp;&nbsp;新闻类别：${contentBean.type}&nbsp;&nbsp;阅读次数：${contentBean.news.hits}
		</div>
		<div class="news_content">
			${contentBean.news.content}
		</div>
	</div>
	<div class="upDownPage">
		<c:if test="${contentBean.news.id>1}">

			上一篇 <a href="${pageContext.request.contextPath}/content.html?id=${contentBean.lastnew.id}&type=${contentBean.lastnew.type}">${contentBean.lastnew.title}</a><br>
		</c:if>
		<c:if test="${contentBean.news.id < contentBean.count}">
			下一篇 <a href="${pageContext.request.contextPath}/content.html?id=${contentBean.nextnew.id}&type=${contentBean.nextnew.type}">${contentBean.nextnew.title}</a><br>
		</c:if>

	</div>
</div>
	
	</div>
	<div class="span4">
		<div class="data_list right_news_list">
			<div class="dataHeader">最新新闻</div>
			<div class="datas">
				<ul>
					<c:forEach items="${contentBean.newsOfTime}" var="newsofTime">
						<li><a href="${pageContext.request.contextPath}/content.html?id=${newsofTime.id}&type=${newsofTime.type}">${newsofTime.title}</a></li>
					</c:forEach>

					
				</ul>
			</div>
		</div>
		<div class="data_list right_news_list">
			<div class="dataHeader">热门新闻</div>
			<div class="datas">			
					<ul>
						<c:forEach items="${contentBean.hot}" var="hot">
							<li><a href="${pageContext.request.contextPath}/content.html?id=${hot.id}&type=${hot.type}" >${hot.title}</a></li>
						</c:forEach>

				   </ul>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/foreground/common/foot.jsp"/>
</div>
</body>
</html>


