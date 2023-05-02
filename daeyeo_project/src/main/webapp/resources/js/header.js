const toggleBtn = document.querySelector('#bar_li');
const menu = document.querySelector('.navbar_menu');

toggleBtn.addEventListener('click', () => {
   menu.classList.toggle('active');
});