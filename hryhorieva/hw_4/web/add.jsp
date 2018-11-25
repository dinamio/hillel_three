<%--
  Created by IntelliJ IDEA.
  User: Алёна
  Date: 18.11.2018
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="templates/header.jsp" >
    <jsp:param name="title" value="Add form" />
</jsp:include>

<div class="form_block py-5">
<div class="container">
    <form action="/add" method="post">
        <div class="row align-items-center">
            <div class="col-md-12 col-sm-12 col-12 mb-2">
                <div class="title">Add new document:</div>
            </div>
            <div class="col-md-4 col-sm-6 col-12">
                <input type="text" name="document_name" placeholder="document name">
            </div>
            <div class="col-md-4 col-sm-6 col-12">
                <input type="submit" class="button" value="send">
            </div>
        </div>
    </form>
</div>
</div>
<jsp:include page="templates/footer.jsp" ></jsp:include>
