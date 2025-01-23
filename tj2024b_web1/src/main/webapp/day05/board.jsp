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
		<h3>게시판 : 커뮤니티를 제공합니다.</h3>
		<a href="/tj2024b_web1/day05/write.jsp">글쓰기</a>
		<table border=1>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>				
				</tr>
			</thead>
			<tbody>
				<!-- 자바스크립트에서 넣어줌 -->
			</tbody>
		</table>
	</div>
	<jsp:include page="/day05/footer.jsp"></jsp:include>
	<script type="text/javascript" src="board_list.js"></script>
	<script type="text/javascript" src="board_execute.js"></script>
</body>
</html>