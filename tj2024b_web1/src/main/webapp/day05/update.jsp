<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    String bno = request.getParameter("bno");    
%>
	
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
			<legend>게시물 개별 수정 : 새로운 내용 하고 수정 버튼을 클릭하세요.</legend>
			<div>
				<lable>제목:</lable>
				<input class="inputUpdateTitle" />
			</div>
			<div>
				<lable>내용:</lable> 								
				<textarea class="inputUpdateContent" cols="50" rows="10"> </textarea>				
			</div>
			<div>
				<lable>작성자:</lable>
				<input class="inputUpdateWriter" />
			</div>			
			<button onclick="articleUpdate(<%= bno %>)" type="button">수정</button>			
		</fieldset>
	</div>
	<jsp:include page="/day05/footer.jsp"></jsp:include>
	
	<script type="text/javascript" src="board_execute.js"></script>
</body>
</html>