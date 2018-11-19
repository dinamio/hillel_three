<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 18.11.2018
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Documents list</title>
</head>
<body>
<div>
    <h1>First servlet!</h1>
</div>

<div>
    <div>
        <div>
            <h2>Documents</h2>
        </div>
        <%
            List<String> names = (List<String>) request.getAttribute("documentNames");

            if (names != null && !names.isEmpty()) {
                out.println("<ui>");
                for (String s : names) {
                    out.println("<li>" + s + "</li>");
                }
                out.println("</ui>");
            } else out.println("<p>There are no docs yet!</p>");
        %>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
