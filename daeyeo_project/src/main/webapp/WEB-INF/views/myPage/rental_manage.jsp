<%--
  Created by IntelliJ IDEA.
  User: dlsxi
  Date: 2023-04-30
  Time: 오전 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.apache.catalina.User" %>
<%@ page import="com.daeyeo.entity.RentalObject" %>
<%@ page import="java.util.List" %>
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
                <h1>나의 대여 관리</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item">MyPage</li>
                        <li class="breadcrumb-item active">Manage</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">작성한 대여 게시글</h5>
                            <!-- Table with stripped rows -->
                            <table class="table datatable">
                                <thead>
                                <tr>
                                    <th>장소명</th>
                                    <th>장소</th>
                                    <th>사람들이 찜한 수</th>
                                    <th>예약 수</th>
                                    <th>성사 수</th>
                                    <th>예약 대기 수</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>경민대학교 404호 강의실</td>
                                    <td>경기도 의정부</td>
                                    <td>32</td>
                                    <td>5</td>
                                    <td>2</td>
                                    <td>1</td>
                                </tr>
                                <tr>
                                    <td>경민대학교 운동장</td>
                                    <td>경기도 의정부</td>
                                    <td>16</td>
                                    <td>7</td>
                                    <td>3</td>
                                    <td>2</td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </section>


            <section class="section">
                <div class="row">
                    <div class="col-lg-6">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">일자별 요약</h5>
                                <table class="table datatable">
                                    <thead>
                                    <tr>
                                        <th>일자</th>
                                        <th>대여 성사 수</th>
                                        <th>매출액</th>
                                        <th>방문자</th>
                                        <th>가입</th>
                                        <th>후기</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>2023-05-01</td>
                                        <td>10회</td>
                                        <td>10만원</td>
                                        <td>404</td>
                                        <td>5</td>
                                        <td>3</td>
                                    </tr>
                                    <tr>
                                        <td>2023-05-14</td>
                                        <td>30회</td>
                                        <td>23만원</td>
                                        <td>302</td>
                                        <td>5</td>
                                        <td>8</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>

                    <div class="col-lg-6">

                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">나의 수익</h5>
                                <table class="table datatable">
                                    <thead>
                                    <tr>
                                        <th>수익</th>
                                        <th>수수료</th>
                                        <th>순수익</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1000원</td>
                                        <td>100원</td>
                                        <td>900원</td>
                                    </tr>
                                    <tr>
                                        <td>2000원</td>
                                        <td>200</td>
                                        <td>1800원</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
            </section>
        </div>
    </div>
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
<%-- footer --%>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</body>
</html>
