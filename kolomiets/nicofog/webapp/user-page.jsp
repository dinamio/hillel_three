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
your 20 cigarettes cost <c:out value="${user.cigarettePrice}"/><br>
money ${user.money/100}

<div class="smoke-info">
    <div id="trow"></div>
    <button id="smoke">Smoke</button>
    <div id="time">${user.cigarette.lastSmokeTime}</div>
    <div id="count">You smoke ${user.cigarette.allCigarettesSmoke} cigarettes for ${user.cigarettePrice*user.cigarette.allCigarettesSmoke/20} money</div>
    <div id="economy">${user.cigarette.oneSecondEconomy}</div>
</div>

<!-- Navigation -->
<div class="menu" id="mainNav">
    <a href="/login">exit</a>
    | <a href="user-edit/${user.id}">edit (sample)</a>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/user-page.js"></script>
</body>
</html>
