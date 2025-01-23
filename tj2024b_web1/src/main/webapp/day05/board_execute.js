// 게시물 쓰기
const articleWrite = () => {
	console.log('write() 호출...')

	let inputTitle = document.querySelector('.inputTitle')
	let inputContent = document.querySelector('.inputContent')
	let inputWriter = document.querySelector('.inputWriter')
	let inputPwd = document.querySelector('.inputPwd')

	let title = inputTitle.value
	let content = inputContent.value
	let writer = inputWriter.value
	let pwd = inputPwd.value

	let dataObj = {
		'btitle': title,
		'bcontent': content,
		'bwriter': writer,
		'bpwd': pwd,
	}

	let option = {
		method: 'POST',
		headers: {
			'content-type': 'application/json'
		},
		body: JSON.stringify(dataObj)
	}

	fetch('/tj2024b_web1/day05/board', option)
		.then(r => r.json())
		.then(data => {
			if (data == true) {
				alert('등록성공')
				location.href = 'board.jsp'
			} else {
				alert('등록실패')
			}
		})
		.catch(e => {
			console.log(e)
		})
}

// 게시물 삭제
const articleDelete = bno => {
	const option = { method: "DELETE" }
	
	let pwd = prompt("비밀번호 입력해주세요.")
	
	fetch(`/tj2024b_web1/day05/board?bno=${bno}&pwd=${pwd}`, option)
		.then(r => r.json())
		.then(data => {
			if (data == true) {
				alert('삭제성공')
				location.href = 'board.jsp'
			} else {
				alert('삭제실패')
			}
		})
		.catch(e => { console.log(e) })
}

// 게시물 수정
const articleUpdate = bno => {
	console.log('articleUpdate() 호출...')
	
	let pwd = prompt("비밀번호 입력해주세요.")

	let inputUpdateTitle = document.querySelector('.inputUpdateTitle')
	let inputUpdateContent = document.querySelector('.inputUpdateContent')
	let inputUpdateWriter = document.querySelector('.inputUpdateWriter')

	let title = inputUpdateTitle.value
	let content = inputUpdateContent.value
	let writer = inputUpdateWriter.value

	let dataObj = {
		'bno': bno,
		'btitle': title,
		'bcontent': content,
		'bwriter': writer,
		'bpwd': pwd
	}

	let option = {
		method: 'PUT',
		headers: {
			'content-type': 'application/json'
		},
		body: JSON.stringify(dataObj)
	}

	fetch('/tj2024b_web1/day05/board', option)
		.then(r => r.json())
		.then(data => {
			if (data == true) {
				alert('수정성공')
				location.href = 'board.jsp'
			} else {
				alert('수정실패')
			}
		})
		.catch(e => {
			console.log(e)
		})
}

// 게시물 상세보기
const articleView = (bno) => {
	console.log('articleView() 호출...')
	console.log(bno)

	let inputNo = document.querySelector('.inputNo')
	let inputTitle = document.querySelector('.inputTitle')
	let inputContent = document.querySelector('.inputContent')
	let inputDate = document.querySelector('.inputDate')
	let inputWriter = document.querySelector('.inputWriter')

	const option = { method: 'GET' }
	fetch(`/tj2024b_web1/day05/board/view?bno=${bno}`, option)
		.then(r => r.json())
		.then(data => {
			console.log(data)			
			// 3. 출력
			//tbody.innerHTML = html
			inputNo.value = data.bno
			inputTitle.value = data.btitle
			inputContent.value = data.bcontent
			inputDate.value = data.bdate
			inputWriter.value = data.bwriter
			/*
			<td>${obj.bno}</td>
										<td><a href="board_view.jsp?bno=${obj.bno}">${obj.btitle}</a></td>							
										<td>${obj.bwriter}</td>
										<td>${obj.bdate}</td>							
										<td>${obj.bview}</td>*/
		})
		.catch(e => { console.log(e) })
}