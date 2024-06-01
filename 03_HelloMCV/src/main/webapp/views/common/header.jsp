<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/css/style.css">
<script src="${path }/jsjquery-3.7.1.min.js"></script>
</head>
<body>
	<div id="container">
		<header>
		<h1>HelloMVC</h1>
		<div class="login-container">
			<form action="loginFrm" method="post">
				<table>
					<tr>
						<td>
							<input type="text" name="userid" id="userid">
						</td>
						<td></td>
					</tr>
					<tr>
						<td>
							<input type="password" name="password" id="password">
						</td>
						<td>
							<input type="submit" value="로그인">
						</td>
					</tr>
					<tr>
						<td>
							<input type="checkbox" name="saveId" id="saveId"><label>아이디저장</label>
							<input type="button" value="회원가입">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<nav>
			<ul class="main-nav">
				<li class="home">
					<a href="">Home</a>
				</li>
				<li class="board">
					<a href="">게시판</a>
				</li>
			</ul>
		</nav>
		</header>
	</div>
</body>
</html>