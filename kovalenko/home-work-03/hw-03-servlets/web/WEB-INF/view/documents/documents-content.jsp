<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <div class="text-center float-right">
            <form method="get" action="/documents">
                <input type="hidden" name="action" value="create">
                <input type="submit" class="btn btn-success text-center" value="Create">
            </form>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <table class="table">
            <thead class="table-info">
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
                                <a href="/documents/${document.id}" class="btn btn-info text-center">View</a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
            </tbody>
        </table>
    </div>
</div>