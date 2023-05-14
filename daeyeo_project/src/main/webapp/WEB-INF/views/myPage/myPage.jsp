<%--
  Created by IntelliJ IDEA.
  User: dlsxi
  Date: 2023-04-30
  Time: 오전 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>r,
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/footer_bottom.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/mypage/myPage.css?after">
    <title>마이페이지</title>
    <link rel="stylesheet" href="${path}/resources/webjars/css/bootstrap.min.css">
    <script src="${path}/resources/webjars/js/bootstrap.min.js"></script>
</head>
<body>

<div class="body_container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="main_content">

        <div class="parentContainer">

            <div class="h2_container">
                <div id="h2">
                    <h2>나의 정보</h2>
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
            <div class="childContainer">
                <table>
                    <tr>
                        <td class="core">
                            <label> 이메일 </label>
                        </td>

                        <td class="left_left">
                            <label>
                                <input type="text" name="email" value="tecte@kyungmin.ac.kr" readonly>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class="core">
                            <label> 상태 메시지 </label>
                        </td>

                        <td class="left_left">
                            <label>
                                <input type="text" name="message" value="안녕하세요! 잘 부탁드립니다!" readonly>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class="core">
                            <label> 비밀번호 </label>
                        </td>

                        <td class="left_left">
                            <label>
                                <input type="password" name="password" value="0000" readonly>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class="core">
                            <label> 소속 </label>
                        </td>

                        <td class="left_left">
                            <label>
                                <input type="text" name="department" value="컴퓨터공학과" readonly>
                            </label>
                        </td>
                    </tr>

                    <tr>
                        <td class="core">
                            <label> 나의 위치 </label>
                        </td>

                        <td class="left_left">
                            <label>
                                <input type="text" name="main" value="서울특별시 강동구" readonly>
                            </label>
                            <button> 인증하기</button>
                        </td>
                    </tr>

                </table>
            </div>
        </div>
    </div>

    <%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
