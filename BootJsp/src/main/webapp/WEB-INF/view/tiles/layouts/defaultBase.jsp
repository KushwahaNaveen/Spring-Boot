<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="https://cdn.ckeditor.com/ckeditor5/12.4.0/classic/ckeditor.js"></script>

<link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
</head>

<body>
	<header id="header">
		<tiles:insertAttribute name="header" />
	</header>

	<section id="site-content">
		<tiles:insertAttribute name="body" />
	</section>

	<footer id="footer">
		<tiles:insertAttribute name="footer" />
	</footer>
</body>
<script>
	$('.dropdown').click(function() {

		$('.dropdown-menu').toggleClass('show');

	});

	/* Anything that gets to the document
	   will hide the dropdown */
	$(document).click(function() {
		$(".dropdown-menu").toggleClass('hide');
	});
</script>
<script>
                        ClassicEditor
                                .create( document.querySelector( '#editor' ) )
                                .then( editor => {
                                        console.log( editor );
                                } )
                                .catch( error => {
                                        console.error( error );
                                } );
                </script>
</html>