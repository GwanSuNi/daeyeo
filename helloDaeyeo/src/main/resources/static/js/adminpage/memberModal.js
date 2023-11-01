document.addEventListener('DOMContentLoaded', function () {
    const modalTriggerButtons = document.querySelectorAll('.modal-trigger');

    modalTriggerButtons.forEach(function (button) {
        button.addEventListener('click', function () {
            const modal = document.querySelector('.modal');
            modal.style.display = 'block';

            // 클릭한 행의 사용자 정보를 가져와서 모달 내용을 업데이트
            console.log(JSON.parse(button.getAttribute('data-user-info')));

            const userInfo = JSON.parse(button.getAttribute('data-user-info'));
            // const  userInfo = button.getAttribute('data-user-info');
            document.getElementById('userName').textContent = userInfo.nickname;
            document.getElementById('userEmail').textContent = userInfo.userEmail;
            document.getElementById('userPhone').textContent = userInfo.phone;
            document.getElementById('topRole').textContent = userInfo.topRole;
            document.getElementById('registdate').textContent = userInfo.formattedRegistDate;
            document.getElementById('address').textContent = userInfo.formattedAddress;
            if (userInfo.enabled === false) {
                document.getElementById('banEndDate').textContent = userInfo.formattedBanEndDate;
                document.getElementById('isEnabled').textContent = "까지 정지";
            } else {
                document.getElementById('isEnabled').textContent = "X";
            }
            document.getElementById('objectCount').textContent = userInfo.objectCount;
            document.getElementById('rentalCount').textContent = userInfo.rentalCount;
            document.getElementById('reviewCount').textContent = userInfo.reviewCount;
            document.getElementById('paySum').textContent = userInfo.paySum;
            document.getElementById('moneyEarned').textContent = userInfo.moneyEarned;

        });
    });

    const closeBtn = document.querySelector('.close');

    closeBtn.addEventListener('click', function () {
        const modal = document.querySelector('.modal');
        modal.style.display = 'none';
    });
});