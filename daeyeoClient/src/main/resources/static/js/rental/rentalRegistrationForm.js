const category0 = ['공간시설', '개인대여'];
const category1 = ['강의실', '회의실', 'scIdTest'];
const category2 = [];
const category = {
    'category1': category1,
    'category2': category2
}
const mainCate = document.querySelector('.main-cate');
const subCate = document.querySelector('.sub-cate');

category0.forEach((value) => {
    mainCate.options[mainCate.options.length] = new Option(value, value);
});

mainCate.addEventListener('change', () => {
    const select = mainCate.options[mainCate.selectedIndex].index;

    subCate.options.length = 1;

    if (select !== 0) {
        category['category' + select].forEach((value) => {
            subCate.options[subCate.options.length] = new Option(value, value);
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


// 숫자만 입력
const phoneNum = document.querySelectorAll(".phone > input");

phoneNum.forEach((e) => {
    e.addEventListener('input', () => {
        e.value = e.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');
    });
});


//주소 입력
const findAddress = document.querySelector('#find-address');
const findAddressBtn = document.querySelector('.find-address-btn');

findAddressBtn.addEventListener('click', (event) => {
    event.preventDefault();
    new daum.Postcode({
        oncomplete: function (data) {
            let address = data.address;
            let jibunAddress = data.jibunAddress;
            if (address !== '' || jibunAddress !== '') {
                document.querySelector("input[name=roadAddress]").value = address;
                document.querySelector("input[name=jibunAddress]").value = jibunAddress;
                document.querySelector("input[name=zipCode]").value = data.zonecode;
                document.querySelector("input[name=sido]").value = data.sido;
                document.querySelector("input[name=sigungu]").value = data.sigungu;
                document.querySelector('.btn-close').click();
            }
        },
        // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
        onresize: function (size) {
            findAddress.style.height = size.height + 'px';
        },
        width: '100%',
        height: '100%',
        theme: {
            searchBgColor: "#3B71CA", //검색창 배경색
            queryTextColor: "#FFFFFF" //검색창 글자색
        }
    }).embed(findAddress);
});


// 등록하기
const registration = document.querySelector('.registration');
const registrationForm = document.querySelector('.container');

registration.addEventListener('click', (event) => {
    event.preventDefault();

    const phone = document.querySelector('.phone').children;
    const representNum = document.querySelector("input[name='representNum']")
    let str = '';

    for (let element of phone) {
        if (element.tagName === "INPUT")
            str += element.value;
        else
            str += element.innerText;
    }

    representNum.value = str;

    txtEditor.forEach((element) => {
        const editor = element.contentWindow.document.querySelector('.ql-editor');
        const input = element.nextElementSibling;

        input.value = editor.innerHTML;
    });
    registrationForm.submit();
})