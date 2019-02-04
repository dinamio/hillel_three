<%--
  Created by IntelliJ IDEA.
  User: Алёна
  Date: 18.11.2018
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../templates/header.jsp" >
    <jsp:param name="title" value="Documents (watch, edit, delete)" />
</jsp:include>
<% Integer i = 1; %>
<div class="documents_block py-5">
    <div class="container">
        <h1>Documents</h1>
        <div class="table_wrapper">
            <table class="documents">
                <thead>
                    <tr>
                        <td>№</td>
                        <td>Title</td>
                        <td>Publish date</td>
                        <td>User Login</td>
                        <td>Options</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items='${documents}' var="doc">
                        <tr class="doc" data-id="${doc.getId()}">
                            <td><%= i++ %></td>
                            <td class="name"><span>${doc.getName()}</span></td>
                            <td><span>${doc.getDate()}</span></td>
                            <td><span>${doc.getUser().getLogin()}</span></td>
                            <td>
                                <c:set var="user" value='<%=session.getAttribute("user")%>'/>
                                <c:choose>
                                    <c:when test="${user==doc.getUser()}">
                                        <button class="button edit"><i class="fas fa-pencil-alt"></i>edit</button>
                                        <button class="button delete"><i class="fas fa-trash-alt"></i>delete</button>
                                    </c:when>
                                    <c:otherwise>
                                        <p>You can't edit this document</p>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    <a href="/add" class="add mt-3">add new document</a>
    </div>
</div>

<jsp:include page="../../templates/footer.jsp" ></jsp:include>