<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Document</title>
</head>
<body>
        <form method="post" action="/updateDoc">
            <br/>
                ID : <input type="number" name="upDocId" value="<c:out value="${upDocId}" />" readonly="readonly"/>
            <br/>
                 Name: <input type="text" name="upDocName" value="<c:out value="${upDocName}" />" />
            <br/>
                <label>Date</label>
                <input type="date" name="upDocDate" value="<c:out value="${upDocDate}" />" />
            <br/>
            <label>Author</label>
            <input type="id" name="upDocAuthor" value="<c:out value="${upDocAuthor}" />" readonly="readonly"/>
            <br/>
            <input type="submit" value="Save">
        </form>
</body>
</html>