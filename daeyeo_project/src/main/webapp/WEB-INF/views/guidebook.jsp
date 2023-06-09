<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- BootStrap CSS File -->
    <link href="${path}/resources/css/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/css/style.css" rel="stylesheet">
    <!-- CSS File -->
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/guidebook.css">
    <title>이용안내 | 대여대여</title>
    <script>
        window.dataLayer = window.dataLayer || [];
        function gtag(){dataLayer.push(arguments);}
        gtag('js', new Date());

        gtag('config', 'G-S11E29LT0T');
    </script>
    <!-- Google Tag Manager -->
    <script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
            new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
        j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
        'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
    })(window,document,'script','dataLayer','GTM-58QHFKS');</script>
    <!-- End Google Tag Manager -->
</head>
<body>
<div id="wrapper">
    <jsp:include page="includes/header.jsp"/>
    <div id="container">
        <div class="content_title">자주 묻는 질문</div>
        <div class="content">
            <div class="search_field">
                <select class="form-select">
                    <option value="1" selected>전체</option>
                    <option value="2">제목</option>
                    <option value="2">내용</option>
                </select>
                <label class="search">
                    <input type="text" placeholder="검색어를 입력하세요.">
                </label>
                <a href="" class="search_btn">검색</a>
            </div>
            <div class="list_wrap">
                <h5 class="total icon">총 <span class="emphasis">${totalCount}</span> 건</h5>
                <ul class="list">
                    <c:forEach var="item" items="${useInfos}">
                        <li class="item">
                            <div class="collapsible" onclick="toggleActive(this)">
                                <div class="question"><span>Q</span></div>
                                <textarea class="item_title" oninput="resizeHeight(this)" disabled>${item.question}</textarea>
                                <div class="clps_icon"></div>
                            </div>
                            <div class="item_content">
                                <div class="answer"><span>A</span></div>
                                <textarea class="item_txar" oninput="resizeHeight(this)" disabled>${item.answer}</textarea>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
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
    </div>
    <jsp:include page="includes/footer.jsp"/>
</div>

<script src="${path}/resources/js/guidebook.js"></script>
<script src="${path}/resources/js/resizeHeight.js"></script>
</body>
</html>