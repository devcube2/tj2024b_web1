<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>

</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<!-- 회원가입 폼 -->
	<div class="container col-xl-10 col-xxl-8 px-4 py-5">
		<div class="row align-items-center g-lg-5 py-5">
			<!--  왼쪽 메시지 구역 -->
			<div class="col-lg-7 text-center text-lg-start">
				<h1 class="display-4 fw-bold lh-1 text-body-emphasis mb-3">
					더조은 WEB LOGIN
				</h1>
				<p class="col-lg-10 fs-4">다양한 서비스를 제공 합니다.</p>
			</div>
			<!--  오른쪽 메시지 구역 -->
			<div class="col-md-10 mx-auto col-lg-5">
				<form id="signupform" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
					<div class="form-floating mb-3">
						<input type="text" id="mid" class="form-control midinput" id="floatingInput1" placeholder="계정아이디">
						<label for="floatingInput">계정아이디</label>
					</div>
					
					<div class="form-floating mb-3">
						<input type="password" name="mpwd" class="form-control mpwdinput" id="floatingPassword1" placeholder="계정비밀번호">
						<label for="floatingPassword">계정비밀번호</label>
					</div>					
										
					<button class="w-100 btn btn-lg btn-primary" type="button" onclick="onLogin()">로그인</button>
					<hr class="my-4">
					<small class="text-body-secondary"><a href="signup.jsp">회원가입</a></small>	
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="/tj2024b_web1/js/member/login.js"></script>"

</body>
</html>