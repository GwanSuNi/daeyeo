<%--
  Created by IntelliJ IDEA.
  User: seosanghyeon
  Date: 2023/05/15
  Time: 2:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: seosanghyeon
  Date: 2023/06/03
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: seosanghyeon
  Date: 2023/05/15
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: seosanghyeon
  Date: 2023/05/15
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<html>
<head>
    <!-- Favicons -->
    <link href="${path}/resources/css/assets/img/favicon.png" rel="icon">
    <link href="${path}/resources/css/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="${path}/resources/css/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/vendor/simple-datatables/style.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="${path}/resources/css/assets/css/style.css" rel="stylesheet">
    <title>어드민 메인페이지</title>
</head>
<body>
<!-- ======= Header ======= -->
<header id="header" class="header fixed-top d-flex align-items-center">
    <div class="d-flex align-items-center justify-content-between">
        <a href="${path}/adminMainPage" class="logo d-flex align-items-center">
            <img src="assets/img/logo.png" alt="">       <!-- 이미지 바꾸기 -->
            <span class="d-none d-lg-block">NoobGPT</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>  <!-- 메뉴 열고닫는 버튼-->
    </div>
    <!-- End Logo -->

    <div class="search-bar">
        <form class="search-form d-flex align-items-center" method="POST" action="#">
            <input type="text" name="query" placeholder="Search" title="Enter search keyword">
            <button type="submit" title="Search"><i class="bi bi-search"></i></button>
        </form>
    </div>

    <!-- End Search Bar -->

</header>
<!-- End Header -->

<!-- ======= Sidebar ======= -->
<aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

        <li class="nav-item">

            <a class="nav-link collapsed" href="${path}/adminMainPage">
                <i class="bi bi-grid"></i>
                <span>대쉬보드</span>
            </a>
        </li>

        <!-- End Dashboard Nav -->

        <!-- Start member Nav -->
        <li class="nav-item">

            <a class="nav-link collapsed" data-bs-target="#member-nav" data-bs-toggle="collapse" href="#">

                <i class="bi bi-menu-button-wide"></i>
                <span>회원관리</span>
                <i class="bi bi-chevron-down ms-auto"></i>

            </a>


            <ul id="member-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">

                <li>

                    <a href="${path}/adminMemberPage">
                        <i class="bi bi-circle"></i><span>회원 테이블</span>
                    </a>

                </li>

            </ul>
        </li>

        <!-- End Member Nav -->

        <!-- Start Content Nav -->

        <li class="nav-item">

            <a class="nav-link collapsed" data-bs-target="#content-nav" data-bs-toggle="collapse" href="#">

                <i class="bi bi-journal-text"></i><span>컨텐츠관리</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="content-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">

                <li>
                    <a href="${path}/adminPostPage">
                        <i class="bi bi-circle"></i><span>전체 게시물</span>
                    </a>
                </li>

                <li>
                    <a href="${path}/adminReviewPage">
                        <i class="bi bi-circle"></i><span>후기 관리</span>
                    </a>
                </li>
            </ul>
        </li>

        <!-- End Content Nav -->

        <!-- Start Statistics Nav -->
        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#statistics-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-layout-text-window-reverse"></i><span>통계</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="statistics-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
                <li>
                    <a href="${path}/adminStatisticsPage">
                        <i class="bi bi-circle"></i><span>일별 요약</span>
                    </a>
                </li>
                <li>
                    <a href="https://analytics.google.com/analytics/web/?hl=ko&pli=1#/p363945097/realtime/overview?params=_u..pageSize%3D25%26_u..nav%3Dmaui">
                        <i class="bi bi-circle"></i><span>방문자 현황 그래프</span>
                    </a>
                </li>
            </ul>
        </li>

        <!-- End Statistics Nav -->

        <!-- Start Ad Nav -->

        <li class="nav-item">
            <a class="nav-link collapsed" data-bs-target="#Ad-nav" data-bs-toggle="collapse" href="#">
                <i class="bi bi-bar-chart"></i><span>광고 관리</span><i class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="Ad-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
                <li>
                    <a href="/${path}adminAdPage">
                        <i class="bi bi-circle"></i><span>광고수익 전체통계</span>
                    </a>
                </li>
                <li>
                    <a href="/${path}adminAdFormPage">
                        <i class="bi bi-circle"></i><span>광고 수익 신청 양식</span>
                    </a>
                </li>
            </ul>
        </li>

        <!-- End Ad Nav -->
    </ul>
</aside>

<!-- End Sidebar-->

<main id="main" class="main">
    <div class="pagetitle">
        <h1>일자별 요약</h1>
        <nav>
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="index.html">통계</a></li>
                <li class="breadcrumb-item active">일별 요약</li>
            </ol>
        </nav>
    </div><!-- End Page Title -->


    <div class="card">
        <div class="card-body">
            <h5 class="card-title">일,월,별 요약</h5>
            <!-- Bordered Tabs -->
            <ul class="nav nav-tabs nav-tabs-bordered" id="borderedTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active" id="day-tab" data-bs-toggle="tab" data-bs-target="#day" type="button" role="tab" aria-controls="home" aria-selected="true">일별</button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="month-tab" data-bs-toggle="tab" data-bs-target="#month" type="button" role="tab" aria-controls="profile" aria-selected="false">월별</button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link" id="year-tab" data-bs-toggle="tab" data-bs-target="#year" type="button" role="tab" aria-controls="contact" aria-selected="false">년별</button>
                </li>
            </ul>
            <div class="tab-content pt-2" id="borderedTabContent">
                <div class="tab-pane fade show active" id="day" role="tabpanel" aria-labelledby="day-tab">
                    <table class="table datatable">
                        <thead>
                        <tr>
                            <th scope="col">index</th>
                            <th scope="col">날짜</th>
                            <th scope="col">대여 성사 횟수</th>
                            <th scope="col">회원 수익</th>
                            <th scope="col">광고 수익</th>
                            <th scope="col">가입자 수</th>
                            <th scope="col">총 매출</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>2022년 5월 8일</td> <!-- 날짜 -->
                            <td>8회</td>            <!-- 대여 성사 수 -->
                            <td>3000원</td>         <!-- 매출액 -->
                            <td>9명</td>         <!-- 방문자 -->
                            <td>1명</td>         <!-- 가입자 -->
                            <td>4개</td>         <!-- 후기 개수 -->
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>2022년 5월 9일</td> <!-- 날짜 -->
                            <td>4회</td>            <!-- 대여 성사 수 -->
                            <td>5000원</td>         <!-- 매출액 -->
                            <td>5명</td>         <!-- 방문자 -->
                            <td>3명</td>         <!-- 가입자 -->
                            <td>5개</td>         <!-- 후기 개수 -->
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>2022년 5월 10일</td> <!-- 날짜 -->
                            <td>3회</td>            <!-- 대여 성사 수 -->
                            <td>7000원</td>         <!-- 매출액 -->
                            <td>4명</td>         <!-- 방문자 -->
                            <td>2명</td>         <!-- 가입자 -->
                            <td>3개</td>         <!-- 후기 개수 -->
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="month" role="tabpanel" aria-labelledby="month-tab">
                    <table class="table datatable" id="monthtable">
                        <thead>
                        <tr>
                            <th scope="col">index</th>
                            <th scope="col">날짜</th>
                            <th scope="col">대여 성사 횟수</th>
                            <th scope="col">회원 수익</th>
                            <th scope="col">광고 수익</th>
                            <th scope="col">가입자 수</th>
                            <th scope="col">총 매출</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>2022년 3월</td> <!-- 날짜 -->
                            <td>8회</td>            <!-- 대여 성사 수 -->
                            <td>3000원</td>         <!-- 매출액 -->
                            <td>9명</td>         <!-- 방문자 -->
                            <td>1명</td>         <!-- 가입자 -->
                            <td>4개</td>         <!-- 후기 개수 -->
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>2022년 4월</td> <!-- 날짜 -->
                            <td>4회</td>            <!-- 대여 성사 수 -->
                            <td>5000원</td>         <!-- 매출액 -->
                            <td>5명</td>         <!-- 방문자 -->
                            <td>3명</td>         <!-- 가입자 -->
                            <td>5개</td>         <!-- 후기 개수 -->
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>2022년 5월</td> <!-- 날짜 -->
                            <td>3회</td>            <!-- 대여 성사 수 -->
                            <td>7000원</td>         <!-- 매출액 -->
                            <td>4명</td>         <!-- 방문자 -->
                            <td>2명</td>         <!-- 가입자 -->
                            <td>3개</td>         <!-- 후기 개수 -->
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="tab-pane fade" id="year" role="tabpanel" aria-labelledby="year-tab">
                    <table class="table datatable">
                        <thead>
                        <tr>
                            <th scope="col">index</th>
                            <th scope="col">날짜</th>
                            <th scope="col">대여 성사 횟수</th>
                            <th scope="col">회원 수익</th>
                            <th scope="col">광고 수익</th>
                            <th scope="col">가입자 수</th>
                            <th scope="col">총 매출</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th scope="row">1</th>
                            <td>2020년</td> <!-- 날짜 -->
                            <td>8회</td>            <!-- 대여 성사 수 -->
                            <td>3000원</td>         <!-- 매출액 -->
                            <td>9명</td>         <!-- 방문자 -->
                            <td>1명</td>         <!-- 가입자 -->
                            <td>4개</td>         <!-- 후기 개수 -->
                        </tr>
                        <tr>
                            <th scope="row">2</th>
                            <td>2021년</td> <!-- 날짜 -->
                            <td>4회</td>            <!-- 대여 성사 수 -->
                            <td>5000원</td>         <!-- 매출액 -->
                            <td>5명</td>         <!-- 방문자 -->
                            <td>3명</td>         <!-- 가입자 -->
                            <td>5개</td>         <!-- 후기 개수 -->
                        </tr>
                        <tr>
                            <th scope="row">3</th>
                            <td>2022년</td> <!-- 날짜 -->
                            <td>3회</td>            <!-- 대여 성사 수 -->
                            <td>7000원</td>         <!-- 매출액 -->
                            <td>4명</td>         <!-- 방문자 -->
                            <td>2명</td>         <!-- 가입자 -->
                            <td>3개</td>         <!-- 후기 개수 -->
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div><!-- End Bordered Tabs -->
        </div>
    </div>





</main><!-- End #main -->

</body>
<!-- Vendor JS Files -->
<script src="${path}/resources/css/assets/vendor/apexcharts/apexcharts.min.js"></script>
<script src="${path}/resources/css/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="${path}/resources/css/assets/vendor/chart.js/chart.umd.js"></script>
<script src="${path}/resources/css/assets/vendor/echarts/echarts.min.js"></script>
<script src="${path}/resources/css/assets/vendor/quill/quill.min.js"></script>
<script src="${path}/resources/css/assets/vendor/simple-datatables/simple-datatables.js"></script>
<script src="${path}/resources/css/assets/vendor/tinymce/tinymce.min.js"></script>
<script src="${path}/resources/css/assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="${path}/resources/css/assets/js/main.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</html>
