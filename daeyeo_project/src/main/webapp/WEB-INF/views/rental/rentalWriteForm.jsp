<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/rental/rental_write_form.css">
    <title>대여 양식</title>
</head>
<body>
<div id="wrapper">
    <jsp:include page="../includes/header.jsp"/>
    <div id="container">
        <div class="top_container">
            <div class="contents">
                <div class="top_contents">
                    <div class="state">대여가능</div>
                    <div class="title">title</div>
                </div>
                <div class="bot_contents">
                    <div class="left_box">
                        <div class="img_box">
                            <img src="${path}/resources/img/rental/airplane.jfif" alt="사진">
                            <input type="button" class="expand icon btn">
                        </div>
                        <div class="calendar">
                            <div class="month">
                                <input type="button" class="prev_mon icon btn">
                                <div class="pres_mon">
                                    <b class="num">2023</b>년
                                    <b class="num">05</b>월
                                </div>
                                <input type="button" class="next_mon icon btn">
                            </div>
                            <table class="cal_tbl">
                                <thead>
                                <tr>
                                    <th>일</th>
                                    <th>월</th>
                                    <th>화</th>
                                    <th>수</th>
                                    <th>목</th>
                                    <th>금</th>
                                    <th>토</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td class="empty"></td>
                                    <td id="cal_20230501">
                                        <span class="date">1</span>
                                    </td>
                                    <td id="cal_20230502" class="able">
                                        <a href=""><span class="date">2</span></a>
                                    </td>
                                    <td id="cal_20230503" class="able">
                                        <a href=""><span class="date">3</span></a>
                                    </td>
                                    <td id="cal_20230504" class="able">
                                        <a href=""><span class="date">4</span></a>
                                    </td>
                                    <td id="cal_20230505" class="able">
                                        <a href=""><span class="date">5</span></a>
                                    </td>
                                    <td id="cal_20230506" class="able">
                                        <a href=""><span class="date">6</span></a>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                </tr>
                                <tr>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                </tr>
                                <tr>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                </tr>
                                <tr>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                </tr>
                                <tr>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                    <td class="empty"></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div class="right_box">
                        <div class="func_box">
                            <div class="heart_box">
                                <input type="button" class="heart icon btn">
                                <span class="heart_cnt">120</span>
                            </div>
                            <div class="rating">
                                <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                                <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                                <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                                <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                                <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                            </div>
                            <input type="button" class="share icon btn">
                            <input type="button" class="report icon btn">
                        </div>
                        <table class="description">
                            <tr>
                                <th>장소</th>
                                <td>place</td>
                            </tr>
                            <tr>
                                <th>이용요금</th>
                                <td>price</td>
                            </tr>
                            <tr>
                                <th>접수기간</th>
                                <td>reception period</td>
                            </tr>
                            <tr>
                                <th>사용기간</th>
                                <td>use period</td>
                            </tr>
                            <tr>
                                <th>취소기간</th>
                                <td>Cancellation period</td>
                            </tr>
                            <tr>
                                <th>예약방법</th>
                                <td>Reservation method-dfadskfjsalkfjdskfjlksdjflksdjflksdjfksdjfdsjf;lksdnflksdfjskdsjf
                                    sldkfflskfdjlksdjf;lkdsjf;hkdf;lkdsj;lkdsfjlkdsjf;lksjfd;lkdsjkf
                                </td>
                            </tr>
                            <tr>
                                <th>문의전화</th>
                                <td>inquiry call</td>
                            </tr>
                        </table>
                        <div class="btn_box">
                            <a href="" class="reservation">예약하기</a>
                            <a href="" class="list">목록</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="bottom_container">
            <ul class="tab_list">
                <li class="active" onclick="changeTab(this)">이용안내</li>
                <li class="" onclick="changeTab(this)">장소안내</li>
                <li class="" onclick="changeTab(this)">이용후기</li>
            </ul>
            <div id="tab_content">
                <div id="use_guide" class="tab_title active">
                    <textarea id="guide_txt" class="txt" oninput="resizeHeight(this)" disabled>이용안내</textarea>
                </div>
                <div id="place_guide" class="tab_title">
                    <div class="sub_box">
                        <div class="txt_title">지도</div>
                        <iframe src="" id="map"></iframe>
                    </div>
                    <div class="sub_box">
                        <div class="txt_title">주소</div>
                        <textarea id="address" class="txt" oninput="resizeHeight(this)" disabled>주소</textarea>
                    </div>
                    <div class="sub_box">
                        <div class="txt_title">오시는 길</div>
                        <textarea id="directions" class="txt" oninput="resizeHeight(this)" disabled>오시는 길</textarea>
                    </div>
                </div>
                <div id="review" class="tab_title">
                    <div class="rate_box">
                        <div class="txt_title">평점</div>
                        <div class="rate">
                            <input type="button" id="star_1" class="empty_star icon btn">
                            <input type="button" id="star_2" class="empty_star icon btn">
                            <input type="button" id="star_3" class="empty_star icon btn">
                            <input type="button" id="star_4" class="empty_star icon btn">
                            <input type="button" id="star_5" class="empty_star icon btn">
                        </div>
                    </div>
                    <textarea id="review_input" class="txt" oninput="resizeHeight(this)" placeholder="이용후기를 입력해 주세요."></textarea>
                    <div class="post_box">
                        <input type="button" class="post btn" value="후기 작성">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../includes/footer.jsp"/>
</div>

<script src="${path}/resources/js/rental/rentalWriteForm.js"></script>
<script src="${path}/resources/js/resizeHeight.js"></script>
</body>
</html>