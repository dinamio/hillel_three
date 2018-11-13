<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 11/7/18
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>My Fabulous Application</h1>
<c:forEach var="fruit" items="request.getAttributes"fruits)">

    <c:out value="${fruit}"/>
</c:forEach>
<form action="/registration" method="post">
    Введите ваше имя: <input name="first_name">
    <button> Отправить</button>
</form>
</body>
</html>
