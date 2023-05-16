<%--
  Created by IntelliJ IDEA.
  User: gwansuni
  Date: 2023/05/02
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>대여대여 로그인</title>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/footer_bottom.css">
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/login_style.css">
    
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="content">
        <div class="dum_area">
            <%--flex용 더미 데이터            --%>
        </div>
        <div class="login_form_total">
            <img src="${path}/resources/img/logo_transparent.png" alt="dd">
            <form action="" method="post" id="login_form">
                <fieldset>
                    <legend>로그인</legend>
                    <div></div>
                    <div class="login_form_inputs">
                        <input type="text" name="memberId" id="memberId" placeholder="아이디 입력">
                        <input type="password" name="memberPw" id="memberPw" placeholder="비밀번호 입력">
                    </div>
                    <div class="login_form_btn">
                        <label for="saveId">
                            <input type="checkbox" name="saveId" id="saveId">
                            아이디 저장
                        </label>
                        <button class="loginFormBtn" formaction="#" formmethod="post">아이디 찾기</button>
                        <button class="loginFormBtn" onclick="window.location.href='#'">비밀번호 찾기</button>
                        <button class="loginFormBtn" onclick="window.location.href='#'">회원가입</button>
                    </div>
                    <div class="login_form_login">
                        <button type="submit" id="loginBtn">로그인</button>
                    </div>
                    <div class="login_form_api">
                        <button type="submit" id="loginByGoogle">구글 아이디로 로그인</button>
                        <button type="submit" id="loginByKakao">카카오 아이디로 로그인</button>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="dum_area">
            <%--flex용 더미 데이터            --%>
        </div>
    </div>
    <%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
