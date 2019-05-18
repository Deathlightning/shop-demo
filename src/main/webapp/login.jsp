<!--login.jsp-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <link href="css/common.css">
    <link href="css/bootstrap.min.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<c:if test="${requestScope.errorMessage!=null}">a
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
        <label for="exampleInputPassword1">Password</label>
        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
