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
                    <h3 class="box-title">编辑奖品</h3>
                    <div class="box-tools pull-right">
                        <a href="../ticketType/list" class="btn btn-primary btn-sm"><i
                                class="fa fa-arrow-left"></i> 返回列表</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="newTicketTypeForm" action="../ticketType/add">
                        <div class="form-group">
                            <label>名称</label>
                            <input type="text" class="form-control" name="name">
                        </div>
                        <div class="form-group">
                            <label>状态</label>
                            <div>
                                <label class="radio-inline"><input type="radio" name="status" value=1>使用</label>
                                <label class="radio-inline"><input type="radio" checked name="status" value=0>禁用</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>总数量</label>
                            <input type="text" class="form-control" name="totalNum">
                        </div>
                        <div class="form-group">
                            <label>每日数量</label>
                            <input type="text" class="form-control" name="daliyNum">
                        </div>
                        <div class="form-group">
                            <label>每日最大数量</label>
                            <input type="text" class="form-control" name="daliyNumMax">
                        </div>
                        <div class="form-group">
                            <label>权重</label>
                            <input type="text" class="form-control" name="probability">
                        </div>
                        <div class="form-group">
                            <label>备注</label>
                            <input type="remark" name="remark" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>开始时间</label>
                            <input type="startTime" name="startTime" class="form-control timePicker">
                        </div>
                        <div class="form-group">
                            <label>结束时间</label>
                            <input type="endTime" name="endTime" class="form-control timePicker">
                        </div>
                        <div class="form-group">
                            <label>开始使用时间</label>
                            <input type="useStartTime" name="useStartTime" class="form-control timePicker">
                        </div>
                        <div class="form-group">
                            <label>结束使用时间</label>
                            <input type="useEndTimeStr" name="useEndTime" class="form-control timePicker">
                        </div>
                    </form>
                </div>
                <div class="box-footer">
                    <button class="btn btn-primary" id="newTicketTypeBtn">保存</button>
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
        var timepicker = $('.timePicker').datetimepicker({
            format: "yyyy-mm-dd hh:ii:ss",
            language: "zh-CN",
            autoclose: true,
            todayHighlight: true
        });
        $("#newTicketTypeBtn").click(function () {
            $("#newTicketTypeForm").submit();
        });

        $("#newTicketTypeForm").validate({
            errorClass: "text-danger",
            errorElement: "span",
            rules: {
                name: {
                    required: true
                },
                remark: {
                    required: true
                }
            },
            messages: {
                name: {
                    required: "请输入名称"
                },
                remark: {
                    required: "请输入备注"
                }
            }
        });
    })
</script>
</body>
</html>
