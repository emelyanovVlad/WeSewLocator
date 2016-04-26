<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/pages/dir/page.jspf" %>
<%@ include file="/WEB-INF/pages/dir/libs.jspf" %>
<html>
<ctag:head/>
<body>
<div class="back-holder">
    <div class="transparent-cover">
        <div class="form-container">
            <form>
                <fieldset>
                    <legend>
                        Login
                    </legend>
                    <label for="loginId">Login</label>
                    <input id="loginId" type="text" name="login">
                    <label for="passwordId">Password</label>
                    <input id="passwordId" type="text" name="password">
                    <input type="submit" value="Go on">
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>