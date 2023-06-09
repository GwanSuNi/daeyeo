const toggleBtn = document.querySelector('#bar_li');
const menu = document.querySelector('.navbar_menu');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
});

const hCategories = document.querySelectorAll('.header-cate');
const hForm = document.querySelector('#header-form');
const hMainCate = document.querySelector('.header-main-cate');

hCategories.forEach((element) => {
    element.addEventListener('click', (event) => {
        event.preventDefault();
        hMainCate.value = element.innerText;
        hForm.submit();
    });
});