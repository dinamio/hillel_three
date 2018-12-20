<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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