<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--index.jsp-->
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<%session.setAttribute("user1","user2222222");%>
${sessionScope.user1}
<c:if test="${sessionScope.user!=null}">
    <c:if test="${sessionScope.user.userType==0}">
        <jsp:forward page="purchase.jsp"/>
    </c:if>
    <c:if test="${sessionScope.user.userType==1}">
        <jsp:forward page="manager.jsp"/>
    </c:if>
</c:if>
<c:if test="${sessionScope.user==null}">
    <jsp:forward page="/login.jsp">
        <jsp:param value="errorMessage" name="登录态异常，请重新登陆"/>
    </jsp:forward>
</c:if>
</body>
</html>
