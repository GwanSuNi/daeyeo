<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- BootStrap CSS File -->
    <link href="${path}/resources/css/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/css/style.css" rel="stylesheet">
    <!-- Dropzone CSS File -->
    <link rel="stylesheet" href="https://unpkg.com/dropzone@5/dist/min/dropzone.min.css" type="text/css"/>
    <!-- CSS File -->
    <link href="${path}/resources/css/rental/rental_registration_form.css" rel="stylesheet">

    <title>대여 등록 양식 | 대여대여</title>
</head>
<body>
<div class="wrapper">
    <jsp:include page="../includes/header.jsp"/>
    <form action="/rental/register.do" class="container">
        <div class="content-title">대여 등록</div>
        <div class="content">
            <ul class="card">

                <li class="item">
                    <div class="item-title">분류</div>
                    <div class="item-content">
                        <div class="category">
                            <select name="mcId" class="main-cate form-select">
                                <option value="" selected>선택</option>
                            </select>
                            <select name="scId" class="sub-cate form-select" aria-label="Default select example">
                                <option value="" selected>선택</option>
                            </select>
                        </div>
                    </div>
                </li>

                <li class="item">
                    <div class="item-title">제목</div>
                    <div class="item-content">
                        <input type="text" class="txt" name="objectName">
                    </div>
                </li>

                <li class="item">
                    <div class="item-title">대상</div>
                    <div class="item-content">
                        <input type="text" class="txt" name="target">
                    </div>
                </li>

                <li class="item">
                    <div class="item-title">이용요금</div>
                    <div class="item-content">
                        <input type="number" class="num" name="price"><b>원</b>
                    </div>
                </li>

                <li class="item">
                    <div class="item-title">장소</div>
                    <div class="item-content">
                        <input type="text" class="txt" name="location">
                    </div>
                </li>

                <li class="item">
                    <div class="item-title">웹사이트</div>
                    <div class="item-content">
                        <input type="text" class="txt" name="website">
                    </div>
                </li>

                <%--구현안됨--%>
                <%--                <li class="item">--%>
                <%--                    <div class="item-title">사진</div>--%>
                <%--                    <div class="item-content">--%>
                <%--                        <div class="dropzone" id="myDropzone"></div>--%>
                <%--                    </div>--%>
                <%--                </li>--%>

                <li class="item">
                    <div class="item-title">주소</div>
                    <div class="item-content address">
                        <input type="text" class="txt" name="roadAddress" tabindex="-1" readonly>
                        <a class="a-btn find-address-btn" data-bs-toggle="modal"
                           data-bs-target="#modalDialogScrollable">주소 찾기</a>
                    </div>
                    <input type="hidden" id="zipCode" name="zipCode"/>
                    <input type="hidden" id="jibunAddress" name="jibunAddress"/>
                    <input type="hidden" id="sido" name="sido"/>
                    <input type="hidden" id="sigungu" name="sigungu"/>
                </li>
                <!-- Modal Dialog Scrollable -->
                <div class="modal fade" id="modalDialogScrollable" tabindex="-1">
                    <div class="modal-dialog modal-dialog-scrollable">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">대여대여 | 주소 찾기</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div id="find-address"></div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                            </div>
                        </div>
                    </div>
                </div><!-- End Modal Dialog Scrollable-->

                <li class="item">
                    <div class="item-title">오시는 길</div>
                    <div class="item-content">
                        <iframe src="/txtEditor" class="txt-editor" scrolling="no"></iframe>
                        <input type="hidden" name="locationInfo" value="">
                    </div>
                </li>

                <li class="item">
                    <div class="item-title">접수기간</div>
                    <div class="item-content">
                        <div class="reception">
                            <input type="date" name="receiptStartDuration"><span>~</span><input type="date"
                                                                                                name="receiptEndDuration">
                        </div>
                    </div>
                </li>

                <li class="item">
                    <div class="item-title">사용기간</div>
                    <div class="item-content">
                        <div class="use">
                            <input type="date" name="startDuration"><span>~</span><input type="date" name="endDuration">
                        </div>
                    </div>
                </li>

                <li class="item">
                    <div class="item-title">모집정원</div>
                    <div class="item-content">
                        <input type="number" class="num" name="capacity"><b>명</b>
                    </div>
                </li>

<%--                DB에 없음--%>
<%--                <li class="item">--%>
<%--                    <div class="item-title">취소기간</div>--%>
<%--                    <div class="item-content">--%>
<%--                        <b>이용일 </b><input type="number" class="cancellation"><b>일 전까지</b>--%>
<%--                    </div>--%>
<%--                </li>--%>

<%--                DB에 없음--%>
<%--                <li class="item">--%>
<%--                    <div class="item-title">예약방법</div>--%>
<%--                    <div class="item-content">--%>
<%--                        <div class="reservation">--%>
<%--                            <div class="online">--%>
<%--                                <input type="checkbox" id="online">--%>
<%--                                <label for="online">온라인 예약</label>--%>
<%--                            </div>--%>
<%--                            <div class="visit">--%>
<%--                                <input type="checkbox" id="visit">--%>
<%--                                <label for="visit">방문 예약</label>--%>
<%--                            </div>--%>
<%--                            <div class="call">--%>
<%--                                <input type="checkbox" id="call">--%>
<%--                                <label for="call">전화 예약</label>--%>
<%--                            </div>--%>
<%--                            <div class="site">--%>
<%--                                <input type="checkbox" id="site">--%>
<%--                                <label for="site">외부 사이트</label>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </li>--%>

                <li class="item">
                    <div class="item-title">문의전화</div>
                    <div class="item-content">
                        <div class="phone">
                            <input type="text" name="firstNum" maxlength="3"/>
                            <span>-</span>
                            <input type="text" name="middleNum" maxlength="4"/>
                            <span>-</span>
                            <input type="text" name="lastNum" maxlength="4"/>
                        </div>
                        <input type="hidden" name="representNum" value="">
                    </div>
                </li>

                <li class="item">
                    <div class="item-title">이용안내</div>
                    <div class="item-content">
                        <iframe src="/txtEditor" class="txt-editor" scrolling="no"></iframe>
                        <input type="hidden" name="useInfo" value="">
                    </div>
                </li>
            </ul>

            <div class="btn-box">
                <a href="" class="a-btn">취소하기</a>
                <a href="#" class="registration a-btn">등록하기</a>
            </div>
        </div>
    </form>
    <jsp:include page="../includes/footer.jsp"/>
</div>
</body>
<!-- BootStrap JS File -->
<script src="${path}/resources/css/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Dropzone JS File -->
<script src="https://unpkg.com/dropzone@5/dist/min/dropzone.min.js"></script>
<!-- Kakao Local JS File -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- JS File -->
<script src="${path}/resources/js/rental/rentalRegistrationForm.js"></script>
</html>