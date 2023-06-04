<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <!-- BootStrap CSS File -->
    <link href="${path}/resources/css/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/css/style.css" rel="stylesheet">
    <!-- CSS File -->
    <link href="${path}/resources/css/rental/rental_write.css" rel="stylesheet">

    <title>대여글 작성 | 대여대여</title>
</head>
<body>
<div class="wrapper">
    <jsp:include page="../includes/header.jsp"/>
    <div class="container">
        <div class="top_container">
            <div class="contents">
                <div class="top_contents">
                    <div class="state">대여가능</div>
                    <div class="title">제목</div>
                </div>
                <div class="bot_contents">
                    <div class="left_box">
                        <div class="img_box">
                            <!-- Slides only carousel -->
                            <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="${path}/resources/img/rental/airplane.jfif" class="d-block w-100" alt="...">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${path}/resources/img/rental/sea.jpg" class="d-block w-100" alt="...">
                                    </div>
                                    <div class="carousel-item">
                                        <img src="${path}/resources/img/rental/image_icon.png" class="d-block w-100" alt="...">
                                    </div>
                                </div>
                            </div> <!-- End Slides only carousel-->
                            <button type="button" class="expand icon btn" data-bs-toggle="modal" data-bs-target="#fullscreenModal"></button>
                            <!-- Full Screen Modal -->
                            <div class="modal fade" id="fullscreenModal" tabindex="-1">
                                <div class="modal-dialog modal-fullscreen">
                                    <div class="modal-content">
                                        <%-- Slider --%>
                                        <div class="carousel-wrap">
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            <div class="carousel">
                                                <div class="btn btn-back hidden">
                                                    <i class="fas left-arrow"></i>
                                                </div>
                                                <div class="viewbox">
                                                    <div class="track">
                                                        <div class="slide active">
                                                            <img class="images" src="${path}/resources/img/rental/airplane.jfif">
                                                        </div>
                                                        <div class="slide">
                                                            <img class="images" src="${path}/resources/img/rental/sea.jpg">
                                                        </div>
                                                        <div class="slide">
                                                            <img class="images" src="${path}/resources/img/rental/image_icon.png">
                                                        </div>
                                                        <div class="slide">
                                                            <img class="images" src="https://source.unsplash.com/random/800x803">
                                                        </div>
                                                        <div class="slide active">
                                                            <img class="images" src="https://source.unsplash.com/random/800x804">
                                                        </div>
                                                        <div class="slide">
                                                            <img class="images" src="https://source.unsplash.com/eADQs40WywY/800x805">
                                                        </div>
                                                        <div class="slide">
                                                            <img class="images" src="https://source.unsplash.com/random/800x806">
                                                        </div>
                                                        <div class="slide">
                                                            <img class="images" src="https://source.unsplash.com/ArYjvKHVByg/800x807">
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="btn btn-next">
                                                    <i class="fas right-arrow"></i>
                                                </div>
                                                <div class="nav-indicator">
                                                    <div class="dot active"></div>
                                                    <div class="dot"></div>
                                                    <div class="dot"></div>
                                                    <div class="dot"></div>
                                                    <div class="dot"></div>
                                                    <div class="dot"></div>
                                                    <div class="dot"></div>
                                                    <div class="dot"></div>
                                                </div>
                                            </div>
                                        </div> <!-- End Slider-->
                                    </div>
                                </div>
                            </div> <!-- End Full Screen Modal-->
                        </div>
                        <div id='calendar'></div> <!-- Full Calendar -->
                    </div>
                    <div class="right_box">
                        <div class="func_box">
                            <div class="icon_box">
                                <div class="icon hits_box">
                                    <span class="hits" title="조회수">120</span>
                                </div>
                                <div class="rating">
                                    <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                                    <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                                    <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                                    <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                                    <img src="${path}/resources/img/rental/star_icon.png" alt="사진">
                                </div>
                            </div>
                            <div class="icon_btn_box">
                                <input type="button" class="want icon btn">
                                <input type="button" class="share icon btn">
                                <input type="button" class="report icon btn">
                            </div>
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
                                <td>a
                                    a
                                    a
                                    a
                                    a
                                    a
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
        <!-- Bordered Tabs Justified -->
        <div class="bottom_container">
            <ul class="nav nav-tabs nav-tabs-bordered d-flex" id="borderedTabJustified" role="tablist">
                <li class="nav-item flex-fill" role="presentation">
                    <button class="nav-link w-100 active" id="guide-tab" data-bs-toggle="tab" data-bs-target="#bordered-justified-guide" type="button" role="tab" aria-controls="guide" aria-selected="true">이용안내</button>
                </li>
                <li class="nav-item flex-fill" role="presentation">
                    <button class="nav-link w-100" id="place-tab" data-bs-toggle="tab" data-bs-target="#bordered-justified-place" type="button" role="tab" aria-controls="place" aria-selected="false">장소안내</button>
                </li>
                <li class="nav-item flex-fill" role="presentation">
                    <button class="nav-link w-100" id="review-tab" data-bs-toggle="tab" data-bs-target="#bordered-justified-review" type="button" role="tab" aria-controls="review" aria-selected="false">이용후기</button>
                </li>
            </ul>
            <div class="tab-content pt-2" id="borderedTabJustifiedContent">
                <div class="tab-pane fade show active" id="bordered-justified-guide" role="tabpanel" aria-labelledby="guide-tab">
                    <div>이용안내</div>
                </div>
                <div class="tab-pane fade" id="bordered-justified-place" role="tabpanel" aria-labelledby="place-tab">
                    <div class="sub_box">
                        <h3>지도</h3>
                        <div id="map"></div>
                    </div>
                    <div class="sub_box">
                        <h3>주소</h3>
                        <div>경기도 의정부시</div>
                    </div>
                    <div class="sub_box">
                        <h3>오시는 길</h3>
                        <div>녹양역에서 5번 버스 승차하고 경민대학에서 하차</div>
                    </div>
                </div>
                <div class="tab-pane fade" id="bordered-justified-review" role="tabpanel" aria-labelledby="review-tab">
                    <div class="user_review">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">평점
                                    <div class="rate">
                                        <input type="button" id="star_1" class="empty_star icon btn">
                                        <input type="button" id="star_2" class="empty_star icon btn">
                                        <input type="button" id="star_3" class="empty_star icon btn">
                                        <input type="button" id="star_4" class="empty_star icon btn">
                                        <input type="button" id="star_5" class="empty_star icon btn">
                                    </div>
                                </h5>
                                <textarea class="review_input"z placeholder="이용후기를 입력해 주세요."></textarea>
                                <div class="post_box">
                                    <a href="" class="post">후기 작성</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="reviews">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Default Card</h5>
                                Ut in ea error laudantium quas omnis officia. Sit sed praesentium voluptas. Corrupti inventore consequatur nisi necessitatibus modi consequuntur soluta id. Enim autem est esse natus assumenda. Non sunt dignissimos officiis expedita. Consequatur sint repellendus voluptas.
                                Quidem sit est nulla ullam. Suscipit debitis ullam iusto dolorem animi dolorem numquam. Enim fuga ipsum dolor nulla quia ut.
                                Rerum dolor voluptatem et deleniti libero totam numquam nobis distinctio. Sit sint aut. Consequatur rerum in.
                                <a href="" class="btn btn-primary">Button</a>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Default Card</h5>
                                Ut in ea error laudantium quas omnis officia. Sit sed praesentium voluptas. Corrupti inventore consequatur nisi necessitatibus modi consequuntur soluta id. Enim autem est esse natus assumenda. Non sunt dignissimos officiis expedita. Consequatur sint repellendus voluptas.
                                Quidem sit est nulla ullam. Suscipit debitis ullam iusto dolorem animi dolorem numquam. Enim fuga ipsum dolor nulla quia ut.
                                Rerum dolor voluptatem et deleniti libero totam numquam nobis distinctio. Sit sint aut. Consequatur rerum in.
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Default Card</h5>
                                Ut in ea error laudantium quas omnis officia. Sit sed praesentium voluptas. Corrupti inventore consequatur nisi necessitatibus modi consequuntur soluta id. Enim autem est esse natus assumenda. Non sunt dignissimos officiis expedita. Consequatur sint repellendus voluptas.
                                Quidem sit est nulla ullam. Suscipit debitis ullam iusto dolorem animi dolorem numquam. Enim fuga ipsum dolor nulla quia ut.
                                Rerum dolor voluptatem et deleniti libero totam numquam nobis distinctio. Sit sint aut. Consequatur rerum in.
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- End Bordered Tabs Justified -->
        </div>
    </div>
    <jsp:include page="../includes/footer.jsp"/>
</div>
</body>
<!-- BootStrap JS File -->
<script src="${path}/resources/css/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- Slider JS File -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.1/TweenLite.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/2.0.1/TimelineMax.min.js"></script>
<!-- FullCalendar JS File -->
<script src='${path}/resources/js/rental/index.global.js'></script>
<!-- Kakao Maps API -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=0e9e66db9f3843b34b9c3a178aaae77d"></script>
<!-- JS File -->
<script src="${path}/resources/js/rental/rentalWrite.js"></script>
</html>