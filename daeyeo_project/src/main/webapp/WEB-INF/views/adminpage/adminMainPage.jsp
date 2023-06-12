<%@ page import="org.apache.catalina.User" %>
<%@ page import="com.daeyeo.entity.RentalObject" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: seosanghyeon
  Date: 2023/05/10
  Time: 11:54 PM
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
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

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
                <i class="bi bi-layout-text-window-reverse"></i><span>통계</span><i
                    class="bi bi-chevron-down ms-auto"></i>
            </a>
            <ul id="statistics-nav" class="nav-content collapse" data-bs-parent="#sidebar-nav">
                <li>
                    <a href="${path}/adminStatisticsPage">
                        <i class="bi bi-circle"></i><span>일별 요약</span>
                    </a>
                </li>
                <li>
                    <a href="/error/404">
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
                <li class="breadcrumb-item"><a href="/${path}adminMainPage">대쉬보드</a></li>
                <li class="breadcrumb-item active">일자별 요약</li>
            </ol>
        </nav>
    </div>

    <!-- End Page Title -->

    <!-- Start Main-Content -->

    <section class="Main-Content">
        <div class="row">
            <div class="col-lg-12">
                <div class="card">         <!-- 내용을 구분해주는 div -->
                    <div class="card-body">  <!-- 내용을 구분해주는 div -->
                        <h5 class="card-title">일자별로 요약한 내용</h5>

                        <!-- Start Table with stripped rows -->

                        <table class="table datatable">
                            <thead>
                            <tr>
                                <th scope="col">index</th>
                                <th scope="col">등록날짜</th>
                                <th scope="col">매출액</th>
                                <th scope="col">방문자</th>
                                <th scope="col">가입자</th>
                                <th scope="col">후기개수</th>
                            </tr>
                            </thead>
                            <tbody>
                                <c:forEach varStatus="index" var="board" items="${dashBoard}">
                                    <tr>
                                        <td>${index.count}</td>
                                        <td>${board.registDate}</td>
                                        <td>${board.totalRentalPrice}</td> <!-- 집계 -->
                                        <td>${board.totalVisitCount}</td>
                                        <td>${board.totalNewUserCount}</td>
                                        <td>${board.totalReviewCount}</td>
                                    </tr>
                                </c:forEach>
<%--                                <td>${rental.userEntity.registDate}</td>--%>
<%--                                <td>${rental.reviews.size()}</td>--%>

                            </tbody>
                        </table>

                        <!-- End Table with stripped rows -->

                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- Start google analytics -->

    <div class="col-lg-6">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">구글 애널리틱스</h5>
                <a href="https://www.google.co.kr/?hl=ko"></a>
            </div>
        </div>
    </div>

    <!-- End google analytics  -->

</main>
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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</html>
