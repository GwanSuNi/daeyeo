const modalBtns = document.querySelectorAll('.modal-trigger');

modalBtns.forEach((modalBtn) => {
    modalBtn.addEventListener('click', (e) => {
        e.preventDefault();
        fetchRentalWriteDetail(modalBtn.dataset.objectIndex);
    });
});

function fetchRentalWriteDetail(objectIndex) {
    fetch('/adminpage/rentalWriteDetail/' + objectIndex, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (response.ok)
                return response.json();
            else
                throw new Error('fetch rentalWriteDetail fail');
        })
        .then(data => {
            let object = data.rentalObject;
            let statistics = data.rentalStatistics;

            document.getElementById('objectIndex').textContent = object.objectIndex;
            document.getElementById('objectName').textContent = object.objectName;
            document.getElementById('mcId').textContent = object.objectIndex;
            document.getElementById('scId').textContent = object.objectIndex;
            document.getElementById('userEmail').textContent = object.userEmail;
            document.getElementById('address').textContent = object.address.address + ' (' + object.address.extraAddress + ') ' + object.address.detailAddress;
            document.getElementById('usageFee').textContent = object.usageFee;
            document.getElementById('applicationPeriod').textContent = object.applicationPeriod.startDate + ' ~ ' + object.applicationPeriod.endDate;
            document.getElementById('usagePeriodDate').textContent = object.usagePeriod.startDate + ' ~ ' + object.usagePeriod.endDate;
            document.getElementById('usagePeriodTime').textContent = object.usagePeriod.startTime + ' ~ ' + object.usagePeriod.endTime;
            document.getElementById('cancellation').textContent = object.cancellation;
            document.getElementById('maxPerson').textContent = object.maxPerson;
            document.getElementById('webSite').textContent = object.webSite;
            document.getElementById('inquiryPhone').textContent = object.inquiryPhone;
            document.getElementById('visitCount').textContent = object.visitCount;

            document.getElementById('income').textContent = statistics.income;
            document.getElementById('rental-total').textContent = statistics.rentalStatusCount;
            document.getElementById('success-count').textContent = statistics.successCount;

            const tbody = document.querySelector('#rentalWriteModal .datatable-table tbody');

            tbody.innerHTML = '';

            data.rentalUsersDetails.forEach((item) => {
                const row = document.createElement('tr');

                row.innerHTML = `
                    <td>${item.roles[0]}</td>
                    <td>${item.userEmail}</td>
                    <td>${item.nickname}</td>
                    <td>${item.status}</td>
                    <td>${item.payment}</td>
                    <td>${item.startTime}</td>
                    <td>${item.endTime}</td>
                `;

                tbody.appendChild(row);
            });
        })
        .catch((error) => {
            console.error('Error:', error);
        });
}