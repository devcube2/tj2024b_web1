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
		<!--  bno :  , btitle: , bcontent :  , bwriter : , bview : , bpwd : , bdate : ' '  } -->
			<legend>게시물 상세 보기</legend>
			<div>
				<lable>번호:</lable>
				<input class="inputNo" readonly/>
			</div>
			<div>
				<lable>제목:</lable>
				<input class="inputTitle" readonly/>
			</div>
			<div>
				<lable>내용:</lable>
				<textarea class="inputContent" cols="50" rows="10" readonly> </textarea>
			</div>			
			<div>
				<lable>작성일:</lable>
				<input class="inputDate" readonly/>
			</div>
			<div>
				<lable>작성자:</lable>
				<input class="inputWriter" readonly/>
			</div>						
		</fieldset>
	</div>
	<jsp:include page="/day05/footer.jsp"></jsp:include>

	<script type="text/javascript" src="board_execute.js"></script>
	<script type="text/javascript">articleView(<%= bno %>)</script>
</body>
</html>