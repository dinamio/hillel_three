<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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