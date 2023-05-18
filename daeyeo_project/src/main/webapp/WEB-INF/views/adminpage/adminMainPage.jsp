<%--
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
    <link rel="stylesheet" type="text/css" href="resources/css/admin_main_page.css?after">
    <title>어드민 메인페이지</title>
</head>
<body>
<div class="layout">

    <div class="left-menu">
        <button class="main_button_class">대시보드</button>
        <button class="main_button_class">회원관리</button>
        <button class="main_button_class">컨텐츠 관리</button>
        <button class="main_button_class">통계</button>
        <button class="main_button_class">광고 관리</button>
    </div>

    <div class="content">

        <div class="summarytable">
            <h1>일자별 요약</h1>
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th scope="col">index</th>
                    <th scope="col">날짜</th>
                    <th scope="col">대여 성사 수</th>
                    <th scope="col">매출액</th>
                    <th scope="col">방문자</th>
                    <th scope="col">가입자</th>
                    <th scope="col">후기 개수</th>
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

        <div class="google">
            <h1>방문자 현황 그래프</h1>
            <a href="https://developers.google.com/analytics?hl=ko" target="_blank">구글 애널리틱스 사용</a>
        </div>

    </div>
</div>
</div>
</body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
</html>
