<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 21.11.2018
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>

<body>


<div>

    <div>
        <div>
            <h2>Registration</h2>
        </div>

        <form method="post">
            <label>Login:
                <input type="text" name="login"><br />
            </label>
            <label>Password:
                <input type="text" name="password"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>

