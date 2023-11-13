document.addEventListener("DOMContentLoaded", function () {
    document.getElementById('updatePwButton').addEventListener('click', () => {
        var userEmail = document.querySelector("span[id='userEmail']").textContent;
        var tempPw = document.getElementById('tempPw').value; // 얘는 textContent로 하니까 ""로 넘어감;;
        var requestData = {
            userEmail: userEmail,
            tempPw: tempPw
        };
        var csrfToken = document.querySelector("meta[name='_csrf']").getAttribute("content");
        var csrfHeader = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

        fetch("/adminpage/tempPassword", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                [csrfHeader]: csrfToken // CSRF 토큰을 요청 헤더에 포함
            },
            body: JSON.stringify(requestData)
        })
            .then(response => {
                if (response.ok) {
                    alert(userEmail + " 임시 비밀번호 설정 완료");
                } else {
                    alert("임시 비밀번호 설정 실패");
                }
            })
            .catch(error => {
                console.error(error);
                alert("임시 비밀번호 설정 실패");
            });
    });
});
