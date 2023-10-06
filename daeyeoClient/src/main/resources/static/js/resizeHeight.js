// obj의 높이를 조절하는 함수
function resizeHeight(obj) {
    obj.style.height = 'auto'; // 높이 초기화
    obj.style.height = obj.scrollHeight;
}