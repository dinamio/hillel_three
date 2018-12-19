<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 11/21/17
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>Servers</title>
  </head>
  <body>
  <c:if test="${not empty servers}">

    <ul>
      <c:forEach var="server" items="${servers}">
        <li>${server.name}, ${server.description}</li>
      </c:forEach>
    </ul>

  </c:if>
  <a href="/server/add">Добавить сервер</a>

  </body>
</html>
