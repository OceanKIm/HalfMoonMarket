<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	<script defer src="/res/js/main/home.js"></script>
	<link rel="stylesheet" href="/res/css/common.css">
	<link rel="stylesheet" href="/res/css/main/home.css">
</head>
<body>
	<div id="container">
		<tiles:insertAttribute name="header" />
		<section>
			<tiles:insertAttribute name="content" />		
		</section>		
	</div>
</body>
</html>