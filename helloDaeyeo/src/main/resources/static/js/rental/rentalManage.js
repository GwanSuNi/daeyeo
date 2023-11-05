// Ajax 요청을 보낼 때 CSRF 토큰과 인증 정보를 포함
const csrfToken = document.querySelector("meta[name='_csrf']").content;
const csrfHeader = document.querySelector("meta[name='_csrf_header']").content;

function refreshPage() {
    location.reload();
}

function permit(id) {
    // XMLHttpRequest 객체 생성
    var xhr = new XMLHttpRequest();

    // POST 요청 설정
    xhr.open("POST", "/myPage/rentalManage/" + id + "/permit", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader(csrfHeader, csrfToken);
    // 이벤트 핸들러 등록
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // 요청이 성공했을 때 실행할 코드
                console.log("POST 요청 성공");
                // 이곳에서 리다이렉트 또는 다른 처리를 수행할 수 있습니다.
            } else {
                // 요청이 실패했을 때 실행할 코드
                console.error("POST 요청 실패");
            }
        }
    };
    // 실제 요청 보내기
    xhr.send();

    setTimeout(refreshPage, 200);
}

function cancel(id) {
    // XMLHttpRequest 객체 생성
    var xhr = new XMLHttpRequest();

    // POST 요청 설정
    xhr.open("POST", "/myPage/rentalManage/" + id + "/cancel", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.setRequestHeader(csrfHeader, csrfToken);
    // 이벤트 핸들러 등록
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                // 요청이 성공했을 때 실행할 코드
                console.log("POST 요청 성공");
                // 이곳에서 리다이렉트 또는 다른 처리를 수행할 수 있습니다.
            } else {
                // 요청이 실패했을 때 실행할 코드
                console.error("POST 요청 실패");
            }
        }
    };
    // 실제 요청 보내기
    xhr.send();

    setTimeout(refreshPage, 200);
}


const openModalButton = document.getElementById('openModalButton');
const closeModalButton = document.getElementById('closeModalButton');
const modal = document.getElementById('modalContainer');
const closeRentalModalButton = document.getElementById('closeRentalModalButton');
openModalButton.addEventListener('click', function () {
    modal.style.display = 'flex';
});
closeModalButton.addEventListener('click', () => {
    modal.style.display = 'none';
});


    // 여기에서 JavaScript 코드를 실행
    function showRentalStatusModal(objectIndex) {
        var modal = document.getElementById('rentalStatusModal');
        var statusList = document.getElementById('rentalStatusTableBody');
        statusList.innerHTML = ""; // Clear the existing table rows

        // Send an AJAX request to retrieve RentalStatus values for the selected RentalObject
        var xhr = new XMLHttpRequest();
        xhr.open('GET', "/myPage/ModalRentalStatus/" + objectIndex, true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.setRequestHeader(csrfHeader, csrfToken);

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var rentalStatusList = JSON.parse(xhr.responseText);
                rentalStatusList.forEach(function (rentalStatus) {
                    // Add rows to the table
                    var row = document.createElement('tr');
                    var cell1 = document.createElement('td');
                    var cell2 = document.createElement('td');
                    // var cell3 = document.createElement('td');
                    // var cell4 = document.createElement('td');
                    // var cell5 = document.createElement('td');
                    var cell6 = document.createElement('td');

                    cell1.textContent = rentalStatus.objectName;
                    cell2.textContent = rentalStatus.userName;
                    var dateString = rentalStatus.rentalDate;
                    var date = new Date(dateString);
                    var year = date.getFullYear();
                    var month = String(date.getMonth() + 1).padStart(2, '0');
                    var day = String(date.getDate()).padStart(2, '0');
                    var formattedDate = year + "-" + month + "-" + day;

                    // cell3.textContent = formattedDate;

                    var startTime = new Date(rentalStatus.startTime);
                    var dayOfWeek = ["일", "월", "화", "수", "목", "금", "토"][startTime.getDay()]; // 요일 구하기

                    var formattedStartTime = startTime.getFullYear() + "년 " +
                        (startTime.getMonth() + 1) + "월 " + startTime.getDate() + "일 " +
                        dayOfWeek + " " + startTime.getHours() + "시 " + startTime.getMinutes() + "분";

                    // cell4.textContent = formattedStartTime;

                    var endTime = new Date(rentalStatus.endTime);
                    var dayOfWeek = ["일", "월", "화", "수", "목", "금", "토"][endTime.getDay()]; // 요일 구하기

                    var formattedEndTime = endTime.getFullYear() + "년 " +
                        (endTime.getMonth() + 1) + "월 " + endTime.getDate() + "일 " +
                        dayOfWeek + " " + endTime.getHours() + "시 " + endTime.getMinutes() + "분";

                    // cell5.textContent = formattedEndTime;

                    cell6.textContent = rentalStatus.status;

                    row.appendChild(cell1);
                    row.appendChild(cell2);
                    // row.appendChild(cell3);
                    // row.appendChild(cell4);
                    // row.appendChild(cell5);
                    row.appendChild(cell6);

                    statusList.appendChild(row);
                });

                // Show the modal using Bootstrap's modal function
                $('#rentalObjectModal').modal('show');
            }
        };

        xhr.send();
    }
closeRentalModalButton.addEventListener('click', () => {
    modal.style.display = 'none';
});
// const csrfToken = document.querySelector("meta[name='_csrf']").content;
// const csrfHeader = document.querySelector("meta[name='_csrf_header']").content;
//
// fetch('/myPage/getModalRentalStatusList', {
//     method: 'GET',
//     headers: {
//         [csrfHeader]: csrfToken
//     }
// })
//     .then(response => response.json())
//     .then(data => {
//         let modalContainer = document.getElementById('modalContainer');
//         modalContainer.innerHTML = data;
//
//     })
//     .catch(error => {
//         console.error('데이터 가져오기 중 오류 발생: ' + error);
//     });

// document.addEventListener("DOMContentLoaded", function () {
//     openModalButton.addEventListener('click', function () {
//         modal.style.display = 'flex';
//         const csrfToken = document.querySelector("meta[name='_csrf']").content;
//         const csrfHeader = document.querySelector("meta[name='_csrf_header']").content;
//
//         fetch('/myPage/getModalRentalStatusList', {
//             method: 'GET',
//             headers: {
//                 [csrfHeader]: csrfToken
//             }
//         })
//             .then(response => response.json())
//             .then(data => {
//                 // 데이터를 받아와서 모달 내의 요소에 할당
//                 let rentalStatusTableBody = document.getElementById('rentalStatusTableBody');
//                 rentalStatusTableBody.innerHTML = '';
//                 // for (let i = 0; i < data.length; i++) {
//                 //     let rentalStatus = data[i]
//                 //     // 새로운 <tr> 요소를 생성하고 데이터를 각 <td> 요소에 추가
//                 //     let rentalStatusRow = document.createElement('tr');
//                 //     rentalStatusRow.innerHTML = `
//                 //     <td th:text="${rentalStatus.objectName}"></td>
//                 //     <td th:text="${rentalStatus.nickname}"></td>
//                 //     <td th:text="${rentalStatus.rentalDate}"></td>
//                 //     <td th:text="${rentalStatus.startTime}"></td>
//                 //     <td th:text="${rentalStatus.endTime}"></td>
//                 //     <td th:text="${rentalStatus.label}"></td>
//                 //     `
//
//                 data.forEach((status) => {
//                     let objectName = document.createElement('td');
//                     objectName.value = status.objectName;
//                     objectName.text = status.objectName;
//                     let nickname = document.createElement('td');
//                     nickname.value = status.nickname;
//                     nickname.text = status.nickname;
//                     let rentalDate = document.createElement('td');
//                     rentalDate.value = status.rentalDate;
//                     rentalDate.text = status.rentalDate;
//                     let startTime = document.createElement('td');
//                     startTime.value = status.startTime;
//                     startTime.text = status.startTime;
//                     let endTime = document.createElement('td');
//                     endTime.value = status.endTime;
//                     endTime.text = status.endTime;
//                     let label = document.createElement('td');
//                     label.value = status.status;
//                     label.text = status.status;
//                     rentalStatusTableBody.appendChild(objectName);
//                     rentalStatusTableBody.appendChild(nickname);
//                     rentalStatusTableBody.appendChild(rentalDate);
//                     rentalStatusTableBody.appendChild(startTime);
//                     rentalStatusTableBody.appendChild(endTime);
//                     rentalStatusTableBody.appendChild(label);
//                 });
//             })
//             .catch(error => {
//                 console.error('데이터 가져오기 중 오류 발생: ' + error);
//             });
//     });
//     closeModalButton.addEventListener('click', () => {
//         modal.style.display = 'none';
//     });
// });