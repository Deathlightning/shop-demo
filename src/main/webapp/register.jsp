<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<!DOCTYPE>
<html>
<head>
    <title>注册</title>
    <link href="css/commonHeader.css">
    <link href="css/bootstrap.min.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
            background-color: #ECEEF1;
        }
    </style>
</head>
<body>
<c:if test="${requestScope.errorMessage!=null}">
    <span style="color: red">${requestScope.errorMessage}</span>
</c:if>
<div class="commonHeader">
    <div style="font-size: 20px;color: black">购物商城</div>
</div>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div class="form-group">
        <label for="username">username</label>
        <input type="text" class="form-control" id="username" placeholder="username" name="username">
    </div>
    <div class="form-group">
        <label for="password1">Password</label>
        <input type="password" class="form-control" id="password1" placeholder="Password" name="password">
    </div>
    <div class="form-group">
        <label for="password2">Password</label>
        <input type="password" class="form-control" id="password2" placeholder="Password">
    </div>
    <div class="form-group">
        <label for="email">email</label>
        <input type="email" class="form-control" id="email" placeholder="email" name="email">
    </div>
    <div class="form-group">
        <label for="checkCode">checkCode</label>
        <input type="text" class="form-control" id="checkCode" placeholder="checkCode" name="checkCode">
    </div>
    <button type="submit" class="btn btn-default" onclick="return passwordCheck()">Submit</button>
</form>
</body>
<script>
    function passwordCheck() {
        var password1 = document.getElementById('password1').value;
        var password2 = document.getElementById('password2').value;
        if (password1 !== password2) {
            alert('两次密码不同');
            return false;
        }
        return true;
    }
</script>
</html>
