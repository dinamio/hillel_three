<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mihail
  Date: 11/10/18
  Time: 9:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user page</title>
</head>
<body>
Edit <c:out value='${sessionScope.get("user-edit").name}'/> profile
<form action="/user-edit/" method="post">
  <input type="hidden" name="id" value="<c:out value='${sessionScope.get("user-edit").id}'/>">
  Name: <input type="text" name="userName" placeholder="<c:out value='${sessionScope.get("user-edit").name}'/>">
<br>  Role: <input type="text" name="role" placeholder="<c:out value='${sessionScope.get("user-edit").role}'/>">
<br>  Cigaret price: <input type="text" value="0" name="price" placeholder="<c:out value='${sessionScope.get("user-edit").sigaretPrice}'/>">
<br>  <input type="submit" value="Edit">
</form>
</body>
</html>
