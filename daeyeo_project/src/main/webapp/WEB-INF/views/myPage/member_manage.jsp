<%--
  Created by IntelliJ IDEA.
  User: dlsxi
  Date: 2023-04-30
  Time: 오전 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/footer_bottom.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/mypage/myPage.css?after">
    <title>마이페이지</title>

    <!-- Custom fonts for this template-->
    <link href="${path}/resources/css/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">


    <!-- Custom styles for this template-->
    <link href="${path}/resources/css/assets/css/sb-admin-2.min.css" rel="stylesheet">


    <!-- Vendor CSS Files -->
    <link href="${path}/resources/css/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${path}/resources/css/assets/css/style.css" rel="stylesheet">
</head>
<body>

<div class="body_container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="main_content">


        <!-- ======= Sidebar ======= -->
        <div class="my_content">

            <!-- 왼쪽 표 -->
            <div class="divInform">
                <table class="inFormTable">
                    <tr>
                        <th colspan="2">이동하기</th>
                    </tr>
                    <tr>
                        <td><a class="nav-link collapsed" href="/myPage"><i class="bi bi-person"></i> 내 정보</a></td>
                    </tr>
                    <tr>
                        <td><a class="nav-link collapsed" href="../myPage/myWishList"><i
                                class="bi-cart"></i> 찜한 목록</a></td>
                    </tr>

                    <tr>
                        <td><a class="nav-link collapsed" href="../myPage/reservation"><i
                                class="bi-calendar-week"></i> 예약 기록</a></td>
                    </tr>

                    <tr>
                        <td><a class="nav-link collapsed" href="../myPage/rental_manage"><i
                                class="bi-table"></i> 대여 관리</a></td>
                    </tr>
                    <tr>
                        <td><a class="nav-link collapsed" href="../myPage/rental_log"><i
                                class="bi-cart-check"></i> 대여 기록</a></td>
                    </tr>
                    <tr>
                        <td><a class="nav-link collapsed" href="../myPage/member_manage"><i
                                class="bi-person-lines-fill"></i> 회원 관리</a></td>
                    </tr>
                </table>
            </div>
            <!-- End Sidebar-->


            <div class="pagetitle">
                <h1>나의 회원 관리</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item">MyPage</li>
                        <li class="breadcrumb-item active">Member Manage</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section">
                <div class="row">
                    <div class="col-lg-12">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">회원 정보 검색</h5>
                                <!-- Table with stripped rows -->
                                <table class="table datatable">
                                    <thead>
                                    <tr>
                                        <th scope="col">index</th>
                                        <th scope="col">회원 유형</th>
                                        <th scope="col">회원 이름</th>
                                        <th scope="col">생년 월일</th>
                                        <th scope="col">번호</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <th scope="row">1</th>
                                        <td>일반 회원</td>
                                        <td>홍길동</td>
                                        <td>1990-01-01</td>
                                        <td>010-1234-5678</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">2</th>
                                        <td>VIP 회원</td>
                                        <td>김철수</td>
                                        <td>1985-03-15</td>
                                        <td>010-9876-5432</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">3</th>
                                        <td>일반 회원</td>
                                        <td>박민수</td>
                                        <td>1988-09-10</td>
                                        <td>010-3692-8147</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">4</th>
                                        <td>VIP 회원</td>
                                        <td>이지현</td>
                                        <td>1992-12-25</td>
                                        <td>010-7654-3210</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">5</th>
                                        <td>일반 회원</td>
                                        <td>송재민</td>
                                        <td>1991-07-08</td>
                                        <td>010-5678-1234</td>
                                    </tr>
                                    <tr>
                                        <th scope="row">6</th>
                                        <td>일반 회원</td>
                                        <td>이영희</td>
                                        <td>2000-01-04</td>
                                        <td>010-5678-1234</td>
                                    </tr>

                                    </tbody>
                                </table>
                                <!-- End Table with stripped rows -->

                            </div>
                        </div>

                    </div>
                </div>
            </section>


            <section class="section">
                <div class="row">
                    <div class="col-lg-6">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">회원별 대여 기록</h5>
                                <table class="table datatable">
                                    <thead>
                                    <tr>
                                        <th scope="col">회원 이름</th>
                                        <th scope="col">예약 횟수</th>
                                        <th scope="col">이용 후기</th>
                                        <th scope="col">회원 별점</th>
                                        <th scope="col">정지 여부</th>
                                        <th scope="col">숫자</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>홍길동</td>
                                        <td>5</td>
                                        <td>좋았어요!</td>
                                        <td>4.5</td>
                                        <td>정지 안 함</td>
                                        <td>1</td>
                                    </tr>
                                    <tr>
                                        <td>김철수</td>
                                        <td>10</td>
                                        <td>매우 만족합니다!</td>
                                        <td>5.0</td>
                                        <td>정지 안 함</td>
                                        <td>2</td>
                                    </tr>
                                    <tr>
                                        <td>이영희</td>
                                        <td>3</td>
                                        <td>추천합니다!</td>
                                        <td>4.0</td>
                                        <td>정지 안 함</td>
                                        <td>3</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>

                    <div class="col-lg-6">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">회원별 수익</h5>
                                <table class="table datatable">
                                    <thead>
                                    <tr>
                                        <th scope="col">회원 이름</th>
                                        <th scope="col">회원 유형</th>
                                        <th scope="col">누적 결제금액</th>
                                        <th scope="col">누적 수수료</th>
                                        <th scope="col">메모</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>홍길동</td>
                                        <td>일반 회원</td>
                                        <td>500,000원</td>
                                        <td>50,000원</td>
                                        <td>-</td>
                                    </tr>
                                    <tr>
                                        <td>김철수</td>
                                        <td>VIP 회원</td>
                                        <td>1,000,000원</td>
                                        <td>100,000원</td>
                                        <td>-</td>
                                    </tr>
                                    <tr>
                                        <td>이영희</td>
                                        <td>일반 회원</td>
                                        <td>300,000원</td>
                                        <td>30,000원</td>
                                        <td>-</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
            </section>
        </div>

        <!-- Vendor JS Files -->
        <script src="${path}/resources/css/assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="${path}/resources/css/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="${path}/resources/css/assets/vendor/chart.js/chart.umd.js"></script>
        <script src="${path}/resources/css/assets/vendor/echarts/echarts.min.js"></script>
        <script src="${path}/resources/css/assets/vendor/quill/quill.min.jss"></script>
        <script src="${path}/resources/css/assets/vendor/simple-datatables/simple-datatables.js"></script>
        <script src="${path}/resources/css/assets/vendor/tinymce/tinymce.min.js"></script>
        <script src="${path}/resources/css/assets/vendor/php-email-form/validate.js"></script>


        <!-- Template Main JS File -->
        <script src="${path}/resources/css/assets/js/main.js"></script>
    </div>
    <%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
