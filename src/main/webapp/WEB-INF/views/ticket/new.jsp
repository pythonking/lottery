<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>华泰CRM-编辑奖品</title>
    <%@ include file="../include/css.jsp" %>
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
                    <h3 class="box-title">新增优惠券</h3>
                    <div class="box-tools pull-right">
                        <a href="../ticketCount/list" class="btn btn-primary btn-sm"><i
                                class="fa fa-arrow-left"></i> 返回列表</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="newTicketForm" action="../ticketCount/add">
                        <input type="hidden" name="typeId" value="${ticketType.id}">
                        <input type="hidden" name="status" value="0">
                        <div class="form-group">
                            <label>奖品类型</label>
                            <input type="text" readonly="readonly" class="form-control" value="${ticketType.name}">
                        </div>
                        <div class="form-group">
                            <label>数量</label>
                            <input type="text" class="form-control" name="num">
                        </div>
                    </form>
                </div>
                <div class="box-footer">
                    <button class="btn btn-primary" id="newTicketBtn">保存</button>
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
<script src="../static/plugins/validate/jquery.validate.min.js"></script>
<script src="../static/plugins/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="../static/plugins/datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script>
    $(function () {
        $("#newTicketBtn").click(function () {
            $("#newTicketForm").submit();
        });

        $("#newTicketForm").validate({
            errorClass: "text-danger",
            errorElement: "span",
            rules: {
                num: {
                    required: true,
                    digits:true
                }
            },
            messages: {
                num: {
                    required: "请输入数量",
                    digits:"请输入正整数"
                }
            }
        });
    })
</script>
</body>
</html>
