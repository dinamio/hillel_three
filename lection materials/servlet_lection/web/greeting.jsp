<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 11/7/18
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    Hello, <%out.print(session.getAttribute("user"));%>

</body>
</html>
