<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/dir/page.jspf" %>
<%@ include file="/WEB-INF/pages/dir/libs.jspf" %>
<html>

<ctag:head/>
<body>
<div class="back-holder">
    <div class="transparent-cover">
        <div class="form-container">
            <form name="loginForm" class="form-horizontal" method="POST" action="/login">
                <fieldset>
                    <div class="form-group">
                        <input class="form-control" type="text" name="login" placeholder="Login">
                    </div>
                    <div class="form-group">
                        <input class="form-control" type="password" name="password" placeholder="Password">
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