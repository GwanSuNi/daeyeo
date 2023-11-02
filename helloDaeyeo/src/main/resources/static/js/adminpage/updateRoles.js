document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("updateRolesButton").addEventListener("click", function () {
        var userEmail = document.querySelector("span[id='userEmail']").textContent;
        var roles = Array.from(document.querySelectorAll("input[name='roles']:checked")).map(function (role) {
            return role.value;
        });
        // JSON.stringify를 사용하여 roles를 JSON 형식으로 변환
        var requestData = {
            userEmail: userEmail,
            roles: roles
        };
        var csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
        var csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

        fetch("/adminpage/updateRoles", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                [csrfHeader]: csrfToken // CSRF 토큰을 요청 헤더에 포함
            },
            body: JSON.stringify(requestData)
        })
            .then(function (response) {
                if (response.ok) {
                    return response.text();
                } else {
                    throw new Error("Roles update failed");
                }
            })
            .then(function (data) {
                alert("등급 변경 완료");
                // 원하는 추가적인 처리를 수행
                updateModalWithData(data)
                uncheckCheckboxes() // 체크박스 해제
            })
            .catch(function (error) {
                console.log(requestData)
                alert("등급 변경 실패")
                // 오류 처리를 수행
            });
    });
});

// 완료된 결과를 모달에 반영하는 함수
function updateModalWithData(data) {
    var result = JSON.parse(data);
    var topRoleElement = document.getElementById("roles");
    // 모달 내의 요소를 업데이트
    if (topRoleElement)
        topRoleElement.textContent = result.roles;
}

// 체크박스를 선택 해제하는 함수
function uncheckCheckboxes() {
    var checkboxes = document.querySelectorAll("input[name='roles']");
    checkboxes.forEach(function (checkbox) {
        checkbox.checked = false;
    });
}