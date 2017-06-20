<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<link href="resources/css/style.css" rel="stylesheet" />

</head>
<body>
	<div class="left">left</div>
	<div class="middle">

		<div class="newPostContainer">

new post
<form action="/app/post/addpost" method="post">
<input type="text" name="title"/>
<input type="text" name="content"/>
<input type="submit" value="save"/>

</form>

</div>
		<div class="listPostContainer">


			<c:forEach var="post" items="${posts}">
				<div class="postContainer">
					post title:${post.title} post created date: ${post.createdDate}
					Post content: ${post.content} user: ${post.owner.firstname}

			 		<c:forEach var="comment" items="${post.comments}">
						<div class="commentcontainer">
						comment user:${comment.owner.firstname}
							says ${comment.content}</div>
					</c:forEach>
			<!--  -->
						<form action="/addcomment" method="post">
			<input type="text" name="content"/>
			<input type="hidden" name="postId" value="${post.id}" />
	
			<input type="submit" value="save"/>

				</form>

				</div>

			</c:forEach>
		</div>


	</div>
	<div class="right">right</div>




</body>
</html>