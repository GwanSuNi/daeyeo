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
    <link rel="stylesheet" href="${path}/resources/webjars/css/bootstrap.min.css">
    <script src="${path}/resources/webjars/js/bootstrap.min.js"></script>
    <script src="${path}/resources/js/mypage/myPage.js"></script>
</head>
<body>

<div class="body_container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="main_content">

        <div class="TableParentContainer">

            <div class="h2_container">
                <div id="h2">
                    <h2>대여 관리</h2>
                    <hr>
                    <br>
                </div>
            </div>

            <!-- 왼쪽 표 -->
            <div class="divInform">
                <table class="informTable">
                    <th id="modifyInfo">정보 수정</th>
                    <tr>
                        <td><a href="passwordChange">비밀번호 변경</a></td>
                    </tr>
                    <tr>
                        <td><a href="profile">계정</a></td>
                    </tr>
                    <tr>
                        <td><a href="myWishList">내가 찜한 목록</a></td>
                    </tr>
                    <tr>
                        <td><a href="reservation">예약 기록</a></td>
                    </tr>
                    <tr>
                        <td><a href="rental_write_form">대여 등록</a></td>
                    </tr>
                    <tr>
                        <td><a href="rental_manage">대여 관리</a></td>
                    </tr>
                    <tr>
                        <td><a href="rental_log">대여 기록</a></td>
                    </tr>
                </table>
            </div>

            <div class="TableChildContainer">
                <select id="tableSelect" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example"
                        onchange="changeTable()">
                    <option value="total">작성한 대여 게시글</option>
                    <option value="one_day">일자별 요약</option>
                    <option value="profit">나의 수익</option>
                </select>

                <table id="total" class="table table-striped table-hover" style="display: none;">
                    <thead class="table-dark">
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

                <table id="one_day" class="table table-striped table-hover" style="display: none;">
                    <thead class="table-dark">
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

                <table id="profit" class="table table-striped table-hover" style="display: none;">
                    <thead class="table-dark">
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

    <%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
