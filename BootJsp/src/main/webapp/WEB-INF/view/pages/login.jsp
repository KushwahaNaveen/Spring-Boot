<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first" >
     <img style="width: 20%;height: 25%;" alt="image"  src="<c:url value="resources/images/user.png" />">
    </div>

    <!-- Login Form -->
    <form method="post" action="login">
      <input type="text" id="login" class="fadeIn second" name="username" placeholder="login">
      <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="#">Forgot Password?</a>
    </div>

  </div>
</div>
