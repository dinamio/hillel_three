<%--
  Created by IntelliJ IDEA.
  User: Алёна
  Date: 12.11.2018
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show documents</title>
</head>
<body>
<h1>Documents</h1>

<c:forEach items='<%= request.getAttribute("documents") %>' var="doc">
    <p> Document id:${doc.getId()}, name:${doc.getName()}, date:${doc.getDate()}</p>
</c:forEach>
<a href="/">add new document</a>
</body>
</html>
