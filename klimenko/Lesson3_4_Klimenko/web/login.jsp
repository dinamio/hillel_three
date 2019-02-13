<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<form:form method="POST" action="/UserController/login" modelAttribute="user">
    <%--modelAttribute="user">--%>

<label for="name"> Name <form:input path="name" type="text" class="form-control" id="name"/></label><br>
<label for="password"> Password <form:input path="password" type="password" id="password" class="form-control"/></label>
<br>
<button type="submit" id="login-btn" class="btn btn-primary">
    Войти
</button>

</form:form>

</body>
</html>
