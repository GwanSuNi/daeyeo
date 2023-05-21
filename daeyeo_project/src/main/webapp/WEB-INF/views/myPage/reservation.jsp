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
                <h1>내가 예약한 목록</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item">MyPage</li>
                        <li class="breadcrumb-item active">My Reservation List</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">내가 예약한 목록</h5>
                            <!-- Table with stripped rows -->
                            <table class="table table-striped table-hover">
                                <thead class="table-dark">
                                <tr>
                                    <th>objectName</th>
                                    <th>price</th>
                                    <th>website</th>
                                    <th>representNum</th>
                                    <th>locationInfo</th>
                                    <th>startDuration</th>
                                    <th>endDuration</th>
                                    <th>예약 취소 요청</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>경민 401호 강의실</td>
                                    <td>무료</td>
                                    <td>www.kyungmin.ac.kr/</td>
                                    <td>학과사무실)010-****-****</td>
                                    <td>경기도 의정부시 서부로 545</td>
                                    <td>2023-05-15</td>
                                    <td>2023-05-20</td>
                                    <td>
                                        <button class="cancel-reservation-btn" onclick="cancelReservation(1)">예약 취소
                                        </button>
                                    </td>
                                </tr>
                                <tr>
                                    <td>경민 운동장</td>
                                    <td>10000원</td>
                                    <td>www.kyungmin.ac.kr/</td>
                                    <td>관리자)010-****-****</td>
                                    <td>경기도 의정부시 서부로 545</td>
                                    <td>2023-06-01</td>
                                    <td>2023-06-10</td>
                                    <td>
                                        <button class="cancel-reservation-btn" onclick="cancelReservation(1)">예약 취소
                                        </button>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                            <!-- End Table with stripped rows -->

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
