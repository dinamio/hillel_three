<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 11/7/18
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    Hello, <%out.print(session.getAttribute("user"));%>
    <c:forEach var="pet" items="${pets}">
        <c:out value="${pet.name}"/>
        <c:out value="${pet.age}"/>
        <br/>
    </c:forEach>

</body>
</html>
