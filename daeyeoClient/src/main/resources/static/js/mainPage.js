// 지역 선택
const area0 = ["서울특별시", "인천광역시", "대전광역시", "광주광역시", "대구광역시", "울산광역시", "부산광역시", "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주도"];
const area1 = ["강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"];
const area2 = ["계양구", "남구", "남동구", "동구", "부평구", "서구", "연수구", "중구", "강화군", "옹진군"];
const area3 = ["대덕구", "동구", "서구", "유성구", "중구"];
const area4 = ["광산구", "남구", "동구", "북구", "서구"];
const area5 = ["남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군"];
const area6 = ["남구", "동구", "북구", "중구", "울주군"];
const area7 = ["강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "기장군"];
const area8 = ["고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시", "가평군", "양평군", "여주군", "연천군"];
const area9 = ["강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시", "태백시", "고성군", "양구군", "양양군", "영월군", "인제군", "정선군", "철원군", "평창군", "홍천군", "화천군", "횡성군"];
const area10 = ["제천시", "청주시", "충주시", "괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "증평군", "진천군", "청원군"];
const area11 = ["계룡시", "공주시", "논산시", "보령시", "서산시", "아산시", "천안시", "금산군", "당진군", "부여군", "서천군", "연기군", "예산군", "청양군", "태안군", "홍성군"];
const area12 = ["군산시", "김제시", "남원시", "익산시", "전주시", "정읍시", "고창군", "무주군", "부안군", "순창군", "완주군", "임실군", "장수군", "진안군"];
const area13 = ["광양시", "나주시", "목포시", "순천시", "여수시", "강진군", "고흥군", "곡성군", "구례군", "담양군", "무안군", "보성군", "신안군", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"];
const area14 = ["경산시", "경주시", "구미시", "김천시", "문경시", "상주시", "안동시", "영주시", "영천시", "포항시", "고령군", "군위군", "봉화군", "성주군", "영덕군", "영양군", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군"];
const area15 = ["거제시", "김해시", "마산시", "밀양시", "사천시", "양산시", "진주시", "진해시", "창원시", "통영시", "거창군", "고성군", "남해군", "산청군", "의령군", "창녕군", "하동군", "함안군", "함양군", "합천군"];
const area16 = ["서귀포시", "제주시", "남제주군", "북제주군"];
const area = {
    'area1': area1,
    'area2': area2,
    'area3': area3,
    'area4': area4,
    'area5': area5,
    'area6': area6,
    'area7': area7,
    'area8': area8,
    'area9': area9,
    'area10': area10,
    'area11': area11,
    'area12': area12,
    'area13': area13,
    'area14': area14,
    'area15': area15,
    'area16': area16
};
const sido = document.querySelector('.sido');
const sigungu = document.querySelector('.sigungu');

// 시/도 선택 박스 초기화
area0.forEach((value) => {
    sido.options[sido.options.length] = new Option(value, value);
});

// 시/도 선택시 시/군/구 설정
sido.addEventListener('change', () => {
    const select = sido.selectedIndex;

    sigungu.options.length = 1;

    if (select !== 0) {
        area['area' + select].forEach((value) => {
            sigungu.options[sigungu.options.length] = new Option(value, value);
        });
    }
});


// 분류 선택
const cate0 = ['강의실', '강당', '회의실', '축구장', '농구장', '야구장'];
const cate1 = [];
const cate = {'cate0': cate0, 'cate1': cate1};
const activeCate = document.querySelector('.category.active');
const initCate = cate['cate' + activeCate.value];
const tab = document.querySelectorAll('.category');
const category = document.querySelector('.sub-category');
const mainCate = document.querySelector('#main-cate');

initCate.forEach((item) => {
    category.options[category.options.length] = new Option(item, item);
});

tab.forEach((e, num) => {
    e.addEventListener('click', () => {
        category.options.length = 1;
        cate['cate' + num].forEach((value) => {
            category.options[category.options.length] = new Option(value, value);
        });
        mainCate.value = e.innerText;
    });
});


// 가로 스크롤
const sliderBox = document.querySelector('.slider-box');
const slider = document.querySelector('.slider');
let sbWidth = sliderBox.offsetWidth;
let sWidth = slider.offsetWidth;
let sMoveMax = (sbWidth < sWidth) ? (sWidth - sbWidth) : 0;
const indiBarLine = document.querySelector('.indicator');
const indiBar = document.querySelector('.indi-bar');
let indiBarMax = indiBarLine.offsetWidth - indiBar.offsetWidth;
let sPos = 0;
let pct = 0;

sliderBox.addEventListener('wheel', (e) => {
    if (sMoveMax > 0) {
        e.preventDefault();
        move_slider(e.deltaY);
    }
});

function move_slider(amount) {
    sPos += amount;

    if (sPos > sMoveMax)
        sPos = sMoveMax;
    else if (sPos < 0)
        sPos = 0;

    pct = sPos / sMoveMax * indiBarMax;
    slider.style.transform = `translate(-${sPos}px, -50%)`;
    indiBar.style.transform = `translate(${pct}px, -50%)`;
}

window.onresize = () => {
    let newSbWidth = sliderBox.offsetWidth
    let ratio = newSbWidth / sbWidth;

    sbWidth = newSbWidth;
    sWidth = slider.offsetWidth;
    sMoveMax = (sbWidth < sWidth) ? (sWidth - sbWidth) : 0;
    indiBarMax = indiBarLine.offsetWidth - indiBar.offsetWidth;
    pct = pct * ratio;
    sPos = pct / indiBarMax * sMoveMax;
    slider.style.transform = `translate(-${sPos}px, -50%)`;
    indiBar.style.transform = `translate(${pct}px, -50%)`;
}

indiBar.addEventListener('mousedown', (event) => {
    event.preventDefault();

    let shiftX = event.clientX - indiBar.getBoundingClientRect().left;

    indiBar.style.transition = 'none';
    document.addEventListener('mousemove', onMouseMove);
    document.addEventListener('mouseup', onMouseUp);

    function onMouseMove(event) {
        pct = event.clientX - indiBarLine.getBoundingClientRect().left - shiftX;

        if (pct > indiBarMax)
            pct = indiBarMax;
        else if (pct < 0)
            pct = 0;

        sPos = pct / indiBarMax * sMoveMax;
        slider.style.transform = `translate(-${sPos}px, -50%)`;
        indiBar.style.transform = `translate(${pct}px, -50%)`;
    }

    function onMouseUp() {
        document.removeEventListener('mouseup', onMouseUp);
        document.removeEventListener('mousemove', onMouseMove);
        indiBar.style.transition = '';
    }
});