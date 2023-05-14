<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/rental_list.css">
    <title>대여 목록</title>
    <link rel="stylesheet" href="${path}/resources/webjars/css/bootstrap.min.css">
    <script src="${path}/resources/webjars/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../includes/header.jsp"/>
<div id="wrapper">
    <div id="contents">
        <div class="category_wrap">
            <div class="category_list">
                <a href="#" class="item">전체</a>
                <div class="item active">강의실</div>
                <div class="item">체육관</div>
                <div class="item">도서관</div>
            </div>
            <div class="search">
                <label class="search_box">
                    <input type="text" placeholder="검색어를 입력하세요.">
                </label>
                <input type="submit" class="search_btn" value="검색">
            </div>
        </div>
        <ul class="icon_list">
            <li>
                <span class="icon online">온라인 예약</span>
            </li>
            <li>
                <span class="icon visit">방문 예약</span>
            </li>
            <li>
                <span class="icon call">전화 예약</span>
            </li>
            <li>
                <span class="icon site">외부 사이트</span>
            </li>
        </ul>
        <div class="rental_list_wrap">
            <h3 class="icon order_field">
                총 <span class="emphasis">9</span> 건
                <div class="order_box">
                    <label class="select_order">
                        <select>
                            <option value="1" selected>접수기간 순</option>
                            <option value="2">이용기간 순</option>
                            <option value="2">지역명 순</option>
                            <option value="2">장소명 순</option>
                        </select>
                    </label>
                    <button id="board_type" onmousedown="changeType('board')">
                        <span class="board">보드형</span>
                    </button>
                    <button id="list_type" class="active" onclick="changeType('list')">
                        <span class="list">목록형</span>
                    </button>
                </div>
            </h3>
            <iframe id="rental_list" src="list" onload="iHeight(this)" scrolling="no"></iframe>
            <div class="page_box">
                <a href="#" class="icon prev_first"></a>
                <a href="#" class="icon prev"></a>
                <ul>
                    <li>
                        <a href="#" class="active">1</a>
                    </li>
                    <li>
                        <a href="#">2</a>
                    </li>
                    <li>
                        <a href="#">3</a>
                    </li>
                    <li>
                        <a href="#">4</a>
                    </li>
                    <li>
                        <a href="#">5</a>
                    </li>
                </ul>
                <a href="#" class="icon next"></a>
                <a href="#" class="icon next_last"></a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../includes/footer.jsp"/>

<script src="resources/js/rental.js"></script>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>