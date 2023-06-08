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
                <h1>내 정보</h1>
                <nav>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="/">Home</a></li>
                        <li class="breadcrumb-item">MyPage</li>
                        <li class="breadcrumb-item active">Profile</li>
                    </ol>
                </nav>
            </div><!-- End Page Title -->

            <section class="section profile">
                <div class="row">
                    <div class="col-xl-4">

                        <div class="card">
                            <div class="card-body profile-card pt-4 d-flex flex-column align-items-center">
                                <img src="${path}/resources/css/assets/img/my_profile.png" alt="Profile"
                                     class="rounded-circle">
                                <h2>유관형</h2>
                                <h3>코딩하기 좋은날!</h3>
                            </div>
                        </div>

                    </div>

                    <div class="col-xl-8">

                        <div class="card">
                            <div class="card-body pt-3">
                                <!-- Bordered Tabs -->
                                <ul class="nav nav-tabs nav-tabs-bordered">

                                    <li class="nav-item">
                                        <button class="nav-link active" data-bs-toggle="tab"
                                                data-bs-target="#profile-overview">상세보기
                                        </button>
                                    </li>

                                    <li class="nav-item">
                                        <button class="nav-link" data-bs-toggle="tab" data-bs-target="#profile-edit">
                                            프로필 수정
                                        </button>
                                    </li>

                                    <li class="nav-item">
                                        <button class="nav-link" data-bs-toggle="tab"
                                                data-bs-target="#profile-change-password">비밀번호 변경
                                        </button>
                                    </li>

                                    <li class="nav-item">
                                        <button class="nav-link" data-bs-toggle="tab" data-bs-target="#Delete-Account">
                                            회원 탈퇴
                                        </button>
                                    </li>

                                </ul>
                                <div class="tab-content pt-2">

                                    <div class="tab-pane fade show active profile-overview" id="profile-overview">

                                        <h5 class="card-title">상세 정보</h5>

                                        <div class="row">
<%--                                            <c:forEach var="user" items="${userEntityList}">--%>
<%--                                                ${user.name}--%>
<%--                                                ${user.department}--%>
<%--                                                ${user.statusMsg}--%>
<%--                                                ${user.phoneNum}--%>
<%--                                                ${user.userEmail}--%>
<%--                                            </c:forEach>--%>
                                            <div class="col-lg-3 col-md-4 label ">이름</div>
                                            <div class="col-lg-9 col-md-8">유관형</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">소속</div>
                                            <div class="col-lg-9 col-md-8">경민대학교</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">상태 메시지</div>
                                            <div class="col-lg-9 col-md-8">코딩하기 좋은날!</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">주소</div>
                                            <div class="col-lg-9 col-md-8">서울특별시 강동구</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">전화</div>
                                            <div class="col-lg-9 col-md-8">010-1234-4321</div>
                                        </div>

                                        <div class="row">
                                            <div class="col-lg-3 col-md-4 label">Email</div>
                                            <div class="col-lg-9 col-md-8">rhksgud@kyungmin.ac.kr</div>
                                        </div>

                                    </div>

                                    <div class="tab-pane fade profile-edit pt-3" id="profile-edit">

                                        <!-- Profile Edit Form -->
                                        <form>
                                            <div class="row mb-3">
                                                <label class="col-md-4 col-lg-3 col-form-label">프로필
                                                    사진</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <img src="${path}/resources/css/assets/img/my_profile.png"
                                                         alt="Profile">
                                                    <div class="pt-2">
                                                        <a href="#" class="btn btn-primary btn-sm"
                                                           title="Upload new profile image"><i class="bi bi-upload"></i></a>
                                                        <a href="#" class="btn btn-danger btn-sm"
                                                           title="Remove my profile image"><i
                                                                class="bi bi-trash"></i></a>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="fullName"
                                                       class="col-md-4 col-lg-3 col-form-label">이름</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="fullName" type="text" class="form-control"
                                                           id="fullName"
                                                           placeholder="이름을 입력하세요">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="company" class="col-md-4 col-lg-3 col-form-label">소속</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="company" type="text" class="form-control" id="company"
                                                           placeholder="소속을 입력하세요">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="company" class="col-md-4 col-lg-3 col-form-label">상태
                                                    메시지</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="statusMsg" type="text" class="form-control"
                                                           id="statusMsg"
                                                           placeholder="상태메시지를 입력하세요">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="Job" class="col-md-4 col-lg-3 col-form-label">직업</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="job" type="text" class="form-control" id="Job"
                                                           placeholder="직업명 을 입력하세요">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="Country" class="col-md-4 col-lg-3 col-form-label">나라</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="country" type="text" class="form-control" id="Country"
                                                           placeholder="나라명 을 입력하세요">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="Address" class="col-md-4 col-lg-3 col-form-label">주소</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="address" type="text" class="form-control" id="Address"
                                                           placeholder="주소를 입력하세요">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="Phone" class="col-md-4 col-lg-3 col-form-label">전화</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="phone" type="text" class="form-control" id="Phone"
                                                           placeholder="번호를 입력하세요">
                                                </div>
                                            </div>

                                            <div class="row mb-3">
                                                <label for="Email" class="col-md-4 col-lg-3 col-form-label">이메일</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="email" type="email" class="form-control" id="Email"
                                                           placeholder="이메일을 입력하세요">
                                                </div>
                                            </div>

                                            <div class="text-center">
                                                <button type="submit" class="btn btn-primary">저장하기</button>
                                            </div>
                                        </form><!-- End Profile Edit Form -->

                                    </div>


                                    <div class="tab-pane fade pt-3" id="profile-change-password">
                                        <!-- Change Password Form -->
                                        <form>

                                            <div class="row mb-4">
                                                <label for="currentPassword" class="col-md-4 col-lg-4 col-form-label">현재
                                                    비밀번호 입력</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="password" type="password" class="form-control"
                                                           id="currentPassword">
                                                </div>
                                            </div>

                                            <div class="row mb-4">
                                                <label for="newPassword" class="col-md-4 col-lg-4 col-form-label">새로운
                                                    비밀변호
                                                    입력</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="newpassword" type="password" class="form-control"
                                                           id="newPassword">
                                                </div>
                                            </div>

                                            <div class="row mb-4">
                                                <label for="renewPassword" class="col-md-4 col-lg-4 col-form-label">비밀번호
                                                    재입력</label>
                                                <div class="col-md-8 col-lg-9">
                                                    <input name="renewpassword" type="password" class="form-control"
                                                           id="renewPassword">
                                                </div>
                                            </div>

                                            <button type="submit" class="btn btn-primary">비밀번호 변경</button>
                                        </form><!-- End Change Password Form -->

                                    </div>

                                    <div class="tab-pane fade pt-4" id="Delete-Account">

                                        <div class="row mb-4">
                                            <div class="col-md-8 col-lg-9">
                                                <form>

                                                    <div class="row mb-4">
                                                        <label for="currentPassword"
                                                               class="col-md-4 col-lg-4 col-form-label">아이디 입력</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="password" type="password" class="form-control"
                                                                   id="currentPassword1">
                                                        </div>
                                                    </div>

                                                    <div class="row mb-4">
                                                        <label for="newPassword"
                                                               class="col-md-4 col-lg-4 col-form-label">비밀변호
                                                            입력</label>
                                                        <div class="col-md-8 col-lg-9">
                                                            <input name="newpassword" type="password"
                                                                   class="form-control"
                                                                   id="newPassword2">
                                                        </div>
                                                    </div>

                                                    <button type="button" class="btn btn-danger">회원 탈퇴하기</button>
                                                </form><!-- End Change Password Form -->
                                                <div class="text-center">
                                                </div>

                                            </div>
                                        </div>


                                    </div>

                                </div><!-- End Bordered Tabs -->

                            </div>
                        </div>

                    </div>
                </div>
            </section>
        </div>


        <!-- Vendor JS Files -->
        <script src="${path}/resources/css/assets/vendor/apexcharts/apexcharts.min.js"></script>
        <script src="${path}/resources/css/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Template Main JS File -->
        <script src="${path}/resources/css/assets/js/main.js"></script>
    </div>
    <%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
