<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>DAY04/WAITING2 대기번호 발행 프로그램</h3>

	<div>
		<h4>대기명단 작성</h4>
		전화번호 : <input class="telNoInput" /> <br /> 
		대기인원 : <input class="countInput" /> <br />
		<button onclick="waitingWrite()" type="button">등록</button>
	</div>

	<div>
		<div>대기명단목록</div>
		<table border=1>
			<thead>
				<tr>
					<th>no</th>
					<th>telNo</th>
					<th>count</th>					
				</tr>
			</thead>
			<tbody>
				
			</tbody>
		</table>
	</div>

	<script src="task2.js"></script>
</body>
</html>