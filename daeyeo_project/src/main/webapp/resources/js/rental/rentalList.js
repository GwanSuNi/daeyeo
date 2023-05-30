const btn = document.querySelectorAll('.btn');
const rentalList = document.querySelector('#rental-list');

btn.forEach((element) => {
    element.addEventListener('click', () => {
        let sibling = element.nextElementSibling;

        if(!sibling)
            sibling = element.previousElementSibling;

        element.classList.add('active');
        sibling.classList.remove('active');
        rentalList.className = element.id;
    });
});