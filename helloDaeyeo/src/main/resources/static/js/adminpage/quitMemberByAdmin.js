document.addEventListener("DOMContentLoaded", function () {
    document.getElementById('quitMemberButton').addEventListener('click', () => {
        var quitMemberCheckbox = document.getElementById('quitMemberCheckbox');
        if (!quitMemberCheckbox.checked) {
            alert("안전 장치를 체크 해주세요.");
            return;
        }
        var userEmail = document.querySelector("span[id='userEmail']").textContent;
        var requestData = {
            userEmail: userEmail
        };
        var csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
        var csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

        fetch("/adminpage/quitUser", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                [csrfHeader]: csrfToken // CSRF 토큰을 요청 헤더에 포함
            },
            body: JSON.stringify(requestData)
        })
            .then(response => {
                if (response.ok) {
                    alert(userEmail + " 회원 탈퇴 완료");
                    quitMemberCheckbox.checked = false; // 체크박스 해제
                } else {
                    alert("회원 탈퇴 실패");
                }
            })
            .catch(error => {
                console.error(error);
                alert("회원 탈퇴 실패");
            });
    });
});
