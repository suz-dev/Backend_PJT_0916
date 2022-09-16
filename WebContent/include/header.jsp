<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<title>SSAFIT</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- 아이콘 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
<!-- css파일 -->
<link rel="stylesheet" href="style2.css" type="text/css">
</head>
<body>
	<header
		class="d-flex flex-wrap justify-content-center py-3 border-bottom"
		style="margin-bottom: 0px;">
		<a href="/"
			class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
			<svg class="bi me-2" width="40" height="32">
        <use xlink:href="#bootstrap"></use>
      </svg> <!-- class="fs-4" --> <span style="color: blue; font-size: 190%;">SSAFIT</span>
		</a>





		<ul class="nav nav-pills">
			<c:if test="${empty loginUser }">
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/signup.jsp">회원가입</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/login.jsp">로그인</a></li>
			</c:if>

			<c:if test="${!empty loginUser }">
				<li class="nav-item">
					<p class="nav-link">${ loginUser.userName }님환영합니다.</p>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/UserServlet?action=logout">로그아웃</a>
				</li>
			</c:if>
		</ul>
	</header>