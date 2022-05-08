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
                document.getElementById("add-icon").style.display = "none";
                document.getElementById("uploadbtn").disabled = false;
            }
        }
    </script>


    <%--    <div class="card-body">--%>
    <%--        <h1 class="text-center p-3" style="color: #eeeeea">Profile</h1>--%>
    <%--    </div>--%>


    <div class="card special-card">
        <div class="card-body row g-2">
            <div class="col-4">
                <div class="container">
                    <div id="fileSelect" onclick="triggerInput()" class="image-preview border border-primary rounded">
                        <i id="add-icon" class="add-icon">+</i>
                        <img id="image" class="image" alt="" src="">
                    </div>
                    <form class="upload-form col-4" action="/cinema/images" method="POST" enctype="multipart/form-data">
                        <input id="inputFile" style="display: none" type="file" name="fileToUpload"
                               onchange="inputImage(event)" accept="image/*">
                        <button id="uploadbtn" class="btn btn-primary  btn-lg btn-block btn-full" type="submit" disabled>Upload</button>
<%--                        <input  type="submit" class="btn btn-primary" value="Upload" disabled>--%>
                    </form>
                </div>
            </div>
            <div class="col">
                <p> Hello, i'm ......</p>
                <div class="sessions-list">
                    <p class="table-label">Sessions</p>
                    <hr>
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

            <div class="images-list">
                <p class="table-label">Images</p>
                <hr>
                <table>
                    <tr>
                        <th>File name</th>
                        <th>Size</th>
                        <th>MIME</th>
                    </tr>
                        <%--                <c:forEach var="f" items="<%= imageFiles %>">--%>
                        <%--                    <tr>--%>
                        <%--                        <td><a href="/cinema/images/${f.uuid.toString()}">${f.name}</a></td>--%>
                        <%--                        <td>${f.size}</td>--%>
                        <%--                        <td>${f.mime}</td>--%>
                        <%--                    </tr>--%>
                        <%--                </c:forEach>--%>
                </table>
            </div>
        </div>
    </div>


    <a href="${pageContext.request.contextPath}/logOut" class="link-primary">LogOut</a>
</t:template>