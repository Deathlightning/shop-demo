<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
<script>
    <c:if test="${requestScope.errorMessage!=null}">
    showAlert(${requestScope.errorMessage});
    window.history.back();
    </c:if>
</script>
<script>
    function showAlert(errorMessage) {

    }
</script>
</html>
