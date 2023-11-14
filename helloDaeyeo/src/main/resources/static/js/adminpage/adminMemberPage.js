const memberBtns = document.querySelectorAll('.modal-trigger');
const userEmail = document.getElementById('userEmail');

memberBtns.forEach((memberBtn) => {
    memberBtn.addEventListener('click', (e) => {
        e.preventDefault();
        fetchMemberRentals(memberBtn.textContent);
        fetchMemberRegistrations(memberBtn.textContent);
    });
});

document.getElementById('rental-tab').addEventListener('click', (e) => {
    e.preventDefault();
    fetchMemberRentals(userEmail.textContent);
});

document.getElementById('registration-tab').addEventListener('click', (e) => {
    e.preventDefault();
    fetchMemberRegistrations(userEmail.textContent);
});

// 회원의 대여 내역을 가져오는 함수
function fetchMemberRentals(userEmail) {
    fetch('/adminpage/memberRentals/' + userEmail, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (response.ok)
                return response.json();
            else
                throw new Error('fetch memberRentals fail');
        })
        .then(data => {
            const tbody = document.querySelector('#bordered-rental table tbody');

            // tbody의 내용을 초기화
            tbody.innerHTML = '';

            // 데이터의 각 항목에 대해
            data.forEach((item) => {
                // 새로운 행을 생성
                const row = document.createElement('tr');

                // 각 셀에 대한 데이터를 설정
                row.innerHTML = `
                    <td>${item.rentalStatusId}</td>
                    <td>${item.objectIndex}</td>
                    <td>${item.objectName}</td>
                    <td>${item.offerer}</td>
                    <td>${item.status}</td>
                    <td>${item.payment}</td>
                    <td>${item.startTime}</td>
                    <td>${item.endTime}</td>
                    <td>${item.rentalDate}</td>
                `;

                // 행을 tbody에 추가
                tbody.appendChild(row);
            });
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}

// 회원이 등록한 대여 항목을 가져오는 함수
function fetchMemberRegistrations(userEmail) {
    fetch('/adminpage/memberRegistrations/' + userEmail, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (response.ok)
                return response.json();
            else
                throw new Error('fetch memberRegistrations fail');
        })
        .then(data => {
            const tbody = document.querySelector('#bordered-registration table tbody');

            // tbody의 내용을 초기화
            tbody.innerHTML = '';

            // 데이터의 각 항목에 대해
            data.forEach((item) => {
                // 새로운 행을 생성
                const row = document.createElement('tr');

                // 각 셀에 대한 데이터를 설정
                row.innerHTML = `
                    <td>${item.objectIndex}</td>
                    <td>${item.objectName}</td>
                    <td>${item.address.sido + ' ' + item.address.sigungu + ' ' + item.address.detailAddress}</td>
                    <td>${item.income}</td>
                    <td>${item.rentalStatusCount}</td>
                    <td>${item.successCount}</td>
                    <td>${item.visitCount}</td>
                `;

                // 행을 tbody에 추가
                tbody.appendChild(row);
            });
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}