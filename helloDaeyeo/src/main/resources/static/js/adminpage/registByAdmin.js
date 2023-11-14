document.addEventListener('DOMContentLoaded', function () {
    const registByAdminBtn = document.getElementById('registByAdminBtn');

    registByAdminBtn.addEventListener('click', function () {
        const popupWidth = 600; // 팝업 창의 폭
        const popupHeight = 670; // 팝업 창의 높이
        const left = (window.screen.width - popupWidth) / 2;
        const top = (window.screen.height - popupHeight) / 2;
        // 팝업 창을 엽니다.
        const popupWindow = window.open('/memberApi/register', 'Popup', `width=${popupWidth}, height=${popupHeight}, left=${left}, top=${top}, resizable = no`);

        // 팝업 창이 로드될 때 이벤트 리스너를 추가할 수 있습니다.
        popupWindow.addEventListener('load', function () {
            // 팝업 내부에서 초기화 또는 추가 작업 수행
        });
    });
});
