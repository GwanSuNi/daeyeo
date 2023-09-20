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