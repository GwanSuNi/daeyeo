// obj의 클래스에 active 추가하고 형제 element의 클래스에 active 제거
function changeTab(obj) {
    if (!obj.classList.contains('active')) { // obj의 클래스에 active가 없다면
        let title = obj.parentElement.children;
        let content = document.getElementById('tab_content').children;

        // obj의 부모 element를 통해 형제 element를 하나씩 가져와 active 클래스르 제거하고 obj에는 active 클래스 추가
        for (let i = 0; i < title.length; i++) {
            if (title[i] === obj) { // 본인인 경우 클래스에 active 추가
                title[i].classList.add('active');
                content[i].classList.add('active');
            } else { // 형제 element의 active 클래스 제거
                title[i].classList.remove('active');
                content[i].classList.remove('active');
            }
        }
    }
}