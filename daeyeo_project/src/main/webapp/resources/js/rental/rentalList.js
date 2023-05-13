// 호출한 element의 클래스에 active를 추가하고 css를 파라미터로 받아온 css로 바꾸는 함수
function changeCSS(obj, css) { // 함수를 호출한 element와 바꿀 css 이름을 파라미터로 받음
    if (!obj.classList.contains('active')) { // 호출한 element의 클래스에 active 없을 경우
        // 클래스가 type_btn인 element들의 클래스에 active가 있으면 제거, 없으면 추가
        for (let item of document.querySelectorAll('.type_btn'))
            item.classList.toggle('active');

        // css를 파라미터로 받은 css로 바꿈
        document.querySelector('#css').href = ('./resources/css/rental/' + css + '.css');
    }
}