<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>헤더 페이지</title>

<!-- 부트스트랩 CSS  -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="/tj2024b_web1/css/index.css" rel="stylesheet">

</head>

<body>	
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<!-- bg-body-tertiary : 배경색 -->
		<div class="container">
			<!-- container : 반응형(크기) 구역/박스 -->

			<a class="navbar-brand" href="#"> <!-- 로고 -->
				<a href="/tj2024b_web1/index.jsp"><img class="header_logo" src="/tj2024b_web1/img/logo.jpg" /></a>
			</a>

			<!-- 반응형 토큰(버튼) : 디바이스가 작아지면 메뉴를 보여주는 버튼 -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- 메뉴박스 -->
			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<!-- 왼쪽 메뉴 목록 -->
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">					
					<li class="nav-item"><a class="nav-link" href="#">게시판</a></li>
					

					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						제품 
					</a>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="#">Action</a></li>
							<li><a class="dropdown-item" href="#">Another action</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="#">Something else
									here</a></li>
						</ul></li>
				</ul>				
				
				<!-- 오른쪽 메뉴 목록 -->
				<ul class="navbar-nav me-end mb-2 mb-lg-0 loginmenu"> <!-- me-end : 오른쪽 정렬 -->					
					<!-- 자바스크립트에서 생성 -->
				</ul>				
			</div>
		</div>
	</nav>

	<!--  부트스트랩 js -->
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/tj2024b_web1/js/header.js"></script>

</body>
</html>