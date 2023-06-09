<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link href="${path}/resources/css/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/resources/css/assets/vendor/quill/quill.snow.css" rel="stylesheet">
    <style>
        .ql-container,
        .ql-editor {
            font-size: 16px;
            height: auto;
        }
    </style>
    <title>txt editor</title>
</head>
<body>
<div class="wrapper">
    <div class="quill-editor-default txt-editor"></div>
</div>
</body>
<script src="${path}/resources/css/assets/vendor/quill/quill.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tinymce/4.5.6/tinymce.min.js"></script>
<script src="${path}/resources/css/assets/js/main.js"></script>
</html>