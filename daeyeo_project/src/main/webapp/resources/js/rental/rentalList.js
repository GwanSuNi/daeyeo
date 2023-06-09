const btn = document.querySelectorAll('.btn');
const rentalList = document.querySelector('#rental-list');

btn.forEach((element) => {
    element.addEventListener('click', () => {
        let sibling = element.nextElementSibling;

        if (!sibling)
            sibling = element.previousElementSibling;

        element.classList.add('active');
        sibling.classList.remove('active');
        rentalList.className = element.id;
    });
});

const url = new URL(window.location.href);
const params = url.searchParams;
const cateForm = document.querySelector('.category_wrap')
let mainCate = params.get('mainCate');
let subCate = params.get('subCate');
const firstCateBtn = document.querySelector('.cate-btn:first-child');
const cateBtn = document.querySelectorAll('.cate-btn:not(:first-child)');

firstCateBtn.addEventListener('click', (event) => {
    event.preventDefault();

    if (mainCate !== '')
        params.set('subCate', '');

    // cateForm.submit();
    url.search = params.toString();
    window.location.replace(url.toString());
});

cateBtn.forEach((element) => {
    element.addEventListener('click', (event) => {
        event.preventDefault();

        // TODO : 뒤로가기 시 데이터가 남아있어서 뒤로갔다 클릭하면 문제 생김
        // 예를 들어 list?searchWord=&mainCate=공간시설&subCate= 이 되야 하는데 뒤로 갔다 클릭하면 list?searchWord=&mainCate=공간시설&subCate=공간시설이 됨
        if (mainCate === '')
            params.set('mainCate', element.innerText);
        else
            params.set('subCate', element.innerText);

        // cateForm.submit();
        url.search = params.toString();
        window.location.replace(url.toString());
    });
});

if (mainCate === '' || subCate === '')
    firstCateBtn.classList.add('active');
else {
    cateBtn.forEach((element) => {
        if (element.innerText === subCate)
            element.classList.add('active');
    });
}