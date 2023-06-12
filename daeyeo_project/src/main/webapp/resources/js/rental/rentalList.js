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


const rentalObjectForm = document.querySelector('.object-form');
const rentalObjects = document.querySelectorAll('.rental-object');

rentalObjects.forEach((element) => {
    element.addEventListener('click', (event) => {
        event.preventDefault();
        element.previousElementSibling.setAttribute('name','objectId');
        rentalObjectForm.submit();
    });
});