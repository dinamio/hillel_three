<%--
  Created by IntelliJ IDEA.
  User: Klimenko
  Date: 04.12.2018
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>

    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Index Page"/>
    <jsp:param name="content" value="/index/index-content"/>
</jsp:include>
<%
    if (request.getAttribute("UserExist") != null) {
        out.print("This user is already exist");
        request.setAttribute("UserExist", false);
    }
%>
<form:form method="POST" action="/UserController" modelAttribute="User">

<form:label path="name" for="name"> Name <input type="text" class="form-control" id="name" required></form:label><br>
<form:label path="email" for="email"> E-mail <input type="text" id="email" class="form-control" required></form:label><br>
<form:label path="password" for="password"> Password <input type="password" id="password" class="form-control" required></form:label>
<br>
    <input type="submit" class="btn btn-primary" value="Зарегистрироваться"/>
</form:form>
</body>
<script src="js/main.js">
</script>
</html>