<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 11/7/18
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>My Fabulous Application</h1>
<c:forEach var="pet" items="${pets}">
    <c:out value="${pet.name}"/>
    <c:out value="${pet.age}"/>
    <button class="btn" pet-id="${pet.id}">Add age</button>
    <br/>
</c:forEach>
<form action="/registration" method="post">
    Enter your name: <input name="first_name">
    <button> Send</button>
</form>
</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {

       $(".btn").click(function() {
           var petId = $(this).attr("pet-id");
           $.ajax({
               type: "PUT",
               url: "/hello?id=" + petId,
               success: function () {

               },
               failure: function () {

               }
           })
       })
    });
</script>

</html>
