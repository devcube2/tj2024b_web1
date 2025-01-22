// [1] 람다식 함수 정의
// const 상수명 = ( ) => { }
const func1 = () => {
	console.log('func1 execute')
}

// [2] 람다식 함수 정의 안에서 fetch 함수 활용
const func2 = () => {
	// ** fetch : HTTP 비동기 통신 제공하는 함수
	fetch(`http://localhost:8080/tj2024b_web1/day03/example1`)
}

const func3 = () => {
	// POST 메소드 매핑
	fetch(`/tj2024b_web1/day03/example1`, { method: `POST` })
	//fetch( `http://localhost:8080/tj2024b_web1/day03/example1`, { method: `POST` })
}

const func4 = () => {
	// PUT 메소드 매핑
	fetch(`/tj2024b_web1/day03/example1`, { method: `PUT` })
	//fetch( `http://localhost:8080/tj2024b_web1/day03/example1`, { method: `POST` })
}

const func5 = () => {
	// DELETE 메소드 매핑
	fetch(`/tj2024b_web1/day03/example1`, { method: `DELETE` })
	//fetch( `http://localhost:8080/tj2024b_web1/day03/example1`, { method: `POST` })
}

const func6 = () => {
	let name = '유재석';
	let age = 40;
	fetch(`/tj2024b_web1/day03/example1?data1=${name}&data2=${age}`);
}

const func7 = () => {
	let name = '신동엽';
	let age = 30;
	const option = { method: 'POST' };
	fetch(`/tj2024b_web1/day03/example1?data1=${name}&data2=${age}`, option);
}

const func8 = () => {
	let name = '서장훈';
	let age = 10;
	const option = { method: 'PUT' };
	fetch(`/tj2024b_web1/day03/example1?data1=${name}&data2=${age}`, option);
}

const func9 = () => {
	let name = '김희철'
	let age = 50
	const option = { method: 'DELETE' };
	fetch(`/tj2024b_web1/day03/example1?data1=${name}&data2=${age}`, option);
}

const func10 = () => {
	let object = {
		data1: '유재석',
		data2: 50
	}
	const option = {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(object)
	}
	fetch(`/tj2024b_web1/day03/example3`, option)
}

const func11 = () => {
	let object = {
		data1: '서장훈',
		data2: 40
	}
	const option = {
		method: 'PUT',
		headers: {
			'content-type': 'application/json'
		},
		body: JSON.stringify(object)
	}
	fetch('/tj2024b_web1/day03/example3', option)
}

const func12 = () => {
	const option = { method: 'GET' }
	fetch(`/tj2024b_web1/day03/example5`, option)
		.then(
			response => response.json()
		)
		.then(
			data => {
				console.log(data)
			}
		)
}

const func13 = () => {
	const option = { method: 'POST' }
		fetch(`/tj2024b_web1/day03/example5`, option)
			.then(
				response => response.text()
			)
			.then(
				data => {
					console.log(data)
				}
			)
}

const func14 = () => {
	const option = { method: 'PUT' }
		fetch(`/tj2024b_web1/day03/example5`, option)
			.then(
				response => response.json()
			)
			.then(
				data => {
					console.log(data)
				}
			)
			.catch(
				error => {
					console.log(error) // 통신 실패시
				}
			)
}

const func15 = () => {
	const option = { method: 'DELETE' }
		fetch(`/tj2024b_web1/day03/example5`, option)
			.then(
				response => response.json()
			)
			.then(
				data => {
					console.log(data)
				}
			)
			.catch(
				error => {
					console.log(error) // 통신 실패시
				}
			)
}

/*
		fetch( `HTTP URL` , {옵션} )
			URL
				1. 통신할 서블릿의 URL 주소
				2. 쿼리스트링
			- fetch( `HTTP URL` , { method: `GET` } )
			- fetch( `HTTP URL` , { method: `POST` } )
			- fetch( `HTTP URL` , { method: `PUT` } )
			- fetch( `HTTP URL` , { method: `DELETE` } )
*/