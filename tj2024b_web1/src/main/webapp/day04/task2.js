// 1. 등록 함수
const waitingWrite = () => {
	console.log('waitingWrite 호출')
	// 1. HTML 으로부터 input dom 객체 가져오기	
	let telNoInput = document.querySelector('.telNoInput')
	let countInput = document.querySelector('.countInput')

	// 2. 입력받은 값 가져오기
	let telNo = telNoInput.value
	let count = countInput.value

	// 3. 객체화
	let dataObj = {
		'telNo': telNo,
		'count': count
	}

	// 4. fetch 통신
	let option = {
		method: 'POST',
		headers: {
			'content-type': 'application/json'
		},
		body: JSON.stringify(dataObj) // 본문에 보낼 자료를 JSON 타입으로 변환
	}

	// 5. 결과에 따른 화면 구현
	fetch('/tj2024b_web1/day03/waiting2', option)
		.then(r => r.json())
		.then(data => {
			if (data == true) {
				alert('등록성공')
				waitingFindAll();
			} else {
				alert('등록실패')
			}
		})
		.catch(e => {
			console.log(e)
		})
}

// 2. 전체 조회 함수 , 실행조건 : 1. JS 열릴때 2. 등록/수정/삭제 성공했을때
const waitingFindAll = () => {
	// 1. 어디에 , tbody
	let tbody = document.querySelector('tbody')

	// 2. 무엇을 , fetch 로 받은 자료들을
	let html = ''
	// 2-1 fetch 이용한 서블릿에게 자료를 HTTP GET METHOD 요청
	const option = { method: 'GET' }
	// 2-2 fetch
	fetch('/tj2024b_web1/day03/waiting2', option)
		.then(r => r.json()) // 통신 응답 성공시 json타입으로 변환
		.then(data => {
			// 방법1
			// for (let index = 0; index < data.length; index++) {}
			data.forEach(obj => {
				html += `
					<tr>
						<td>${obj.no}</td>
						<td>${obj.telNo}</td>
						<td>${obj.count}</td>
						<td>
							<button onclick="waitingUpdate(${obj.no})">수정</button>
							<button onclick="waitingDelete(${obj.no})">삭제</button>						
						</td>
					</tr>
				`
			})
			// 3. 출력
			tbody.innerHTML = html
		})
		.catch(e => { console.log(e) })
}
waitingFindAll()

// 3. 수정 함수
const waitingUpdate = no => { // prompt() 함수로 수정할 content/age 받기
	// 1. 수정할 식별자(num)
	// 2. 수정할 내용 content/age
	let newTelno = prompt('new Telno : ')
	let newCount = prompt('new Count : ')
	// 3. 객체화
	let dataObj = {
		no: no,
		telNo: newTelno,
		count: newCount
	}
	// 3. fetch 이용한 서블릿에게 HTTP PUT METHOD 처리 요청 , BODY
	const option = {
		method: 'PUT',
		headers: { 'content-type': 'application/json' },
		body: JSON.stringify(dataObj)
	}
	fetch('/tj2024b_web1/day03/waiting2', option)
		.then(r => r.json())
		.then(data => {			
			if (data == true) {
				alert('수정성공')
				waitingFindAll()
			} else {
				alert('수정실패')
			}
		})
		.catch (e => {
			console.log(e)
		})
}

// 4. 삭제 함수
const waitingDelete = no => {
	// 1. 삭제할 식별자(num)
	// 2. fetch 이용한 서블릿에게 HTTP delete METHOD 처리 요청
	const option = { method: "DELETE" }
	fetch(`/tj2024b_web1/day03/waiting2?no=${no}`, option)
		.then(r => r.json())
		.then(data => {
			if (data == true) {
				alert('삭제성공')
				waitingFindAll()
			} else {
				alert('삭제실패')
			}
		})
		.catch(e => { console.log(e) })
}