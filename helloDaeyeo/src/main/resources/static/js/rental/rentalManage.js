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


console.log('시간변환 코드가 실행되었습니다1.');
var tdElements = document.getElementsByClassName('rentalDate'); // 클래스 이름으로 선택
console.log(tdElements);
// var executed = false;
// window.addEventListener('DOMContentLoaded', function () {
//     if (!executed) {
//         executed = true;
//         var tdElements = document.getElementsByClassName('rentalDate'); // 클래스 이름으로 선택
//         console.log(tdElements);
//         for (var i = 0; i < tdElements.length; i++) {
//             var originalText = tdElements[i].textContent;
//             var formattedDate = formatDateToLocalDate(originalText);
//             tdElements[i].textContent = formattedDate;
//         }
//
//         // startTime와 endTime에 대한 변환도 동일한 방식으로 수행
//         var startTimeElements = document.getElementsByClassName('startTime');
//         console.log(startTimeElements);
//         for (var i = 0; i < startTimeElements.length; i++) {
//             var originalText = startTimeElements[i].textContent;
//             var formattedTime = formatLocalTimeToHoursMinutes(originalText);
//             startTimeElements[i].textContent = formattedTime;
//         }
//         var endTimeElements = document.getElementsByClassName('endTime');
//         console.log(endTimeElements);
//         for (var i = 0; i < endTimeElements.length; i++) {
//             var originalText = endTimeElements[i].textContent;
//             var formattedTime = formatLocalTimeToHoursMinutes(originalText);
//             endTimeElements[i].textContent = formattedTime;
//         }
//     }
// });
//
//
// // isValidDate 함수는 이전과 동일하게 사용
//
// // isValidDate, formatDateToYearMonthDay, formatTimeToHoursMinutes 함수는 이전 코드와 동일하게 작성합니다.
// function isValidDate(dateString) {
//     var pattern = /^\d{4}-\d{2}-\d{2}$/;
//     return pattern.test(dateString);
// }
//
// function formatDateToLocalDate(localDate) {
//     console.log('시간변환 코드가 실행되었습니다.rentalDate');
//     var year = localDate.year();
//     var month = localDate.monthValue();
//     var day = localDate.dayOfMonth();
//     return year + '년 ' + month + '월 ' + day + '일';
// }
//
// function formatLocalTimeToHoursMinutes(localTime) {
//     console.log('시간변환 코드가 실행되었습니다.localDate');
//     var localDateTime = LocalDateTime.parse(localTime);
//     var formattedTime = localDateTime.getHours() + '시 ' + localDateTime.getMinutes() + '분';
//     return formattedTime
// }

