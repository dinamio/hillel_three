<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihail
  Date: 11/11/18
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
    <link href="css/nicofog-style.css" rel="stylesheet">
</head>
<body class="masthead">
<c:set var="user" value="${sessionScope.get('login')}"/>
Hello <c:out value="${user.name}"/>
<br><br>
You status <c:out value="${user.role}"/><br>
your 20 sigarets cost <c:out value="${user.sigaretPrice}"/><br>
and create date accaunt: <c:out value="${user.dateRegistration}"/>

<!-- Navigation -->
<div class="menu" id="mainNav">
    <a href="/">main page</a>
</div>
</body>
</html>
