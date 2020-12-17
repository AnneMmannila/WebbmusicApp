<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Albums</title>
<link rel="stylesheet" href="/styles/artistAlb.css">
</head>
<body>
<h1>
<c:forEach items = "${artistName}" var ="name"> 
<c:out value="Albums from ${name.getName()}"></c:out>
</c:forEach>
</h1>

<div class = 'table'>
	
	<c:forEach items="${list}" var="album">
	
	<a href ="/musicApp/track?AlbumId=${album.getAlbumId() }"> <c:out value="${album.getTitle()}"></c:out> </a>
	
	<br>
		
	</c:forEach>
	
	
</div>
	
	
</body>
</html>