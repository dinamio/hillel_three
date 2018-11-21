<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 19.11.2018
  Time: 21:12
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
            out.println("<p>Document '" + request.getAttribute("documentName") + "' added!</p>");
        }
    %>
    <div>
        <div>
            <h2>Add document</h2>
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
