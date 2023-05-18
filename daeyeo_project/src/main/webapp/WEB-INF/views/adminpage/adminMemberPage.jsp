<%--
  Created by IntelliJ IDEA.
  User: seosanghyeon
  Date: 2023/05/15
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/admin_member_page.css?after">
    <title>어드민 멤버 페이지</title>
</head>
<body>
<body>
<h1>어드민 멤버 페이지</h1>
<div class="layout">
    <div class="left-menu">
        <button class="main_button_class" onclick="location.href='AdminMainPage.html'" >대시보드</button>
        <button class="main_button_class" onclick="location.href='AdminMemberPage.html'">회원관리</button>
        <button class="main_button_class" onclick="location.href='AdminContentPage.html'">컨텐츠 관리</button>
        <button class="main_button_class" onclick="location.href='AdminStatisticsPage.html'">통계</button>
        <button class="main_button_class" onclick="location.href='AdminAdPage.html'">광고 관리</button>
        <button class="main_button_class" onclick="location.reload();">새로고침</button>
    </div>
    <div class="content">
        <h1>회원 정보</h1>
        <div class="input-group mb-3">
            <input type="text" class="form-control" placeholder="회원 이름을 입력하시오" aria-label="회원이름을 입력하시오" aria-describedby="button-addon2">
            <input type="text" class="form-control" placeholder="회원 생년월일을 입력하시오" aria-label="회원 생년월일을 입력하시오" aria-describedby="button-addon2">
            <input type="text" class="form-control" placeholder="회원의 번호를 입력하시오" aria-label="회원의 번호를 입력하시오" aria-describedby="button-addon2">
            <button class="btn btn-outline-secondary" type="button" id="button-addon2">조회하기</button>
        </div>
        <div class = "membertable">
            <table class="table table-striped table-hover">
                <h1>회원테이블</h1>
                <thead>
                <tr>
                    <th scope="col">index</th>
                    <th scope="col">회원유형</th>
                    <th scope="col">회원이름</th>
                    <th scope="col">생년월일</th>
                    <th scope="col">번호</th>
                    <th scope="col">가입일</th>
                    <th scope="col">대여 글 횟수</th>
                    <th scope="col">예약 횟수</th>
                    <th scope="col">대여 횟수</th>
                    <th scope="col">이용 후기</th>
                    <th scope="col">누적 결제 금액</th>
                    <th scope="col">누적 수수료</th>
                    <th scope="col">회원 별점</th>
                    <th scope="col">정지 여부</th>
                    <th scope="col">메모</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>골드</td>           <!-- 회원 유형 -->
                    <td><button onclick="openPopUp()">서상현</button></td>
                    <td>000612</td>         <!-- 생년 월일 -->
                    <td>01099481901</td>         <!-- 번호 -->
                    <td>20220612</td>         <!-- 가입일 -->
                    <td>1회</td>         <!-- 대여 글 횟수 -->
                    <td>2회</td>         <!-- 예약 횟수 -->
                    <td>3회</td>         <!-- 대여 횟수 -->
                    <td>4개</td>         <!-- 이용 후기 -->
                    <td>4030</td>         <!-- 누적 결제 금액 -->
                    <td>300</td>         <!-- 누적 수수료 -->
                    <td>4.3</td>         <!-- 회원 별점 -->
                    <td>true</td>         <!-- 정지 여부 -->
                    <td>메모</td>         <!-- 메모 -->
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>실버</td>           <!-- 회원 유형 -->
                    <td><button onclick="openPopUp()">유관형</button></td>
                    <td>000423</td>         <!-- 생년 월일 -->
                    <td>01082440870</td>         <!-- 번호 -->
                    <td>20220423</td>         <!-- 가입일 -->
                    <td>3회</td>         <!-- 대여 글 횟수 -->
                    <td>4회</td>         <!-- 예약 횟수 -->
                    <td>5회</td>         <!-- 대여 횟수 -->
                    <td>6개</td>         <!-- 이용 후기 -->
                    <td>2030</td>         <!-- 누적 결제 금액 -->
                    <td>600</td>         <!-- 누적 수수료 -->
                    <td>2.3</td>         <!-- 회원 별점 -->
                    <td>false</td>         <!-- 정지 여부 -->
                    <td>메모</td>         <!-- 메모 -->
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>브론즈</td>           <!-- 회원 유형 -->
                    <td><button onclick="openPopUp()">류인태</button></td>
                    <td>000104</td>         <!-- 생년 월일 -->
                    <td>01075248997</td>         <!-- 번호 -->
                    <td>20220104</td>         <!-- 가입일 -->
                    <td>2회</td>         <!-- 대여 글 횟수 -->
                    <td>4회</td>         <!-- 예약 횟수 -->
                    <td>1회</td>         <!-- 대여 횟수 -->
                    <td>3개</td>         <!-- 이용 후기 -->
                    <td>6974</td>         <!-- 누적 결제 금액 -->
                    <td>600</td>         <!-- 누적 수수료 -->
                    <td>4.1</td>         <!-- 회원 별점 -->
                    <td>true</td>         <!-- 정지 여부 -->
                    <td>메모</td>         <!-- 메모 -->
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</html>
