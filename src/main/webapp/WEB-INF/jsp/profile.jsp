<%@ page import="edu.school21.cinema.models.Image" %>
<%@ page import="edu.school21.cinema.models.User" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:template>

    <script>
        function triggerInput() {
            document.getElementById('inputFile').click();
        }

        function inputImage(event) {
            if (event.target.files[0]) {
                document.getElementById('image').src = URL.createObjectURL(event.target.files[0]);
                // document.getElementById("add-icon").style.display = "none";
                document.getElementById("uploadbtn").disabled = false;
            }
        }
    </script>



<%--  <%=List<Image> userImages = (List<Image>) request.getAttribute("userImages");%>--%>

<%--        User user = (User) request.getAttribute("loginedUser");--%>


<%--    <c:if test="${loginedUser.getImageId != null}">--%>
<%--        <c:set var = "userImage"--%>
<%--                value= "/images/${loginedUser.getImageId()}"--%>
<%--               scope = "session"--%>
<%--        />--%>
<%--    </c:if>--%>


    <div class="card special-card">
        <div class="card-body g-2">
            <div class="row">
                <div class="col-4 text-center">

                    <img id="image" onclick="triggerInput()"
                         src= "${loginedUser.getImageId()==null? "/static/assets/images/placeholder.png" : "/images/".concat(loginedUser.getImageId().toString())}"  class="img-fluid"
                         alt="placeholder">

                    <form class="" action="${pageContext.request.contextPath}/images" method="POST"
                          enctype="multipart/form-data">
                        <input id="inputFile" style="display: none" type="file" name="uploadedImage"
                               onchange="inputImage(event)" accept="image/*">
                        <button id="uploadbtn" class="btn btn-secondary mt-2" type="submit" disabled>Upload</button>
                            <%--                        <input  type="submit" class="btn btn-primary" value="Upload" disabled>--%>
                    </form>
                    <p class="text-danger text-center">${upload_error}</p>
                </div>
                <div class="col-8">
                    <p> Hello, i'm ${loginedUser.getFirstName()} ${loginedUser.getLastName()}</p>
                    <div class="fwa-list">
                        <table>
                            <tr>
                                <th>Date</th>
                                <th>Time</th>
                                <th>IP</th>
                            </tr>
                                <%--                <c:forEach var="s" items="<%= userSessions %>">--%>
                                <%--                    <tr>--%>
                                <%--                        <td>${s.date}</td>--%>
                                <%--                        <td>${s.time}</td>--%>
                                <%--                        <td>${s.ip}</td>--%>
                                <%--                    </tr>--%>
                                <%--                </c:forEach>--%>
                        </table>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <div class="fwa-list">
                        <table>
                            <tr>
                                <th>File name</th>
                                <th>Size</th>
                                <th>MIME</th>
                            </tr>
                                <c:forEach  items="${userImages}" var="img">
                                    <tr>
                                        <td>
                                            <a href="/images/${img.getId()}">${img.getFilename()}</a>
                                        </td>
                                        <td> <c:out value ="${img.size}"/></td>
                                        <td> <c:out value ="${img.mime}"/></td>
                                    </tr>
                                </c:forEach>
                        </table>
                    </div>
                </div>

            </div>
        </div>
    </div>


    <a href="${pageContext.request.contextPath}/logOut" class="link-primary">LogOut</a>
</t:template>