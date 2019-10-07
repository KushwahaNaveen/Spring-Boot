<%@ page language="java" errorPage="/error.jsp" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color:white;">
        <div class="container">
        <a class="navbar-brand" href="#"><img style="width: 40%;height: 25%;" alt="image"  src="<c:url value="resources/images/logo.png" />"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
            <!-- <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" href="#">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Projects</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Blog</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
                </ul>
            </div> -->
        </div>
    </nav>


<!------ Include the above in your HEAD tag ---------->

