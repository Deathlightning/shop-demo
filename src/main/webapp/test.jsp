<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <%
        Map<Integer, Integer[]> map = new HashMap<>();
        map.put(1, new Integer[]{1, 2, 3});
        map.put(2, new Integer[]{2, 2, 3});
        map.put(3, new Integer[]{3, 2, 3});
        map.put(4, new Integer[]{4, 2, 3});
        request.setAttribute("map", map);
    %>
</head>
<body>
<c:forEach items="${map}" var="i">
    ${i.key}
    <br>
</c:forEach>
</body>
</html>
