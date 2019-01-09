<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 21.11.2018
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-dark-grey">


<div>

    <div>
        <div>
            <h2>Registration</h2>
        </div>

        <form method="post">
            <label>Login:
                <input type="text" name="login" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>Password:
                <input type="text" name="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <div><button class="w3-btn w3-yellow w3-round-large" onclick="location.href='/main'">Complete Registration</button></div>
        </form>

    </div>
</div>

</body>
</html>

