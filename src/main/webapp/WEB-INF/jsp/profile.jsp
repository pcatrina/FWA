<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
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


    <%--    <div class="card-body">--%>
    <%--        <h1 class="text-center p-3" style="color: #eeeeea">Profile</h1>--%>
    <%--    </div>--%>


    <div class="card special-card">
        <div class="card-body g-2">
            <div class="row">
                <div class="col-4 text-center">

                    <img id="image" onclick="triggerInput()"
                         src="${pageContext.request.contextPath}/static/assets/images/placeholder.png" class="img-fluid"
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
                    <p> Hello, i'm ......</p>
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
<%--                            <% Object userImages = request.getAttribute("userImages"); %>--%>
                                <c:forEach items="${userImages}" var="img" >
                                    <tr>
                                        <td>
                                            <a href="/images/${img.id}">${img.fileName}</a>
                                        </td>
                                        <td>${img.size}</td>
                                        <td>${img.mime}</td>
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