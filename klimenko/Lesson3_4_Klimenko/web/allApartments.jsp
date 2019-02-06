<%--
  Created by IntelliJ IDEA.
  User: Klimenko
  Date: 19.11.2018
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="Index Page"/>
    <jsp:param name="content" value="/index/index-content"/>
</jsp:include>
<table border="3" class="table table-hover">
    <thead>
    <tr>
        <th>Адрес</th>
        <th>Тип</th>
        <th>Этаж</th>
        <th>Количество комнат</th>
        <th>Квадратура</th>
        <th>Дополнительная информация</th>
        <th>Изображение</th>
        <th>Действие</th>

    </tr>
    </thead>

    <c:forEach var="Appart" items="${listApp}">
    <tbody>
    <td id="adress${Appart.getEstateId()}">
        <c:out value="${Appart.getAddress()}"/>
    </td>
    <td id="typeEstate${Appart.getEstateId()}">
        <c:out value="${Appart.getTypeEstate()}"/>
    </td>
    <td id="floor${Appart.getEstateId()}">
        <c:out value="${Appart.getFloor()}"/>
    </td>
    <td id="countOfRoom${Appart.getEstateId()}">
        <c:out value="${Appart.getCountOfRoom()}"/>
    </td>
    <td id="size${Appart.getEstateId()}">
        <c:out value="${Appart.getSize()}"/>
    </td>
    <td id="additionalDescription${Appart.getEstateId()}">
        <c:out value="${Appart.getAdditionalDescription()}"/>
    </td>
    <td id="picture${Appart.getEstateId()}">
        <img src="data:image/jpeg;base64,${Appart.getPicture()}" />
    </td>
    <td>
        <button class="del-btn btn btn-danger" id="del" id-apart="${Appart.getEstateId()}">Удалить</button>
        <sec:authorize access="hasAnyAuthority('ADMIN')">
            <button class="edit-btn btn btn-primary" id-apart="${Appart.getEstateId()}">Редактировать</button>
        </sec:authorize>
    </td>
    </c:forEach>
    </tbody>
</table>

<div id="edit-div" class="table table-hover" hidden=true>
    Редактирование элемента
<form:form modelAttribute="apartment" action="/Appartments/edit" method="POST">
    <table border="0" class="table table-hover">
        <tr>
            <td>Адрес</td>
            <td><form:input  path="address" autocomplete="off" id="address" type="text" name="address" value="${appartment.address}"/></td>
            <td><form:input path="estateId" id="id-for-edit" type="text" hidden="true"/></td>
        </tr>
        <tr>
            <td>Тип</td>
            <td><form:input path="typeEstate" autocomplete="off" id="typeEstate" type="text" name="typeEstate"
                       value="${appartment.typeEstate}"/></td>
        </tr>
        <tr>
            <td>Этаж</td>
            <td><form:input path="floor" pattern="^[ 0-9]+$" autocomplete="off" id="floor" type="text" name="floor"
                       value="${appartment.floor}"/>
                <form:errors path="floor"  cssStyle="color: #ff0000;" /></td>
        </tr>
        <tr>
            <td>Количество комнат</td>
            <td><form:input path="countOfRoom" pattern="^[ 0-9]+$" autocomplete="off" id="countOfRoom" type="text" name="countOfRoom"
                       value="${appartment.countOfRoom}"/>
                <form:errors path="countOfRoom"  cssStyle="color: #ff0000;" /></td>
        </tr>
        <tr>
            <td>Размер</td>
            <td><form:input path="size" pattern="^[ 0-9]+$" autocomplete="off" id="size" type="text" name="size"
                       value="${appartment.size}"/>
                <form:errors path="size"  cssStyle="color: #ff0000;"/></td>
        </tr>
        <tr>
            <td>Дополнительня информация</td>
            <td><form:input path="additionalDescription" id="additionalDescription" type="text" name="additionalDescription"
                       value="${appartment.additionalDescription}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit" class="btn btn-primary">
                    Подтвердить
                </button>
                <button id="cancel-button"  class="btn btn-danger">
                    Отменить
                </button>
            </td>
        </tr>
    </table>
</form:form>
</div>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script src="js/main.js">
</script>
</html>