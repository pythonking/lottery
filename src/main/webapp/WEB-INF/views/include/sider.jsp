<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 左侧菜单栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- 菜单 -->
        <ul class="sidebar-menu">
            <li class="${param.menu == 'home' ? 'active' : ''}"><a href="../ticketType/list"><i
                    class="fa fa-home"></i> <span>首页</span></a></li>
            <li class="header">系统功能</li>
            <!-- 奖品管理 -->
            <li class="${param.menu == 'ticketType_my' ? 'active' : ''}"><a href="../ticketType/list"><i class="fa fa-address-book-o"></i> <span>奖品管理</span></a></li>

            <!-- 优惠券统计 -->
            <li class="${param.menu == 'ticketCount' ? 'active' : ''}"><a href="../ticketCount/list"><i class="fa fa-calculator"></i> <span>优惠券统计</span></a></li>

            <!-- 登录分享管理 -->
            <li class="${param.menu == 'control_my' ? 'active' : ''}"><a href="../control/list"><i class="fa fa-share-alt"></i> <span>登录分享管理</span></a></li>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>