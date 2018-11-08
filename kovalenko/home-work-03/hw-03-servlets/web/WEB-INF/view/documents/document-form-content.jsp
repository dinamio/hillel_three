<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row mt-3">
    <div class="col-sm-6 mx-auto">
        <div class="card mb-3 text-center">
            <div class="card-header text-white bg-success">Edit Form</div>
            <div class="card-body">
                <c:choose>
                    <c:when test="${empty document}">
                        <form method="post" action="${pageContext.request.contextPath}/documents">
                            <div class="form-group row">
                                <label for="title1" class="col-sm-4 col-form-label">Document title</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="title" id="title1">
                                </div>
                            </div>
                            <div class="form-group row float-right">
                                <div class="col-sm-8 ">
                                    <button type="submit" class="btn btn-success">Save</button>
                                </div>
                            </div>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form method="post" action="${pageContext.request.contextPath}/documents/${document.id}">
                            <div class="form-group row">
                                <label for="title2" class="col-sm-4 col-form-label">Document title</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" name="title" value="${document.title}" id="title2">
                                </div>
                            </div>
                            <div class="form-group row float-right">
                                <div class="col-sm-8 ">
                                    <button type="submit" class="btn btn-success">Save</button>
                                </div>
                            </div>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</div>