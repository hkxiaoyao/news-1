<%@ page  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row-fluid">
	<div class="span12">
		<img src="${pageContext.request.contextPath}/images/logo.png">
	</div>
</div>
<div class="row-fluid">
	<div class="span12">		  
		   <div class="navbar">
		      <div class="navbar-inner">
		          <a class="brand" href="${pageContext.request.contextPath}">首页</a>
		         <ul class="nav">
					 <c:forEach items="${types}" var="type" varStatus="statu">

							<li><a href="${pageContext.request.contextPath}/newslist.html?type=${type.id}">${type.type}</a> </li>
					 </c:forEach>

		        </ul>
		    </div>
	   </div>
   </div>
</div>

