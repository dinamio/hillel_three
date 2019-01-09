<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 29.12.2018
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>My Account</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body class="w3-deep-orange">

<form method="post" class="w3-selection w3-deep-orange w3-padding">
    <label>Login:
        <input type="text" name="login"  class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
    </label>
    <label>Password:
        <input type="text" name="password" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
    </label>
    <label>

    <div>

        <button class="w3-btn w3-yellow w3-round-large" onclick="location.href='/main'">Log in</button>
    </div>
    </label>
</form>
</body>
</html>
