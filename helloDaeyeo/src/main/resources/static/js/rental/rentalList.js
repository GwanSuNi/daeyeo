const listType = document.getElementById('list-type');
const boardType = document.getElementById('board-type');

// 목록형, 보드형 클릭 시 typeActive 호출
listType.addEventListener('click', (e) => typeActive(e.currentTarget));
boardType.addEventListener('click', (e) => typeActive(e.currentTarget));

// 목록형, 보드형 바꿔주는 함수
function typeActive(type) {
    listType.classList.remove('active');
    boardType.classList.remove('active');
    type.classList.add('active');
    document.getElementById('rental-list').className = type.id;
    sessionStorage.setItem("type", type.id);
}

// 페이지 로드 시
window.addEventListener('load', () => {
    let type = sessionStorage.getItem("type");

    if (type) // 세션 스토리지에서 가져온 id 값이 있으면 요소 찾기
        typeActive(document.getElementById(type));
});

const categories = document.querySelectorAll('.cate-btn');
const mainCategory = document.getElementById('mainCategory');
const subCategory = document.getElementById('subCategory');
let category = mainCategory.value ? mainCategory : subCategory;

// 카테고리에 클릭 이벤트 추가
categories.forEach((element) => {
    element.addEventListener('click', (e) => {
        e.preventDefault();

    });
});

const rentalObjectForm = document.querySelector('.object-form');
const rentalObjects = document.querySelectorAll('.rental-object');

rentalObjects.forEach((element) => {
    element.addEventListener('click', (event) => {
        event.preventDefault();
        element.previousElementSibling.setAttribute('name', 'objectId');
        rentalObjectForm.submit();
    });
});