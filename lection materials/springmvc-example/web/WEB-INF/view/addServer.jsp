<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 11/21/17
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Добавить сервер</title>
    <link href="/res/style.css" rel="stylesheet">
  </head>
  <body>
  <h3>Enter server details</h3>
  <form:form method="POST" action="/server/add" modelAttribute="server">
    <table>
      <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" cssErrorClass="field-error"/></td>
        <td><form:errors path="name" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="description">Description</form:label></td>
        <td><form:input path="description" cssErrorClass="field-error"/></td>
        <td><form:errors path="description" cssClass="error"/></td>
      </tr>
      <tr>
        <td><form:label path="enabled">Enabled</form:label></td>
        <td><form:checkbox path="enabled"/></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit"/></td>
      </tr>
    </table>
  </form:form>
  </body>
</html>
