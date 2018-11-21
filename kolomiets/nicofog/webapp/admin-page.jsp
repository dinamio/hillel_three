<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
 JSP admin page
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
    <link href="css/nicofog-style.css" rel="stylesheet">
</head>
<body class="masthead">

<c:if test="${sessionScope.get('crud-result') != null}">
    <c:out value="${sessionScope.get('crud-result')}"/>
</c:if>

<form action="/user-add" method="post">
    <input type="text" name="username" placeholder="Input user name">
    <input type="submit" value="Add in base">
</form>
<form action="user-get-all">
    <input type="submit" value="Get all">
</form>

<div style="text-align: center">
    <div id="result"></div>
    <c:forEach var="user" items="${sessionScope.get('all-users')}">

        <div id="user-${user.id}">
            <c:out value="${user.name}"/>
            <a href="<c:url value="user-edit/${user.id}"/>">edit</a>
            <a href="#" onclick="userDelete(${user.id},'${user.name}')">delete</a>
        </div>

    </c:forEach>
</div>
<!-- Navigation -->
<div class="menu" id="mainNav">
    <a href="/">main page</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="js/admin.js"></script>
</body>
</html>
