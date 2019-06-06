<!--login.jsp-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>重置密码</title>
    <link rel="stylesheet" href="css/commonHeader.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/axios.min.js"></script>
    <style>
        * {
            padding: 0;
            margin: 0;
        }

        .wrapper {
            margin-top: 100px;
            background-color: #4A74B4;
            padding-bottom: 15px;
            padding-top: 150px;
            padding-left: 800px;
            height: 350px;
        }
    </style>
</head>
<body>
<jsp:include page="commonHeader.jsp"/>
<body>
<div class="wrapper">
    <label for="username" style="display: block">用户名</label>
    <input type="text" style="margin-bottom: 15px" id="username">
    <label for="checkCode" style="display: block">验证码</label>
    <div>
        <input type="text" width="50px" id="checkCode">
        <button type="button" class="btn-default" onclick="sendCheckCode()">发送验证码</button>
    </div>
    <button type="button" onclick="changePassword()">下一步</button>
</div>
</body>
</body>
<script>
    function sendCheckCode() {
        axios.get('/sendCheckCode').catch(function () {
            alert('账号不存在')
        })
    }

    function changePassword() {
        var username = document.getElementById('username');
        var password = document.getElementById('password');
        axios.post('/resetPasswordServlet').then(function (value) {  })
    }
</script>
</html>
