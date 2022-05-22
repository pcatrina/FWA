<%@tag description="page tmplate Tag" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%--    <title>Sign In</title>--%>
<%--    TODO: add title to template--%>
    <style>
        body {
            background: #000000;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
    <body>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/prettycss/index.css">
    <script src="${pageContext.request.contextPath}/static/js/particles.js"></script>
    <script type="text/javascript">
        particlesJS.load('particles-js', '/static/assets/particles.json', function () {
            console.log('callback - particles.js config loaded');
        });
    </script>
    <div id="particles-js"></div>
    <div id="page-wrapper">
        <div class="container h-100">
            <div class="row h-100 justify-content-center align-items-center">
                <jsp:doBody/>
            </div>
        </div>
    </div>
    </body>
</html>