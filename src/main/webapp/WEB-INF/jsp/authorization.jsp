<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
<div class="container" style="width: 20vw">
    <h1 class="text-center p-3" style="color: #eeeeea">Sign In</h1>
    <form action="${pageContext.request.contextPath}/signIn" method="POST">
        <div class="mb-3">
            <input
                    type="tel"
                    placeholder="Enter phone number"
                    name="phone"
                    class="form-control"
                    id="phoneNumberInput"
                    required>
        </div>
        <div class="mb-3">
            <input
                    type="password"
                    placeholder="Enter password"
                    name="password"
                    class="form-control"
                    id="passwordInput"
                    required>
        </div>
        <input type="submit" class="btn btn-primary" value="Sign In">
    </form>
    <p class="text-danger text-center">${error}</p>
    <a href="/signUp" class="link-primary">Create account</a>
</div>
</t:template>