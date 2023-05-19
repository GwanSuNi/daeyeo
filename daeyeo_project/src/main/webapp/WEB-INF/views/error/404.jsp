<%--
  Created by IntelliJ IDEA.
  User: gwansuni
  Date: 2023/05/19
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Daeyeo?Daeyeo!</title>
    <link rel="stylesheet" type="text/css" href="${path}/resources/css/footer_bottom.css">
    <!-- Custom fonts for this template-->
    <link href="${path}/resources/css/assets/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="${path}/resources/css/assets/css/sb-admin-2.min.css" rel="stylesheet">
</head>
<body>
<div class="body_container">
    <%-- header --%>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="main_content">
        <div class="text-center">
            <div class="error mx-auto" data-text="404">404</div>
            <p class="lead text-gray-800 mb-5">Page Not Found</p>
            <p class="text-gray-500 mb-0">개발 중입니다...</p>
            <a href="/">&larr; 메인화면으로 돌아가기</a>
        </div>
    </div>
    <%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
