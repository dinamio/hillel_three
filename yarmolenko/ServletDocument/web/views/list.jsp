<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 03.01.2019
  Time: 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Documents list</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">

<div class="w3-container w3-center w3-margin-bottom w3-padding">
    <div class="w3-card-4">
        <div class="w3-container w3-light-blue">
            <h2>Documents</h2>
        </div>

    </div>

    <c:forEach var="document" items="${documents}">
        <tr>
            <td><c:out value="${document.id}" /></td>
            <td><c:out value="${document.title}" /></td>
            <td><c:out value="${document.author}" /></td>
            <td><c:out value="${document.price}" /></td>
        </tr>
    </c:forEach>
</div>


<div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
    <button class="w3-btn w3-round-large" onclick="location.href='/main'">Back to main</button>
</div>
</body>
</html>