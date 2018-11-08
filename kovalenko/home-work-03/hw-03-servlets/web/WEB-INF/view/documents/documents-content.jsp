<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <div class="text-center float-right">
            <a href="${pageContext.request.contextPath}/documents" class="btn btn-success text-center">Create</a>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <table class="table">
            <thead>
                <tr>
                    <th>Doc. Title</th>
                    <th>Date Created</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:if test = "${not empty documents}">
                    <c:forEach var="document" items="${documents}">
                        <tr>
                            <td>${document.title}</td>
                            <td>${document.created}</td>
                            <td>
                                <form method="get" action="/documents/${document.id}">
                                    <input type="hidden" name="id" value="${document.id}">
                                    <input type="submit" class="btn btn-success text-center" value="View">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>
</div>