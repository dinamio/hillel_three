<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 11/21/17
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Servers</title>
    <link href="/res/style.css" rel="stylesheet">
</head>
<body>
<h1><spring:message key="title"/></h1>
<p>Hello, ${user}</p>
<c:if test="${not empty servers}">

    <ul>
        <c:forEach var="server" items="${servers}">
            <li>${server.name}, ${server.description}</li>
        </c:forEach>
    </ul>

</c:if>
<form:form action="/upload" method="post" enctype="multipart/form-data">
    <input name="file" type="file">
    <button type="submit">Загрузить!</button>
</form:form>
<a href="/server/add"><spring:message key="server.add"/> </a>
<a href="?locale=ru">Switch to RU</a>
<a href="?locale=en">Switch to EN</a>
</body>
</html>
