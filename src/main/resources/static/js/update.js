// (1) 회원정보 수정
function update(userId, event) {
	
	event.preventDefault(); // form태그 액션을 막기
	
	// jQuery를 사용해서 id가 profileUpdate인 폼의 데이터를 직렬화
	// 직렬화된 데이터는 http 요청으로 보내기 적합한 형태로 변환된다
	let data = $("#profileUpdate").serialize();
	
	console.log(data);
	
	$.ajax({
		type:"put",
		url:`/api/user/${userId}`,
		data:data,
		contentType:"application/x-www-form-urlencoded; charset=utf-8",
		dataType: "json"
		
		// ajax 요청=비동기적 특성, 요청이 서버로 보내지고 응답이 올 때까지 기다리지 않고 다른 코드가 실행되는 것
		// 이때 ajax 요청이 성공했을 때와 실패했을 때 각각 실행할 함수를 정의할 수 있음 이게 콜백함수
		// ajax 비동기통신을 쓰는 이유 : 페이지 전체 새로고침 안하고 서버와 데이터 주고받을수있음
		// 전체 페이지 로드 대신 필요한 데이터만 교환하므로 네트워크 트래픽 줄이고 응답 시간 개선
		// 그래서 더 동적이고 반응이 빠름
	}).done(res=>{ // httpStatus 상태코드 200번대
		console.log("성공", res);
		location.href = `/user/${userId}`;	
	}).fail(error=>{ // httpStatus 상태코드 200번대가 아닐 때
		if(error.data == null) {
			alert(error.responseJSON.message);
		} else {
			alert(JSON.stringify(error.responseJSON.data)); // 자바스크립트 오브젝트를 JSON 문자열로 변환해줌
		}
	});
}