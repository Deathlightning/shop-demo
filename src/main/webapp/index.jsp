<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--index.jsp-->
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:if test="${sessionScope.user!=null}">
    <c:if test="${sessionScope.user.type==0}">
        <jsp:forward page="purchase.jsp"/>
    </c:if>
    <c:if test="${sessionScope.user.type==1}">
        <jsp:forward page="manager.jsp"/>
    </c:if>
</c:if>
<c:if test="${sessionScope.user==null}">
    <script>alert('账号或密码错误')</script>
    <jsp:forward page="/login.jsp"/>
</c:if>
</body>
</html>
