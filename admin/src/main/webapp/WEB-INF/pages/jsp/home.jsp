<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/dir/page.jspf" %>
<%@ include file="/WEB-INF/pages/dir/libs.jspf" %>
<html>
<c:set var="title" scope="page" value="Home | WeSeW Locator"/>
<ctag:head/>
<body>
<div class="screen-content">
    <div class="sidebar">
        <div class="full-width user-info">
            <div class="sidebar-avatar">
                <img src="/clientlibs/img/def-ava.png"/>
            </div>
            <div class="sidebar-personal">
                <h4>${loggedUser.fullName}</h4>
            </div>
        </div>
        <div class="full-width menu-holder">
            <div class="menu">
                <ul>
                    <sec:authorize access="hasAnyRole('HEADADMIN', 'ADMIN', 'DATAMANAGER')">
                        <li data-target="/categories" data-form="category_create">Categories</li>
                        <li data-target="/branches">Branches</li>
                        <li data-target="/questions">Questions</li>
                        <li data-target="/answers">Answers</li>
                        <li data-target="/organizations">Organizations</li>
                        <li data-target="/locations">Locations</li>
                        <li data-target="/services" data-form="service_create">Services</li>
                    </sec:authorize>
                    <sec:authorize access="hasRole('HEADADMIN')">
                        <li data-target="/users" data-form="user_create">Users</li>
                        <li data-target="/roles" data-form="role_create">Roles</li>
                    </sec:authorize>
                </ul>
            </div>
        </div>
    </div>
    <div class="admin-content">
        <div class="options">
            <button class="btn btn-default btn-xs" id="create_button">Create</button>
        </div>
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
<div id="create_forms">
    <formc:role/>
    <formc:user/>
    <formc:service/>
    <formc:category/>
</div>
</body>
</html>