<%--
  Created by IntelliJ IDEA.
  User: Klimenko
  Date: 19.11.2018
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <td>
        <button class="del-btn btn btn-danger" id="del" id-apart="${Appart.getEstateId()}">Удалить</button>
        <button class="edit-btn btn btn-primary" id-apart="${Appart.getEstateId()}">Редактировать</button>
    </td>
    </c:forEach>
    </tbody>
</table>

<div id="edit-div" class="table table-hover" hidden=true>
    Редактирование элемента
    <table border="0" class="table table-hover">
        <tr>
            <td>Адрес</td>
            <td><input autocomplete="off" id="address" type="text" name="address" value="${appartment.address}"/></td>
            <td><input id="id-for-edit" type="text" hidden=true name="IDApartments"/></td>
        </tr>
        <tr>
            <td>Тип</td>
            <td><input autocomplete="off" id="typeEstate" type="text" name="typeEstate"
                       value="${appartment.typeEstate}"/></td>
        </tr>
        <tr>
            <td>Этаж</td>
            <td><input pattern="^[ 0-9]+$" autocomplete="off" id="floor" type="text" name="floor"
                       value="${appartment.floor}"/></td>
        </tr>
        <tr>
            <td>Количество комнат</td>
            <td><input pattern="^[ 0-9]+$" autocomplete="off" id="countOfRoom" type="text" name="countOfRoom"
                       value="${appartment.countOfRoom}"/></td>
        </tr>
        <tr>
            <td>Размер</td>
            <td><input pattern="^[ 0-9]+$" autocomplete="off" id="size" type="text" name="size"
                       value="${appartment.size}"/></td>
        </tr>
        <tr>
            <td>Дополнительня информация</td>
            <td><input id="additionalDescription" type="text" name="additionalDescription"
                       value="${appartment.additionalDescription}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <button id="edit-button" class="btn btn-primary">
                    Подтвердить
                </button>
                <button id="cancel-button"  class="btn btn-danger">
                    Отменить
                </button>
                <%--<a href="/allApartments.jsp">Cancel</a>--%>
            </td>
        </tr>
    </table>
</div>
</body>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
<script src="js/main.js">
</script>
</html>