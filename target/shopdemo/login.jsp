<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>登录</title>
</head>
<body>你需要登录
<form action="${pageContext.request.contextPath}/login" method="post">
    <input type="text" value="root" name="username">
    <input type="submit">
</form>
</body>
</html>
