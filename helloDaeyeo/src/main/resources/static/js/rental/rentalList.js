// form
const frm = document.getElementById('rentalListFrm');
// 카테고리
const categories = document.querySelectorAll('.cate-btn');
const mainCategory = document.getElementById('mainCategory');
const subCategory = document.getElementById('subCategory');
let category = mainCategory.value ? subCategory : mainCategory;
// 검색
const search = document.getElementById('search');
// 목록형, 보드형
const listType = document.getElementById('list-type');
const boardType = document.getElementById('board-type');
// 정렬
const selectSort = document.getElementById('sort');
// 페이징
const pages = document.querySelectorAll('.page-link');

// 페이지 로드 시
window.addEventListener('load', () => {
    let type = sessionStorage.getItem("type");

    if (type) // 세션 스토리지에서 가져온 id 값이 있으면 요소 찾기
        typeActive(document.getElementById(type));
});

// 카테고리에 클릭 이벤트 추가
categories.forEach((element) => {
    element.addEventListener('click', (e) => {
        e.preventDefault();

        if (element.text === "전체")
            category.value = ""
        else
            category.value = element.text;
        validateSubmit();
    });
});

// 검색 이벤트 리스너
search.addEventListener('click', (e) => {
    e.preventDefault();
    validateSubmit();
});
document.getElementById('search-word').addEventListener('keydown', (e) => {
    if (e.keyCode === 13) {
        e.preventDefault();
        validateSubmit();
    }
});

// 목록형, 보드형 클릭 시 typeActive 호출
listType.addEventListener('click', (e) => typeActive(e.currentTarget));
boardType.addEventListener('click', (e) => typeActive(e.currentTarget));

// 목록형, 보드형 바꿔주는 함수
function typeActive(element) {
    listType.classList.remove('active');
    boardType.classList.remove('active');
    element.classList.add('active');
    document.getElementById('rental-list').className = element.id;
    sessionStorage.setItem("type", element.id);
}

// 정렬 select 이벤트 리스너
selectSort.addEventListener('change', validateSubmit);

// 페이징 이벤트 리스너
pages.forEach((page) => {
    page.addEventListener('click', (e) => {
        e.preventDefault();
        frm.action = "/rentals/list/" + page.dataset.value;
        validateSubmit();
    });
});

// get 요청으로 보낼 때 url이 지저분해져서 값이 있는 필드만 보내는 함수
function validateSubmit() {
    let elements = frm.elements;

    for (let i = 0; i < elements.length; i++)
        if (elements[i].value === "")
            elements[i].name = "";

    frm.submit();
}
