<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:template>
    <div class="card-body">
        <h1 class="text-center p-3" style="color: #eeeeea">Profile</h1>
    </div>
    <a href="${pageContext.request.contextPath}/logOut" class="link-primary">LogOut</a>
</t:template>