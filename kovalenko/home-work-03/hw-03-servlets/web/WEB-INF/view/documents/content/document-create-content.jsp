<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="row">
    <div class="col-sm-6 mx-auto mt-3">
        <div id="document-create" class="card mb-3 ">
            <div class="card-header text-white bg-success text-center">Create Form</div>
            <div class="card-body">
                <form:form method="post" id="form-create" action="/documents" modelAttribute="document">
                    <div class="form-group row">
                        <form:label path="title" class="col-sm-4 col-form-label">Document title</form:label>
                        <div class="col-sm-8">
                            <form:input type="text" class="form-control" path="title" id="title"/>
                        </div>
                    </div>
                    <div class="form-group row float-right">
                        <div class="col-sm-8 ">
                            <button type="submit" id="submit" class="btn btn-success">Save</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>