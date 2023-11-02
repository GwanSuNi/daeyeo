// obj의 클래스에 active 추가하고 형제 element의 클래스에 active 제거
function changeTab(obj) {
    if (!obj.classList.contains('active')) { // obj의 클래스에 active가 없다면
        let title = obj.parentElement.children;
        let content = document.getElementById('tab_content').children;

        // obj의 부모 element를 통해 형제 element를 하나씩 가져와 active 클래스르 제거하고 obj에는 active 클래스 추가
        for (let i = 0; i < title.length; i++) {
            if (title[i] === obj) { // 본인인 경우 클래스에 active 추가
                title[i].classList.add('active');
                content[i].classList.add('active');
            } else { // 형제 element의 active 클래스 제거
                title[i].classList.remove('active');
                content[i].classList.remove('active');
            }
        }
    }
}

/* Slider */
const modal = document.querySelector('#fullscreenModal');
modal.style.display = 'block';

const track = document.querySelector('.track');
let slideWidth = track.getBoundingClientRect().width;
const slides = Array.from(track.children);

const slidePosition = (slide, index) => {
    slide.style.left = `${slideWidth * index}px`;
}

slides.forEach(slidePosition)
modal.style.display = 'none';

const prevBtn = document.querySelector('.btn.btn-back');
const nextBtn = document.querySelector('.btn.btn-next');
const navIndicator = document.querySelector('.nav-indicator');
const dots = Array.from(navIndicator.children)
let tl = new TimelineMax();

function blur(el, blur) {
    tl.fromTo(el, 0.55,
        {filter: `blur(${blur}px)`},
        {filter: 'blur(0px)'});
}

const slideToMove = (track, currentSlide, targetSlide) => {
    track.style.transition = 'all 500ms ease';
    track.style.transform = `translateX(-${targetSlide.style.left})`;
    currentSlide.classList.remove('active');
    targetSlide.classList.add('active');
}

function updateDots(current, target) {
    current.classList.remove('active')
    target.classList.add('active')
}

function btnShowHide(targetIndex, prevBtn, nextBtn, slides) {
    if (targetIndex === 0) {
        prevBtn.classList.add('hidden')
        nextBtn.classList.remove('hidden')
    } else if (targetIndex === slides.length - 1) {
        prevBtn.classList.remove('hidden')
        nextBtn.classList.add('hidden')
    } else {
        prevBtn.classList.remove('hidden')
        nextBtn.classList.remove('hidden')
    }
}

window.onresize = () => {
    let currentSlide = track.querySelector('.active')

    slideWidth = track.getBoundingClientRect().width;
    slides.forEach(slidePosition);
    track.style.transition = '';
    track.style.transform = `translateX(-${currentSlide.style.left})`
}


nextBtn.addEventListener('click', (e) => {
    let currentSlide = track.querySelector('.active')
    let nextSlide = currentSlide.nextElementSibling;
    let currentDot = navIndicator.querySelector('.active');
    let nextDot = currentDot.nextElementSibling;
    let nextIndex = slides.findIndex(slide => slide === nextSlide)

    slideToMove(track, currentSlide, nextSlide);
    updateDots(currentDot, nextDot);
    btnShowHide(nextIndex, prevBtn, nextBtn, slides);
    if (e.detail > 1) return;
    blur(track, 5)
});

prevBtn.addEventListener('click', (e) => {
    let currentSlide = track.querySelector('.active')
    let prevSlide = currentSlide.previousElementSibling;
    let currentDot = navIndicator.querySelector('.active');
    let prevDot = currentDot.previousElementSibling;
    let prevIndex = slides.findIndex(slide => slide === prevSlide)

    slideToMove(track, currentSlide, prevSlide);
    updateDots(currentDot, prevDot);
    btnShowHide(prevIndex, prevBtn, nextBtn, slides)
    if (e.detail > 1) return;
    blur(track, 5)
});

navIndicator.addEventListener('click', (e) => {
    let targetDot = e.target.closest('.dot');
    if (!targetDot) return;

    let currentSlide = track.querySelector('.active');
    let currentDot = navIndicator.querySelector('.active');
    let targetIndex = dots.findIndex(dot => dot === targetDot)
    let targetSlide = slides[targetIndex];

    slideToMove(track, currentSlide, targetSlide)
    updateDots(currentDot, targetDot);
    btnShowHide(targetIndex, prevBtn, nextBtn, slides)
    if (e.detail > 1) return;
    blur(track, 5)
}); /* End Slider*/

/* FullCalendar */
document.addEventListener('DOMContentLoaded', function () {
    const rentalDate = document.getElementById('rentalDate');
    const receiptStartDuration = document.querySelector('.receipt-start-duration').innerText;
    const receiptEndDuration = document.querySelector('.receipt-end-duration').innerText;
    let calendarEl = document.getElementById('calendar');
    let calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
            left: 'prev',
            center: 'title',
            right: 'next'
        },
        selectable: false,
        businessHours: true,
        dayMaxEvents: true,
        locale: 'ko',
        validRange: {
            start: receiptStartDuration,
            end: receiptEndDuration
        },
        selectOverlap: false,
        showNonCurrentDates: true,
        height: 450,
        dateClick: function (arg) {
            // 사용자가 생성한 이벤트 제거
            calendar.getEvents().forEach(function (event) {
                if (event.groupId === 'user-event') {
                    event.remove();
                }
            });

            // 새 이벤트 추가
            calendar.addEvent({
                title: '신청일',
                start: arg.date,
                allDay: arg.allDay,
                backgroundColor: '#3B71CA',
                groupId: 'user-event' // groupId 설정
            });

            rentalDate.value = arg.dateStr;
            calendar.unselect();
        },
        eventClick: function (arg) {
            // 이벤트 제거
            arg.event.remove();
            rentalDate.value = '';
        }
    });

    calendar.render();
}); /* End FullCalendar */

/* Kakao Maps */
const container = document.getElementById('map');
const address = container.dataset.address;
const detailAddress = container.dataset.detailAddress;
let options = {
    center: new kakao.maps.LatLng(33.450701, 126.570667),
    level: 3
};
let map = new kakao.maps.Map(container, options);
// 주소-좌표 변환 객체를 생성
let geocoder = new kakao.maps.services.Geocoder();
// 주소로 좌표를 검색
geocoder.addressSearch(address, function (result, status) {
    // 정상적으로 검색이 완료됐으면
    if (status === kakao.maps.services.Status.OK) {
        let coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        // 마커를 생성
        let marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });
        // 마커에 표시할 인포윈도우를 생성
        let content = '<div id="infowindow">' + detailAddress + '</div>';
        // 커스텀 오버레이가 표시될 위치
        let position = coords;
        // 커스텀 오버레이를 생성
        let customOverlay = new kakao.maps.CustomOverlay({
            position: position,
            content: content,
            yAnchor: 2.5
        });
        // 지도의 중심을 결과값으로 받은 위치로 이동
        map.setCenter(coords);
        // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록
        kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, customOverlay));
        kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(customOverlay));
        const placeTab = document.querySelector('#place-tab');
        placeTab.addEventListener('click', () => {
            // tab 안에 지도가 있을 경우 처음 로딩시 지도가 깨져서 relayout() 함수를 호출해 크기 조정
            map.relayout();
            // 마커의 위치로 지도의 중심을 다시 설정
            map.setCenter(marker.getPosition());
        });
    }
});

// 인포윈도우를 표시하는 함수
function makeOverListener(map, marker, customOverlay) {
    return function () {
        customOverlay.setMap(map);
    };
}

// 인포윈도우를 닫는 함수
function makeOutListener(customOverlay) {
    return function () {
        customOverlay.setMap(null);
    };
} /* End Kakao Maps */

const reviewTxar = document.querySelector('.review_input');
reviewTxar.oninput = () => {
    const root = document.querySelector(':root');
    const review = document.querySelector('.user_review');

    reviewTxar.style.height = 'auto'; // 높이 초기화
    reviewTxar.style.height = reviewTxar.scrollHeight;
    root.style.setProperty('--reviewHeight', -review.scrollHeight + 'px');
}; /* End Kakao Maps */


const reservationForm = document.querySelector('#reservation-form');
const reservationBtn = document.querySelector('.reservation');

reservationBtn.addEventListener('click', (event) => {
    event.preventDefault();
    reservationForm.submit();
});