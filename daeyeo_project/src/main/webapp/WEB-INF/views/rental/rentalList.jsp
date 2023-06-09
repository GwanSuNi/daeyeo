<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- BootStrap CSS File -->
    <link href="${path}/resources/css/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/css/style.css" rel="stylesheet">
    <!-- CSS File -->
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/rental/rental_list.css">
    <title>공간시설 목록 | 대여대여</title>
    <script>
        window.dataLayer = window.dataLayer || [];

        function gtag() {
            dataLayer.push(arguments);
        }

        gtag('js', new Date());

        gtag('config', 'G-S11E29LT0T');
    </script>
    <!-- Google Tag Manager -->
    <script>(function (w, d, s, l, i) {
        w[l] = w[l] || [];
        w[l].push({
            'gtm.start':
                new Date().getTime(), event: 'gtm.js'
        });
        var f = d.getElementsByTagName(s)[0],
            j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : '';
        j.async = true;
        j.src =
            'https://www.googletagmanager.com/gtm.js?id=' + i + dl;
        f.parentNode.insertBefore(j, f);
    })(window, document, 'script', 'dataLayer', 'GTM-58QHFKS');</script>
    <!-- End Google Tag Manager -->
</head>
<body>
<div class="wrapper">
    <jsp:include page="../includes/header.jsp"/>
    <div class="contents">
        <form class="category_wrap">
            <div class="category_list">
                <a href="" class="cate-btn">전체</a>
                <c:forEach var="category" items="${categories}">
                    <a href="#" class="cate-btn">${category}</a>
                </c:forEach>
            </div>
            <div class="search">
                <label class="search_box">
                    <input type="text" id="search-word" name="searchWord" placeholder="검색어를 입력하세요."
                           value="${rentalListCmd.searchWord}">
                </label>
                <a href="" class="a-btn">검색</a>
            </div>
            <%--            <input type="hidden" id="main-cate" name="mainCate" value="${rentalListCmd.mainCate}">--%>
            <%--            <input type="hidden" id="sub-cate" name="subCate" value="${rentalListCmd.subCate}">--%>
        </form>
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
            <h5 class="icon order_field">
                총 <span class="emphasis">${rentalList.size()}</span> 건
                <div class="order_box">
                    <select class="form-select">
                        <option value="1" selected>접수기간 순</option>
                        <option value="2">이용기간 순</option>
                        <option value="3">지역명 순</option>
                        <option value="4">장소명 순</option>
                    </select>
                    <button type="button" id="board-type" class="btn">
                        <span class="board-btn">보드형</span>
                    </button>
                    <button type="button" id="list-type" class="btn active">
                        <span class="list-btn">목록형</span>
                    </button>
                </div>
            </h5>
            <form action="/rental/write" class="object-form">
                <ul id="rental-list" class="list-type">
                    <c:forEach var="rentalObject" items="${rentalList}">
                        <li>
                            <input type="hidden" value="${rentalObject.objectIndex}">
                            <a href="" class="rental-object">
                                <div class="img_box">
                                    <span class="board-state">대여가능</span>
                                    <img src="${path}/resources/img/rental/image_icon.png" alt="사진">
                                </div>
                                <div class="description">
                                    <div class="top_box">
                                        <div class="list-state">대여가능</div>
                                        <ol class="breadcrumb">
                                            <li class="breadcrumb-item">${rentalObject.subCategory.mainCategory.mcId}</li>
                                            <li class="breadcrumb-item">${rentalObject.subCategory.scId}</li>
                                        </ol>
                                    </div>
                                    <div class="title">${rentalObject.objectName}</div>
                                    <ul class="obj_info">
                                        <li>
                                            <span class="place icon">장소</span>
                                            <span class="obj">${rentalObject.location}</span>
                                        </li>
                                        <li>
                                            <span class="price icon">이용요금</span>
                                            <span class="obj">${rentalObject.price}</span>
                                        </li>
                                        <li>
                                            <span class="reception_period icon">접수기간</span>
                                                ${rentalObject.receiptStartDuration}
                                            ~ ${rentalObject.receiptEndDuration}
                                        </li>
                                        <li>
                                            <span class="use_period icon">사용기간</span>
                                                ${rentalObject.startDuration} ~ ${rentalObject.endDuration}
                                        </li>
<%--                                        <li>--%>
<%--                                            <span class="reservation icon">예약방법</span>--%>
<%--                                            <ul class="reservation_method">--%>
<%--                                                <li><img src="${path}/resources/img/rental/online_icon.png" alt="icon">--%>
<%--                                                </li>--%>
<%--                                                <li><img src="${path}/resources/img/rental/visit_icon.png" alt="icon">--%>
<%--                                                </li>--%>
<%--                                                <li><img src="${path}/resources/img/rental/phone_icon.png" alt="icon">--%>
<%--                                                </li>--%>
<%--                                                <li><img src="${path}/resources/img/rental/site_icon.png" alt="icon">--%>
<%--                                                </li>--%>
<%--                                            </ul>--%>
<%--                                        </li>--%>
                                    </ul>
                                </div>
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </form>
            <ul class="pagination">
                <li class="page-item disabled">
                    <a class="page-link" href="">
                        <img src="${path}/resources/img/rental/double_left_arrow_icon.png" alt="<<">
                    </a>
                </li>
                <li class="page-item disabled">
                    <a class="page-link" href="">
                        <img src="${path}/resources/img/rental/left_arrow_icon.png" alt="<">
                    </a>
                </li>
                <li class="page-item active"><a class="page-link" href="">1</a></li>
                <li class="page-item"><a class="page-link" href="">2</a></li>
                <li class="page-item"><a class="page-link" href="">3</a></li>
                <li class="page-item">
                    <a class="page-link" href="">
                        <img src="${path}/resources/img/rental/left_arrow_icon.png" alt=">">
                    </a>
                </li>
                <li class="page-item">
                    <a class="page-link" href="">
                        <img src="${path}/resources/img/rental/double_left_arrow_icon.png" alt=">>">
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <jsp:include page="../includes/footer.jsp"/>
</div>
</body>
<!-- Google Tag Manager (noscript) -->
<noscript>
    <iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58QHFKS"
            height="0" width="0" style="display:none;visibility:hidden"></iframe>
</noscript>
<!-- End Google Tag Manager (noscript) -->
<!-- JS File -->
<script src="${path}/resources/js/rental/rentalList.js" type="text/javascript"></script>
</html>