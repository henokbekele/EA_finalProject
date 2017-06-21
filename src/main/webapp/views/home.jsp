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
					name="content" /> <input type="submit" value="post" />

			</form>

		</div>
		<div class="listPostContainer">


			<c:forEach var="postp" items="${posts}">
				<div class="postContainer">
					post title:${postp.post.title} post created date:
					${postp.post.createdDate} Post content: ${postp.post.content} user:
					${postp.post.owner.firstname} status : ${postp.status} id
					${postp.post.id} owner id: ${postp.post.owner.firstname}


					<c:if test="${postp.post.owner.id eq 2}"> delete
					
					
						<form action="deletePost" method="post">
							<input type="hidden" name="userid" value="2" /> <input
								type="hidden" name="postid" value="${postp.post.id}" /> <input
								type="submit" value="delete" />
							
							<input id="btnp${postp.post.id}" onclick="myEditPost(${postp.post.id})" type="button" value="edit" />
								
								
						</form>


							<div id="post${postp.post.id}" class="postEditClass" style="display: none;" >
										<form   action="updatePost" method="post">
								<input type="hidden" name="userid" value="2" /> <input
									type="hidden" name="postid" value="${postp.post.id}" /> 
									<input type="text" name="content" value="${postp.post.content}">
									<input 	type="submit" value="update" />
							</form>
							</div>



					</c:if>

					<c:if test="${postp.status eq true}">


						<form action="unLikePost" method="post">
							<input type="hidden" name="userid" value="2" /> <input
								type="hidden" name="postid" value="${postp.post.id}" /> <input
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
							user:${comment.owner.firstname} says ${comment.content}
							
						<c:if test="${comment.owner.id eq 2}"> 
							
								<form action="deleteComment" method="post">
								<input type="hidden" name="userid" value="2" /> <input
									type="hidden" name="commentid" value="${comment.id}" /> <input
									type="submit" value="delete" />
									<input id="btnc${comment.id}" onclick="myEditComment(${comment.id})" type="button" value="edit" />
							</form>
							
							<div id="comment${comment.id}" class="commentEditClass" style="display: none;" >
										<form   action="updateComment" method="post">
								<input type="hidden" name="userid" value="2" /> <input
									type="hidden" name="commentid" value="${comment.id}" /> 
									<input type="text" name="content" value="${comment.content}">
									<input 	type="submit" value="update" />
							</form>
							</div>
							
							
						</c:if>

					</div>
					</c:forEach>
					<!--  -->
					<form action="/addcomment" method="post">


						<input type="text" name="content" /> <input type="hidden"
							name="userId" value="2" /> <input type="hidden" name="postId"
							value="${postp.post.id}" /> <input type="submit" value="comment" />

					</form>

				</div>

			</c:forEach>
		</div>


	</div>
	<div class="right">right</div>



<script src="resources/js/script.js" type="text/javascript" ></script>

</body>

</html>


