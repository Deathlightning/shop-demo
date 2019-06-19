<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <style>
        a,
        a:link,
        a:hover,
        a:visited {
            color: black;
        }
    </style>
</head>
<body>
<div style="font-size: 18px">
    <c:forEach items="${classifyMap}" var="i">
        <div>
            <div class="nav-header">
                <a href="${pageContext.request.contextPath}/good/listOnTypeController?classify=${i.key.catId}">${i.key.catName}</a>
                <span class="glyphicon glyphicon-chevron-down" style="font-size: 15px;cursor: pointer"
                      onclick="fold(this)"></span>
            </div>
            <div hidden>
                <c:forEach items="${i.value}" var="j">
                    <div class="nav-item">
                        <a href="${pageContext.request.contextPath}/good/listOnTypeController?classify=${j.catId}">${j.catName}</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </c:forEach>
</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script>
    function fold(event) {
        $(event).parent().next().slideToggle();
    }
</script>
</html>

