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
    if (targetIndex == 0) {
        prevBtn.classList.add('hidden')
        nextBtn.classList.remove('hidden')
    } else if (targetIndex == slides.length - 1) {
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
    var calendarEl = document.getElementById('calendar');
    var calendar = new FullCalendar.Calendar(calendarEl, {
        headerToolbar: {
            left: 'prev',
            center: 'title',
            right: 'next'
        },
        // initialDate: '2023-01-12', // 지정하지 않으면 현재 날짜로 기본 설정
        selectable: true,
        businessHours: true,
        dayMaxEvents: true,
        locale: 'ko',
        // weekends: false,
        // hiddenDays: [ 0,6 ],
        validRange: {
            start: '2023-02',
            end: '2023-06-20'
        },
        selectOverlap: false,
        // selectConstraint: {[1,2,3,4,5]}, // groupId가 998인 것만 event 선택 가능
        // selectOverlap: function(event) {
        // return !(event.groupId == "999"); // groupId가 999인 것은 overlap 불가
        // },
        select: function (arg) {
            var title = prompt('Event Title:');
            if (title) {
                calendar.addEvent({
                    title: title,
                    start: arg.start,
                    end: arg.end,
                    allDay: arg.allDay,
                    backgroundColor: '#3B71CA'
                })
            }
            console.log(arg.startStr);
            console.log(arg.endStr);
            calendar.unselect();
        },
        eventClick: function (arg) {
            if (confirm('삭제')) {
                arg.event.remove()
            }
        },
        events: [
            {
                title: 'All Day Event',
                start: '2023-01-01'
            },
            {
                title: 'Long Event',
                start: '2023-01-07',
                end: '2023-01-10'
            },
            {
                groupId: 999,
                title: 'Repeating Event',
                start: '2023-01-09T16:00:00'
            },
            {
                groupId: 998,
                title: 'Repeating Event',
                start: '2023-01-16'
            },
            {
                title: 'Meeting',
                start: '2023-01-12T10:30:00',
                end: '2023-01-12T12:30:00'
            },
            {
                title: 'Click for Google',
                url: 'http://google.com/',
                start: '2023-01-28'
            }
        ]
    });

    calendar.render();
}); /* End FullCalendar */

/* Kakao Maps */
let container = document.getElementById('map');
let options = {
    center: new kakao.maps.LatLng(33.450701, 126.570667),
    level: 3
};
let map = new kakao.maps.Map(container, options);
const placeTab = document.querySelector('#place-tab');
// tab 안에 지도가 있을 경우 처음 로딩시 지도가 깨져서 relayout() 함수를 호출해 크기 조정
placeTab.addEventListener('click', () => map.relayout());
/* End Kakao Maps */

const reviewTxar = document.querySelector('.review_input');
reviewTxar.oninput = () => {
    const root = document.querySelector(':root');
    const review = document.querySelector('.user_review');

    reviewTxar.style.height = 'auto'; // 높이 초기화
    reviewTxar.style.height = reviewTxar.scrollHeight;
    root.style.setProperty('--reviewHeight', -review.scrollHeight + 'px');
};