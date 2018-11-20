<%--
  Created by IntelliJ IDEA.
  User: Klimenko
  Date: 19.11.2018
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Index Page"/>
        <jsp:param name="content" value="/index/index-content"/>
    </jsp:include>

</head>
<body>
<form method="POST" action="/Appartments">
    <table border="0" class="table table-hover">
        <tr>
            <td>Адрес</td>
            <td><input autocomplete="off" type="text" name="address" value="${appartment.address}" /></td>
        </tr>
        <tr>
            <td>Тип</td>
            <td>
                <%--<input autocomplete="off" type="text" name="typeEstate" value="${appartment.typeEstate}" />--%>
            <select name="typeEstate" type="text">
                <option value="Квартира">Квартира</option>
                <option value="Дом">Дом</option>
                <option value="Нежилой фонд">Нежилой фонд</option>
            </select>
            </td>
        </tr>
        <tr>
            <td>Этаж</td>
            <td><input pattern="^[ 0-9]+$" autocomplete="off" type="text" name="floor" value="${appartment.floor}" /></td>
        </tr>
        <tr>
            <td>Количество комнат</td>
            <td><input pattern="^[ 0-9]+$" autocomplete="off" type="text" name="countOfRoom" value="${appartment.countOfRoom}" /></td>
        </tr>
        <tr>
            <td>Размер</td>
            <td><input pattern="^[ 0-9]+$" autocomplete="off" type="text" name="size" value="${appartment.size}" /></td>
        </tr>
        <tr>
            <td>Дополнительня информация</td>
            <td><input autocomplete="off" type="text" name="additionalDescription" value="${appartment.additionalDescription}" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" class="btn btn-primary" value="Добавить" />
                <a href="/allApartments.jsp">Отменить</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
