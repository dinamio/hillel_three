<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <div class="card mb-3">
            <div class="card-header text-white bg-info text-center">Register Form</div>
            <div class="card-body">
                <form method="post" action="${pageContext.request.contextPath}/register">
                    <div class="form-group row">
                        <label for="name" class="col-sm-4 col-form-label">Name:</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="name" id="name" required>
                        </div>
                    </div>
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
                    <div class="form-group row float-right">
                        <div class="col-sm-8 ">
                            <button type="submit" class="btn btn-info">Register</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
