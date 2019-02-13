<%--
  Created by IntelliJ IDEA.
  User: Klimenko
  Date: 19.11.2018
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <jsp:include page="header.jsp">
        <jsp:param name="title" value="Index Page"/>
        <jsp:param name="content" value="/index/index-content"/>
    </jsp:include>

</head>
<body>
<<<<<<< HEAD
<form:form method="POST" action="/Appartments" modelAttribute="apartment"  enctype="multipart/form-data">
    <table border="0" class="table table-hover" >
        <tr>
            <td>Адрес</td>
            <td><form:input path="address" autocomplete="off" type="text" name="address" /></td>
=======
<form:form method="POST" action="/Appartments" modelAttribute="apartment">
    <table border="0" class="table table-hover" >
        <tr>
            <td>Адрес</td>
            <td><form:input path="address" autocomplete="off" type="text" name="address"/></td>
>>>>>>> 60cac7ff53855449b2d79895fe9cc70f360cc243
        </tr>
        <tr>
            <td>Тип</td>
            <td>
                <%--<input autocomplete="off" type="text" name="typeEstate" value="${appartment.typeEstate}" />--%>
                <form:select name="typeEstate" type="text" path="typeEstate">
                    <option value="Квартира">Квартира</option>
                    <option value="Дом">Дом</option>
                    <option value="Нежилой фонд">Нежилой фонд</option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Этаж</td>
            <td><form:input pattern="^[ 0-9]+$" autocomplete="off" type="text" name="floor" path="floor"/>
            </td>
        </tr>
        <tr>
            <td>Количество комнат</td>
            <td><form:input path="countOfRoom" pattern="^[ 0-9]+$" autocomplete="off" type="text" name="countOfRoom"/></td>
        </tr>
        <tr>
            <td>Размер</td>
            <td><form:input path="size" pattern="^[ 0-9]+$" autocomplete="off" type="text" name="size"/></td>
        </tr>
        <tr>
            <td>Дополнительня информация</td>
            <td><form:input path="additionalDescription" autocomplete="off" type="text" name="additionalDescription"/></td>
<<<<<<< HEAD
        </tr>
        <tr>
            <td>Выберите изображение</td>
            <td><form:input path="uploadfile" type="file" name="uploadfile"/></td>
=======
>>>>>>> 60cac7ff53855449b2d79895fe9cc70f360cc243
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" class="btn btn-primary" value="Добавить"/>
<<<<<<< HEAD
                <a href="/WEB-INF/view/allApartments.jsp">Отменить</a>
=======
                <a href="/WEB-INF/view/allApartments.jsppartments.jsp">Отменить</a>
>>>>>>> 60cac7ff53855449b2d79895fe9cc70f360cc243
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
