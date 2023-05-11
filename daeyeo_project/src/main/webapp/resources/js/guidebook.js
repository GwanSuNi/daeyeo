// 페이지가 로드되면 textarea 태그들의 높이를 조절
window.onload = () => {
    let obj = document.getElementsByTagName('textarea');

    for (let i = 0; i < obj.length; i++)
            obj[i].style.height = obj[i].scrollHeight;
}

// obj의 클래스에 active가 있으면 제거, 없으면 추가하고 content의 내용을 펼치고 접는 함수
function toggleActive(obj) {
    obj.parentElement.classList.toggle('active');

    let content = obj.nextElementSibling; // obj 옆에 있는 content를 가져옴
    if (content.style.maxHeight) { // content가 펼쳐져 있는 경우(maxHeight 값이 있는 경우) content를 접음
        content.style.maxHeight = null;
        content.style.padding = null;
    } else { // content가 접혀져 있는 경우(maxHeight가 0인 경우) content를 펼침
        content.style.maxHeight = content.scrollHeight + "px";
        content.style.padding = '17px 30px';
    }
}