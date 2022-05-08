<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
            <div class="container" style="width: 20vw">
                <h1 class="text-center p-3" style="color: #eeeeea">Sign Up</h1>
                <form action="${pageContext.request.contextPath}/signUp" method="POST">
                    <div class="mb-3">
                        <input
                                type="text"
                                placeholder="Enter first name"
                                name="firstName"
                                class="form-control"
                                id="firstNameInput"
                                required>
                    </div>
                    <div class="mb-3">
                        <input
                                type="text"
                                placeholder="Enter last name"
                                name="lastName"
                                class="form-control"
                                id="lastNameInput"
                                required>
                    </div>
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
                    <input type="submit" class="btn btn-primary" value="Sign Up">
                </form>
                <p class="text-danger text-center">${error}</p>
                <a style="color: #eeeeea">Already have an account? </a>
                <a href="/signIn" class="link-primary">SignIn</a>
</t:template>