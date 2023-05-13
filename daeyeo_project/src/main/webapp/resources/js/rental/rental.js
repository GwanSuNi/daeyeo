// iframe 태그 높이 조절하는 함수
function iHeight(ifrm) {
    ifrm.height = 100; // 초기화
    ifrm.height = ifrm.contentWindow.document.body.scrollHeight;
}

// 목록형을 눌렀으면 iframe에 listType.jsp를 넣고 보드형을 눌렸으면 boardType.jsp를 넣는 함수
function changeType(type) {
    if (type === 'board_type') { // 보드형이면 list_type의 클래스에 active를 제거하고 board_type의 클레스에 active를 추가함
        document.getElementById('board_type').className = 'active';
        document.getElementById('list_type').classList.remove('active');
    } else { // 리스트형이면 board_type의 클래스에 active를 제거하고 list_type의 클레스에 active를 추가함
        document.getElementById('list_type').className = 'active';
        document.getElementById('board_type').classList.remove('active');
    }

    let ifrm = document.getElementById('rental_list');
    ifrm.src = type; // iframe에 입력받은 type(목록형 or 보드형)을 넣음
    iHeight(ifrm); // iframe의 높이를 조절
}