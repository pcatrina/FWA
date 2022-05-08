<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Sign In</title>
    <style>
        body {
            background: #000000;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<script src="${pageContext.request.contextPath}/static/js/particles.js"></script>
<script type="text/javascript">
    particlesJS.load('particles-js', '/static/assets/particles.json', function () {
        console.log('callback - particles.js config loaded');
    });
</script>

<div id="particles-js"></div>
<div id="page-wrapper">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/prettycss/index.css">

    <div class="container h-100">
        <div class="row h-100 justify-content-center align-items-center">
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
        </div>
    </div>

</div>
</body>
</html>