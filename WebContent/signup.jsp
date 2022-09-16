<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
* {
	box-sizing: border-box;
}

body {
	margin: 0;
	padding: 0;
	color: skyblue;
	font-size: 15px;
}

input, textarea, button {
	color: gray;
	font-size: 15px;
}

input:focus, textarea:focus, button:focus {
	outline: none;
}

textarea {
	resize: none;
}

h3 {
	margin: 0 0 12px 0;
	font-size: 45px;
	text-align: center;
	text-transform: uppercase;
}

p {
	padding: 0 10px;
	margin: 0 0 55px 0;
	text-align: center;
	line-height: 1.8;
}

.wrapper {
	min-height: 100vh;
	display: flex;
	align-items: center;
}

.form-container {
	max-width: 767px;
	margin: auto;
	padding: 70px 100px 80px;
	border: 10px solid skyblue;
	background: white;
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.2);
}

.form-group {
	position: relative;
	display: block;
	margin-bottom: 48px;
}

.form-group span {
	position: absolute;
	top: 11px;
	color: gray;
	font-size: 15px;
	cursor: text;
	transition: all 0.2s ease;
	transform-origin: 0 0;
}

.form-group span.border {
	position: absolute;
	left: 0;
	top: 41px;
	width: 100%;
	height: 2px;
	display: block;
	background: #ffffff;
	transform: scaleX(0);
	transition: all 0.15s ease;
}

.form-control {
	width: 100%;
	height: 43px;
	display: block;
	font-size: 15px;
	border: none;
	border-bottom: 2px solid skyblue;
	background: none;
}

.form-control:focus, .form-control:valid {
	border-bottom: 2px solid grey;
}

.form-control:focus+span, .form-control:valid+span {
	transform: translateY(-22px) scale(0.8);
}

.form-control:focus+span+.border, .form-control:valid+span+.border {
	transform: scaleX(1);
}

textarea.form-control {
	padding: 13px 1px;
}

button[type="submit"] {
	width: 162px;
	height: 51px;
	display: flex;
	align-items: center;
	justify-content: center;
	margin: 60px auto 0;
	padding: 0;
	color: white;
	border: 2px solid white;
	border-radius: 4px;
	background-color: skyblue;
	cursor: pointer;
	text-transform: uppercase;
	transition: background-color 0.2s linear;
}

button[type="submit"]:hover {
	background-color: grey;
}
</style>
</head>

<body>
	<div class="wrapper">
		<div class="form-container">
			<form action="user">
				<input type="hidden" name="action" value="signup">
				<h3>회원가입</h3>
				<div class="form-group">
					<input type="text" class="form-control" name="userId" required>
					<span>아이디</span> <span class="border"></span>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="password"
						required> <span>비밀번호</span> <span class="border"></span>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="userName" required>
					<span>이름</span> <span class="border"></span>
				</div>
				<button id="reg" type="submit">가입</button>
				<button type="submit" onclick="history.back()" >취소</button>
			</form>
		</div>
	</div>
</body>

</html>