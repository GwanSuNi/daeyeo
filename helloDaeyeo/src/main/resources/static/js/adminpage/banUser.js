document.getElementById('suspendForm').addEventListener('submit', function (e) {
    e.preventDefault();  // 폼 제출 기본 동작 막기

    // 입력된 데이터 가져오기
    const email = document.getElementById('userEmail').textContent; // value로 하니까 undefined됨
    console.log(email);
    const duration = document.getElementById('banDuration').value;
    const banUnit = document.getElementById('banUnit').value;
    // const reason = document.getElementById('reason').value;

    // Ajax 요청을 보낼 때 CSRF 토큰과 인증 정보를 포함
    const csrfToken = document.querySelector("meta[name='_csrf']").content;
    const csrfHeader = document.querySelector("meta[name='_csrf_header']").content;

    // AJAX 요청 보내기
    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/adminpage/suspendUser', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader(csrfHeader, csrfToken);

    // 요청 본문 구성
    const data = {
        email: email,
        duration: duration,
        banUnit: banUnit
        // reason: reason
    };

    xhr.send(JSON.stringify(data));

    // 서버 응답 처리
    xhr.onload = function () {
        if (xhr.status === 200) {
            alert('변경이 반영되었습니다.');
            // 모달 창 닫기 또는 다른 동작 수행
        } else {
            alert('정지 변경에 실패했습니다. 다시 시도해 주세요.');
        }
    };
});
