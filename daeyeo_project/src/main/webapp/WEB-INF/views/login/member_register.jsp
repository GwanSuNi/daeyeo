<%--
  Created by IntelliJ IDEA.
  User: gwansuni
  Date: 2023/05/16
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>회원가입</title>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/footer_bottom.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/login_style.css">
    <!-- Custom fonts for this template-->
    <link href="${path}/resources/css/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/resources/css/assets/css/sb-admin-2.min.css" rel="stylesheet">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <%--    <script>--%>
    <%--        window.onload = function () {--%>
    <%--            document.getElementById("userAddress").addEventListener("click", () => {--%>
    <%--                new daum.Postcode({--%>
    <%--                    oncomplete: function (data) {--%>
    <%--                        let address = data.address;--%>
    <%--                        if (address !== '') { // 주소가 존재할 경우--%>
    <%--                            document.getElementById("userAddress").value = address;--%>
    <%--                            document.querySelector("input[name=userDepartment]").focus();--%>
    <%--                        }--%>
    <%--                    }--%>
    <%--                }).open();--%>
    <%--            })--%>
    <%--        }--%>
    <%--    </script>--%>

</head>
<body>
<div class="body_container">
    <%-- header --%>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="main_content">
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-5 d-none d-lg-block bg-login-image"></div>
                            <div class="col-lg-7">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
                                    </div>
                                    <form action="/login/register" method="post" class="user">
                                        <!-- name속성: 서버로 전송할 때 변수이름의 역할 -->
                                        <div class="form-group">
                                            <input type="text" name="userName" class="form-control form-control-user"
                                                   id="exampleFirstName"
                                                   placeholder="이름 입력">
                                        </div>
                                        <div class="form-group">
                                            <input type="email" name="userEmail" class="form-control form-control-user"
                                                   id="floatingInput"
                                                   placeholder="이메일 입력">
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="password" name="userPw"
                                                       class="form-control form-control-user"
                                                       id="exampleInputPassword" placeholder="비밀번호 입력">
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="password" name="userPw"
                                                       class="form-control form-control-user"
                                                       id="exampleRepeatPassword" placeholder="비밀번호 다시 입력">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input type="text" id="phoneNum" name="phoneNum"
                                                   class="form-control form-control-user"
                                                   placeholder="번호 입력">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" id="userAddress" name="location"
                                                   class="form-control form-control-user"
                                                   placeholder="주소 입력" onclick="execDaumPostcode();"
                                                   onfocus="execDaumPostcode()">
                                        </div>
                                        <div id="wrap"
                                             style="display:none;border:1px solid;width:500px;height:300px;margin:5px 0;position:relative">
                                            <img src="<c:url value="//t1.daumcdn.net/postcode/resource/images/close.png"/>"
                                                 id="btnFoldWrap"
                                                 style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1"
                                                 onclick="foldDaumPostcode()"
                                                 alt="접기 버튼">
                                        </div>

                                        <div class="form-group">
                                            <input type="text" name="userDepartment"
                                                   class="form-control form-control-user"
                                                   placeholder="소속 입력">
                                        </div>

                                        <input type="submit" class="btn btn-primary btn-user btn-block" value="회원가입하기">
                                        <hr>
                                        <a href="index.html" class="btn btn-google btn-user btn-block">
                                            <i class="fab fa-google fa-fw"></i> Register with Google
                                        </a>
                                        <%--                                        <a href="index.html" class="btn btn-facebook btn-user btn-block">--%>
                                        <%--                                            <i class="fab fa-facebook-f fa-fw"></i> Register with KakaoTalk--%>
                                        <%--                                        </a>--%>
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="../login/findPw">비밀번호 찾기</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="../login">계정이 있으시다면? 로그인하기</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
<script>
    let element_wrap = document.getElementById("wrap");

    function foldDaumPostcode() {
        element_wrap.style.display = 'none';
    }

    function execDaumPostcode() {
        let currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
        new daum.Postcode({
            oncomplete: function (data) {
                let address = data.address;
                if (address !== '') {
                    document.getElementById("userAddress").value = address;
                    document.querySelector("input[name=userDepartment]").focus();
                    element_wrap.style.display = 'none';
                    document.body.scrollTop = currentScroll;
                }
            },
            // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
            onresize: function (size) {
                element_wrap.style.height = size.height + 'px';
            },
            width: '100%',
            height: '100%'
        }).embed(element_wrap);
        // iframe을 넣은 element를 보이게 한다.
        element_wrap.style.display = 'block';
    }

    // 페이지 로드가 완료되면 다음 함수를 실행합니다.
    $(document).ready(function () {
        // submit 버튼을 클릭하면, 해당 함수를 실행합니다.
        $("form[action='/login/register']").submit(function (e) {
            e.preventDefault();

            // 입력 유효성 검사
            let userName = $("input[name='userName']").val();
            let userEmail = $("input[name='userEmail']").val();
            let userPw = $("input[name='userPw']").val();
            let userPwRepeat = $("#exampleRepeatPassword").val();
            let userAddress = $("#userAddress").val();
            let userDepartment = $("input[name='userDepartment']").val();

            // 비어 있는 값이 있는지 확인합니다.
            if (!userName || !userEmail || !userPw || !userAddress || !userDepartment) {
                alert("모든 입력란을 채워주시기 바랍니다.");
                return false;
            }

            // 비밀번호가 일치하는지 확인합니다.
            if (userPw !== userPwRepeat) {
                alert("비밀번호가 일치하지 않습니다.");
                return false;
            }

            // 이메일 유효성 확인 (간단한 이메일 유효성 검사)
            let emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            if (!emailRegex.test(userEmail)) {
                alert("올바른 이메일 형식이 아닙니다.");
                return false;
            }

            // 유효성 검사가 끝났다면, form을 제출합니다.
            this.submit();
        });
    });
</script>
</body>
</html>
