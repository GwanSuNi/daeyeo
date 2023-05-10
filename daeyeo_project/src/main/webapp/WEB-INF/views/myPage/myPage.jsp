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
    <link rel="stylesheet" type="text/css" href="resources/css/myPage.css?after">
    <title>마이페이지</title>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="content">

        <!-- 왼쪽 표 -->
        <div>
            <table class="inFormTable">
                <tr id="modifyInfo">
                    <th>정보 수정</th>
                </tr>
                <tr>
                    <td><a href="#"></a>비밀번호 변경</td>
                </tr>
                <tr>
                    <td><a href="#"></a>계정</td>
                </tr>
                <tr>
                    <td><a href="#"></a>내가 찜한 목록</td>
                </tr>
                <tr>
                    <td><a href="#"></a>예약 기록</td>
                </tr>
                <tr>
                    <td><a href="#"></a>대여 등록</td>
                </tr>
                <tr>
                    <td><a href="#"></a>대여 관리</td>
                </tr>
                <tr>
                    <td><a href="#"></a>대여 기록</td>
                </tr>
            </table>
        </div>

        <!-- flex box 사용하려고 container 로 그룹핑 함 -->
        <div class="container">
            <div id="h2">
                <h2>정보 수정</h2>
                <hr>
            </div>

            <table class="myPageInform">
                <tr>
                    <div>

                        <td class="core">
                            <label> 이메일 </label>
                        </td>

                        <!-- text 값을 left 로 정렬하기 위해서 class 값을 넣어준겁니다-->

                        <td class="left_left">
                            <input type="text" name="email" value="tecte@kyungmin.ac.kr" readonly>
                        </td>

                    </div>
                </tr>

                <tr>
                    <div>

                        <td class="core">
                            <label> 상태 메시지 </label>
                        </td>

                        <td class="left_left">
                            <input type="text" name="message" value="안녕하세요! 잘 부탁드립니다!" readonly>
                        </td>

                    </div>
                </tr>

                <tr>
                    <div>

                        <td class="core">
                            <label> 비밀번호 </label>
                        </td>

                        <td class="left_left">
                            <input type="password" name="password" value="0000" readonly>
                        </td>

                    </div>
                </tr>

                <tr>
                    <div>

                        <td class="core">
                            <label> 소속 </label>
                        </td>

                        <td class="left_left">
                            <input type="text" name="department" value="컴퓨터공학과" readonly>
                        </td>

                    </div>
                </tr>

                <tr>
                    <div>

                        <td class="core">
                            <label> 나의 위치 </label>
                        </td>

                        <td class="left_left">
                            <input type="text" name="main" value="서울특별시 강동구" readonly>
                            <button> 인증하기</button>
                        </td>

                    </div>
                </tr>

            </table>


        </div>

    </div>

    <%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>

</body>
</html>
