<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <div class="text-center">
            <form method="get" action="${pageContext.request.contextPath}/documents">
                <input type="hidden" name="action" value="create">
                <input type="submit" class="btn btn-block btn-success text-center" value="Create">
            </form>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
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
</div>