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
    <title>Delete document</title>
</head>


<body>
<div>
    <h1>First servlet!</h1>
</div>

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

        <form method="post">
            <label>Name:
                <input type="text" name="name"><br />
            </label>
            <label>Date:
                <input type="text" name="date"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>
