<%--
  Created by IntelliJ IDEA.
  User: 平行时空
  Date: 2018/2/15
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>新闻发布后台管理</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<link href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/admin/css/bootstrap-reset.css" rel="stylesheet">
<!--external css-->
<link href="${pageContext.request.contextPath}/admin/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/admin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/owl.carousel.css" type="text/css">
<!-- Custom styles for this template -->
<link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/admin/css/style-responsive.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/admin/assets/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath}/admin/assets/ckfinder/ckfinder.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/pxsk.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/bootstrap.min.js"></script>


<body>
<section id="container" class="">
    <!--头部导航栏-->
    <header class="header white-bg">
        <!--收缩展开标签-->
        <div class="sidebar-toggle-box">
            <div data-original-title="显示/隐藏" data-placement="right" class="icon-reorder tooltips"></div>
        </div>


        <!--logo start-->
        <a href="#" class="logo">新闻<span>发布</span></a>
        <!--logo end-->

        <!--左端头部按钮-->
        <div class="nav notify-row" id="top_menu">
            <!--  notification start -->
            <ul class="nav top-menu">
                <!-- inbox dropdown end -->
                <!-- notification dropdown start-->
                <li id="header_notification_bar" class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                        <i class="icon-bell-alt"></i>
                        <span class="badge bg-warning">1</span>
                    </a>
                    <ul class="dropdown-menu extended notification">
                        <div class="notify-arrow notify-arrow-yellow"></div>
                        <li>
                            <p class="yellow">您有1条新通知</p>
                        </li>
                        <li>
                            <a href="http://www.waq8.com">
                                <span class="label label-danger"><i class="icon-bolt"></i></span>

                                <span class="small italic">34 mins</span>
                            </a>
                        </li>

                    </ul>
                </li>
                <!-- notification dropdown end -->
            </ul>
            <!--  notification end -->
        </div>

        <!--右端按钮-->
        <div class="top-nav ">
            <!--search & user info start-->
            <ul class="nav pull-right top-menu">
                <li>
                    <input type="text" class="form-control search" placeholder="查找信息">
                </li>
                <!-- user login dropdown start-->
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <img alt="" src="${pageContext.request.contextPath}/admin/img/avatar1_small.jpg">
                        <span class="username">${user.username}</span>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu extended logout">
                        <div class="log-arrow-up"></div>
                        <li><a href="#"><i class=" icon-suitcase"></i>概况</a></li>
                        <li><a href="#"><i class="icon-cog"></i> 设置</a></li>
                        <li><a href="#"><i class="icon-bell-alt"></i> 通知</a></li>
                        <li><a href="${pageContext.request.contextPath}/admin/html/adminhtml/quitUser.html" id="quit"><i class="icon-key"></i>退出账户</a></li>
                    </ul>
                </li>
                <!-- user login dropdown end -->
            </ul>
            <!--search & user info end-->
        </div>

    </header>

    <!--左端导航栏-->
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu">
                <li >
                    <a class="" href="">
                        <i class="icon-dashboard"></i>
                        <span>仪表板</span>
                    </a>
                </li>


                <li class="sub-menu active">
                    <a href="javascript:;" class="">
                        <i class="icon-book"></i>
                        <span>消息管理</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li class="active"><a class="" href="${pageContext.request.contextPath}/admin/html/adminhtml/msgpublish.html">发布消息</a></li>
                        <li><a class="" href="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html">新闻管理</a></li>
                        <li><a class="" href="${pageContext.request.contextPath}/admin/html/adminhtml/linkcontrol.html">友链管理</a></li>

                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;" class="">
                        <i class="icon-user"></i>
                        <span>账户管理</span>
                        <span class="arrow"></span>
                    </a>
                    <ul class="sub">
                        <li class=""><a class="" href="${pageContext.request.contextPath}/admin/html/adminhtml/usercontrol.html">管理员管理</a></li>

                    </ul>
                </li>

            </ul>
            <!-- sidebsar menu end-->
        </div>
    </aside>


    <section id="main-content">
        <section class="wrapper">
            <!--开始状态概述-->
            <div class="row state-overview">
                <!--widget start-->
                <div class="right">
                    <section class="panel">
                        <div class="content_type">
                            <header class="panel-heading">
                                消息发布

                                <button type="button" id="updateandadd" style="float: right" class="btn btn-primary">
                                    <i class="icon-save"></i>
                                    发布/修改
                                </button>

                            </header>

                            <form id="newsForm">
                                <div class="form-group row">
                                    <label style="text-align: right;" class="col-lg-2 control-label">请选择新闻分类</label>
                                    <div class="col-lg-5">
                                        <input type="hidden" name="id" value="${news.id}">
                                        <input type="hidden" name="froms" value="${user.username}">
                                        <select  class="form-control" name="type">
                                            <c:forEach items="${types}" var="type" varStatus="status">
                                                <c:choose>
                                                    <c:when test="${status.count eq news.type}">
                                                        <option value="${type.id}" selected="selected">
                                                                ${type.type}
                                                        </option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="${type.id}">
                                                                ${type.type}
                                                        </option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <label style="text-align: right;" class="col-lg-2 control-label">热点</label>
                                    <div class="col-lg-2">
                                        <select  class="form-control" name="hot">
                                                <c:choose>
                                                    <c:when test="${news.hot eq 1}">

                                                        <option value="0">
                                                            否
                                                        </option>
                                                        <option value="1" selected="selected">
                                                            是
                                                        </option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="0" selected="selected">
                                                            否
                                                        </option>
                                                        <option value="1" >
                                                            是
                                                        </option>
                                                    </c:otherwise>
                                                </c:choose>
                                        </select>
                                    </div>


                                </div>

                                <div class="form-group row">
                                    <label style="text-align: right;" class="col-lg-2 control-label">请填写发布标题</label>
                                    <div class="col-lg-5">
                                        <input name="title" class="form-control" rows="8" value="${news.title}">
                                    </div>

                                    <label style="text-align: right;" class="col-lg-2 control-label">作者</label>
                                    <div class="col-lg-2">
                                        <input name="writer" class="form-control" rows="8" value="${news.writer}">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label  style="text-align: right;"  class="col-lg-2 control-label">出处</label>
                                    <div class="col-lg-5">
                                        <input name="froms" class="form-control" rows="8" value="${news.froms}">
                                    </div>
                                    <span class="pull-right">
		                    <a data-toggle="modal" id="tishia" href="msgpublish.html#myModal" style="display: none"></a>
		                             </span>
                                </div>


                                <textarea name="content" id="content" class="col-sm-5">
                                    ${news.content}
                                </textarea>
                                <script>
                                    var editor = CKEDITOR.replace( 'content' );
                                    CKFinder.setupCKEditor(editor, '${pageContext.request.contextPath}/admin/assets/ckfinder/');
                                </script>
                            </form>

                            <!-- Modal -->
                            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title">系统提示：</h4>
                                        </div>
                                        <div class="modal-body">
                                            <p id="tishi"></p>

                                        </div>
                                        <div class="modal-footer">
                                            <button data-dismiss="modal"  id="tijiaos" class="btn btn-theme btn-success" type="button">确定</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- modal -->

                        </div>
                    </section>
                </div>
            </div>
        </section>
    </section>

</section>
</body>

<script>
    $(function () {
        $("#updateandadd").click(function () {
            for (instance in CKEDITOR.instances)
                CKEDITOR.instances[instance].updateElement();
            $.ajax({
                type:'post',
                url:getRootPath()+"/admin/html/adminhtml/updateandaddNews",
                contentType:'application/json; charset=utf-8',
                dataType:'json',
                cache:false,
                data:$("#newsForm").toJson(),
                success:function(data){
                    if(data.success==1){
                        $("#tishi").text(data.msg);
                        $("#tishia").click();
                        $("#tijiaos").click(function () {
                            window.location.href=getRootPath()+"/admin/html/adminhtml/msgnotice.html";
                        });

                    }else{
                        $("#tishi").text(data.msg);
                        $("#tishia").click();
                    }
                }
            });
        });

    });
</script>



<script src="${pageContext.request.contextPath}/admin/js/common-scripts.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.scrollTo.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.sparkline.js" type="text/javascript"></script>
</html>
