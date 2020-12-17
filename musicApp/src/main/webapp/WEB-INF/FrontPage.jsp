<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/styles/FrontP.css">
</head>

<body>
<a class = "toplink" href = /musicApp/add>Add or delete an Artist from the list</a>

	
	<form method="get"> Find an artist by typing the name
	<input name="artistName" required type="text"
			placeholder="type artist name here..." autofocus /> <input type="submit"  value= "Search"/>
	</form>
	
	<c:forEach items="${findArtist}" var="fa">
	
	<a href ="/albums?ArtistId=${fa.getArtistId()}"> <c:out value="${fa.getName()}"></c:out> </a>
		<br>
	</c:forEach>

<br>
		<form method="get">Find an album from the list. Press the number.
	<input name="albumName" required type="text"
			placeholder="type name of the album" autofocus /> <input type="submit" value= "Search" />
	</form>
	
	
	<br>
	<c:forEach items="${findAlbum}" var="findA">
	<br>
	<a href = "/albums?ArtistId=${findA}"><c:out value="${findA}"></c:out> </a>
	</c:forEach>
	
	
	 
	<p>List of artists</p>
	
	<c:forEach items="${list}" var="artist">
	<a href= "/albums?ArtistId=${artist.getArtistId()}" > <c:out value="${artist.getName()}"></c:out> </a>
		<br>
	</c:forEach>
	
	
 
</body>
</html>