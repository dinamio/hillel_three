<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row mt-3">
    <div class="col-sm-6 mx-auto">
        <div class="card mb-3 text-center">
            <div class="card-header text-white bg-success">Edit Form</div>
            <div class="card-body">
                <form method="post" action="/documents">
                    <div class="form-group row">
                        <label for="title" class="col-sm-4 col-form-label">Document title</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" name="title" id="title">
                        </div>
                    </div>
                    <div class="form-group row float-right">
                        <div class="col-sm-8 ">
                            <button type="submit" class="btn btn-success">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>