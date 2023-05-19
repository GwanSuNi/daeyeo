<%--
  Created by IntelliJ IDEA.
  User: gwansuni
  Date: 2023/04/27
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${path}/resources/css/header_style.css" type="text/css">
    <%-- font awesome css 라이브러리--%>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <%-- fonts.google --%>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro&display=swap" rel="stylesheet">

</head>
<body>
<nav class="navBar">
    <div class="navbar_logo">
        <a class="header_a" href="${path}/">대여대여로고</a>
    </div>

    <ul class="navbar_menu">
        <li><a class="header_a" href="">공간시설</a></li>
        <li><a class="header_a" href="">개인대여</a></li>
        <li><a class="header_a" href="">이용안내</a></li>
    </ul>

    <div class="dum_navbar_links">
        <%-- flex space between 용--%>
    </div>

    <ul class="navbar_links">
        <li><i class="fas fa-bell" style="color: #ffffff;"></i></li>
        <%--<i class="fa-solid fa-bell-on" style="color: #ffffff;"></i>--%>
        <li><i class="fas fa-user" style="color: #ffffff;"></i></li>
        <li id="bar_li"><i class="fas fa-bars" style="color: #ffffff;"></i></li>
    </ul>
</nav>
<%-- 햄버거버튼 이벤트 --%>
<script src="${path}/resources/js/header.js"></script>
</body>
</html>
