function changeTable() {
    var selectElement = document.getElementById("tableSelect");
    var selectedTable = selectElement.value;

    var tables = document.getElementsByClassName("table table-striped table-hover");
    for (var i = 0; i < tables.length; i++) {
        tables[i].style.display = "none";
    }

    var tableToShow = document.getElementById(selectedTable);
    tableToShow.style.display = "table";
}

document.addEventListener("DOMContentLoaded", function () {
    changeTable(); // 페이지의 요소가 로드된 후에 테이블 변경 함수 실행
});



// 버튼을 클릭할 때 실행될 함수 정의
function toggleInputVisibility() {
    var input = document.getElementById("myInput");
    if (input.style.display === "none") {
        input.style.display = "block"; // 보이게
        input.value = ""; // 텍스트 초기화
    } else {
        input.style.display = "none"; // 숨김
    }
}

// 버튼 요소를 가져와서 클릭 이벤트에 함수 연결
var toggleButton = document.getElementById("toggleButton");
toggleButton.addEventListener("click", toggleInputVisibility);