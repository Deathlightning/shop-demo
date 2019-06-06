<!--login.jsp-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/commonHeader.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .formWrapper {
            margin-top: 10%;
            background: #4A74B4;
            padding-top: 10px;
            padding-bottom: 10px;
        }

        .loginForm {
            width: 250px;
            margin-left: 40%;
        }

        a:link {
            color: black
        }
        a:visited {
            color: black
        }
    </style>
</head>
<body>
<jsp:include page="commonHeader.jsp"/>
<div class=formWrapper>
    <form action="${pageContext.request.contextPath}/login" method="post" class="loginForm">
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" name="username" maxlength="50" placeholder="用户名">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="密码">
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="autoLogin"> 七天自动登录
            </label>
        </div>
        <button type="submit" class="btn btn-info">登录</button>
        <button type="button" onclick="window.location.href='<%=request.getContextPath()%>/forgetPassword.jsp'" class="btn btn-info">忘记密码</button>
        <a href="register.jsp" style="display:block;margin-top: 15px">去注册</a>
    </form>

</div>
</body>
</html>
