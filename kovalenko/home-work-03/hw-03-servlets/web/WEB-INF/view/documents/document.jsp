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
            <a href="${pageContext.request.contextPath}/documents" id="back" class=" text-center mt-2 mb-2">Back to list of documents</a>
            <div id="document" class="card mb-3">
                <div class="card-header text-center bg-info">
                    <h3><c:out value="${document.title}"/></h3>
                </div>
                <div class="card-body">
                    <p class="card-text text-center text-dark">Author: <c:out value="${document.author.name}"/></p>

                    <div class="text-center float-right">
                        <p class="card-text text-primary ">Created time: <c:out value="${document.created}"/></p>
                    </div>
                </div>
                <div class="card-footer bg-transparent">
                    <div class="text-center float-right">
                        <button class="btn btn-update btn-warning text-center">Update</button>
                    </div>
                </div>
            </div>
            <div id="document-update" class="card mb-3 invisible">
                <div class="card-header text-white bg-warning text-center">Edit Form</div>
                <div class="card-body">
                    <form id="form-update" action="${pageContext.request.contextPath}/documents/${document.id}">
                        <div class="form-group row">
                            <label for="title" class="col-sm-4 col-form-label">Document title</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="title" value="${document.title}" id="title">
                            </div>
                        </div>
                        <div class="form-group row float-right">
                            <div class="col-sm-8 ">
                                <button type="submit" id="submit" class="btn btn-warning">Edit</button>
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
