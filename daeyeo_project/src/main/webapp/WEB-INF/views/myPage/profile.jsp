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
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/myPage.css?after">
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
                    <h2>계정</h2>
                    <hr>
                    <br>
                </div>
            </div>

            <!-- 왼쪽 표 -->
            <div class="divInform">
                <table>
                    <th>정보 수정</th>
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

            <div class="childContainer">
                <table>
                    <tr>
                        <div>

                            <td class="core">
                                <label> 학교 / 회사 정보 </label>
                            </td>
                            <!-- text 값을 left 로 정렬하기 위해서 class 값을 넣어준겁니다-->
                            <td class="left_left">
                                <input type="text" name="company" value="Naver" readonly>
                                <button>변경하기</button>
                            </td>

                        </div>
                    </tr>

                    <tr>
                        <div>

                            <td class="core">
                                <label> 계정 연동 </label>
                            </td>

                            <td class="left_left">
                                <button class="btn"><img src="${path}/resources/img/kakao-talk.png"></button>
                                <button class="btn"><img src="${path}/resources/img/naver-logo.png"></button>
                                <button class="btn"><img src="${path}/resources/img/google_32.png"></button>
                            </td>

                        </div>
                    </tr>


                    <tr>
                        <div>

                            <td class="core">
                                <label> 계정 삭제 </label>
                            </td>

                            <td class="left_left">
                                <button class="delete_member">회원탈퇴</button>
                            </td>
                        </div>
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
