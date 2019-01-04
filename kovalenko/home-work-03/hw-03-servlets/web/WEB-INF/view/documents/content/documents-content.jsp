<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <a href="/documents/create" class="btn btn-create btn-block btn-success text-center mt-2 mb-2">Create</a>
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
                                    <a href="/documents/${document.id}" class="btn btn-info text-center">View</a>
                                </td>
                                <td>
                                    <form:form method="post" action="/documents/${document.id}">
                                        <input type="hidden" name="_method" value="DELETE"/>
                                        <button type="submit" id="submit" class="btn btn-delete btn-danger text-center">Delete</button>
                                    </form:form>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>