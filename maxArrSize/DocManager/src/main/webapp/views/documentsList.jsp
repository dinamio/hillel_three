<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Documents</title>
</head>
<body>
<table border="2">
    <tr>
        <th>Документ</th>
        <th>Дата добавления</th>
    </tr>
    <c:forEach var="doc" items="${docs}">
        <tr>
            <td><c:out value="${doc.name}"/></td>
            <td><c:out value="${doc.date}"/></td>
            <td>
                <form action="/documentsList" method="post">
                    <input type="hidden" name="doc" value="${doc.name}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>
<h5>Для добавления нового документа введите название и нажмите "Добавить"...</h5>
<form action="/documentsList" method="post">
    <input required type="text" name="name" placeholder="Название документа">
    <input required type="date" name="date" placeholder="дата">

    <input type="submit" value="Добавить">
</form>
</body>
</html>
