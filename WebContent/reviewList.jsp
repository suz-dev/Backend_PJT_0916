<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>리뷰 목록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="css/reveiwList.css">
</head>

<body>
	<%@ include file="include/header.jsp"%>
	<br>
	<main>
	<div class="video-container d-flex justify-content-center">

		<iframe width="560" height="315" src="${video.url}"
			title="YouTube video player" frameborder="0"
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen></iframe>

	</div>
	<hr>
	<div class="review-container">
		<div class="review-table-header">

			<span class="add-review-button"> <!-- <input type="button" name="addreview" value="글작성"> -->
				<button type="button" class="btn btn-outline-primary"
					id="makeReview">
					<a
						href="${pageContext.request.contextPath }/review?action=getForm&id=${video.id}">글작성</a>
				</button>
				
				
			</span> <i class="bi bi-search"
				style="display: inline-block; margin: 0 5px; float: right;"></i> <span
				class="col-lg-4"
				style="display: inline-block; margin: 0 5px; float: right;">
				<input type="password" class="form-control" class="col-xs-3"
				id="inputText" placeholder="제목, 내용으로 검색">
			</span>


		</div>
		<hr>
		<div class="review-content">
			<div class="review">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성자</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${ !empty reviewList and fn:length(reviewList) > 0 }">
							<c:forEach var="review" items="${reviewList}">
								<tr>
									<td scope="col">${review.reviewId+1}</td>
									<td scope="col"><a
										href="${pageContext.request.contextPath}/review?action=detail&videoId=${video.id}&reviewId=${review.reviewId}">${review.title}</a></td>
									<td scope="col">${review.writer}</td>
								</tr>
							</c:forEach>
						</c:if>

					</tbody>
				</table>
			</div>

		</div>
	</div>
	</main>
	<script src="./js/reviewList.js"></script>
</body>

</html>