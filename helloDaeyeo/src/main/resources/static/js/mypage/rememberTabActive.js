document.addEventListener('DOMContentLoaded', function () {
    // 각 탭 버튼의 요소를 선택
    var tabs = document.getElementById('tabs').querySelectorAll('.nav-link');

    // 클릭 이벤트를 추가
    tabs.forEach(function (tab) {
        tab.addEventListener('click', function () {
            // 현재 활성화된 탭의 인덱스를 로컬 스토리지에 저장
            var activeTabIndex = Array.from(this.parentNode.parentNode.children).indexOf(this.parentNode);
            localStorage.setItem("activeTabIndex", activeTabIndex);
        });
    });
});

document.addEventListener('DOMContentLoaded', function () {
    // 로컬 스토리지에서 저장된 활성화된 탭의 인덱스를 읽어와서 탭을 활성화
    var activeTabIndex = localStorage.getItem("activeTabIndex");
    if (activeTabIndex !== null) {
        // 각 탭 버튼의 요소를 선택
        var tabs = document.getElementById('tabs').querySelectorAll('.nav-link');

        // 저장된 활성화된 탭의 인덱스를 기반으로 해당 탭을 활성화
        if (activeTabIndex >= 0 && activeTabIndex < tabs.length) {
            tabs[activeTabIndex].click();
        }
    }
});