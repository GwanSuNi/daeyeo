<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/list_type.css">
    <title>목록형</title>
    <link rel="stylesheet" href="${path}/resources/webjars/css/bootstrap.min.css">
    <script src="${path}/resources/webjars/js/bootstrap.min.js"></script>
</head>
<body>
<ul id="rental_list">
    <li>
        <a href="#">
            <div class="img_box">
                <img src="${path}/resources/img/airplane.jfif" alt="사진">
            </div>
            <div class="description">
                <div class="top_box">
                    <div class="state">대여가능</div>
                    <ul class="category">
                        <li>공간시설</li>
                        <li>강의실</li>
                    </ul>
                </div>
                <div class="title">title-adsfasdfasdfafdasdfasdfsadfdsafsadfsadfasfaasdfafasdfasfddsaf
                    dsafdsfkdasjflkdsjfblkdsjablkgjsldbasdlfjnaslkfsalkfslkfjsalkfjd;lksfj;lkdsafjl;dsakfjdskjfksfkdsj</div>
                <ul class="obj_info">
                    <li>
                        <span class="place icon">장소</span>
                        <span class="obj">place-adsfasdfasdfafdasdfasdfsadfdsafsadfsadfasfa</span>
                    </li>
                    <li>
                        <span class="price icon">이용요금</span>
                        <span class="obj">price-adsfasdfasdfafdasdfasdfsadfdsafsadfsadfasfa</span>
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
                            <li><img src="${path}/resources/img/online_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/visit_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/phone_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/site_icon.png" alt="icon"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </a>
    </li>
    <li>
        <a href="#">
            <div class="img_box">
                <img src="${path}/resources/img/sea.jpg" alt="사진">
            </div>
            <div class="description">
                <div class="top_box">
                    <div class="state">대여가능</div>
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
                            <li><img src="${path}/resources/img/online_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/visit_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/phone_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/site_icon.png" alt="icon"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </a>
    </li>
    <li>
        <a href="#">
            <div class="img_box">
                <img src="${path}/resources/img/image_icon.png" alt="사진">
            </div>
            <div class="description">
                <div class="top_box">
                    <div class="state">대여가능</div>
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
                            <li><img src="${path}/resources/img/online_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/visit_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/phone_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/site_icon.png" alt="icon"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </a>
    </li>
    <li>
        <a href="#">
            <div class="img_box">
                <img src="${path}/resources/img/image_icon.png" alt="사진">
            </div>
            <div class="description">
                <div class="top_box">
                    <div class="state">대여가능</div>
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
                            <li><img src="${path}/resources/img/online_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/visit_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/phone_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/site_icon.png" alt="icon"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </a>
    </li>
    <li>
        <a href="#">
            <div class="img_box">
                <img src="${path}/resources/img/image_icon.png" alt="사진">
            </div>
            <div class="description">
                <div class="top_box">
                    <div class="state">대여가능</div>
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
                            <li><img src="${path}/resources/img/online_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/visit_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/phone_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/site_icon.png" alt="icon"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </a>
    </li>
    <li>
        <a href="#">
            <div class="img_box">
                <img src="${path}/resources/img/image_icon.png" alt="사진">
            </div>
            <div class="description">
                <div class="top_box">
                    <div class="state">대여가능</div>
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
                            <li><img src="${path}/resources/img/online_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/visit_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/phone_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/site_icon.png" alt="icon"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </a>
    </li>
    <li>
        <a href="#">
            <div class="img_box">
                <img src="${path}/resources/img/image_icon.png" alt="사진">
            </div>
            <div class="description">
                <div class="top_box">
                    <div class="state">대여가능</div>
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
                            <li><img src="${path}/resources/img/online_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/visit_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/phone_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/site_icon.png" alt="icon"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </a>
    </li>
    <li>
        <a href="#">
            <div class="img_box">
                <img src="${path}/resources/img/image_icon.png" alt="사진">
            </div>
            <div class="description">
                <div class="top_box">
                    <div class="state">대여가능</div>
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
                            <li><img src="${path}/resources/img/online_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/visit_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/phone_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/site_icon.png" alt="icon"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </a>
    </li>
    <li>
        <a href="#">
            <div class="img_box">
                <img src="${path}/resources/img/image_icon.png" alt="사진">
            </div>
            <div class="description">
                <div class="top_box">
                    <div class="state">대여가능</div>
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
                            <li><img src="${path}/resources/img/online_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/visit_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/phone_icon.png" alt="icon"></li>
                            <li><img src="${path}/resources/img/site_icon.png" alt="icon"></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </a>
    </li>
</ul>
</body>
</html>