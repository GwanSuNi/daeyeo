<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- BootStrap CSS File -->
    <link href="${path}/resources/css/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/css/style.css" rel="stylesheet">
    <!-- Dropzone CSS File -->
    <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css" />
    <!-- CSS File -->
    <link href="${path}/resources/css/rental/rental_registration_form.css" rel="stylesheet">

    <title>대여 등록 양식 | 대여대여</title>
</head>
<body>
<div class="wrapper">
    <jsp:include page="../includes/header.jsp"/>
    <div class="container">
        <div class="content-title">대여 등록</div>
        <div class="content">
            <ul class="card">
                <li class="item">
                    <div class="item-title">분류</div>
                    <div class="item-content">
                        <div class="category">
                            <select class="main-cate form-select">
                                <option value="0" selected>선택</option>
                            </select>
                            <select class="sub-cate form-select" aria-label="Default select example">
                                <option value="0" selected>선택</option>
                            </select>
                        </div>
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">제목</div>
                    <div class="item-content">
                        <input type="text" class="txt">
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">장소</div>
                    <div class="item-content">
                        <input type="text" class="txt">
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">사진</div>
                    <div class="item-content">
                        <div class="dropzone" id="myDropzone"></div>
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">주소</div>
                    <div class="item-content">
                        <input type="text" class="txt">
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">오시는 길</div>
                    <div class="item-content">
                        <iframe src="/txtEditor" class="txt-editor" scrolling="no"></iframe>
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">이용요금</div>
                    <div class="item-content">
                        <input type="number" class="price"><b>원</b>
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">접수기간</div>
                    <div class="item-content">
                        <div class="reception">
                            <input type="date"><span>~</span><input type="date">
                        </div>
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">사용기간</div>
                    <div class="item-content">
                        <div class="use">
                            <input type="date"><span>~</span><input type="date">
                        </div>
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">취소기간</div>
                    <div class="item-content">
                        <b>이용일 </b><input type="number" class="cancellation"><b>일 전까지</b>
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">예약방법</div>
                    <div class="item-content">
                        <div class="reservation">
                            <div class="online">
                                <input type="checkbox" id="online">
                                <label for="online">온라인 예약</label>
                            </div>
                            <div class="visit">
                                <input type="checkbox" id="visit">
                                <label for="visit">방문 예약</label>
                            </div>
                            <div class="call">
                                <input type="checkbox" id="call">
                                <label for="call">전화 예약</label>
                            </div>
                            <div class="site">
                                <input type="checkbox" id="site">
                                <label for="site">외부 사이트</label>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">문의전화</div>
                    <div class="item-content">
                        <div class="phone">
                            <input type="text" maxlength="3" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
                            <span>-</span>
                            <input type="text" maxlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
                            <span>-</span>
                            <input type="text" maxlength="4" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
                        </div>
                    </div>
                </li>
                <li class="item">
                    <div class="item-title">이용안내</div>
                    <div class="item-content">
                        <iframe src="/txtEditor" class="txt-editor" scrolling="no"></iframe>
                    </div>
                </li>
            </ul>
            <div class="btn-box">
                <a href="" class="a-btn">취소하기</a>
                <a href="" class="a-btn">등록하기</a>
            </div>
        </div>
    </div>
    <jsp:include page="../includes/footer.jsp"/>
</div>
</body>
<!-- BootStrap JS File -->
<!-- Dropzone JS File -->
<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
<!-- JS File -->
<script src="${path}/resources/js/rental/rentalRegistrationForm.js"></script>
</html>