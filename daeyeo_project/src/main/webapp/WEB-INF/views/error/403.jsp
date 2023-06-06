<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="sec"%>
<%@ page import="java.util.*"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
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
    <style>
        .access {
            text-align: center;
        }
    </style>
</head>
<body>

<div class="body_container">
    <%-- header --%>
    <%@ include file="/WEB-INF/views/includes/header.jsp" %>
    <div class="main_content">
            <h2 class="access">
                <c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage() }" />
            </h2>
            <h2 class="access">
                <c:out value="${msg}" />
            </h2>
    </div>
    <%-- footer --%>
    <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>
</body>
</html>
