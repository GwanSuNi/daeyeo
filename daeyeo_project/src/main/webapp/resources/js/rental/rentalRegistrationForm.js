const category0 = ['야외시설', '실내시설', '개인대여'];
const category1 = ['축구장', '농구장', '야구장'];
const category2 = ['강의실', '회의실'];
const category3 = [];
const category = {
    'category1': category1,
    'category2': category2,
    'category3': category3
}
const mainCate = document.querySelector('.main-cate');
const subCate = document.querySelector('.sub-cate');

category0.forEach((value, index) => {
    mainCate.options[mainCate.options.length] = new Option(value, index + 1);
});

mainCate.addEventListener('change', () => {
    const select = mainCate.options[mainCate.selectedIndex].value;

    subCate.options.length = 1;

    if (select !== '0') {
        category['category' + select].forEach((value, index) => {
            subCate.options[subCate.options.length] = new Option(value, index + 1);
        });
    }
});


Dropzone.options.myDropzone = {
    url: "/fake/location",
    autoProcessQueue: false,
    paramName: "file",
    clickable: true,
    maxFilesize: 5, //in mb
    addRemoveLinks: true,
    acceptedFiles: '.png,.jpg',
    dictDefaultMessage: "Upload your file here",
    init: function () {
        this.on("sending", function (file, xhr, formData) {
            console.log("sending file");
        });
        this.on("success", function (file, responseText) {
            console.log('great success');
        });
        this.on("addedfile", function (file) {
            console.log('file added');
        });
    }
};


const txtEditor = document.querySelectorAll('.txt-editor');

txtEditor.forEach((element) => {
    element.addEventListener('load', () => {
        const ifrm = element.contentWindow.document;
        const editor = ifrm.querySelector('.ql-editor');

        resizeIframe();

        // Options for the observer (which mutations to observe)
        const config = {
            attributes: true,
            childList: true,
            characterData: true,
            subtree: true
        };

        // Callback function to execute when mutations are observed
        const callback = function (mutationsList) {
            for (let mutation of mutationsList)
                resizeIframe()
        };

        // Create an observer instance linked to the callback function
        const observer = new MutationObserver(callback);

        // Start observing the target node for configured mutations
        observer.observe(editor, config);

        function resizeIframe() {
            element.style.height = '89px';
            element.style.height = ifrm.body.scrollHeight;
        }

        const wrapper = ifrm.querySelector('.wrapper');
        const ancestor = element.parentElement.parentElement;

        wrapper.addEventListener('focusin', () => {
            ancestor.style.backgroundColor = 'var(--faint-blue)';
        });
        wrapper.addEventListener('focusout', () => {
            ancestor.style.backgroundColor = '#FFFFFF';
        });
    });
});