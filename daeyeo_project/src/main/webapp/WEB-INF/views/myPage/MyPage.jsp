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
    <title>Title</title>
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
                    <td><a href="#"></a>학교/회사 정보</td>
                </tr>
                <tr>
                    <td><a href="#"></a>계정 연동</td>
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
                <hr />
            </div>

            <div class="email">
                <label> 이메일 </label>
                <input />
            </div>

            <div class="messge">
                <label> 상태메시지 </label>
                <input/>
            </div>

            <div class="passWord">
                <label> 비밀번호 </label>
                <input/>
            </div>

            <div class="position">
                <label> 소속 </label>
                <input/>
            </div>

            <div class="main">
                <label> 나의 위치 </label>
                <input />
                <button>위치인증</button>
            </div>

        </div>

    </div>

<%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>



</body>
</html>
