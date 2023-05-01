<%--
  Created by IntelliJ IDEA.
  User: gwansuni
  Date: 2023/04/27
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${path}/resources/css/footer_style.css" type="text/css">
    <%-- fonts.google --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">
</head>
<footer>
<hr style="margin: 0">
<nav class="footer_navbar">
    <ul class="footer_nav_links">
        <li><a class="footer_a" href="">Contact us</a></li>
        <li><a class="footer_a" href="">개인정보 처리방침</a></li>
        <li><a class="footer_a" href="">위치기반사이트 이용약관</a></li>
        <li><a class="footer_a" href="">사이트맵</a></li>
        <li><a class="footer_a" href="">운영정책</a></li>
        <li><a class="footer_a" href="">이용약관</a></li>
    </ul>

    <div class="footer_address">
        <p>11618 경기도 의정부시 서부로 545</p>
    </div>

    <div class="footer_copyright">
        <p>COPYRIGHT(C) 2023 <span class="team">Noob-GPT</span>. ALL RIGHTS RESERVED</p>
    </div>
</nav>
</footer>
</html>
