<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/day05/header.jsp"></jsp:include>
	<div>
		<fieldset>
			<legend>게시물 작성 : 작성후 등록버튼을 클릭하세요!</legend>
			<div>
				<lable>제목:</lable>
				<input class="inputTitle" />
			</div>
			<div>
				<lable>내용:</lable> 								
				<textarea class="inputContent" cols="50" rows="10"> </textarea>				
			</div>
			<div>
				<lable>작성자:</lable>
				<input class="inputWriter" />
			</div>
			<div>
				<lable>비밀번호:</lable>
				<input class="inputPwd"/>
			</div>
			<button onclick="articleWrite()" type="button">등록</button>			
		</fieldset>
	</div>
	<jsp:include page="/day05/footer.jsp"></jsp:include>
	
	<script type="text/javascript" src="board_execute.js"></script>
</body>
</html>