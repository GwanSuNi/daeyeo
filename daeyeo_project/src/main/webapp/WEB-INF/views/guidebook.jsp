<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
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
                <label class="select">
                    <select>
                        <option value="1" selected>전체</option>
                        <option value="2">제목</option>
                        <option value="2">내용</option>
                    </select>
                </label>
                <label class="search">
                    <input type="text" placeholder="검색어를 입력하세요.">
                </label>
                <input type="button" class="search_btn" value="검색">
            </div>
            <div class="list_wrap">
                <h4 class="total icon">총 <span class="emphasis">10</span> 건</h4>
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
                <div class="page">
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
    <jsp:include page="includes/footer.jsp"/>
</div>

<script src="${path}/resources/js/guidebook.js"></script>
<script src="${path}/resources/js/resizeHeight.js"></script>
</body>
</html>