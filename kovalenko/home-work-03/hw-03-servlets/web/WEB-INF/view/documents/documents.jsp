<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>${param.title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<nav class=" container navbar navbar-expand-lg navbar-light bg-secondary">
    <a class="navbar-brand" href="/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse d-flex justify-content-end" id="navbarSupportedContent">
        <c:if test="${sessionScope.user != null}">
            <ul class="navbar-nav ">
                <li class="nav-item dropdown">
                    <a class="justify-content-end nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <c:out value="${sessionScope.user.name}"/>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <div class="dropdown-divider"></div>
                        <form method="post" action="/logout" class="dropdown-item">
                            <button type="submit" class="dropdown-item">Logout</button>
                        </form>
                    </div>
                </li>
            </ul>
        </c:if>

    </div>
</nav>
<div role="main" class="container">
    <div class="row">
        <div class="col-sm-6 mx-auto mt-3">
            <button class="btn btn-create btn-block btn-success text-center mt-2 mb-2">Create</button>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-6 mx-auto mt-3">
            <div id="data-list">
                <c:choose>
                    <c:when test="${empty documents}">
                        <h2 class="text-center">No documents are available</h2>
                    </c:when>
                    <c:otherwise>
                        <table class="table">
                            <thead class="table-info">
                            <tr>
                                <th>Doc. Title</th>
                                <th>Date Created</th>
                                <th colspan="2">Action</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="document" items="${documents}">
                                <tr>
                                    <td>${document.title}</td>
                                    <td>${document.created}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/documents/${document.id}" class="btn btn-info text-center">View</a>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/documents/${document.id}" class="btn btn-delete btn-danger text-center">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </c:otherwise>
                </c:choose>
            </div>
            <div id="document-create" class="card mb-3 invisible">
                <div class="card-header text-white bg-success text-center">Create Form</div>
                <div class="card-body">
                    <form method="post" id="form-create" action="${pageContext.request.contextPath}/documents">
                        <div class="form-group row">
                            <label for="title" class="col-sm-4 col-form-label">Document title</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="title" id="title">
                            </div>
                        </div>
                        <div class="form-group row float-right">
                            <div class="col-sm-8 ">
                                <button type="submit" id="submit" class="btn btn-success">Save</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script
        src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://code.jquery.com/jquery-3.3.1.min.js"
        integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</body>
</html>
