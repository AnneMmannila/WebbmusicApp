<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tracks</title>
<link rel="stylesheet" href="/styles/artistAlb.css">
</head>
<body>

<h1>

<c:forEach items="${list}" var="album"> 
<c:out value="${album.getTitle()}"></c:out>
</c:forEach>
</h1>



<ol> 
 
	<c:forEach items="${trackList}" var="track">
	<li>
	<div class = 'table'>
	
 	<b> <c:out value="${track.getName()}">  </c:out> </b>  <c:out value="${track.getMinutes() } minutes"></c:out> 
   
   </div>   
	

		<br>
		</li>
	</c:forEach>
	 
	
</ol>


</body>
</html>