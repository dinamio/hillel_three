<%--
  Created by IntelliJ IDEA.
  User: Klimenko
  Date: 04.12.2018
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Index Page"/>
    <jsp:param name="content" value="/index/index-content"/>
</jsp:include>
<label for="name"> Name <input type="text" class="form-control" id="name" required></label><br>
<label for="password"> Password <input type="password" id="password" class="form-control" required></label>
<br>
<button id="login-btn" class="btn btn-primary">
    Войти
</button>
</body>
</html>
