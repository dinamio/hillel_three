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
<form:form method="POST" action="/UserController" modelAttribute="user">

    <label for="name"> Name <form:input path="name" type="text" class="form-control"/>
    </label><br>
    <label for="email"> E-mail <form:input path="email" type="text" id="email" class="form-control"/> </label><br>
    <label for="password"> Password <form:input path="password" type="password" id="password"
                                                class="form-control"/></label>
    <br>
    <input type="submit" class="btn btn-primary" value="Зарегистрироваться"/>
</form:form>

</body>
<script src="js/main.js">
</script>
</html>