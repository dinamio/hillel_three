<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="templates/header.jsp" >
  <jsp:param name="title" value="Main page" />
</jsp:include>
<%--<jsp:include page="templates/registration.jsp" ></jsp:include>--%>
<div class="buttons py-5">
  <div class="container text-center">
    <a href="/add" class="button mx-3"><i class="fas fa-plus"></i>add document</a>
    <a href="/documents" class="button mx-3"><i class="fas fa-pencil-alt"></i>edit document</a>
  </div>
</div>
<jsp:include page="templates/footer.jsp" ></jsp:include>