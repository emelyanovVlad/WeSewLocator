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
                    <li data-target="/branches">Branches</li>
                    <li data-target="/questions">Questions</li>
                    <li data-target="/answers">Answers</li>
                    <li data-target="/organizations">Organizations</li>
                    <li data-target="/locations">Locations</li>
                    <li data-target="/services">Services</li>
                    <li data-target="/users">Users</li>
                    <li data-target="/roles">Roles</li>
                </ul>
            </div>
        </div>
    </div>
    <div class="admin-content">
        <div class="data" id="data">
            <table class="table table-striped table-hover table-bordered">
                <thead>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>
<ctag:footer/>
</body>
</html>