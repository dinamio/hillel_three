<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
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

    </div>
    <%
        List<String> names = (List<String>) request.getAttribute("documentNames");

        if (names != null && !names.isEmpty()) {
            out.println("<ul class=\"w3-ul\">");
            for (String s : names) {
                out.println("<li class=\"w3-hover-sand\">" + s + "</li>");
            }
            out.println("</ul>");

        } else out.println("<div class=\"w3-panel w3-red w3-display-container w3-card-4 w3-round\">\n"
                +
                "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" +
                "   <h5>There are no users yet!</h5>\n" +
                "</div>");
    %>
</div>

        <c:if test="${names != null}">
            <c:forEach items="${names}" var="documentNames">
                <p>${names}.</p>
            </c:forEach>
        </c:if>


    </div>
</div>

<div>
    <button onclick="location.href='/'">Back to main</button>
</div>
</body>
</html>

