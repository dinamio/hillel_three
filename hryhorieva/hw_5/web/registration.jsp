<%--
  Created by IntelliJ IDEA.
  User: Алёна
  Date: 25.11.2018
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="templates/header.jsp" >
    <jsp:param name="title" value="Main page" />
</jsp:include>
<div class="registration form_block py-5">
    <div class="container">
        <div class="tabs_block">
            <div class="tabs_titles">
                <div class="tab_name active">registration</div>
                <div class="tab_name">sign in</div>
            </div>
            <div class="tabs_content">
                <div class="tab_text p-4">
                    <form action="/registration" method="post" name="registration">
                        <div class="row align-items-center">
                            <div class="col-md-12 col-sm-12 col-12 mb-2">
                                <div class="title">Registration:</div>
                            </div>
                            <div class="col-md-4 col-sm-6 col-12">
                                <input type="text" name="user_login" placeholder="your login">
                            </div>
                            <div class="col-md-4 col-sm-6 col-12">
                                <input type="password" name="user_password" placeholder="your password">
                            </div>
                            <div class="col-md-4 col-sm-6 col-12">
                                <input type="submit" class="button" value="send">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="tab_text p-4">
                    <form action="/authorization" method="post" name="singin">
                        <div class="row align-items-center">
                            <div class="col-md-12 col-sm-12 col-12 mb-2">
                                <div class="title">Sign in:</div>
                            </div>
                            <div class="col-md-4 col-sm-6 col-12">
                                <input type="text" name="user_login" placeholder="your login">
                            </div>
                            <div class="col-md-4 col-sm-6 col-12">
                                <input type="password" name="user_password" placeholder="your password">
                            </div>
                            <div class="col-md-4 col-sm-6 col-12">
                                <input type="submit" class="button" value="send">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="templates/footer.jsp" ></jsp:include>
