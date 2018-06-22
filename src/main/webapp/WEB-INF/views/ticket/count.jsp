<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>华泰CRM-优惠券统计</title>
    <%@ include file="../include/css.jsp" %>
    <style>
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
        <jsp:param name="menu" value="ticketCount"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Main content -->
        <section class="content">

            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border">
                    <h3 class="box-title">优惠券统计</h3>
                </div>
                <div class="box-body no-padding">
                    <table class="table table-hover">
                        <tbody>
                        <tr>
                            <th>奖品名称</th>
                            <th>卡券数量</th>
                            <th>卡券状态</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${ticketDTOList}" var="ticketDTO">
                            <tr class="dataRow" rel="${ticketType.id}">
                                <td>${ticketDTO.typeName}</td>
                                <td>${ticketDTO.num}</td>
                                <c:if test="${ticketDTO.status == 1}">
                                    <td><span style="color:#369">已占用</span></td>
                                </c:if>
                                <c:if test="${ticketDTO.status == 2}">
                                    <td><span style="color:#F00">已使用</span></td>
                                </c:if>
                                <c:if test="${ticketDTO.status == 0}">
                                    <td><span>未用</span></td>
                                </c:if>
                                <td><a href="../ticketCount/${ticketDTO.typeId}" class="btn btn-success btn-sm"><i
                                        class="fa fa-plus"></i>新增卡券</a></td>
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
</script>
</body>
</html>
