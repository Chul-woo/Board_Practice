<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Portpolio of KCW</title>
<link rel="stylesheet" type="text/css" href="/resources/css/style.css">
<!-- Bootstrap 3.3.4 -->
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<!-- Font Awesome Icons -->
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Ionicons -->
<link
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css"
	rel="stylesheet" type="text/css" />
<!-- Theme style -->
<link href="/resources/dist/css/AdminLTE.min.css" rel="stylesheet"
	type="text/css" />
<!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
<link href="/resources/dist/css/skins/_all-skins.min.css"
	rel="stylesheet" type="text/css" />
<script src="https://code.jquery.com/jquery-3.2.1.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"
	type="text/javascript"></script>
<script src="/resources/js/script.js"></script>

</head>
<body>
	<div id='cssmenu'>
		<ul>
			<c:choose>
				<c:when test="${login eq null || login eq ''}">
					<li><a href='/login'>로그인</a></li>
				</c:when>
				<c:otherwise>
<%-- 					<li><a>${login.name }님</a></li> --%>
					<li><a href='/logout'>로그아웃</a></li>
				</c:otherwise>
			</c:choose>
			<li><a href='/'>Home</a></li>
			<li class='active'><a href='#'>Board</a>
				<ul>
					<li><a href='/board'>Board</a>
						<ul>
							<li><a href='/board'>To List</a></li>
							<li><a href='/regist'>To Regist</a></li>
						</ul></li>
					<!-- 					<li><a href='#'>Product 2</a> -->
					<!-- 						<ul> -->
					<!-- 							<li><a href='#'>Sub Product</a></li> -->
					<!-- 							<li><a href='#'>Sub Product</a></li> -->
					<!-- 						</ul></li> -->
				</ul></li>
		</ul>
	</div>
</body>
</html>