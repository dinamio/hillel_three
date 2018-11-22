<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <div class="card mb-3">
            <div class="card-header text-white bg-success text-center">Login Form</div>
            <div class="card-body">
                <c:if test = "${not empty error}">
                    <p class="text-center"><c:out value = "${error}"/></p>
                </c:if>
                <form method="post" action="${pageContext.request.contextPath}/login">
                    <div class="form-group row">
                        <label for="login" class="col-sm-4 col-form-label">Login:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="login" id="login" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-sm-4 col-form-label">Password:</label>
                        <div class="col-sm-8">
                            <input type="password" class="form-control" name="password" id="password" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12 mx-auto mt-1">
                            <button type="submit" class="btn btn-block btn-success">Login</button>
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-12 mx-auto">
                            <a href="${pageContext.request.contextPath}/register" class="btn btn-block btn-info text-center mt-2 mb-2">Register</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>