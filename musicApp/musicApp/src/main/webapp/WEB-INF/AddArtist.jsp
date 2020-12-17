<%@ page language="java" contentType="text/html; utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>AddArtist</title>
<link rel="stylesheet" href="/styles/artistAlb.css">
</head>
<body>


 	<h1>Add an artist on the list</h1>
 <b>	<p>Test the remove button by creating an artist and then removing from the remove-button. </p> </b>

		<form method="post">
		<input name="name" required type="text"
			placeholder="type artist name here..." autofocus /> <input type="submit"
			value="Add to list" />
	</form>
<dl>
<c:forEach items="${list}" var="artist">
	<dt id="artist-${ artist.getArtistId()}"> <c:out value="${artist.getName()}"></c:out> <button onclick="removeArtist(${artist.getArtistId() })">Remove</button> </dt>
		<br>
	</c:forEach>

</dl>
	<script>  
	async function removeArtist(id) {
		let response = await fetch(`/musicApp/add?ArtistId=`+id, { method: "DELETE" });

		if (response.status === 200) {
			let artist= "artist-"+ id;
			let element = document.getElementById(artist);
			element.remove();
		} else {
			alert("Something went wrong");
		}
	}
 </script>


</body>
</html>