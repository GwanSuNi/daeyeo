<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/rental/rental_list.css">
    <link rel="stylesheet" type="text/css" id="css" href="${path}/resources/css/rental/list_type.css">
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
                <a href="" class="item">전체</a>
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
                            <option value="3">지역명 순</option>
                            <option value="4">장소명 순</option>
                        </select>
                    </label>
                    <button class="type_btn" onmousedown="changeCSS(this, 'board_type')">
                        <span class="board_type">보드형</span>
                    </button>
                    <button class="type_btn active" onclick="changeCSS(this, 'list_type')">
                        <span class="list_type">목록형</span>
                    </button>
                </div>
            </h3>
            <ul class="rental_list">
                <li>
                    <a href="">
                        <div class="img_box">
                            <span class="board state">state</span>
                            <img src="${path}/resources/img/rental/image_icon.png" alt="사진">
                        </div>
                        <div class="description">
                            <div class="top_box">
                                <div class="list state">대여가능</div>
                                <ul class="category">
                                    <li>공간시설</li>
                                    <li>강의실</li>
                                </ul>
                            </div>
                            <div class="title">title</div>
                            <ul class="obj_info">
                                <li>
                                    <span class="place icon">장소</span>
                                    <span class="obj">place</span>
                                </li>
                                <li>
                                    <span class="price icon">이용요금</span>
                                    <span class="obj">price</span>
                                </li>
                                <li>
                                    <span class="reception_period icon">접수기간</span>
                                    0000.00.00 ~ 0000.00.00
                                </li>
                                <li>
                                    <span class="use_period icon">사용기간</span>
                                    0000.00.00 ~ 0000.00.00
                                </li>
                                <li>
                                    <span class="reservation icon">예약방법</span>
                                    <ul class="reservation_method">
                                        <li><img src="${path}/resources/img/rental/online_icon.png" alt="icon"></li>
                                        <li><img src="${path}/resources/img/rental/visit_icon.png" alt="icon"></li>
                                        <li><img src="${path}/resources/img/rental/phone_icon.png" alt="icon"></li>
                                        <li><img src="${path}/resources/img/rental/site_icon.png" alt="icon"></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </a>
                </li>
            </ul>
            <div class="page_box">
                <a href="" class="icon prev_first"></a>
                <a href="" class="icon prev"></a>
                <ul>
                    <li>
                        <a href="" class="active">1</a>
                    </li>
                    <li>
                        <a href="">2</a>
                    </li>
                    <li>
                        <a href="">3</a>
                    </li>
                    <li>
                        <a href="">4</a>
                    </li>
                    <li>
                        <a href="">5</a>
                    </li>
                </ul>
                <a href="" class="icon next"></a>
                <a href="" class="icon next_last"></a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../includes/footer.jsp"/>

<script src="resources/js/rental.js"></script>
</body>
</html>