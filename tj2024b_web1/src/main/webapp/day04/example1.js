console.log(`example1.js 실행`);

// 1. JS 자료
console.log(3);
console.log(3.14);
console.log(function 함수명() { });
console.log({ "속성명1": 3, "속성명2": '안녕4' });

// 2. JS 함수
// (1) 선언적 함수 : function 함수명(매개변수명 , 매개변수명) { 실행문; }
// (정의/만들기)
function func1(a, b) {
	console.log('func1 execute');
	let c = a + b;
	return c;
}
let result1 = func1(3, 4);
console.log(result1);

// (2) 익명 함수 : function(매개변수명, 매개변수명) { 실행문; }
const func2 = function(a, b) {
	console.log('func2 execute');
	let c = a + b;
	return c;
}
let result2 = func2(3, 4);
console.log(result2);

// (3) 람다식(화살표) 함수 : (매개변수명, 매개변수명) => { 실행문; }
const func3 = (a, b) => {
	console.log('func3 execute');
	c = a + b;
	return c;
}
console.log(func3(3, 4))

// 3. 람다식 함수의 활용처
const words = ['사과', '수박', '딸기', '오렌지']
// 예] 배열내 모든 요소 값들을 하나씩 출력하시오.
// (1) 일반 for문
for (let index = 0; index <= words.length-1; index++) {
	console.log(words[index])
}
// (2) forEach 함수
words.forEach( word => { console.log(word) } )

// (3) 배열변수명.map()
words.map( word => { console.log(word) } )

// (*) forEach 와 map 함수의 차이점
let newWords1 = words.forEach ( i => { return i; } )
console.log(newWords1);

let newWords2 = words.map ( i => { return i; } )
console.log(newWords2);

words[2] = "메론스"
console.log(words);
console.log(newWords2);