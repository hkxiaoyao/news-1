<%--
  Created by IntelliJ IDEA.
  User: 平行时空
  Date: 2018/2/15
  Time: 0:04
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

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/admin/img/favicon.html">
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/css/bootstrap-reset.css" rel="stylesheet">
    <!--external css-->
    <link href="${pageContext.request.contextPath}/admin/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/admin/assets/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css" media="screen"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/admin/css/owl.carousel.css" type="text/css">
    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/admin/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/css/style-responsive.css" rel="stylesheet" />


    <script src="${pageContext.request.contextPath}/admin/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/pxsk.js"></script>
    <script src="${pageContext.request.contextPath}/admin/js/bootstrap.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 tooltipss and media queries -->
    <!--[if lt IE 9]>

    <script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>

    <![endif]-->
    <style type="text/css">
        .line-limit-length {

            max-width: 110px;

            overflow: hidden;

            text-overflow: ellipsis;

            white-space: nowrap; //文本不换行

        }
        .whites{
           color: white;
        }
    </style>
</head>
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
                        <li><a class="" href="${pageContext.request.contextPath}/admin/html/adminhtml/msgpublish.html">发布消息</a></li>
                        <li  class="active"><a class="" href="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html">新闻管理</a></li>

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
    <!--main content start 中心部分-->
    <section id="main-content">
        <section class="wrapper">
            <!-- page start-->
            <div class="row">
                <div class="col-lg-12">
                    <!--权限管理-->
                    <section class="panel">

                        <header class="panel-heading">
                            新闻管理
                            <div class="form-group row" style="text-align: right;" >
                                <label style="text-align: right;" class="col-sm-3 control-label">新闻分类</label>
                                <div class="col-lg-3">
                                    <select  class="form-control" onchange="javascript:location.href=this.value;">

                                        <option value="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html?type=0" selected="selected">全部</option>
                                        <c:forEach items="${types}" var="type">

                                            <c:choose>
                                                    <c:when test="${pageBean.typeid eq type.id}">
                                                        <option value="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html?type=${type.id}" selected="selected">${type.type}</option>
                                                    </c:when>
                                                <c:otherwise>
                                                    <option value="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html?type=${type.id}">${type.type}</option>
                                                </c:otherwise>
                                            </c:choose>
                                            </c:forEach>



                                    </select>
                                </div>

                            </div>
                        </header>
                        <div class="panel-body">
                            <form class="form-horizontal tasi-form" method="get">
                                <div class="form-group">
                                    <table class="table table-striped border-top" id="sample_1">
                                        <thead>
                                        <tr>
                                            <th>新闻标题</th>
                                            <th>发布时间</th>
                                            <th>新闻类型</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${pageBean.beanList}" var="news">
                                        <tr id="${news.id}" class="odd gradeX">
                                                <td class="center line-limit-length">
                                                    ${news.title}
                                                </td>
                                                <td class="center line-limit-length">日期: ${news.dates}</td>
                                                <td class="center line-limit-length">${pageBean.typename}</td>
                                                <td>

                                                    <label class="btn btn-warning btn-xs" value="编辑">
                                                        <a class="whites" href="${pageContext.request.contextPath}/admin/html/adminhtml/msgpublish.html?type=${news.type}&id=${news.id}">
                                                        <i class="icon-pencil "></i>
                                                        </a>
                                                    </label>


                                                    <label class="btn btn-danger btn-xs"  value="删除">
                                                        <a class="whites" name="deletenews" onclick='deletes(${news.id});'>
                                                            <i class="icon-trash"></i>
                                                        </a>
                                                    </label>

                                                </td>
                                        </tr>

                                        </c:forEach>

                                        </tbody>
                                    </table>



                                    <span class="pull-right">
		                                  <a data-toggle="modal" id="tishia" href="msgpublish.html#myModal" style="display: none"></a>
                                          <a data-toggle="modal" id="tishia1" href="msgpublish.html#myModal1" style="display: none"></a>
		                             </span>
                                </div>

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
                                                <button data-dismiss="modal"  class="btn btn-theme" type="button">取消</button>
                                                <button data-dismiss="modal" id="queding"  class="btn btn-theme btn-success" type="button">确定</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- modal -->                                <!-- Modal -->
                                <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal1" class="modal fade">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title">系统提示：</h4>
                                            </div>
                                            <div class="modal-body">
                                                <p id="tishi1"></p>

                                            </div>
                                            <div class="modal-footer">

                                                <button data-dismiss="modal" id="queding1"  class="btn btn-theme btn-success" type="button">确定</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- modal -->


                                <div class="form-group" style="text-align: center;">
                                    <div class="btn-row">

                                            <%--共有记录${pageBean.totalrecord}条，${pageBean.pagecode}/${pageBean.totalpage}页，--%>
                                            <label class="btn btn-primary">
                                                <a href ="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html?type=${pageBean.typeid}&currPage=1" style="color: white"> 首页</a>
                                            </label>

                                            <c:if test="${pageBean.pagecode>1}">
                                            <label class="btn btn-primary">
                                                <a href="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html?type=${pageBean.typeid}&currPage=${pageBean.pagecode-1}" style="color: white">上一页</a>
                                            </label>
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
                                                       <label class="btn btn-primary active" style="color: red">
                                                               ${i}
                                                       </label>

                                                    </c:when>
                                                    <c:otherwise>
                                                        <label class="btn btn-primary">
                                                            <a href="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html?type=${pageBean.typeid}&currPage=${i}" style="color: white">${i }</a>
                                                        </label>

                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>

                                            <c:if test="${pageBean.pagecode<pageBean.totalpage}">
                                            <label class="btn btn-primary">
                                                <a href="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html?type=${pageBean.typeid}&currPage=${pageBean.pagecode+1}" style="color: white">下一页</a>
                                            </label>
                                            </c:if>

                                            <label class="btn btn-primary">
                                            <a href ="${pageContext.request.contextPath}/admin/html/adminhtml/msgnotice.html?type=${pageBean.typeid}&currPage=${pageBean.totalpage}" style="color: white">尾页</a>

                                            </label>
                                        </div>
                                    </div>

                            </form>

                        </div>
                    </section>


                </div>
            </div>
            <!-- page end-->
        </section>
    </section>


    <!--main content end 中心部分-->

</section>

<!-- js placed at the end of the document so the pages load faster -->

<script src="${pageContext.request.contextPath}/admin/js/jquery.scrollTo.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery.sparkline.js" type="text/javascript"></script>

<!--common script for all pages-->
<script src="${pageContext.request.contextPath}/admin/js/common-scripts.js"></script>
<script>

    function deletes(id){
        var datas={};
        datas.id=id;
        $("#tishi").text("是否删除资源？");
        $("#tishia").click();
        $("#queding").click(function () {
            if(datas.id!=0){
                $.ajax({
                    type:'post',
                    url:getRootPath()+"/admin/html/adminhtml/deleteNews",
                    contentType:'application/json; charset=utf-8',
                    dataType:'json',
                    cache:false,
                    data:JSON.stringify(datas),
                    success:function (data) {
                        if(data.success==1){
                            //删除节点
                            $("tbody tr").remove("tr[id="+id+"]");
                            datas.id=0;
                        }else{
                            $("#tishi1").text(data.msg);
                            $("#tishia1").click();
                            datas.id=0;
                        }
                    },
                    error:function (data) {
                        $("#tishi1").text("删除失败，未知错误");
                        $("#tishia1").click();
                    }
                });

            }

        });



    }
</script>


</body>
</html>
