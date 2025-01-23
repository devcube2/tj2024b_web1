// 게시물 전체 조회
const boardFindAll = () => {
	console.log('boardFindAll() 호출...')
	let tbody = document.querySelector('tbody')
	
	let html = ''
	const option = { method: 'GET' }
	fetch('/tj2024b_web1/day05/board', option)
		.then(r => r.json())
		.then(data => {
			data.forEach(obj => {
				html += `				
						<tr>									
							<td>${obj.bno}</td>
							<td><a href="board_view.jsp?bno=${obj.bno}">${obj.btitle}</a></td>							
							<td>${obj.bwriter}</td>
							<td>${obj.bdate}</td>							
							<td>${obj.bview}</td>
							<td>
								<button onclick="location.href='update.jsp?bno=${obj.bno}'">수정</button>
								<button onclick="articleDelete(${obj.bno})">삭제</button>						
							</td>
						</tr>
					`
			})
			// 3. 출력
			tbody.innerHTML = html
		})
		.catch(e => { console.log(e) })
}
boardFindAll()