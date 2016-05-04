<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/dir/page.jspf" %>
<%@ include file="/WEB-INF/pages/dir/libs.jspf" %>
<html>
<ctag:head/>
<body>
<div class="back-holder">
    <div class="transparent-cover">
        <div class="form-container">
            <form class="form-horizontal" method="POST" action="/perform_login">
                <fieldset>
                    <div class="form-group">
                        <input class="form-control" id="loginId" type="text" name="login" placeholder="Login">
                    </div>
                    <div class="form-group">
                        <input class="form-control" id="password" type="text" name="password" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary full-width" type="submit">Go on</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>