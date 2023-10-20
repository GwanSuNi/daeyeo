    const themeObj = {
    //bgColor: "", //바탕 배경색
    searchBgColor: "#3B71CA", //검색창 배경색
    //contentBgColor: "", //본문 배경색(검색결과,결과없음,첫화면,검색서제스트)
    //pageBgColor: "", //페이지 배경색
    //textColor: "", //기본 글자색
    queryTextColor: "#FFFFFF" //검색창 글자색
    //postcodeTextColor: "", //우편번호 글자색
    //emphTextColor: "", //강조 글자색
    //outlineColor: "", //테두리
};

    let element_wrap = document.getElementById("wrap");

    function foldDaumPostcode() {
    element_wrap.style.display = 'none';
}

//     function execDaumPostcode() {
//     let currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
//     new daum.Postcode({
//     oncomplete: function (data) {
//     let address = data.address;
//     let jibunAddress = data.jibunAddress;
//     if (address !== '' || jibunAddress !== '') {
//     document.querySelector("input[name=userAddress]").value = address;
//     document.querySelector("input[name=jibunAddress]").value = jibunAddress;
//     document.querySelector("input[name=zipCode]").value = data.zonecode;
//     document.querySelector("input[name=sido]").value = data.sido;
//     document.querySelector("input[name=sigungu]").value = data.sigungu;
//     document.querySelector("input[name=phoneNum]").focus();
//     element_wrap.style.display = 'none';
//     document.body.scrollTop = currentScroll;
// }
// },
//     // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
//     onresize: function (size) {
//     element_wrap.style.height = size.height + 'px';
// },
//     width: '100%',
//     height: '100%',
//     theme: themeObj
// }).embed(element_wrap);
//     // iframe을 넣은 element를 보이게 한다.
//     element_wrap.style.display = 'block';
// }

    // function stopDefAction(event) {
    //     event.preventDefault();
    // }

    function execDaumPostcode() {
        // 현재 scroll 위치를 저장해놓는다.
        var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function(data) {
                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("address.extraAddress").value = extraAddr;
                } else {
                    document.getElementById("address.extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("address.postcode").value = data.zonecode;
                document.getElementById("address.address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("address.detailAddress").focus();

                // iframe을 넣은 element를 안보이게 한다.
                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                element_wrap.style.display = 'none';

                // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                document.body.scrollTop = currentScroll;
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize : function(size) {
                element_wrap.style.height = size.height+'px';
            },
            width : '100%',
            height : '100%'
        }).embed(element_wrap);

        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }

    function compareInputs() {
        // 두 개의 입력 필드의 값을 가져옵니다.
        var input1 = document.getElementById("userPw2").value;
        var input2 = document.getElementById("userPw").value;

        var resultElement = document.getElementById("result"); // 결과를 표시할 요소 참조

        if (input1 === input2) {
            resultElement.textContent = "비밀번호가 동일합니다";
        } else {
            resultElement.textContent = "비밀번호가 다릅니다. 다시 확인해주세요.";
        }
    }