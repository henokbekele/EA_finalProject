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
				<input type="text" name="title" /> <input type="text"
					name="content" /> <input type="submit" value="save" />

			</form>

		</div>
		<div class="listPostContainer">


			<c:forEach var="postp" items="${posts}">
				<div class="postContainer">
					post title:${postp.post.title} post created date:
					${postp.post.createdDate} Post content: ${postp.post.content} user:
					${postp.post.owner.firstname} status : ${postp.status} id
					${postp.post.id}
					owner id: ${postp.post.owner.firstname}
					<c:if test="${postp.post.owner.id eq 2}"> delete
					
					
						<form action="deletePost" method="post">
							<input type="hidden" name="userid" value="2" /> <input
								type="hidden" name="postid" value="${postp.post.id}" /> <input
								type="submit" value="delete" />
						</form>
					
					
					</c:if>
					
					<c:if test="${postp.status eq true}">


						<form action="unLikePost" method="post">
					<input type="hidden" name="userid" value="2" />
							<input type="hidden" name="postid" value="${postp.post.id}" /> <input
								type="submit" value="UnLike" />
						</form>



					</c:if>

					<c:if test="${postp.status eq false}">
						<form action="likePost" method="post">
							<input type="hidden" name="userid" value="2" /> <input
								type="hidden" name="postid" value="${postp.post.id}" /> <input
								type="submit" value="Like" />
						</form>

					</c:if>

					: ${ postp.post.likesize()}

					<c:forEach var="comment" items="${postp.post.comments}">
						<div class="commentcontainer">comment
							user:${comment.owner.firstname} says ${comment.content}</div>
					</c:forEach>
					<!--  -->
					<form action="/addcomment" method="post">
						<input type="text" name="content" /> <input type="hidden"
							name="postId" value="${postp.post.id}" /> <input type="submit"
							value="save" />

					</form>

				</div>

			</c:forEach>
		</div>


	</div>
	<div class="right">right</div>




</body>
</html>