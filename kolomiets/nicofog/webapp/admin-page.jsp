<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihail
  Date: 11/10/18
  Time: 5:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
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
<c:forEach var="user" items="${sessionScope.get('all-users')}">
    <div>
        <c:out value="${user.name}"/>
        <a href="<c:url value="user-edit/${user.id}"/>">edit</a>
        <a href="<c:url value="user-delete/${user.id}"/>">delete</a>
    </div>

</c:forEach>
</body>
</html>
