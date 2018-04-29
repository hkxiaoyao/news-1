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
		<div class="dataHeader navi">
		    <a href="${pageContext.request.contextPath}">首页</a>>
			<a href="${pageContext.request.contextPath}/newslist.html?type=${pageBean.typeid}&currPage=1">${pageBean.typename}</a>
	    </div>
	  <div class="datas news_type_list">
		<ul>
			<c:forEach items="${pageBean.beanList}" var="news">
				<li><span><a href="${pageContext.request.contextPath}/content.html?id=${news.id}&type=${news.type}" title="">${news.title}</a></span></li>
			</c:forEach>
		</ul>
	  </div>
	  <div>
	    共有记录${pageBean.totalrecord}条，${pageBean.pagecode}/${pageBean.totalpage}页，
		  <a href ="${pageContext.request.contextPath}/newslist.html?type=${pageBean.typeid}&currPage=1">首页</a>
		  <c:if test="${pageBean.pagecode>1}">
			  <a href="${pageContext.request.contextPath}/newslist.html?type=${pageBean.typeid}&currPage=${pageBean.pagecode-1}">上一页</a>
		  </c:if>


		<c:choose>
			<c:when test="${pageBean.totalpage<=5}">
				<c:set var="begin" value="1"/>
				<c:set var="end" value="${pageBean.totalpage}"/>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${pageBean.pagecode-2}"/>
				<c:set var="end" value="${pageBean.pagecode+2}"/>

				<%--头溢出--%>
				<c:if test="${begin<1 }">
				<c:set var="begin" value="1"/>
				<c:set var="end" value="5"/>
				</c:if>

				<%--尾溢出 --%>
				<c:if test="${end>pageBean.totalpage }">
				<c:set var="begin" value="${pageBean.totalpage-4 }"/>
				<c:set var="end" value="${pageBean.totalpage }"/>
				</c:if>
			</c:otherwise>
		</c:choose>


		  <%--循环显示页面列表 --%>
		  <c:forEach var="i" begin="${begin}" end="${end}">
		  <c:choose>
		  <c:when test="${i eq pageBean.pagecode }">
			  <span style="color: red"> [${i}]</span>

		  </c:when>
		  <c:otherwise>
		  <a href="${pageContext.request.contextPath}/newslist.html?type=${pageBean.typeid}&currPage=${i}">[${i }]</a>
		  </c:otherwise>
		  </c:choose>
		  </c:forEach>

		  <c:if test="${pageBean.pagecode<pageBean.totalpage}">
			  <a href="${pageContext.request.contextPath}/newslist.html?type=${pageBean.typeid}&currPage=${pageBean.pagecode+1}">下一页</a>
		  </c:if>

		  <a href ="${pageContext.request.contextPath}/newslist.html?type=${pageBean.typeid}&currPage=${pageBean.totalpage}">尾页</a>
	  </div>
	
	</div>
	<div class="span4">
		<div class="data_list right_news_list">
			<div class="dataHeader">最新新闻</div>
			<div class="datas">
				<ul>
					<c:forEach items="${pageBean.newsOfTime}" var="newsofTime">
						<li><a href="${pageContext.request.contextPath}/content.html?id=${newsofTime.id}&type=${newsofTime.type}">${newsofTime.title}</a></li>
					</c:forEach>

					
				</ul>
			</div>
		</div>
		<div class="data_list right_news_list">
			<div class="dataHeader">热门新闻</div>
			<div class="datas">			
					<ul>
						<c:forEach items="${pageBean.hot}" var="hot" varStatus="varstaus">
							<c:if test="${varstaus.count<=8}">
								<li><a href="${pageContext.request.contextPath}/content.html?id=${hot.id}&type=${hot.type}" >${hot.title}</a></li>
							</c:if>

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