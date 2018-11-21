<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 18.11.2018
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new document</title>
</head>

<body>


<div>
    <%
        if (request.getAttribute("documentName") != null) {
            out.println("<p>Document '" + request.getAttribute("documentName") + "' deleted!</p>");
        }
    %>
    <div>
        <div>
            <h2>Delete document</h2>
        </div>

        <form action="/delete" method="post">
        <input type="hidden" name="id" value="delete">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Удалить">
        </form>

    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>


