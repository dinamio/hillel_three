<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <div class="card mb-3">
            <div class="card-header text-center bg-info">
                <h3><c:out value="${document.title}"/></h3>
            </div>
            <div class="card-body">
                <h5 class="card-title text-center"><c:out value="${document.title}"/></h5>
                <p class="card-text"></p>
                <div class="text-center float-right">
                    <p class="card-text text-primary ">Created time: <c:out value="${document.created}"/></p>
                </div>
            </div>
            <div class="card-footer bg-transparent">
                <div class="text-center float-right">
                    <a href="${pageContext.request.contextPath}/documents/${document.id}?action=delete" class="btn btn-danger text-center">Delete</a>
                </div>
                <div class="text-center float-left">
                    <a href="${pageContext.request.contextPath}/documents/${document.id}?action=update" class="btn btn-warning text-center">Update</a>
                </div>
            </div>
        </div>
    </div>
</div>