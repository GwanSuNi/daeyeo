<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- BootStrap CSS File -->
    <link href="${path}/resources/css/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/css/style.css" rel="stylesheet">
    <!-- CSS File -->
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/guidebook.css">
    <title>이용안내</title>
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
                <h5 class="total icon">총 <span class="emphasis">10</span> 건</h5>
                <ul class="list">
                    <li class="item">
                        <div class="collapsible" onclick="toggleActive(this)">
                            <div class="question"><span>Q</span></div>
                            <textarea class="item_title" oninput="resizeHeight(this)" disabled>질문-ㅁ나어뢰ㅏㄴㅁㅇ러ㅗㄴ모렁ㄴ몰농ㄹ망ㄴ러ㅗ미나어론
                                미ㅏㅗ리ㅏㄴ머ㅗ링나모리ㅏ너ㅗ라놀ㄴㅇㄹㄴㅁㅇㄹㄴㅁㅇㄻㄴㅇㄹㄴㅇㄴㅇㄹㄹㄴㅇㄹ</textarea>
                            <div class="clps_icon"></div>
                        </div>
                        <div class="item_content">
                            <div class="answer"><span>A</span></div>
                            <textarea class="item_txar" oninput="resizeHeight(this)" disabled>내용-ㅇ
                            ㅇ
                            ㅇ
                            ㅇ
                            ㅇ
                            ㅇ
                            ㅇ
                            d
                            d
                            d
                            d</textarea>
                        </div>
                    </li>
                    <li class="item">
                        <div class="collapsible" onclick="toggleActive(this)">
                            <div class="question"><span>Q</span></div>
                            <textarea class="item_title" oninput="resizeHeight(this)" disabled>질문</textarea>
                            <div class="clps_icon"></div>
                        </div>
                        <div class="item_content">
                            <div class="answer"><span>A</span></div>
                            <textarea class="item_txar" oninput="resizeHeight(this)" disabled>내용</textarea>
                        </div>
                    </li>
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