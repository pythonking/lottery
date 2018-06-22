<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>华泰CRM-奖品设置</title>
    <%@ include file="../include/css.jsp" %>
    <style>
        .name-avatar {
            display: inline-block;
            width: 50px;
            height: 50px;
            background-color: #ccc;
            border-radius: 50%;
            text-align: center;
            line-height: 50px;
            font-size: 24px;
            color: #FFF;
        }

        .table > tbody > tr:hover {
            cursor: pointer;
        }

        .table > tbody > tr > td {
            vertical-align: middle;
        }
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@ include file="../include/header.jsp" %>
    <!-- =============================================== -->

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="ticketType_my"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">奖品设置</h3>
                    <div class="box-tools pull-right">
                        <a href="../ticketType/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i>新增奖品</a>
                    </div>
                </div>
                <div class="box-body no-padding">
                    <table class="table table-hover">
                        <tbody>
                        <tr>
                            <th>名称</th>
                            <th>总数量</th>
                            <th>每天数量</th>
                            <th>开始时间</th>
                            <th>结束时间</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                        <c:if test="${empty ticketTypeList}">
                            <tr>
                                <td colspan="6">还没有奖品，可以 <a href="../ticketType/new">新增奖品</a></td>
                            </tr>
                        </c:if>
                        <c:forEach items="${ticketTypeList}" var="ticketType">
                            <tr class="dataRow" rel="${ticketType.id}">
                                <td>${ticketType.name}</td>
                                <td>${ticketType.totalNum}</td>
                                <td>${ticketType.daliyNum}</td>
                                <td><fmt:formatDate value="${ticketType.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <td><fmt:formatDate value="${ticketType.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                <c:if test="${ticketType.status == 1}">
                                    <td><span>使用</span></td>
                                </c:if>
                                <c:if test="${ticketType.status == 0}">
                                    <td><span style="color:#F00">已禁用</span></td>
                                </c:if>
                                <td>
                                    <a href="../ticketType/${ticketType.id}" class="btn bg-purple btn-sm"><i class="fa fa-pencil"></i>
                                        编辑</a>
                                    <c:if test="${ticketType.status == 1}">
                                        <button id="forbiddenBtn" class="btn btn-danger btn-sm"
                                                onclick="del(${ticketType.id},0)"><i
                                                class="fa fa-trash-o"></i>禁用
                                        </button>
                                    </c:if>
                                    <c:if test="${ticketType.status == 0}">
                                        <button id="forbiddenBtn" class="btn bg-green-active btn-sm"
                                                onclick="del(${ticketType.id},1)"><i
                                                class="fa fa-trash-o"></i>启用
                                        </button>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- 底部 -->
    <%@ include file="../include/footer.jsp" %>

</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp" %>
<script src="../static/plugins/layer/layer.js"></script>
<script>
    function del(id, status) {
        if (status == 1) {
            window.location.href = "../ticketType/forbidden/?id=" + id + "&status=" + status;
        } else {
            layer.confirm("确定要禁用吗?", function (index) {
                layer.close(index);
                window.location.href = "../ticketType/forbidden/?id=" + id + "&status=" + status;
            });
        }
    }
</script>
</body>
</html>
