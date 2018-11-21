<html>
<head>
    <script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>

    <link rel="stylesheet" type="text/css" href="css/login.css">
    <meta charset="UTF-8">
    <title>Servlet Login</title>
</head>
<body>
<div class="container">
    <div id="login-row" class="row justify-content-center align-items-center">
        <div id="login-column" class="col-md-6">
            <div class="box">
                <div class="shape1"></div>
                <div class="shape2"></div>
                <div class="shape3"></div>
                <div class="shape4"></div>
                <div class="shape5"></div>
                <div class="shape6"></div>
                <div class="shape7"></div>
                <div class="float">
                    <form class="form" method="post" action="login">
                        <div class="form-group">
                            <label for="username" class="text-white">Username:</label><br>
                            <input type="text" name="name" placeholder="admin" id="username" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="password" class="text-white">Password:</label><br>
                            <input type="text" name="pass" placeholder="admin" id="password" class="form-control">
                        </div>
                        <div class="form-group">
                            <input type="submit" name="submit" class="btn btn-info btn-md" value="LOGIN">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--<form method="post" action="login">
    User:<input type="text" name="name" placeholder="admin"/><br/>
    Password:<input type="text" name="pass" placeholder="admin"/><br/>
    <input type="submit" value="LOGIN" />
</form>-->
</body>
</html>
