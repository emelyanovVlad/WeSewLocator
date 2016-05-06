<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/dir/page.jspf" %>
<%@ include file="/WEB-INF/pages/dir/libs.jspf" %>
<html>
<ctag:head/>
<body>
<div class="screen-content">
    <div class="sidebar">
        <div class="full-width user-info">
            <div class="sidebar-avatar">
                <img src="/clientlibs/img/def-ava.png"/>
            </div>
            <div class="sidebar-personal">
                <h4>Vladyslav Yemelianov</h4>
            </div>
        </div>
        <div class="full-width menu-holder">
            <div class="menu">
                <ul>
                    <li class="active">Home</li>
                    <li data-target="/categories">Categories</li>
                    <li data-target="/categories">Branches</li>
                    <li data-target="/categories">Questions</li>
                    <li data-target="/categories">Answers</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="admin-content">
        <div class="options">

        </div>
        <div class="data">
            <table class="table table-striped table-hover table-bordered" id="example">
                <thead>
                <tr>
                    <th>Sites</th>
                    <th>Names</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>SitePoint</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Learnable</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>
                <tr>
                    <td>Flippa</td>
                    <td>SitePoint</td>
                </tr>

                </tbody>
            </table>

        </div>

    </div>
</div>
<script>
  $(function(){
    $("#example").dataTable();
  })
</script>
<ctag:footer/>
</body>
</html>